import java.util.ArrayList;
import java.util.Collections;

public class Ranking {
    private ArrayList<Jogador> ranking = new ArrayList<Jogador>();

    public void addJogador(String nome, int pontuacao){
        Jogador jogador = new Jogador();
        jogador.setNome(nome);
        jogador.setPontuacao(pontuacao);

        ranking.add(jogador);
    }

    public void ordenar(){
        Collections.sort(ranking);
    }
}
