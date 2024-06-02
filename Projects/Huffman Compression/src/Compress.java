public class Compress {

    @SuppressWarnings("rawtypes")
    private Node root;

    @SuppressWarnings("unused")
    private int layer = 0;

    private String binary = "";
    private String binaryLetters[];

    private String formattedAlphabet[];

    private String documentString = "";



    @SuppressWarnings("rawtypes")
    public Compress(Node root){
        this.root = root;
        this.formattedAlphabet = new String[256];

        String alphabet = "";

        for (int i = 0; i < 256; i++){
            alphabet = "";
            alphabet = Integer.toBinaryString(i);
            formattedAlphabet[i] = String.format("%8s", alphabet).replace(' ', '0');
        }

    }

    @SuppressWarnings("rawtypes")
    public Node root(){
        return this.root;
    }


    public void showAlphabet(){
        for (int i = 0; i < 256; i++){
            System.out.println(formattedAlphabet[i]);
        }
    }


    public void setQtdLetters(int qtd){
        binaryLetters = new String[qtd];
    }

    public String getLetters(int i){
        return binaryLetters[i];
    }


    public void showNewFormationLetters(){
        for (int i = 0; i < 256; i++){
            if (getLetters(i) != null){
                System.out.println((char) i + " = " + getLetters(i));
            }
        }
    }


    public void PreOrder(){
        this.layer = 0;
        this.binary = "";
        PreOrder(this.root);
    }

    @SuppressWarnings("rawtypes")
    private void PreOrder(Node root){

        if (((LetterStructure) root.getData()).getChar() != null){

            binaryLetters[((LetterStructure) root.getData()).getChar()] = this.binary;
        }

        if (root.getLeftSon() != null){
            this.binary = this.binary + "0";
            this.layer++;
            
            PreOrder(root.getLeftSon());

            this.binary = this.binary.substring(0, this.binary.length() - 1);
        }

        if (root.getRightSon() != null){
            this.binary = this.binary + "1";
            this.layer++;

            PreOrder(root.getRightSon());

            this.binary = this.binary.substring(0, this.binary.length() - 1);
        }
    }



    public void cleanDocumentString(){
        this.documentString = "";
    }

    public void appendDocument(char charactere){
        this.documentString += binaryLetters[charactere];
    }

    public void writeDocument(){
        writeDocument(this.root);
    }

    public String getDocument(){
        return this.documentString;
    }



    @SuppressWarnings("rawtypes")
    private void writeDocument(Node root){

        if (((LetterStructure) root.getData()).getChar() != null){
            this.documentString += "1";
            this.documentString += this.formattedAlphabet[((LetterStructure) root.getData()).getChar()];
        }

        if (root.getLeftSon() != null || root.getRightSon() != null){
            this.documentString += "0";
            
            if (root.getLeftSon() != null){
                writeDocument(root.getLeftSon());
            }
    
            if (root.getRightSon() != null){
                writeDocument(root.getRightSon());
            }
        }
    }


    public void showDocument(){
        System.out.println(this.documentString);
    }

    
}
