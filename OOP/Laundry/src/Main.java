import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);
        int LA, LB, SA, SB;
        int n = input.nextInt();
        Laundry lavanderia = new Laundry();
        Washer lava = new Washer();
        Dryer seca = new Dryer();

        boolean resultW, resultD;
        
        LA = input.nextInt();
        LB = input.nextInt();
        lava.setMin(LA);
        lava.setMax(LB);
        resultW = lava.calcWash(n);

        SA = input.nextInt();
        SB = input.nextInt();
        seca.setMin(SA);
        seca.setMax(SB);
        resultD = seca.calcDry(n);

        input.close();
        String result = lavanderia.ehPossivel(resultW, resultD);

        System.out.println(result);

    }
}
