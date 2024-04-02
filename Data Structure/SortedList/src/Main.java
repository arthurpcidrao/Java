public class Main {
    public static void main(String[] args) throws Exception {
        SortedPointers<String> array = new SortedPointers<>();

        array.add("1");
        array.add("2");
        array.add("3");
        array.add("4");
        array.add("5");
        array.print();

        array.clear();
        array.print();

        array.add("2");
        array.add("3");
        array.add("4");
        array.add("5");
        array.add("6");
        array.add("1");
        array.print();

        
        System.out.println(array.getIndex("3"));


    }
}
