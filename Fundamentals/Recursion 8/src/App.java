import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        int cases = input.nextInt();
        //System.out.println("O Problema de Josefo:");
        //System.out.print("tamanho da fila: ");
        //int n = input.nextInt();

        //System.out.print("De quanto será pulado? ");
        //int k = input.nextInt();

        for (int i = 0; i < cases; i++){
            int n = input.nextInt();
            int k = input.nextInt();
            System.out.printf("Case %d: %d\n", i+1, josephus(n,k)+1);
        }
        input.close();
    }

    public static int josephus(int n, int k){
        
        if (n == 1){
            return 0;
        }

        return (josephus(n-1,k) + k)%n;
    }
}
