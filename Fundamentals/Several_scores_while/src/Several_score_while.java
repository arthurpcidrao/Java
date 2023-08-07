import java.util.Scanner;

public class Several_scores_while {
    public static void main(String[] args) throws Exception {
        
        int i, x, soma;

        i = 0;
        x = 1;
        soma = 0;

        while (x != 2) {

            if (i < 2) {
                
                Scanner dados = new Scanner(System.in);

                System.out.print("Digite uma nota: ");
                float nota = input.nextFloat();

                dados.close();

                if ((nota >= 0) && (nota<=10)) {
                    i++;
                    soma = soma + nota;
                }
                else {
                    System.out.println("nota invalida");
                }
                
            }

            else {
                if (x == 1) {

                    float media;

                    media = soma/i;

                    System.out.format("media = %.2f", media);
                }
                
                Scanner final = new Scanner(System.in);
                System.out.print("novo calculo (1-sim, 2-nao)\n");

                int x = input.nextFloat();

                final.close();

                if (x == 1) {

                    i = 0;
                    soma = 0;
                }
            }
        }
    }
}


/*
 * i = 0
x = 1
soma = 0

while (x != 2):

    if(i < 2):
        nota = float(input())
        if ((nota>=0) and (nota<=10)):
            i = i+1
            soma = soma + nota
        else:
            print("nota invalida")

    else: 
        if (x == 1):  
            media = soma/i
            print(f"media = {media:.2f}")
            
        x = int(input("novo calculo (1-sim 2-nao)\n"))
        if (x == 1):
            i = 0
            soma = 0
 
  
 */
