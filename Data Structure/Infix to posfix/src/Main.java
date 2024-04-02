import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        int numCases = input.nextInt();
        input.nextLine();

        Stack<String> posfix = new Stack<>();
        Stack<String> operators = new Stack<>();

        for (int i = 0; i < numCases; i++){

            String sentence = input.nextLine();

            for (int j = 0; j < sentence.length(); j++){
                String ch = sentence.charAt(j) + "";

                //System.out.println("operators: " + operators.top());
                //System.out.println("posfix: " + posfix.top());

                if (ch.equals("(")){
                    operators.push(ch);
                }

                else if (ch.equals("+") || ch.equals("-") || ch.equals("*") ||
                ch.equals("/") || ch.equals("^")){

                    if (!operators.isEmpty() && cases(ch) <= cases(operators.top())){
                        while(!operators.isEmpty() && cases(ch) <= cases(operators.top())){
                            unstack(posfix, operators);
                        }
                        operators.push(ch);
                    }

                    else{
                        operators.push(ch);
                    }
                }
                else{
                    if (!ch.equals(")")){
                        posfix.push(ch);
                    }
                }

                if (!operators.isEmpty() && ch.equals(")")){
                    while(!operators.isEmpty() && !operators.top().equals("(")){
                        unstack(posfix, operators);
                    }
                    operators.pop(); // para remover o parêntese de entrada
                }
                //System.out.println();
                //System.out.println(ch);
                
            }
            while(!operators.isEmpty()){
                unstack(posfix, operators);
            }
            System.out.println(posfix.pop());
            posfix.clear();
            operators.clear();
        }
        
        input.close();
    }




    public static void unstack(Stack<String> posfix, Stack<String> operators){
        String aux1 = "";
        String aux2 = "";
        aux1 = posfix.pop() + operators.pop();
        aux2 = posfix.pop() + aux1;
        posfix.push(aux2);
    }

    public static int cases(String ch){
        
        switch(ch){
            case "+":
                return 1;
            case "-":
                return 1;
            case "*":
                return 2;
            case "/":
                return 2;
            case "^":
                return 3;
            default:
                return 0;
        }
    }
}

