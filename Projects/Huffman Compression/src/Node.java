public class Node<T> {
    
    private T data;
    
    @SuppressWarnings("rawtypes")
    private Node next;

    @SuppressWarnings("rawtypes")
    private Node previous;

    
    
    @SuppressWarnings("rawtypes")
    private Node rightSon;

    @SuppressWarnings("rawtypes")
    private Node leftSon;



    public Node(T data){
        
        this.data = data;
        this.next = null;
        this.previous = null;

        this.rightSon = null;
        this.leftSon = null;
    }

    public Node(){
        this.data = null;
        this.next = null;
        this.previous = null;

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
    public Node getNext(){
        return this.next;
    }
    
    @SuppressWarnings("rawtypes")
    public void setNext(Node next){
        this.next = next;
    }

    @SuppressWarnings("rawtypes")
    public Node getPrevious(){
        return this.previous;
    }

    @SuppressWarnings("rawtypes")
    public void setPrevious(Node previous){
        this.previous = previous;
    }




    @SuppressWarnings("rawtypes")
    public Node getRightSon(){
        return this.rightSon;
    }
    
    @SuppressWarnings("rawtypes")
    public void setRightSon(Node rightSon){
        this.rightSon = rightSon;
    }

    @SuppressWarnings("rawtypes")
    public Node getLeftSon(){
        return this.leftSon;
    }

    @SuppressWarnings("rawtypes")
    public void setLeftSon(Node leftSon){
        this.leftSon = leftSon;
    }

}
