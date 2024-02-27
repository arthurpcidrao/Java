import java.util.Scanner;

public class ArrayClass {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Array<Integer> vetor = new Array<Integer>();

        vetor.add(7);
        vetor.add(4);
        vetor.add(23);
        vetor.add(9);
        vetor.add(10);
        vetor.add(1);
        vetor.add(32);
        vetor.add(6);
        vetor.add(2);
        vetor.print();
        System.out.println(vetor.size());
        vetor.print();

        vetor.sort();
        vetor.print();
    

        
        input.close();
    }
}
