import java.io.IOException;
import java.util.Scanner;

public class Password {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        boolean condition = true;
        int senha;
        while(condition){
            try {
                senha = input.nextInt();
                if (senha != 2002){
                    throw new MyException(0);
                }

                System.out.println("Acesso Liberado");
                break;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        input.close();
    }
}

