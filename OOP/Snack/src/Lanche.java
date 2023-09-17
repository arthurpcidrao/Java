public class Lanche {
    private int codigo;
    private double preco;

    public int getCodigo(){
        return codigo;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public double getPreco(){
        return preco;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public double definePreco(){
        if (this.codigo == 1){
            this.preco = 4.00;
        }
        else if (this.codigo == 2){
            this.preco = 4.50;
        }

        else if (this.codigo == 3){
            this.preco = 5.00;
        }

        else if (this.codigo == 4){
            this.preco = 2.00;
        }

        else if (this.codigo == 5){
            this.preco = 1.50;
        }

        return this.preco;
    }
}
