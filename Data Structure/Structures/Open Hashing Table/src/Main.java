public class Main {
    public static void main(String[] args) throws Exception {
        HashingTable table = new HashingTable(8);

        table.add(5);
        table.add(2);
        table.add(8);
        table.add(1);
        table.add(0);
        table.add(4);
        table.add(7);
        table.add(9);

        table.print();
        System.out.println();

        table.remove(9);
        table.print();

        System.out.println();
        table.remove(2);
        table.print();

        System.out.println();
        table.remove(0);
        table.print();

        System.out.println();
        table.add(12);
        table.print();
    }
}
