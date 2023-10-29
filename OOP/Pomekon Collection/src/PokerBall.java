import java.util.*;

public class PokerBall {
    private ArrayList<Pomekons> poms = new ArrayList<Pomekons>();

    public void guardaPomekon(String name){
        Pomekons pomekon = new Pomekons(name);
        poms.add(pomekon);
    }

    public int buscaPomekon(String name){
        for (Pomekons p : poms){
            if (p.getName().equals(name)){
                return poms.indexOf(p);
            }
        }
        return -1;
    }

    public int qtdePomekons(){
        return poms.size();
    }

    public void print(){
        for (Pomekons p : poms){
            p.imprimePomekon();
        }
    }
}
