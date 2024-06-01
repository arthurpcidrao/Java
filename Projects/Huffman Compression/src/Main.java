import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {

    public static File arquivo = new File("C:\\Users\\arthu\\OneDrive\\Área de Trabalho\\Codes\\Java\\Projects\\Huffman Compression\\src\\arquivoTexto.txt");
    
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) throws Exception {

        // leio o arquivo de texto
        BufferedReader reader = new BufferedReader(new InputStreamReader( new FileInputStream(arquivo),StandardCharsets.UTF_8));

        // leio linha por linha e pego cada "char" e coloco nas estatísticas
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



        // crio uma fila de prioridade e adiciono as estatísticas à essa fila
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

    }
}
