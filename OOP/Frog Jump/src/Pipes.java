import java.util.ArrayList;

public class Pipes {
    private ArrayList<Integer> pipes = new ArrayList<Integer>();
    private int qtde;

    public int getQtde(){
        return qtde;
    }

    public void setQtde(int qtde){
        this.qtde = qtde;
    }

    public void addPipe(int pipe){
        pipes.add(pipe);
    }

    public int getPipe(int index){
        return pipes.get(index);
    }

    public int lenPipes(){
        return pipes.size();
    }

}
