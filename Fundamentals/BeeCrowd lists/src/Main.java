import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        
        int testCases = input.nextInt();
        for (int i = 0; i < testCases; i++){
            
            int num = input.nextInt();
            int vetor[] = new int[2];
            
            vetor[0] = -1;
            vetor [1] = fib(num, vetor);
            
            System.out.printf("fib(%d) = %d calls = %d\n", num, vetor[0], vetor[1]);
        }

        input.close();
    }

    public static int fib(int num, int vetor[]){
        vetor[0]++;

        if (num == 0){
            return 0;
        }
        if (num == 1){
            return 1;
        }

        return fib(num-1, vetor) + fib(num-2, vetor);
    }
}
