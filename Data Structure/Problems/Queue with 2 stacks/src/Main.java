public class Main {
    public static void main(String[] args) throws Exception {
        
        QueueW queue = new QueueW();

        queue.enqueue(0);
        queue.print();
        queue.enqueue(1);
        queue.print();
        queue.enqueue(2);
        queue.print();
        System.out.println(queue.dequeue());
        queue.print();
        System.out.println(queue.dequeue());
        queue.print();
        queue.enqueue(3);
        queue.print();
        queue.enqueue(4);
        queue.print();
        System.out.println(queue.dequeue());
        queue.print();
        queue.enqueue(5);
        queue.print();
        queue.enqueue(6);
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
