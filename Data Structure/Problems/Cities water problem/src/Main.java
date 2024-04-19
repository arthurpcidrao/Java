import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        int numCases = input.nextInt();
        while(numCases != 0){
            House houses = new House(input.nextInt(), input.nextInt());
        }

        input.close();
    }
}
