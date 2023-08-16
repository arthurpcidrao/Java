import java.util.Scanner;

public class Prime_numbers {
    public static void main(String[] args) throws Exception {
        
        int num, i, j, test[], count;

        Scanner input = new Scanner(System.in);

        num = input.nextInt();

        long prime[];
        prime = new long[num];
        test = new int[num];

        for (i = 0; i < num; i++) {

            prime[i] = input.nextLong();
            count = 0;
            for (j = 1; j<= prime[i]/2; j++) {
                
                if (prime[i]%j == 0) {
                    count++;
                }
            }
            test[i] = count;
        }

        for (i = 0; i < num; i++) {

            if (test[i] == 1) {
                System.out.printf("%d eh primo\n", prime[i]);
            }
            else {
                System.out.printf("%d nao eh primo\n", prime[i]);
            }
        }
    }
}
