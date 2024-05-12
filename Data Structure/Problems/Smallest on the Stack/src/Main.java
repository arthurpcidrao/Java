import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        InputStreamReader inputReader = new InputStreamReader(System.in);
        BufferedReader bufferReader = new BufferedReader(inputReader);

        int numOp = Integer.parseInt(bufferReader.readLine());

        LinkedStack<Integer> stack = new LinkedStack<>();

        int leastFun = 1000000000;
        int number;
        String operation;

        for (int i = 0; i < numOp; i++){
            StringTokenizer st = new StringTokenizer(bufferReader.readLine());
            operation = st.nextToken();

            if (operation.equals("PUSH")){
                number = Integer.parseInt(st.nextToken());

                if (stack.isEmpty()){
                    stack.push(number);
                    leastFun = number;
                }
                else{
                    if (leastFun > number){
                        leastFun = number;
                    }
                    stack.push(leastFun);
                }
            }

            else if (operation.equals("POP")){
                if (stack.isEmpty()){
                System.out.println("EMPTY");
                leastFun = 1000000000;
                }
                else{
                    stack.pop();
                    if (!stack.isEmpty()) {
                        leastFun = stack.top();
                    } else {
                        leastFun = 1000000000;
                    }
                }
            }

            else{
                if (stack.isEmpty()){
                    System.out.println("EMPTY");
                    leastFun = 1000000000;
                }
                else{
                    System.out.println(stack.top());
                }
            }
        }
        inputReader.close();
    }
}
