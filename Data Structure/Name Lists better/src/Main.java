import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        int num = input.nextInt();
        input.nextLine();

        Listas lista = new Listas();

        for (int i = 0; i < num; i++){
            lista.add(input.nextLine());
        }
        input.close();

        lista.result();
    }
}
