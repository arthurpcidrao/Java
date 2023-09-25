public class Washer extends Machines{

    @Override
    public boolean calculaMaquina(int num){

        boolean resultW = true;
        if ((num < this.getMin()) || (num > this.getMax())){
            resultW = false;
        }

        return resultW;
    }
}
