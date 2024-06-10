// essa classe foi criada para juntar a quantidade e o caractere em um bloco só, dando suporte para a contagem e separação futura.

public class LetterStructure implements Comparable<LetterStructure> {
    
    private Integer qtd;
    private Character charactere;

    public LetterStructure(Character charactere){
        this.charactere = charactere;
        this.qtd = 0;
    }

    public LetterStructure(Character charactere, Integer qtd){
        this.charactere = charactere;
        this.qtd = qtd;
    }

    public Character getChar(){
        return this.charactere;
    }

    public void setChar(Character character){
        this.charactere = character;
    }

    public Character getBinaryChar(String binary){
        int charCode = Integer.parseInt(binary, 2);  // base string em número de base 2
        return (char) charCode;
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
            if (this.charactere != null){
                order = this.charactere.compareTo(other.charactere);
            }
        }
        return order;
    }
}
