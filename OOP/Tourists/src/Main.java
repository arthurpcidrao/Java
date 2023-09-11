import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        JeepTour peru = new JeepTour(0, 0);

        int turistasJeep = 0;
        boolean test = true;

        while (test){

            String park = input.next();
            peru.setPark(park);

            if (!park.equals("ABEND")){  // usar .EQUALS para Strings
                turistasJeep = input.nextInt();
                peru.setTuristas(turistasJeep);
                if (park.equals("SALIDA")){
                    peru.turistasPark();
                    peru.jeepsPark();
                }
                else if (park.equals("VUELTA")){
                    peru.turistasCentro();
                    peru.jeepsCentro();
                }
                test = true;
            }
            else{
                test = false;
            }
        }
        input.close();

        System.out.printf("%d\n", peru.getQtdTuristas());
        System.out.printf("%d\n", peru.getQtdJeeps());
    }
}
