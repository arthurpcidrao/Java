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

            int preference = 0;
            int currentPreference = 0;
            int countOp = 0;
            boolean moreThanOne = false;

            for (int j = 0; j < sentence.length(); j++){
                String ch = sentence.charAt(j) + "";

                System.out.println("posfix = " + posfix.top());
                System.out.println("operators = " + operators.top());

                if (ch.equals("(")){
                    operators.push(ch);
                    countOp = 0;
                    moreThanOne = false;
                }

                if (ch.equals("+") || ch.equals("-") || ch.equals("*") ||
                ch.equals("/") || ch.equals("^")){
                    moreThanOne = false;
                    countOp++;
                    
                    preference = cases(ch);

                    if (preference > currentPreference || countOp == 1){
                        operators.push(ch);
                    }
                    else{
                        if (operators.exists("(")){
                            while(!operators.top().equals("(") && cases(operators.top()) >= preference){
                                unstack(posfix, operators);
                            }
                        }
                        else{
                            while(!operators.isEmpty() && cases(operators.top()) >= preference){
                                unstack(posfix, operators);
                            }
                        }
                        operators.push(ch);
                    }
                    currentPreference = preference;
                }
                else if(ch.equals(")")){
                    moreThanOne = false;
                    while(!operators.top().equals("(")){
                        unstack(posfix, operators);
                    }
                    operators.pop();
                }
                else{
                    if (!ch.equals("(")){
                        posfix.push(ch);
                        if (moreThanOne){
                            String aux2 = posfix.pop();
                            String aux1 = posfix.pop();
                            posfix.push(aux1+aux2);
                        }
                        moreThanOne = true;
                    }
                }
                
                System.out.println();
                System.out.println(ch);
            }
            while(operators.size() > 0){
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

