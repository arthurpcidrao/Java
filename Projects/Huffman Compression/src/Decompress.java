import java.io.File;

public class Decompress<T extends Comparable<T>> {
    @SuppressWarnings("rawtypes")
    private Node root;

    File decompressFile;

    public Decompress(){
        this.root = null;
    }

    public void setDecompressFile(File decompressFile){
        this.decompressFile = decompressFile;
    }

    

    public void showPreOrder(T element){
        if (this.root == null){
            this.root = new Node<>(element);
        }
        showPreOrder(element, this.root);
    }

    @SuppressWarnings("rawtypes")
    public void showPreOrder(T element, Node root){

        System.out.print(root.getData() + " ");

        if (root.getLeftSon() != null){
            showPreOrder(element, root.getLeftSon());
        }

        if (root.getRightSon() != null){
            showPreOrder(element, root.getRightSon());
        }
    }
}
