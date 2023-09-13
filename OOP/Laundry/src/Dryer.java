public class Dryer {
    private int minD;
    private int maxD;
    private int capD;

    public Dryer (int capD){
        this.capD = capD;
    }

    public int getMinD(){
        return minD;
    }

    public void setMinD(int minD){
        this.minD = minD;
    }

    public int getMaxD(){
        return maxD;
    }

    public void setMaxD(int maxD){
        this.maxD = maxD;
    }

    public int getCapD(){
        return capD;
    }

    public void setCapD(int capD){
        this.capD = capD;
    }

    public boolean calcDry(){
        boolean resultD = true;
        if ((this.capD < this.minD) || (this.capD > this.maxD)){
            resultD = false;
        }

        return resultD;
    }
}
