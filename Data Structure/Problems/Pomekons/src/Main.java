import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        
        int num = input.nextInt();
        input.nextLine();
        
        Wallet carteira = new Wallet();

        for (int i = 0; i < num; i++){
            carteira.add(input.nextLine());
        }
        input.close();

        carteira.result();
    }
}
