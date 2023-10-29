import java.util.ArrayList;
import java.util.Collections;

public class Judge {
    private double media;
    private ArrayList<Double> notas = new ArrayList<Double>();

    public double getMedia(){
        return media;
    }

    public void setMedia(double media){
        this.media = media;
    }

    public void addNotas(double nota){
        notas.add(nota);
    }

    public double calcMedia(){
        this.media = 0;
        notas.remove(Collections.max(notas));
        notas.remove(Collections.min(notas));
        for (int i = 0; i < notas.size(); i++){
            this.media = this.media + notas.get(i);
        } 
        return this.media;
    }
}
