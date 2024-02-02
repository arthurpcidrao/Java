import java.util.Scanner;

public class Caravana {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt(), media = 0;
        int vetor[] = new int[n];

        for (int i = 0; i < n; i++){
            vetor[i] = input.nextInt();
            media = media + vetor[i];
        }
        media = media/n;

        for (int i = 0; i < n; i++){
                vetor[i] = media - vetor[i];
                System.out.println(vetor[i]);
        }

        input.close();
    }
}
