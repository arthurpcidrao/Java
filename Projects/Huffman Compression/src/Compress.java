public class Compress {

    @SuppressWarnings("rawtypes")
    private Node root;

    @SuppressWarnings("unused")
    private int count = 0;

    private String binary = "";
    private String binaryLetters[];

    private String formattedAlphabet[];

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
        this.count = 0;
        this.binary = "";
        PreOrder(this.root);
    }


    @SuppressWarnings("rawtypes")
    private void PreOrder(Node root){

        if (((LetterStructure) root.getData()).getChar() != null){
            
            // System.out.print(((LetterStructure) root.getData()).getChar() + ": ");

            binaryLetters[((LetterStructure) root.getData()).getChar()] = this.binary;
            
            // System.out.println(this.binary);
        }

        // System.out.print(((LetterStructure) root.getData()).getQtd() + " ");

        if (root.getLeftSon() != null){
            this.binary = this.binary + "0";
            this.count++;
            
            PreOrder(root.getLeftSon());

            this.binary = this.binary.substring(0, this.binary.length() - 1);
        }

        if (root.getRightSon() != null){
            this.binary = this.binary + "1";
            this.count++;

            PreOrder(root.getRightSon());

            this.binary = this.binary.substring(0, this.binary.length() - 1);
        }
    }

    
}
