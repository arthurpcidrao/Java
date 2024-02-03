import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //Comb(n, k) = Comb(n-1, k-1) + Comb(n-1, k)
        //decair até k = 1

        Scanner input = new Scanner(System.in);

        System.out.println("Comb(n,k)");

        System.out.print("n = ");
        int n = input.nextInt();
        
        System.out.print("k = ");
        int k = input.nextInt();

        input.close();

        System.out.printf("Comb(%d,%d) = %d", n, k, comb(n,k));
    }

    public static int comb(int n, int k){
        if(n == k){
            return 1;
        }
        else if (k == 1){
            return n;
        }
        else{
            return comb(n-1,k-1) + comb(n-1, k);
        }
    }
}
