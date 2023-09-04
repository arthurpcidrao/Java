import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        int numero = input.nextInt();
        int horas = input.nextInt();
        double valor = input.nextDouble();

        input.close();
        
        Funcionario func = new Funcionario(numero, horas, valor);

        /*
        func.setNumero(numero);
        func.setHorasTrabalho(horas);
        func.setValorHrs(valor);
        */

        double salario = func.calcularSalario();

        System.out.printf("NUMBER = %d\n", numero);
        System.out.printf("SALARY = U$ %.2f\n", salario);

    }
}
