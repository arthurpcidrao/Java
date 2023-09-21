public class Washer extends Laundry{

    public boolean calcWash(int num){

        boolean resultW = true;
        if ((num < this.getMin()) || (num > this.getMax())){
            resultW = false;
        }

        return resultW;
    }
}
