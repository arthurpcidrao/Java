import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        int numCases = input.nextInt();
        input.nextLine();

        for (int i = 0; i < numCases; i++){
            int qtd = input.nextInt();
            input.nextLine();

            int sum = 0;
            for (int j = 0; j < qtd; j++){
                String string = input.nextLine();
                
                for (int k = 0; k < string.length(); k++){
                    sum = sum + hashingFunction(string, k, j);
                }
            }
            System.out.println(sum);

        }

        input.close();
    }

    public static int hashingFunction(String element, int index, int input){
    
        char chars = element.charAt(index);
        int asciiValue = chars - 65;

        return asciiValue + input + index;
    }
}
