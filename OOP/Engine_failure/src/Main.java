import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        Engine maquina = new Engine();

        int num = input.nextInt();

        for (int i = 0; i < num; i++){
            maquina.setRpm(input.nextInt());
            int teste = maquina.getRpm();
            maquina.engineMeasure(teste);
        }

        input.close();

        maquina.tests();

    }
}

