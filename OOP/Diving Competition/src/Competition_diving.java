import java.util.Scanner;

public class Competition_diving {
    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);

        Competition campeonato = new Competition();
        int qtde = input.nextInt();
        String nome;
        double dif, media;

        for (int i = 0; i < qtde; i++){
            
            nome = input.next();
            dif = input.nextDouble();

            Judge jurado = new Judge();
            for (int j = 0; j < 7; j++){
                jurado.addNotas(input.nextDouble());
            }
            media = jurado.calcMedia();

            campeonato.armazenaAtleta(nome, dif, media);

        }
        input.close();
        campeonato.print();

    }
}
