import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        int count = 0, condition = 1;
        double nota, media = 0;

        while (condition == 1){
            try {
                nota = input.nextDouble();
                if (nota > 10.0 || nota < 0.0){
                    throw new MyException(0);
                }
                media += nota;
                count++;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            if (count == 2){
                media = media/count;
                System.out.printf("media = %.2f\n", media);
                System.out.println("novo calculo (1-sim 2-nao)");
                condition = input.nextInt();
                
                while(condition > 2 || condition < 1){
                    System.out.println("novo calculo (1-sim 2-nao)");
                    condition = input.nextInt();
                }
                count = 0;
                media = 0;
            }
        }
        input.close();
    }
}

