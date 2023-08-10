import java.util.Scanner;

public class Highest_number {
    public static void main(String[] args) throws Exception {
        int num, max = 0, pos = 1, i;

        Scanner input = new Scanner(System.in);

        for (i =0; i<5; i++) {

            num = input.nextInt();

            if (i == 0) {
                max = num;
                pos = 1;
            }
            else {
                if (num > max) {
                    max = num;
                    pos = i + 1;
                }
            }
        }

        input.close();

        System.out.println(max);
        System.out.println(pos);
    }
}
