public class Tree<T extends Comparable<T>> {

    @SuppressWarnings("rawtypes")
    private NodeTree root;
    
    public Tree(){
        this.root = null;
    }



    public void add(T element){
        if (this.root == null){
            this.root = new NodeTree<>(element);
        }
        else{
            add(element, this.root);
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void add(T element, NodeTree root){
        if (element.compareTo((T) root.getData()) < 0){
            if (root.getLeftSon() == null){
                root.setLeftSon(new NodeTree<>(element));
            }
            else{
                add(element, root.getLeftSon());
            }
        }
        else {
            if (root.getRightSon() == null){
                root.setRightSon(new NodeTree<>(element));
            }
            else{
                add(element, root.getRightSon());
            }
        }
    }
    


    public boolean search (T element){
        return search (element, this.root);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private boolean search (T element, NodeTree root){
        if (element.compareTo((T) root.getData()) == 0){
            return true;
        }
        
        if (element.compareTo((T) root.getData()) < 0){
            if (root.getLeftSon() == null){
                return false;
            }
            else{
                return search (element, root.getLeftSon());
            }
        }

        if (element.compareTo((T) root.getData()) > 0){
            if (root.getRightSon() == null){
                return false;
            }
            else{
                return search (element, root.getRightSon());
            }
        }

        return false;  // espera-se que não chegue aqui
    }



    




    public void showPreOrder(){
        showPreOrder(this.root);
    }

    @SuppressWarnings("rawtypes")
    private void showPreOrder(NodeTree root){

        System.out.print(root.getData() + " ");

        if (root.getLeftSon() != null){
            showPreOrder(root.getLeftSon());
        }

        if (root.getRightSon() != null){
            showPreOrder(root.getRightSon());
        }
    }
}
