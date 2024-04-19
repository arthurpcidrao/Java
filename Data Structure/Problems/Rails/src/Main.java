import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        int numCoaches = input.nextInt();
        input.nextLine();

        while (numCoaches != 0){
            
            String line = input.nextLine();
            
            while (!line.equals("0")){

                Queue<String> queue = new Queue<>();

                for (int i = 0; i < numCoaches; i++){
                    queue.enqueue(i + 1 + "");
                }

                String coaches[] = line.split(" ");
                LinkedStack<String> stack = new LinkedStack<>();
                Array<String> array = new Array<>();

                int aux = 0;
                while(aux < coaches.length){
                    
                    while(!coaches[aux].equals(stack.top())){
                        if (queue.size() > 0){
                            stack.push(queue.dequeue());
                        }
                        else{
                            break;
                        }
                    }
                    array.add(stack.pop());
                    aux++;
                }

                String answer = "Yes";
                if (array.size() != coaches.length){
                    answer = "No";
                }
                else{
                    for (int i = 0; i < coaches.length; i++){
                        
                        if (!array.getUnit(i).equals(coaches[i])){
                            answer = "No";
                            break;
                        }
                    }
                }
                    
                System.out.println(answer);
                stack.clear();
                array.clear();
                queue.clear();

                line = input.nextLine();
            }
            System.out.println();

            numCoaches = input.nextInt();
            input.nextLine();
        }


        input.close();
    }
}
