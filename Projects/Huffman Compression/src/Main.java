import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Main {

    public static File file = new File("C:\\Users\\arthu\\OneDrive\\Área de Trabalho\\Codes\\Java\\Projects\\Huffman Compression\\src\\arquivoTexto.txt");
    public static File compressFile = new File("C:\\Users\\arthu\\OneDrive\\Área de Trabalho\\Codes\\Java\\Projects\\Huffman Compression\\src\\comprimido.txt");
    public static File decompressFile = new File("C:\\Users\\arthu\\OneDrive\\Área de Trabalho\\Codes\\Java\\Projects\\Huffman Compression\\src\\descomprimido.txt");
    public static File originalFile = new File("C:\\Users\\arthu\\OneDrive\\Área de Trabalho\\Codes\\Java\\Projects\\Huffman Compression\\src\\arquivoNaoComprimidoBinario.txt");

    
    
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) throws Exception {

        // lê file de texto
        BufferedReader reader = new BufferedReader(new InputStreamReader( new FileInputStream(file),StandardCharsets.UTF_8));

        String originalFileBinary = "";

        // lê linha e cria estatística
        Statistics statistic = new Statistics();
        String line;
        Compress teste = new Compress();
        System.out.println("\nArquivo em binário original:");
        while((line = reader.readLine()) != null){
            line = line + "\n";

            for (int i = 0; i < line.length(); i++){
                statistic.add((int) line.charAt(i));

                originalFileBinary = originalFileBinary + teste.changeLetterToByte(line.charAt(i));
            }
        }


        try (BufferedWriter originalFileWriter = new BufferedWriter(new FileWriter(originalFile))) {
            originalFileWriter.write(originalFileBinary);
        }


        System.out.println();
        reader.close();
        System.out.print("\nEstatística das letras:");
        statistic.showall();



        // fila de prioridade com prioridade qtd>char
        PriorityQueue<LetterStructure> queue = new PriorityQueue<>();

        for (int i = 0; i < statistic.size(); i++){
            if (statistic.getData(i) != null){
                queue.enqueue(statistic.getData(i));
            }
        }
        System.out.println("\nprint da fila ordenada por qtd e depois por ordem alfabética:");
        queue.print();


        // transformo a fila em uma árvore
        while (queue.size() > 1){
            Node aux1 = queue.dequeue();
            Node aux2 = queue.dequeue();
            
            LetterStructure aux3 = new LetterStructure(null, ((LetterStructure) aux1.getData()).getQtd() + ((LetterStructure) aux2.getData()).getQtd());

            queue.enqueue(aux3, aux1, aux2);

        }



        // adequa as letras aos novos binários ascii  (compressão)
        Compress huffman = new Compress(queue.dequeue());
        System.out.print("\nNovos códigos binários para as letras:");
        huffman.setQtdLetters(256);
        huffman.PreOrder();
        huffman.showNewFormationLetters();



        //escreve documento com caracteres novos (no terminal)
        System.out.println("\nÁrvore de Huffman:");
        huffman.writeDocument();
        huffman.showDocument();




        System.out.println("\nArquivo completo em binário:");
        // re lê o file e monta binário
        BufferedReader rereader = new BufferedReader(new InputStreamReader( new FileInputStream(file),StandardCharsets.UTF_8));

        while((line = rereader.readLine()) != null){
            line = line + "\n";
            for (int i = 0; i < line.length(); i++){
                huffman.appendDocument(line.charAt(i));
            }
        }
        rereader.close();

        //huffman.showDocument();



        // cria documento de compressão
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(compressFile))) {
            writer.write(huffman.getDocument());
        }

        System.out.println("\n");
        System.out.println("Eficiência: " + String.format("%.2f", ((huffman.getDocument().length() * 1.0) / originalFileBinary.length()) * 100) + "% do tamanho do arquivo original!");
        System.out.println();



        //descompressão através do file comprimido
        Decompress<LetterStructure> decompress = new Decompress<>();

        decompress.setDecompressFile(decompressFile);

        System.out.println();

        String binary = "";

        try (FileReader recreateFile = new FileReader(compressFile)) {
            
            int character;
            while ((character = recreateFile.read()) != -1) {
                binary = binary + ((char) character);
            }
            recreateFile.close();

            int[] indice = {0};
            System.out.println("\nÁrvore de huffman na reconstrução:");
            Node root = decompress.rebuildTree(binary, indice);
            String message = binary.substring(indice[0]);

            String finalMessage = decompress.decoMessage(message, root);



            try (BufferedWriter finalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(decompressFile), StandardCharsets.UTF_8))) {
                finalWriter.write(finalMessage);
                finalWriter.close();
            }
        }

        System.out.println("\n");

    }
}
