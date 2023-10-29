import java.util.*;

public class Remessas {
    private ArrayList<Pedidos> remessas = new ArrayList<Pedidos>();

    public void adicionarRemessa(Pedidos pedidos){
        remessas.add(pedidos);
    }

    public void imprimirPedidos(){
        int i = 0;
        for (Pedidos p : remessas){
            if (i == remessas.size()-1){
                p.imprimirPedidos();
            }
            else if (i < remessas.size()-1) {
                p.imprimirPedidos();
                System.out.println();
            }
            i++;
        }
    }
}
