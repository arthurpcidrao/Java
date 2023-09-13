public class Batalha {
    private int bonus;
    private Pokemons dabriel;
    private Pokemons guarte;
    private double valorDabriel;
    private double valorGuarte;

    public Batalha(Pokemons dabriel, Pokemons guarte){
        this.dabriel = dabriel;
        this.guarte = guarte;
    }

    public int getBonus(){
        return bonus;
    }

    public void setBonus(int bonus){
        this.bonus = bonus;
    }

    public double getValorDabriel(){
        return valorDabriel;
    }

    public void setValorDabriel(double valorDabriel){
        this.valorDabriel = valorDabriel;
    }

    public double getValorGuarte(){
        return valorGuarte;
    }

    public void setValorGuarte(double valorGuarte){
        this.valorGuarte = valorGuarte;
    }

    public String resultado(){
        String result = "";
        
        this.valorDabriel = dabriel.getAta()+dabriel.getDef();
        this.valorDabriel = this.valorDabriel/2;
        if (dabriel.getLevel()%2 == 0){
            this.valorDabriel = this.valorDabriel + this.bonus;
        }
        this.valorGuarte = guarte.getAta()+guarte.getDef();
        this.valorGuarte = this.valorGuarte/2;
        if (guarte.getLevel()%2 == 0){
            this.valorGuarte = this.valorGuarte + this.bonus;
        }

        if (this.valorDabriel > this.valorGuarte){
            result = "Dabriel\n";
        }
        else if (this.valorDabriel < this.valorGuarte){
            result = "Guarte\n";
        }
        else{
            result = "Empate\n";
        }

        return result;
    }

}
