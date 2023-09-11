import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);

        int codigo = input.nextInt();
        int quantidade = input.nextInt();

        input.close();

        Lanchonete lan = new Lanchonete(codigo, quantidade);

        double total = lan.valorFinal();

        System.out.printf("Total: R$ %.2f\n", total);

    }
}
