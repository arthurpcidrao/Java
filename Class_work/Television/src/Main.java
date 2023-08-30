import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        char funcaoControle = 'f';
        Scanner input = new Scanner(System.in);

        Televisao tv = new Televisao();
        Controle ctrl = new Controle(tv);  // estou dizendo que o controle (ctrl) vai poder controlar o objeto tv
        
        System.out.println("Comandos do controle:");
        System.out.print("o: ligar/desligar\nr: aumentar volume\nl: abaixar volume\nu: aumentar canal");
        System.out.print("\nd: diminui canal\ns: finaliza a execucao");

        // botões do controle
        while (funcaoControle != 's'){
            funcaoControle = input.next().charAt(0);
            if (funcaoControle == 'o'){
                ctrl.tvOn();
            }

            if (funcaoControle == 'r'){
                ctrl.volumeUp();
            }

            if (funcaoControle == 'l'){
                ctrl.volumeDown();
            }

            if (funcaoControle == 'u'){
                ctrl.channelUp();
            }

            if (funcaoControle == 'd'){
                ctrl.channelDown();
            }



        }

        input.close();
    }
}
 