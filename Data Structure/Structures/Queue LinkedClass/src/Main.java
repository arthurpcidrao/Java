public class Main {
    public static void main(String[] args) throws Exception {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(1);
        queue.print();
        queue.enqueue(2);
        queue.print();
        queue.enqueue(3);
        queue.print();
        queue.enqueue(4);
        queue.print();
        queue.enqueue(5);
        queue.print();
        queue.enqueue(6);
        queue.print();

        queue.dequeue();
        System.out.println(queue.next());
        queue.print();
        queue.dequeue();
        System.out.println(queue.next());
        queue.print();
        queue.dequeue();
        queue.print();
        queue.dequeue();
        queue.print();
        queue.dequeue();
        queue.print();
        queue.dequeue();
        queue.print();

    }
}
