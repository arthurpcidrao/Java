public class Node<T> {
    
    private T data;
    
    @SuppressWarnings("rawtypes")
    private Node next;



    public Node(T data){
        this.data = data;
        this.next = null;
    }

    public Node(){
        this.data = null;
        this.next = null;
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

}
