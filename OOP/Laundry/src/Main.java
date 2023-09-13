import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        Washer lava = new Washer(n);
        Dryer seca = new Dryer(n);

        boolean resultW, resultD;

        int LA, LB, SA, SB;
        
        LA = input.nextInt();
        lava.setMinW(LA);

        LB = input.nextInt();
        lava.setMaxW(LB);

        SA = input.nextInt();
        seca.setMinD(SA);

        SB = input.nextInt();
        seca.setMaxD(SB);

        input.close();

        resultW = lava.calcWash();
        resultD = seca.calcDry();

        if (resultW && resultD){
            System.out.println("possivel");
        }
        else{
            System.out.println("impossivel");
        }

    }
}
