import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        String nome = input.nextLine();
        double fixo = input.nextDouble();
        double vendas = input.nextDouble();
        double salarioFinal;
        input.close();

        Pessoa funcionario = new Pessoa(nome, fixo, vendas);

        salarioFinal = funcionario.calculaFinal();

        System.out.printf("TOTAL = R$ %.2f\n", salarioFinal);


    }
}
