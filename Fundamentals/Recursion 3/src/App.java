import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        
        //Solução sem recursão
        /*
        System.out.print("Digite um número: ");
        int num = input.nextInt();
        input.close();

        int numInvertido = 0;

        while(num != 0){
            int digito = num % 10; // obtem o último dígito
            numInvertido = numInvertido*10 + digito; // cria o número invertido
            num = num/10;  // remove o último dígito, pois é sempre um inteiro
        }
        System.out.println(numInvertido);
        */


        System.out.print("Digite um número: ");
        int num = input.nextInt();
        input.close();
        int numInvert = 0;

        System.out.println(invertNum(num, numInvert));
    }

    public static int invertNum(int num, int invert){
        int digito = 0;
        if(num == 0){
            return invert;
        }
        
        else{
            digito = num%10;
            invert = invert*10 + digito;
            return invertNum(num/10, invert);
        }
        
    }
}
