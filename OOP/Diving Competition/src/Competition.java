import java.util.Scanner;

public class Competition {
    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);

        Athlete competidor = new Athlete();
        Judge jurado = new Judge();
        Rules regras = new Rules(competidor, jurado);

        int qtde = input.nextInt();
        



        input.close();
    }
}
