public class Main {
    public static void main(String[] args) throws Exception {
        Queue<Integer> queue = new Queue<>();

        queue.enqueue(3);
        queue.print();
        queue.enqueue(4);
        queue.print();
        queue.enqueue(9);
        queue.print();
        queue.enqueue(1);
        queue.print();
        queue.enqueue(5);
        queue.print();

        System.out.println(queue.dequeue());
        queue.print();
        System.out.println(queue.dequeue());
        queue.print();
        System.out.println(queue.dequeue());
        queue.print();
        System.out.println(queue.dequeue());
        queue.print();
    }
}
