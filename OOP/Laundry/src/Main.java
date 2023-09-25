import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);
        
        Washer lava = new Washer();
        Dryer seca = new Dryer();
        Laundry lavanderia = new Laundry(lava, seca);

        int n = input.nextInt();
        lavanderia.setNum(n);

        lava.setMin(input.nextInt());
        lava.setMax(input.nextInt());
       
        seca.setMin(input.nextInt());
        seca.setMax(input.nextInt());

        input.close();

        System.out.println(lavanderia.ehPossivel());

    }
}
