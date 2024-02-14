import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("O Problema de Josefo:");
        System.out.print("tamanho da fila: ");
        int num = input.nextInt();

        int roda[] = new int[num];
        for (int i = 0; i < num; i++){
            roda[i] = i;
        }

        System.out.print("De quanto será pulado? ");
        int passo = input.nextInt();

        int count = 0;
        int finalista = -1;
        int inicio = 0;
        int test = 0;
        while(count < roda.length){

            while (inicio < roda.length){
                roda[inicio] = -1;
                inicio = inicio + passo;
            }
            inicio = inicio - (roda.length - 1);

            test = 0;
            for (int i = 0; i < roda.length; i++){
                count++;
                //System.out.println(roda[i]);
                if(roda[i] != -1){
                    finalista = roda[i];
                    test++;
                    System.out.println(test);
                    count--;
                }
            }
        }

        System.out.printf("O sobrevivente foi o número %d", finalista);

        input.close();
    }
}
