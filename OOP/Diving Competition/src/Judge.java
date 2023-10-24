import java.util.ArrayList;

public class Judge {
    private double score;
    private ArrayList<Double> notas = new ArrayList<Double>();
    
    public double getScore(){
        return score;
    }

    public void setScore(double score){
        this.score = score;
    }

    public void addNota(double nota){
        notas.add(nota);
    }

    public double getNota(int index){
        return notas.get(index);
    }

    public void removeNota (int index){
        notas.remove(index);
    }

}
