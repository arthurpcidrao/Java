import java.io.*;
//import java.util.Scanner;

public class LeituraDeArquivo {
    public static void main (String[] args) throws IOException {
        //Scanner input = new Scanner(System.in);
        File arquivo = new File("C:\\Users\\arthu\\OneDrive\\Área de Trabalho\\pasta Teste\\arquivoTeste.txt");

        Ranking ranking = new Ranking();
        //ranking.addJogador("arthur", 123);
        //ranking.addJogador("alice", 245);
        //ranking.addJogador("leonardo", 500);
        ranking.ordenar();

        if(!arquivo.canRead()){
            System.out.println("O arquivo não pode ser lido");
        } else{
            try (FileWriter escritor = new FileWriter(arquivo, false)){  // o append(segundo argumento) diz se é para adicionar ou sobrescrever.
                for(int i = 0; i < ranking.getTamanho(); i++){
                    Jogador jogador = ranking.getJogador(i);
                    String cadeia = jogador.getNome() + ' ' + jogador.getPontuacao();
                    escritor.write(cadeia + "\n");
                }
            }
        }
        //input.close();

        ranking.limparRanking();

        System.out.println("Conteúdo do arquivo após escrita:");
        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
    
            String linha;

            while ((linha = leitor.readLine()) != null) {
                String dadosJogador[] = linha.split(" ");
                
                ranking.addJogador(dadosJogador[0], Integer.parseInt(dadosJogador[1]));
            }
        }

        ranking.imprimeRanking();

    }
}
