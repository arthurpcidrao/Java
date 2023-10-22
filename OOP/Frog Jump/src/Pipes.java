import java.util.ArrayList;

public class Pipes {
    private ArrayList <Integer> pipes = new ArrayList();
    private int pipe;
    private int qtde;

    public int getPipe(){
        return pipe;
    }

    public void setPipe(int pipe){
        this.pipe = pipe;
    }

    public int getQtde(){
        return qtde;
    }

    public void setQtde(int qtde){
        this.qtde = qtde;
    }

    public void addPipe(int pipe){
        pipes.add(pipe);
    }

    public int whichPipe(int index){
        return pipes.get(index);
    }

    public int lenPipes(){
        return pipes.size();
    }

}
