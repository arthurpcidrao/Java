import java.util.*;

public class Pedidos {

    private ArrayList<Tshirt> pedidos = new ArrayList<Tshirt>();

    public void adicionarPedido(String nome, String cor, String tam){
        Tshirt camisa = new Tshirt();
        camisa.setNome(nome);
        camisa.setCor(cor);
        camisa.setTamanho(tam);
        
        pedidos.add(camisa);
    }

    public void ordenar(){
        Collections.sort(pedidos);
    }

    public void imprimirPedidos(){
        for (Tshirt t : pedidos){
            t.printCamisa();
        }
    }
}
