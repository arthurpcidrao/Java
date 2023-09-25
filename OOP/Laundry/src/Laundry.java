public class Laundry {
    private int num;
    private Washer w;
    private Dryer d;

    public Laundry (Washer w, Dryer d){
        this.w = w;
        this.d = d;
    }

    public int getNum(){
        return num;
    }

    public void setNum(int num){
        this.num = num;
    }

    public String ehPossivel(){
        String result = "impossivel";

        if (w.calculaMaquina(this.num) && d.calculaMaquina(this.num)){
            result = "possivel";
        }
        return result;
    }
}
