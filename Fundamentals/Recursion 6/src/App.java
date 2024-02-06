import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Digite o conjunto a analisar: ");
        
        String conjunto = input.nextLine();
        char letras[] = conjunto.toCharArray();  // converte o conjunto em um vetor de letras do conjunto

        input.close();

        perm(letras, 0, letras.length - 1);
    }

    public static void perm(char letras[], int inicio, int fim){
        
    }

    public static void troca(char letras[], int a, int b){
        char cte = letras[a];
        letras[a] = letras[b];
        letras[b] = cte;
    }

    public static void imprimePerm(char letras[]){
        for (int i = 0; i < letras.length - 1; i++){
            System.out.print(letras[i]);
        }
        System.out.println();
    }
}
