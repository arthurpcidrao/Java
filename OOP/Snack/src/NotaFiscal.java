public class NotaFiscal {
    // atributos
    private Lanche lanche;
    private int qtd;
    
    // métodos

    public NotaFiscal(Lanche lanche){
        this.lanche = lanche;
    }

    public int getQtd(){
        return qtd;
    }

    public void setQtd(int qtd){
        this.qtd = qtd;
    }

    public double calculaPreco(){
        return lanche.getPreco()*this.qtd;
    }

}