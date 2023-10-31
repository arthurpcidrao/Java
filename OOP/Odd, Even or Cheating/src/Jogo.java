public class Jogo extends Jogador {
    private int jogada1;
    private int jogada2;

    public Jogo(int p, int j1, int j2, int c, int a) {
        setP(p);
        setJogada1(j1);
        setJogada2(j2);
        setC(c);
        setA(a);
    }

    public int getJogada1() {
        return jogada1;
    }

    public void setJogada1(int jogada1) {
        this.jogada1 = jogada1;
    }

    public int getJogada2() {
        return jogada2;
    }

    public void setJogada2(int jogada2) {
        this.jogada2 = jogada2;
    }

    public boolean isCheating() {
        boolean cheating = false;
        if (getC() == 1){
            cheating = true;
        }
        return cheating;
    }

    public String isAccused(boolean cheating) {
        String result = "";
        boolean accused = false;
        if (getA() == 1){
            accused = true;
        }
        boolean isEvenSum = false;
        if ((getJogada1() + getJogada2()) % 2 == 0){
            isEvenSum = true;
        }
    
        if (accused && cheating) {
            result = "Jogador 2 ganha!";
        } 
        else if (accused && !cheating) {
            result = "Jogador 1 ganha!";
        } 
        else if (!accused && cheating) {
            result = "Jogador 1 ganha!";
        } 
        else if (!accused && !cheating){
            if ((isEvenSum && (getP() == 1)) || (!isEvenSum && (getP() == 0))) {
                result = "Jogador 1 ganha!";
            } 
            else {
                result = "Jogador 2 ganha!";
            }
        }
        return result;
    }
}