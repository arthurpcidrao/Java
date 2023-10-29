import java.util.Scanner;

public class Tshirts_problem {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        Remessas remessas = new Remessas();

        int num = 1;
        while(num > 0){
            num = input.nextInt();
            if(num == 0){
                break;
            }
          
            input.nextLine();

            Pedidos pedidos = new Pedidos();

            for (int i = 0; i < num; i++){
                pedidos.adicionarPedido(input.nextLine(), input.next(), input.nextLine());
            }
            pedidos.ordenar();

            remessas.adicionarRemessa(pedidos);
        }
        remessas.imprimirPedidos();

        input.close();
    }
}
