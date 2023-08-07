import java.util.Scanner;

public class Input_data {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o seu nome: ");
        String nome = input.nextLine();

        System.out.print("\nDigite sua nota: ");
        float nota = input.nextFloat();
        
        input.close();

        System.out.format("A nota de %s eh %.4f", nome, nota);
    }

    // Para colocar acento, mudar o UTF-8 que fica na parte inferior direita do Vs Code
}
