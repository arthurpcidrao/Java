public class Main {
    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>(5);

        heap.add(384);
        heap.add(887);
        heap.add(778);
        heap.add(916);
        heap.add(794);

        heap.print();

        System.out.println(heap.next());
        heap.print();
        System.out.println(heap.next());
        heap.print();
        System.out.println(heap.next());
        heap.print();
        System.out.println(heap.next());
        heap.print();
        System.out.println(heap.next());
    }

}
