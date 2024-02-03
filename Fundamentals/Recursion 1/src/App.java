import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);
        
        int vetor[] = new int[10];

        for (int i = 0; i < vetor.length; i++){
            vetor[i] = input.nextInt();
        }

        input.close();
        
        System.out.printf("O maior valor do vetor é: %d", valorMax(vetor, vetor.length - 1, 0));
    }

    public static int valorMax(int vetor[], int i, int soma){
        if (i >= 0){
            if (vetor[i] > 0){
                soma = soma + vetor[i];
            }
            return valorMax(vetor, i-1, soma);
        }
        else{
            return soma;
        }
    }
}
