import java.util.Scanner;

public class Interval {
    public static void main(String[] args) throws Exception {
        int num, x, sum = 0;

        Scanner input = new Scanner(System.in);

        num = input.nextInt();

        for (int i = 0; i < num; i++) {

            x = input.nextInt();
            if ((x>=10) && (x<=20)) {

                sum++;
            }
        }
        input.close();

        int out = 0;

        out = num - sum;
        System.out.printf("%d in\n", sum);
        System.out.printf("%d out\n", out); 

    }
}
