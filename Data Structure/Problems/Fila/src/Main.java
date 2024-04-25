import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);
        LinkedQueue<Integer> queue = new LinkedQueue<>();

        int lenQueue = input.nextInt();

        for (int i = 0; i < lenQueue; i++){
            queue.enqueue(input.nextInt());
        }

        int amountExit = input.nextInt();
        int arrayExit[] = new int[amountExit];

        for (int i = 0; i < amountExit; i++){
            arrayExit[i] = input.nextInt();
        }

        boolean removed = false;
        while (lenQueue > 0){
            
            if (amountExit > 0){
                for (int j = 0; j < arrayExit.length; j++){
                    if (((int) queue.getFirst()) == arrayExit[j]){
                        //System.out.println("removeu: "+queue.dequeue());
                        queue.dequeue();
                        amountExit--;
                        lenQueue--;
                        removed = true;
                        break;
                    }
                }
            }

            if (!removed){
                //System.out.println("adicionou: " + queue.getFirst());
                queue.enqueue(queue.dequeue());
                lenQueue--;
            }
            removed = false;
        }

        queue.print();

        input.close();
    }
}
