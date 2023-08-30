public class Elevador {
    
    // Atributos
    private int andarAtual;
    private int totalAndares;
    private int capacidade;
    private int qtdPessoas;

    //Métodos

    public int getAndarAtual(){
        return andarAtual;
    }

    public void setAndarAtual(int andarAtual){
        this.andarAtual = andarAtual;
    }

    public int getTotalAndares(){
        return totalAndares;
    }

    public void setTotalAndares(int totalAndares){
        this.totalAndares = totalAndares;
    }

    // fazer get e set para os outros atributos

    public Elevador(int capacidade, int totalAndares){
        inicializa(capacidade, totalAndares);
    }

    private void inicializa(int capacidade, int totalAndares) {
        this.capacidade = capacidade;
        this.totalAndares = totalAndares;
        this.andarAtual = 0;  // elevador no térreo
        this.qtdPessoas = 0;  // ekevador vazio
    }

    public void entra() {
        if (this.qtdPessoas < this.capacidade){
            this.qtdPessoas++;
        }
    }

    public void sai() {
        if (this.qtdPessoas > 0){
            this.qtdPessoas--;
        }
    }

    public void sobe() {
        if (this.andarAtual < this.totalAndares){
            this.andarAtual++;
        }
    }

    public void desce() {
        if (this.andarAtual > 0) {
            this.andarAtual--;
        }
    }

    public void exibir(){
        System.out.printf("Total de andares: %d\n", this.totalAndares);
        System.out.printf("Capacidade: %d\n", this.capacidade);
        System.out.printf("Andar atual: %d\n", this.andarAtual);
        System.out.printf("Qtd. pessoas: %d", this.qtdPessoas);
    }



}


