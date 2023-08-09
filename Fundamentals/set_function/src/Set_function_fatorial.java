import java.util.Scanner;

public class Set_function_fatorial {

    // Criação de função fica fora da função principal (main)
    public static int fatorial(int n){
        int fator = 1;
        for (int i = 1; i <= n; i++) {
            fator = i*fator;
        }
        return fator;
    }

    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        System.out.print("Digite um número e receba seu fatorial: ");
        int fat = input.nextInt();

        input.close();

        int resp;
        resp = fatorial(fat);
        System.out.format("O fatorial de %d eh %d!", fat, resp);
        
    }
}
