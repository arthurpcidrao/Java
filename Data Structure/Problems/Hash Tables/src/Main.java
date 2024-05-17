import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();

        String ans = "";

        for (int i = 0; i < numCases; i++){
            int sizeTable = input.nextInt();
            HashingTable<String> table = new HashingTable<>(sizeTable);

            int inputsTable = input.nextInt();

            for (int j = 0; j < inputsTable; j++){
                int number = input.nextInt();
                table.add(Integer.toString(number));
            }

            if (i < numCases - 1){
                ans = ans + table.show() + "\n";
            }else{
                ans = ans + table.show();
            }
            
        }

        System.out.print(ans);

        input.close();
    }
}
