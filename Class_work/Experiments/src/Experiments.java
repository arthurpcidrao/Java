import java.util.Scanner;

public class Experiments {
    public static void main(String[] args) throws Exception {
        
        int num;
        double qtde, coelhos = 0, ratos = 0, sapos = 0;
        char animal;
        Scanner input = new Scanner(System.in);

        num = input.nextInt();

        for (int i = 0; i < num; i++){
            
            qtde = input.nextInt();
            animal = input.next().charAt(0);

            if (animal == 'C'){
                coelhos = coelhos + qtde;
            }

            if (animal == 'R'){
                ratos = ratos + qtde;
            }

            if (animal == 'S'){
                sapos = sapos + qtde;
            }
        }
        input.close();

        double total = coelhos + ratos + sapos;

        System.out.printf("Total: %.0f cobaias\nTotal de coelhos: %.0f\nTotal de ratos: %.0f\n", total, coelhos, ratos);
        System.out.printf("Total de sapos: %.0f\nPercentual de coelhos: %.2f %%\nPercentual de ratos: %.2f %%\n", sapos, (coelhos/total)*100, (ratos/total)*100);
        System.out.printf("Percentual de sapos: %.2f %%\n", (sapos/total)*100);

        
    }
}
