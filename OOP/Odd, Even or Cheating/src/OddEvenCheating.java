import java.util.Scanner;

public class OddEvenCheating {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Jogador jogador1 = new Jogador();
        Jogador jogador2 = new Jogador();

        jogador1.setP(input.nextInt());
        jogador1.setJ(input.nextInt());

        jogador2.setJ(input.nextInt());

        jogador1.setC(input.nextInt());
        
        jogador2.setA(input.nextInt());
        
        input.close();

        Jogo jogo = new Jogo(jogador1.getP(), jogador1.getJ(), jogador2.getJ(), jogador1.getC(), jogador2.getA());
        //System.out.println(jogo.getP());
        //System.out.println(jogo.getJogada1());
        //System.out.println(jogo.getJogada2());
        //System.out.println(jogo.getC());
        //System.out.println(jogo.getA());


        System.out.println(jogo.isAccused(jogo.isCheating()));
    }
}
