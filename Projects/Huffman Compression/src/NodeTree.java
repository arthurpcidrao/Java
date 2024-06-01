public class NodeTree<T> {
    
    private T data;
    
    @SuppressWarnings("rawtypes")
    private NodeTree rightSon;

    @SuppressWarnings("rawtypes")
    private NodeTree leftSon;

    
    
    public NodeTree(T data){
        this.data = data;
        this.rightSon = null;
        this.leftSon = null;
    }

    public NodeTree(){
        this.data = null;
        this.rightSon = null;
        this.leftSon = null;
    }

    public T getData(){
        return this.data;
    }

    public void setData(T data){
        this.data = data;
    }

    @SuppressWarnings("rawtypes")
    public NodeTree getRightSon(){
        return this.rightSon;
    }
    
    @SuppressWarnings("rawtypes")
    public void setRightSon(NodeTree rightSon){
        this.rightSon = rightSon;
    }

    @SuppressWarnings("rawtypes")
    public NodeTree getLeftSon(){
        return this.leftSon;
    }

    @SuppressWarnings("rawtypes")
    public void setLeftSon(NodeTree leftSon){
        this.leftSon = leftSon;
    }

}
