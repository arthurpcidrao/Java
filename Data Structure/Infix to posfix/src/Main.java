import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        int num = input.nextInt();
        input.nextLine();

        LinkedStack<String> posfix = new LinkedStack<>();
        LinkedStack<String> operators = new LinkedStack<>();

        for (int i = 0; i < num; i++){
            String expression = input.nextLine();

            int countOperations = 0;
            int preference = 0;
            int currentPref = 0;
            int countP = 0;
            boolean parenteses = false;
            boolean teste = false;
            
            for (int j = 0; j < expression.length(); j++){
                String ch = expression.charAt(j) + "";  // para transformar um char em String, basta concatenar um vazio

                //System.out.println("posfix = " + posfix.top());
                //System.out.println("operators = " + operators.top());

                if (ch.equals("(")){
                    countP = 0;
                    parenteses = true;
                }

                if (ch.equals("+") || ch.equals("-") || ch.equals("*") ||  // continua na próxima linha
                ch.equals("/") || ch.equals("^")){
                    countOperations++;
                    
                    preference = cases(ch);

                    if (parenteses){
                        if (countP == 0){
                            teste = true;
                        }
                        countP++;
                    }

                    if (preference > currentPref || countOperations == 1 || teste){
                        operators.push(ch);
                        teste = false;
                    }                    
                    else{
                        while(posfix.size() > 1){
                            unstack(posfix, operators);
                        }
                        operators.push(ch);
                    }
                    
                    currentPref = preference;
                }
                else if (ch.equals(")")){
                    parenteses = false;
                    while(operators.size() > 0){
                        unstack(posfix, operators);
                    }
                }
                else{
                    if (!ch.equals("(")){
                        posfix.push(ch);
                    }
                }
                //System.out.println();
                //System.out.println(ch);
            }
            while(operators.size() > 0){
                unstack(posfix, operators);
            }
            System.out.println(posfix.top());
            posfix.clear();
            operators.clear();
        }

        input.close();
    }




    public static void unstack(LinkedStack<String> posfix, LinkedStack<String> operators){
        String aux1 = "";
        String aux2 = "";

        aux1 = posfix.pop() + operators.pop();
        aux2 = posfix.pop() + aux1;
        posfix.push(aux2);
    }

    public static int cases(String ch){
        int preference = 0;
        
        switch(ch){
            case "+":
                preference = 0;
                break;
            case "-":
                preference = 0;
                break;
            case "*":
                preference = 1;
                break;
            case "/":
                preference = 1;
                break;
            case "^":
                preference = 2;
                break;
        }
        
        return preference;
    }
}

