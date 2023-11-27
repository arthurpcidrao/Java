public class Jogador implements Comparable<Jogador>{
    private String nome;
    private int pontuacao;

    public Jogador(){
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getPontuacao(){
        return pontuacao;
    }

    public void setPontuacao(int pontuacao){
        this.pontuacao = pontuacao;
    }

    public void imprimeJogador(){
        System.out.printf("%s %d\n", getNome(), getPontuacao());
    }

    @Override
    public int compareTo(Jogador outroJogador) {
        
        int ordem = -(this.pontuacao - outroJogador.getPontuacao());
        if(ordem == 0){
            ordem = this.nome.compareTo(outroJogador.getNome());
        }
        return ordem;
    }


}
