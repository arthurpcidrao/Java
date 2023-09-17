import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);
        
        int codigo = input.nextInt();
        int quantidade = input.nextInt();
        double result;
        input.close();

        Lanche lanche = new Lanche();
        NotaFiscal nota = new NotaFiscal(lanche);
        nota.setQtd(quantidade);
        lanche.setCodigo(codigo);
        lanche.definePreco();

        result = nota.calculaPreco();

        System.out.printf("Total: R$ %.2f\n",result);

    }
}
