import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        while(input.hasNext()){
            String expression = input.nextLine();
            if (lexicalAnalysis(expression)){
                if (parenthesisBalance(expression)){
                    System.out.println(inToPofix(expression));
                }else{
                    System.out.println("Syntax Error!");
                }
            }else{
                System.out.println("Lexical Error!");
            }
        }

        input.close();
    }

    public static boolean lexicalAnalysis(String expression){
        String regex = "[a-zA-Z0-9^*/+-<>=#.| ()]{1,}";

        return expression.matches(regex);
    }

    public static boolean parenthesisBalance(String expression){
        boolean result = true;
        LinkedStack<Character> stack = new LinkedStack<>();
        int index = 0;
        
        for (int i = 0; i < expression.length(); i++){
            
            char ch = expression.charAt(i);

            if(ch == '('){
                stack.push(ch);
                index = i;
            }
            if (ch == ')'){
                
                if (i == index + 1){
                    result = false;
                    break;
                }
                
                if (stack.size() == 0){
                    result = false;
                    break;
                }
                else{
                    stack.pop();
                    
                }
            }
        }
        if (stack.size() > 0){
            result = false;
        }
        
        return result;
    }

    public static String inToPofix(String expression){
        LinkedStack<String> posfix = new LinkedStack<>();
        LinkedStack<String> operators = new LinkedStack<>();
        int countPos = 0;
        int countOpe = 0;
        
        for (int j = 0; j < expression.length(); j++){
            String ch = expression.charAt(j) + "";

            if (ch.equals("(")){
                operators.push(ch);
            }

            else if (ch.equals("+") || ch.equals("-") || ch.equals("*") ||
            ch.equals("/") || ch.equals("^") || ch.equals(">") || ch.equals("<")
            || ch.equals("=") || ch.equals("#") || ch.equals(".") || ch.equals("|")){
                
                if (countOpe > 0 || j == 0){
                    posfix.clear();
                    operators.clear();
                    posfix.push("Syntax Error!");
                    break;
                }

                if (!operators.isEmpty() && cases(ch) <= cases(operators.top())){
                    while(!operators.isEmpty() && cases(ch) <= cases(operators.top())){
                        unstack(posfix, operators);
                    }
                    operators.push(ch);
                }

                else{
                    operators.push(ch);
                }

                if (countPos > 0){
                    countPos--;
                }
                countOpe++;
            }
            else{
                if (!ch.equals(")")){
                    if(countPos > 0){
                        posfix.clear();
                        operators.clear();
                        posfix.push("Syntax Error!");
                        break;   
                    }
                    posfix.push(ch);
                    countPos++;
                    if (countOpe > 0){
                        countOpe--;
                    }
                }
            }

            if (!operators.isEmpty() && ch.equals(")")){
                while(!operators.isEmpty() && !operators.top().equals("(")){
                    unstack(posfix, operators);
                }
                operators.pop(); // para remover o parêntese de entrada
            }
            
        }
        while(!operators.isEmpty()){
            unstack(posfix, operators);
        }
        return posfix.pop();
        
    }

    public static void unstack(LinkedStack<String> posfix, LinkedStack<String> operators){
        String aux1 = "";
        String aux2 = "";
        aux1 = posfix.pop() + operators.pop();
        aux2 = posfix.pop() + aux1;
        posfix.push(aux2);
    }

    public static int cases(String ch){
        
        switch(ch){
            case "|":
                return 1;
            case ".":
                return 2;
            case "#":
                return 3;
            case "=":
                return 3;
            case ">":
                return 3;
            case "<":
                return 3;
            case "-":
                return 4;
            case "+":
                return 4;
            case "*":
                return 5;
            case "/":
                return 5;
            case "^":
                return 6;
            default:
                return 0;
        }
    }
}
