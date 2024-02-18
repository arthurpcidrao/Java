import java.util.Scanner;

public class ArrayClass {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Array vetor = new Array(8);

        // essa classe ainda está aceitando um vetor com tipos variados
        // isso não é natural de uma estrutura de dados... resolver isso com o type[].

        vetor.add("arthur");
        vetor.add("b");
        vetor.add("c");
        vetor.add("d");
        vetor.add("e");
        vetor.add("f");
        vetor.add("g");
        vetor.add("h");
        vetor.print();
        System.out.println(vetor.size());

        System.out.println(vetor.exists("arthur"));

        //vetor.add("alice",1);
        
        vetor.remove(3);
        vetor.print();
        System.out.println(vetor.size());
        input.close();
    }
}
