import java.util.Scanner;

public class If_else {
    public static void main(String[] args) throws Exception {
        
        Scanner var = new Scanner(System.in);
        
        System.out.print("Digite um numero entre 0 e 100: ");
        int x = var.nextInt();

        var.close();

        if ((x >= 0) && (x <= 50)) {
            System.out.printf("O x (%d) esta entre 0 e 50", x);
        }
        else {
            System.out.printf("O x (%d) esta entre 51 e 100", x);
        }

    }
}
