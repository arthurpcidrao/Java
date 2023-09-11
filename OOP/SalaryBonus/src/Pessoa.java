public class Pessoa {
    private String nome;
    private double salario;
    private double vendas;


    public Pessoa(String nome, double salario, double vendas){
        this.nome = nome;
        this.salario = salario;
        this.vendas = vendas;
    }


    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public double getSalario(){
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getVendas() {
        return vendas;
    }

    public void setVendas(double vendas){
        this.vendas = vendas;
    }

    public double calculaFinal(){
        return this.salario + (0.15 * this.vendas);
    }
}
