public class Lanchonete {
    // atributos
    private int lanche;
    private int qtd;
    
    // métodos

    public Lanchonete(int lanche, int qtd){
        this.lanche = lanche;
        this.qtd = qtd;
    }

    public int getLanche(){
        return lanche;
    }

    public void setLanche(int lanche){
        this.lanche = lanche;
    }

    public int getQtd(){
        return qtd;
    }

    public void setQtd(int qtd){
        this.qtd = qtd;
    }

    public double valorFinal(){
        double preco = 0;

        if (this.lanche == 1){
            preco = 4.00;
        }

        else if (this.lanche == 2){
            preco = 4.50;
        }

        else if (this.lanche == 3){
            preco = 5.00;
        }

        else if (this.lanche == 4){
            preco = 2.00;
        }

        else if (this.lanche == 5){
            preco = 1.50;
        }

        return preco * this.qtd;
    }
}
