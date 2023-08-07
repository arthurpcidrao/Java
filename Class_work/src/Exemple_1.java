import java.util.Scanner;

public class Exemple_1 {
    public static void main(String[] args) throws Exception {
        float a, b, aux;

        Scanner input_dados = new Scanner(System.in);
        System.out.print("Digite o numero a: ");
        a = input_dados.nextFloat();

        System.out.print("Digite o numero b: ");
        b = input_dados.nextFloat();

        aux = a;
        a = b;
        b = aux;

        input_dados.close();

        System.out.format("O numero a virou = %.2f", a);
        System.out.format("\nO numero b virou = %.2f", b);
    }
}
