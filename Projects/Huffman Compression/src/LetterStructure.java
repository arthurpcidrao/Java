// essa classe foi criada para juntar a quantidade e o caractere em um bloco só, dando suporte para a contagem e separação futura.

public class LetterStructure implements Comparable<LetterStructure> {
    
    private Integer qtd;
    private Character charactere;

    public LetterStructure(char charactere){
        this.charactere = charactere;
        this.qtd = 0;
    }

    public char getChar(){
        return this.charactere;
    }

    public void setQtd(){
        this.qtd++;
    }

    public int getQtd(){
        return this.qtd;
    }

    @Override
    public int compareTo(LetterStructure other) {
        
        int order = this.qtd.compareTo(other.qtd);
        if (order == 0){
            order = this.charactere.compareTo(other.charactere);
        }
        return order;
    }
}
