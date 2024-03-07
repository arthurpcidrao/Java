public class Main {
    public static void main(String[] args) throws Exception {
        SortedPointers<Integer> array = new SortedPointers<>();

        array.add(4);
        array.add(3);
        array.add(2);
        array.add(5);
        array.add(1);

        array.print();

        array.remove();

        array.add(8);
        array.print();
    }
}

