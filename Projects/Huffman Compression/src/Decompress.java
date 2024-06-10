import java.io.File;

public class Decompress<T extends Comparable<T>> {
    @SuppressWarnings("rawtypes")
    private Node root;

    @SuppressWarnings("unused")
    private File decompressFile;

    public Decompress(){
        this.root = null;
    }

    @SuppressWarnings("unchecked")
    public T getRoot(){
        return (T) this.root.getData();
    }

    public void setDecompressFile(File decompressFile){
        this.decompressFile = decompressFile;
    }


    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Node rebuildTree(String string, int i[]){
        if (string.charAt(i[0]) == '1'){
            System.out.print('1');
            i[0]++;

            String realLetter = string.substring(i[0], i[0]+8); //pega de i até i+8 uma sbustring
            i[0] = i[0] + 8;

            LetterStructure structure = new LetterStructure(null, 1);
            char ch = structure.getBinaryChar(realLetter);

            System.out.print(" " + ch + " ");

            structure.setChar(ch);
            return new Node(structure);
        }
        else{
            System.out.print('0');
            
            i[0]++;
            Node left = rebuildTree(string, i);
            Node right = rebuildTree(string, i);
            return new Node(left, right);
        }

    }

    @SuppressWarnings("rawtypes")
    public String decoMessage(String message, Node root){
        StringBuilder finalMessage = new StringBuilder();
        Node aux = root;

        for (int i = 0; i < message.length(); i++){
            aux = message.charAt(i) == '0' ? aux.getLeftSon() : aux.getRightSon();
            
            if (aux.getLeftSon() == null && aux.getRightSon() == null){
                finalMessage.append(((LetterStructure) aux.getData()).getChar());
                aux = root;
            }
        }
        return finalMessage.toString();
    }

}
