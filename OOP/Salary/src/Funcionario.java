public class Funcionario {

    private int numero;
    private int horasTrabalho;
    private double valorHrs;

    // Método construtor:
    public Funcionario(int numero, int horasTrabalho, double valorHrs){
        this.numero = numero;
        this.horasTrabalho = horasTrabalho;
        this.valorHrs = valorHrs;
    }

    // Métodos
    public int getNumero() {
        return numero;
    }

    public void setNumero( int numero) {
        this.numero = numero;
    }

    public int getHorasTrabalho(){
        return horasTrabalho;
    }

    public void setHorasTrabalho(int horasTrabalho) {
        this.horasTrabalho = horasTrabalho;
    }

    public double getValorHrs() {
        return valorHrs;
    }

    public void setValorHrs(double valorHrs){
        this.valorHrs = valorHrs;
    }

    public double calcularSalario() {
        return this.horasTrabalho * this.valorHrs;
    }
}
