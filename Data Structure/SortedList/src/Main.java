public class Main {
    public static void main(String[] args) throws Exception {
        SortedPointers<Integer> array = new SortedPointers<>();

        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.print();

        array.clear();
        array.print();

        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);
        array.print();  


        array.remove(3);
        array.print();
        array.remove(3);
        array.print();
        array.remove(0);
        array.print();
        array.remove(1);
        array.print();
        array.remove(0);
        array.print();
    }
}
