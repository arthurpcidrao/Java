import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);
        
        int vetor[] = new int[10];

        for (int i = 0; i < vetor.length; i++){
            vetor[i] = input.nextInt();
        }

        input.close();
        
        System.out.printf("O maior valor do vetor é: %d", valorMax(vetor, vetor.length - 1, vetor[9]));
    }

    public static int valorMax(int vetor[], int i, int maiorValor){
        if (i >= 0){
            if (maiorValor < vetor[i]){
                maiorValor = vetor[i];
            }
            return valorMax(vetor, i-1, maiorValor);
        }
        else{
            return maiorValor;
        }
    }
}
