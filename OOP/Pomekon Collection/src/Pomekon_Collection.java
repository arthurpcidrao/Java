import java.util.Scanner;

public class Pomekon_Collection {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        int num = input.nextInt();
        input.nextLine();
        String nome;
        PokerBall ball = new PokerBall();

        for (int i = 0; i < num; i++){
            nome = input.nextLine();
            if (ball.buscaPomekon(nome) == -1){
                ball.guardaPomekon(nome);
            }
        }
        input.close();

        int qtde = 151 - ball.qtdePomekons();
        //ball.print();
        //System.out.println(ball.qtdePomekons());
        System.out.printf("Falta(m) %d pomekon(s).\n", qtde);
    }
}
