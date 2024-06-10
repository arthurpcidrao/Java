import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Main {

    public static File file = new File("C:\\Users\\arthu\\OneDrive\\Área de Trabalho\\Codes\\Java\\Projects\\Huffman Compression\\src\\arquivoTexto.txt");
    public static File compressFile = new File("C:\\Users\\arthu\\OneDrive\\Área de Trabalho\\Codes\\Java\\Projects\\Huffman Compression\\src\\comprimido.txt");
    public static File decompressFile = new File("C:\\Users\\arthu\\OneDrive\\Área de Trabalho\\Codes\\Java\\Projects\\Huffman Compression\\src\\descomprimido.txt");

    static String binary = "";
    static int index = 0;
    
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) throws Exception {

        // lê file de texto
        BufferedReader reader = new BufferedReader(new InputStreamReader( new FileInputStream(file),StandardCharsets.UTF_8));



        // lê linha e cria estatística
        Statistics statistic = new Statistics();
        String line;

        while((line = reader.readLine()) != null){
            line = line + "\n";
            for (int i = 0; i < line.length(); i++){
                statistic.add((int) line.charAt(i));
            }
        }
        reader.close();
        statistic.showall();



        // fila de prioridade com prioridade qtd>char
        PriorityQueue<LetterStructure> queue = new PriorityQueue<>();

        for (int i = 0; i < statistic.size(); i++){
            if (statistic.getData(i) != null){
                queue.enqueue(statistic.getData(i));
            }
        }
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

        huffman.setQtdLetters(256);
        huffman.PreOrder();
        huffman.showNewFormationLetters();



        //escreve documento com caracteres novos (no terminal)
        huffman.writeDocument();
        huffman.showDocument();

        System.out.println();



        // re lê o file e monta binário
        BufferedReader rereader = new BufferedReader(new InputStreamReader( new FileInputStream(file),StandardCharsets.UTF_8));

        while((line = rereader.readLine()) != null){
            line = line + "\n";
            for (int i = 0; i < line.length(); i++){
                huffman.appendDocument(line.charAt(i));
            }
        }
        rereader.close();

        huffman.showDocument();



        // cria documento de compressão
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(compressFile))) {
            writer.write(huffman.getDocument());
        }

        Decompress<LetterStructure> decompress = new Decompress<>();

        decompress.setDecompressFile(decompressFile);

        System.out.println();
        System.out.println();



        //descompressão através do file comprimido
        try (FileReader recreateFile = new FileReader(compressFile)) {
            
            int character;
            while ((character = recreateFile.read()) != -1) {
                binary = binary + ((char) character);
            }
            recreateFile.close();

            int[] indice = {0};
            Node root = decompress.rebuildTree(binary, indice);
            String message = binary.substring(indice[0]);

            String finalMessage = decompress.decoMessage(message, root);

            try (BufferedWriter finalWriter = new BufferedWriter(new FileWriter(decompressFile))) {
                finalWriter.write(finalMessage);
                finalWriter.close();
            }

            //decompress.showPreOrder(root);
        }

    }
}
