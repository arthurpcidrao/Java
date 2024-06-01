// foi criado uma classe Statistics para leitura de um array de LetterStructure para contar quantas vezes cada char se repete.

public class Statistics {
    
    private LetterStructure array[];
    private int qtd;

    public Statistics(){
        this.array = new LetterStructure[256];
        this.qtd = 0;
    }

    public int size(){
        return this.array.length;
    }

    public void add(int index){
        if (this.array[index] == null){
            this.array[index] = new LetterStructure((char) index);
            this.qtd++;
        }
        this.array[index].setQtd();
    }

    public int getHowMany(){
        return this.qtd;
    }

    public int getStatistic(int index){
        return this.array[index].getQtd();
    }

    public LetterStructure getData(int index){
        return this.array[index];
    }

    public char getChar(int index){
        return (char) index;
    }

    public void showall(){
        for (int i = 0; i < 256; i++){
            if (this.array[i] != null){
                System.out.print((char) i);
                System.out.println(": " + this.array[i].getQtd());
            }
        } 
    }

}
