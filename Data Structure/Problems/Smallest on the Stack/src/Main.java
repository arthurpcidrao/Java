import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        int numOp = input.nextInt();
        input.nextLine();

        Stack<Integer> stack = new Stack<>(1000000);

        int leastFun = 0;
        String answer = "";

        for (int i = 0; i < numOp; i++){
            String string = input.nextLine();
            String operation[] = string.split(" ");

            if (operation.length > 1){
                int number = Integer.parseInt(operation[1]);
                if (stack.size() == 0){
                    stack.push(number);
                    leastFun = number;
                }
                else{
                    if (leastFun >= number){
                        leastFun = number;
                    }
                    stack.push(leastFun);
                }
            }

            else if (string.equals("POP")){
                if (stack.size() == 0){
                    answer = answer + "EMPTY\n";
                }
                else{
                    stack.pop();
                }
            }

            else{
                if (stack.size() == 0){
                    answer = answer + "EMPTY\n";
                }
                else{
                    answer = answer + stack.top() + "\n";
                }
            }
        }
        System.out.print(answer);
        input.close();
    }
}
