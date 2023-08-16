import java.util.Scanner;

public class Fibonacci {
    
    public static long fibonacci(int n) {

        long vector[];
        vector = new long[n];

        int i;
        for (i = 0; i < n; i++) {

            if (i == 0) {
                vector[i] = 0;
            }
            else if (i == 1) {
                vector[i] = 1;
            }
            else {
                vector[i] = vector[i-1] + vector[i-2];
            }
        }

        for (i = 0; i < n; i ++) {

            if (i == n-1) {
                System.out.printf("%d\n", vector[i]);
            }
            else {
                System.out.printf("%d ", vector[i]);
            }
        }
        return 0;
    }
    
    
    public static void main(String[] args) throws Exception {
        
        int num;

        Scanner input = new Scanner(System.in);

        num = input.nextInt();
        input.close();
        fibonacci(num);
    }
}
