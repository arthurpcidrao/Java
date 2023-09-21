public class Laundry {
    private int min;
    private int max;

    public int getMin(){
        return min;
    }

    public void setMin(int min){
        this.min = min;
    }

    public int getMax(){
        return max;
    }

    public void setMax(int max){
        this.max = max;
    }

    public String ehPossivel(boolean W, boolean D) {
        String result = "impossivel";
        if (W && D){
            result = "possivel";
        }
        return result;
    }
}
