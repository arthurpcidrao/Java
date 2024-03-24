import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();


        while(input.hasNext()){
            
        String line = input.nextLine();
        String result = "correct";
        for (int i = 0; i < line.length(); i++){
            
            char ch = line.charAt(i);

            if(ch == '('){
                stack.push(ch);
            }
            if (ch == ')'){
                stack.push(ch);
                stack.pop();
                
                if (stack.size() == 0){
                    result = "incorrect";
                    break;
                }
                else{
                    if (stack.top().equals('(')){
                        stack.pop();
                    }
                }
            }
        }
        if (stack.size() > 0){
            result = "incorrect";
        }
        
        System.out.println(result);

        stack.clear();
        }
        input.close();
    }
}
