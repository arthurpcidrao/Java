import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        int numCoaches = input.nextInt();
        input.nextLine();

        while (numCoaches != 0){
            
            String line = input.nextLine();
            String coaches[] = line.split(" ");

            String finish = input.nextLine();
            String letters[] = finish.split(" ");

            Queue<String> queue = new Queue<>();

            for (int i = 0; i < numCoaches; i++){
                queue.enqueue(coaches[i]);
            }
            
            LinkedStack<String> stack = new LinkedStack<>();
            String array[] = new String[letters.length];

            String answer = "";
            int aux = 0;
            while(aux < coaches.length){
                
                while(!letters[aux].equals(stack.top())){
                    if (queue.size() > 0){
                        stack.push(queue.dequeue());
                        System.out.print("I");
                    }
                    else{
                        break;
                    }
                }
                array[aux] = stack.pop();
                if (array[aux].equals(letters[aux])){
                    System.out.print("R");
                }
                else{
                    answer = " Impossible";
                    break;
                }
                aux++;
            }

            System.out.println(answer);
            stack.clear();
            queue.clear();

            numCoaches = input.nextInt();
            input.nextLine();
        }


        input.close();
    }
}
