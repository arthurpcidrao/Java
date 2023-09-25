public class Dryer extends Machines{

    @Override
    public boolean calculaMaquina(int num){
        
        boolean resultD = true;
        if ((num < this.getMin()) || (num > this.getMax())){
            resultD = false;
        }

        return resultD;
    }
}
