import java.util.Scanner;

public class Positive_numbers {  // para o Beecrowd, precisa escrever 'public class Main' para todos os códigos
    public static void main(String[] args) throws Exception {

        double num,  sum = 0, average;
        int qtd = 6, count = 0;

        Scanner input = new Scanner(System.in);

        for (int i = 0; i < qtd; i++) {
            num = input.nextDouble();

            if (num > 0) {
                count++;
                sum = sum + num;
            }
        }
        input.close();

        average = sum/count;

        System.out.printf("%d valores positivos\n", count); // para o Beecrowd, precisa ser colocado o /n no final do código
        System.out.printf("%.1f\n", average);

    }
}
