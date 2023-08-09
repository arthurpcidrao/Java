import java.util.Scanner;

public class Set_function_fatorial {

    // Criação de função fica fora da função principal (main)
    public static long fatorial(long n){
        long fator = 1;
        for (int i = 1; i <= n; i++) {
            fator = i*fator;
        }
        return fator;
    }

    // Função principal (início da leitura)
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        System.out.printf("Digite um número e receba seu fatorial: ");
        long fat = input.nextInt();

        input.close();

        long resp;
        resp = fatorial(fat);
        System.out.printf("O fatorial de %d eh %d!", fat, resp); // ou System.out.format()
        //double termo = Math.pow(4,6);
        //para números float, usar sempre Double

    }
}
