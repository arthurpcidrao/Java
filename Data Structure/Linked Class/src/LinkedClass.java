import java.util.Scanner;

public class LinkedClass {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        LinkedPointers<Integer> array = new LinkedPointers<>();

        array.add(5);
        array.add(2);
        array.add(8);
        array.add(1);
        array.add(213);
        array.add(3);

        array.print();

        //array.add(4, 2);

        //array.print();
        System.out.println(array.getUnit(2));
        System.out.println(array.exists(123));
        array.remove(3);
        array.print();
        array.add(45);
        array.print();

        
        input.close();
    }
}
