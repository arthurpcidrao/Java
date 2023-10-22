import java.util.ArrayList;

public class Engine {

    private ArrayList <Integer> testes = new ArrayList();
    private int rpm;

    public Engine (){
    }

    public int getRpm() {
        return rpm;
    }
    
    public void setRpm(int rpm) {
        this.rpm = rpm;
    }

    public void engineMeasure(int n){
            testes.add(this.rpm);
    }

    public void tests(){
        int position = 0;
        for (int i = 0; i < testes.size() - 1; i++){
            if (testes.get(i) > testes.get(i+1)){
                position = i + 2;
                break;
            }
        }
        System.out.println(position);
    }

    public void imprime(){
        for (int i = 0; i < testes.size(); i++){
			System.out.printf("%d ", testes.get(i));
        }
    }

}
