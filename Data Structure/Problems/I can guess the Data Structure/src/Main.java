import java.util.Scanner;

public class Main {

    static Heap<Integer> heap = new Heap<>(1000);
    static LinkedQueue<Integer> queue = new LinkedQueue<>();
    static LinkedStack<Integer> stack = new LinkedStack<>();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while(input.hasNext()){

            int numOp = input.nextInt();
            input.nextLine();

            boolean q = true;
            boolean h = true;
            boolean s = true;
           
            for (int i = 0; i < numOp; i++){
                String string = input.nextLine();
                String operation[] = string.split(" ");

                if (Integer.parseInt(operation[0]) == 1){
                    addStructure(Integer.parseInt(operation[1]));
                }
                else{
                    if (q && !popQueue(Integer.parseInt(operation[1]))){
                        q = false;
                    }
                    if (h && !popHeap(Integer.parseInt(operation[1]))){
                        h = false;
                    }
                    if (s && !popStack(Integer.parseInt(operation[1]))){
                        s = false;
                    }

                }

            }

            if (q && !h && !s){
                System.out.println("queue");
            }
            else if (!q && h && !s){
                System.out.println("priority queue");
            }
            else if (!q && !h && s){
                System.out.println("stack");
            }
            else if (!q && !h && !s){
                System.out.println("impossible");
            }
            else{
                System.out.println("not sure");
            }

            queue.clear();
            heap.clear(1000);
            stack.clear();

        }

        input.close();
    }

    public static void addStructure(int unit){
        heap.add(unit);
        queue.enqueue(unit);
        stack.push(unit);
    }

    public static boolean popQueue(int unit){
        int pop = queue.dequeue();
        return pop == unit;
    }

    public static boolean popStack(int unit){
        int pop = stack.pop();
        return pop == unit;
    }

    public static boolean popHeap(int unit){
        int pop = heap.next();
        return pop == unit;
    }
}
