public class JeepTour {
    // atributos
    private String park;
    private int turistasJeep;
    private int qtdTuristas;
    private int qtdJeeps;

    // métodos

    public JeepTour (int qtdTuristas, int qtdJeeps){
        this.qtdTuristas = qtdTuristas;
        this.qtdJeeps = qtdJeeps;
    }
    
    public String getPark() {
        return park;
    }

    public void setPark(String park){
        this.park = park;
    }

    public int getTuristas(){
        return turistasJeep;
    }

    public void setTuristas(int turistasJeep){
        this.turistasJeep = turistasJeep;
    }

    public int getQtdTuristas(){
        return qtdTuristas;
    }

    public void setQtdTuristas(int qtdTuristas){
        this.qtdTuristas = qtdTuristas;
    }

    public int getQtdJeeps(){
        return qtdJeeps;
    }

    public void setQtdJeeps(int qtdJeeps){
        this.qtdJeeps = qtdJeeps;
    }

    public void turistasPark(){
        this.qtdTuristas = this.qtdTuristas + this.turistasJeep;
    }

    public void turistasCentro(){
        this.qtdTuristas = this.qtdTuristas - this.turistasJeep;
    }

    public void jeepsPark(){
        this.qtdJeeps++;
    }

    public void jeepsCentro(){
        this.qtdJeeps--;
    }
    
}
