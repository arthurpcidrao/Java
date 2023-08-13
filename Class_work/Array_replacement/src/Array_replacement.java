import java.util.Scanner;

public class Array_replacement {
    public static void main(String[] args) throws Exception {
        int x[], i;
        x = new int[10];

        Scanner input = new Scanner(System.in);

        for (i = 0; i < 10; i++) {

            x[i] = input.nextInt();
            
            if (x[i] <= 0) {
                
                x[i] = 1;
            }

            System.out.printf("X[%d] = %d\n", i, x[i]);
        }
    }
}
