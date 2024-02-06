import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("MDC(x,y)");
        
        System.out.print("x = ");
        int x = input.nextInt();

        System.out.print("y = ");
        int y = input.nextInt();

        input.close();

        System.out.printf("O mdc(%d,%d) = %d", x, y, mdc(x,y));
    }

    public static int mdc(int a, int b){
        if(b == 0){
            return a;
        }
        return mdc(b, a%b);
    }
}
