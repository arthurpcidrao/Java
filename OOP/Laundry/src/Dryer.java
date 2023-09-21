public class Dryer extends Laundry{

    public boolean calcDry(int num){
        boolean resultD = true;
        if ((num < this.getMin()) || (num > this.getMax())){
            resultD = false;
        }

        return resultD;
    }
}
