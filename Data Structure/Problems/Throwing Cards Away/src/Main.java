import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        
        int numCards = input.nextInt();
        while(numCards > 0){

            Queue<Integer> queue = new Queue<>(50);

            for (int i = 0; i < numCards; i++){
                queue.enqueue(i+1);
            }

            String discard = "Discarded cards: ";

            if (numCards > 1){
                while(queue.size() > 2){
                    discard = discard + queue.dequeue() + ", ";
                    queue.enqueue(queue.dequeue());
                }
                discard = discard + queue.dequeue();
            }
            
            System.out.println(discard);
            System.out.println("Remaining card: " + queue.dequeue());

            numCards = input.nextInt();
        }

        input.close();
    }
}
