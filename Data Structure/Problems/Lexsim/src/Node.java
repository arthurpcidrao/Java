public class Node<T> {
    
    private T data;
    
    @SuppressWarnings("rawtypes")
    private Node next;

    @SuppressWarnings("rawtypes")
    private Node previous;


    
    public Node(T data){
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public Node(){
        this.data = null;
        this.next = null;
        this.previous = null;
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

}
