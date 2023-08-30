import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        int funcaoControle = 9;
        Scanner input = new Scanner(System.in);

        Televisao tv = new Televisao();
        Controle ctrl = new Controle(tv);  // estou dizendo que o controle (ctrl) vai poder controlar o objeto tv
        
        System.out.println("Comandos do controle:");
        System.out.print("0: encerra o programa");
        System.out.print("\n1: liga a tv\n2: aumenta volume\n3: diminui volume\n4: aumenta canal\n5: diminui canal");
        System.out.print("\n6: coloque números de 1 a 15 para poder ir direto para o canal de interesse\n\n");

        // botões do controle
        while (funcaoControle != 0){

            System.out.print("Controle: ");
            funcaoControle = input.nextInt();
            if (funcaoControle == 1){
                ctrl.tvOn();
            }

            if (funcaoControle == 2){
                ctrl.volumeUp();
            }

            if (funcaoControle == 3){
                ctrl.volumeDown();
            }

            if (funcaoControle == 4){
                ctrl.channelUp();
            }

            if (funcaoControle == 5){
                ctrl.channelDown();
            }

            if (funcaoControle == 6){
                int canal = input.nextInt();
                ctrl.changeChannel(canal);
            }

            tv.imprima();

        }

        input.close();
    }
}
 