public class Main {
    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>(9);

        heap.add(17);
        heap.add(19);
        heap.add(36);
        heap.add(3);
        heap.add(25);
        heap.add(100);
        heap.add(7);
        heap.add(1);
        heap.add(2);

        heap.print();

        System.out.println(heap.next());
        System.out.println(heap.next());
        System.out.println(heap.next());
        System.out.println(heap.next());
        System.out.println(heap.next());
        System.out.println(heap.next());
        System.out.println(heap.next());
        System.out.println(heap.next());
        System.out.println(heap.next());
    }

}
