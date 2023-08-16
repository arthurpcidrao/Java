import java.util.Scanner;

public class Example_while {
    public static void main(String[] args) throws Exception {
        
        int age = 0, qtd = 0;
        double average, sum = 0;

        Scanner input = new Scanner(System.in);

        while (age >= 0) {
            
            age = input.nextInt();
            
            if (age >= 0) {
                qtd++;
                sum = sum + age;
            }
        }
        input.close();
        average = sum/(qtd);

        System.out.printf("%.2f\n", average);

    }
}
