import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Pinheiro natal = new Pinheiro();
        int altura, largura, galhos;

        for (int i = 0; i < n; i++){

            altura = input.nextInt();
            natal.setAltura(altura);

            largura = input.nextInt();
            natal.setLargura(largura);

            galhos = input.nextInt();
            natal.setGalhos(galhos);

            System.out.println(natal.verifica());
        }

        input.close();
    }
}
