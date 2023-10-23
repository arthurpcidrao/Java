import java.util.Scanner;

public class FrogGame {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Pipes canos = new Pipes();
        Frog sapo = new Frog();
        Game jogo = new Game(sapo, canos);

        sapo.setJump(input.nextInt());
        canos.setQtde(input.nextInt());

        for (int i = 0; i < canos.getQtde(); i++){ 
            canos.addPipe(input.nextInt());
        }

        System.out.println(jogo.isPossible());

        input.close();
        
    }
}
