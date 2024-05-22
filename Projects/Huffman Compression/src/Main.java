import java.io.BufferedReader;
import java.io.FileReader;
//import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        
        // leio o arquivo de texto
        BufferedReader input = new BufferedReader(new FileReader(
        "C:\\Users\\arthu\\OneDrive\\Área de Trabalho\\Codes\\Java\\Projects\\Huffman Compression\\src\\arquivoTexto.txt"));



        // leio linha por linha e pego cada "char" e coloco nas estatísticas
        Statistics statistic = new Statistics();
        String line;

        while((line = input.readLine()) != null){
            for (int i = 0; i < line.length(); i++){
                statistic.add((int) line.charAt(i));
            }
            statistic.add('\n');  // o inteiro do \n é 10
        }
        input.close();
        statistic.showall();



        // crio uma fila de prioridade e adiciono as estatísticas à essa fila
        PriorityQueue<LetterStructure> queue = new PriorityQueue<>();  // mudar para a queue receber tree

        for (int i = 0; i < statistic.size(); i++){
            if (statistic.getData(i) != null){
                queue.enqueue(statistic.getData(i));
            }
        }
        queue.print();



        // agora eu preciso transformar essa fila de prioridade em uma ávore
        
        
    }
}
