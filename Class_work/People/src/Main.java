import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        People person1 = new People();

        Scanner input = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        person1.setName(input.nextLine());

        System.out.print("\nDigite sua idade (dd/mm/aaaa): ");
        person1.setBirthday(input.nextLine());
        
        System.out.println("\nDigite sua altura: ");
        person1.setHeight(input.nextDouble());

        input.close();

        int age1 = person1.age();

        person1.print(age1);

    }
}

