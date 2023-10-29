import java.util.ArrayList;

public class Competition {
    private ArrayList<Athlete> atletas = new ArrayList<Athlete> ();

    public void armazenaAtleta(String nome, double dificuldade, double media){
        Athlete competidor = new Athlete(nome, dificuldade*media);
          atletas.add(competidor);
    }

    public void print(){
        for (Athlete x : atletas){
            x.imprimeDados();
        }
    }
}
