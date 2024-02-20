import java.util.Scanner;

//n1 / d1 + n2 / d2
//0  1  2 3  4 5  6


public class App {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        int numCases = input.nextInt();
        input.nextLine();
        
        for (int i = 0; i < numCases; i++){
            String texto = input.nextLine();
            String vetor[] = texto.split(" ");
           
            int ans[] = new int[2];

            int n1 = Integer.parseInt(vetor[0]);
            int d1 = Integer.parseInt(vetor[2]);
            int n2 = Integer.parseInt(vetor[4]);
            int d2 = Integer.parseInt(vetor[6]);

            if (vetor[3].equals("+")){
                ans[0] = n1*d2 + n2*d1;
                ans[1] = d1*d2;
            }
            if (vetor[3].equals("-")){
                ans[0] = n1*d2 - n2*d1;
                ans[1] = d1*d2;

            }
            if (vetor[3].equals("*")){
                ans[0] = n1*n2;
                ans[1] = d1*d2;
            }
            if (vetor[3].equals("/")){
                ans[0] = n1*d2;
                ans[1] = n2*d1;
            }

            System.out.printf("%d/%d = ", ans[0], ans[1]);
            int mdc = mdc(Math.abs(ans[0]), ans[1]);
            ans[0] = ans[0]/mdc;
            ans[1] = ans[1]/mdc;
            System.out.printf("%d/%d\n", ans[0], ans[1]);
        }
        
        input.close();
    }

    public static int mdc(int a, int b){
        if(b == 0){
            return a;
        }
        return mdc(b, a%b);
    }
}
