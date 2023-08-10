import java.util.Scanner;

public class Sum_odd_between {
    public static void main(String[] args) throws Exception {
        
        int lower, higher, aux, i, sum = 0;
        Scanner input = new Scanner(System.in);

        lower = input.nextInt();
        higher = input.nextInt();

        input.close();

        if (lower > higher) {
            aux = lower;
            lower = higher;
            higher = aux;
        }

        for (i = lower+1; i < higher; i++) {

            if ((i % 2 == 1) || (i % 2 == -1)) {
                sum = sum + i;
            }
        }

        System.out.println(sum);
    }
}
