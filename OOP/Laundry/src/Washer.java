public class Washer {
    private int minW;
    private int maxW;
    private int capW;

    public Washer( int capW){
        this.capW = capW;
    }

    public int getMinW(){
        return minW;
    }

    public void setMinW(int minW){
        this.minW = minW;
    }

    public int getMaxW(){
        return maxW;
    }

    public void setMaxW(int maxW){
        this.maxW = maxW;
    }

    public int getCapW(){
        return capW;
    }

    public void setCapW(int capW){
        this.capW = capW;
    }

    public boolean calcWash(){
        boolean resultW = true;
        if ((this.capW < this.minW) || (this.capW > this.maxW)){
            resultW = false;
        }

        return resultW;
    }
}
