public class LinkedQueue<T extends Comparable<T>> {
    
    @SuppressWarnings("rawtypes")    
    private Node first;

    @SuppressWarnings("rawtypes")
    private Node last;

    private int size;

    public LinkedQueue(){
        this.last = null;
        this.first = null;
        this.size = 0;
    }

    @SuppressWarnings({ "rawtypes"})
    public void enqueue(T unit){
        Node newNode = new Node<>(unit);

        if (this.last == null){
            this.first = newNode;
            this.last = newNode;
        }
        else{
            this.last.setNext(newNode);
            newNode.setPrevious(this.last);
            this.last = newNode;
        }
        this.size++;
    }

    public int size(){
        return this.size;
    }

    public boolean isNull(){
        if (this.size == 0){
            return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public T next(){
        return (T) this.first.getData();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public T dequeue(){
        if (this.first != null){
            Object aux;
            if (this.size == 1){
                aux = (Comparable) this.first.getData();
                clear();
            }
            else{
                aux = (Comparable) this.first.getData();
                this.first = this.first.getNext();
                this.size--;
            }
            return (T) aux;
        }
        return null;
    }

    @SuppressWarnings({ "rawtypes", "unlikely-arg-type" })
    public int getIndex(T unit){
        Node aux = this.first;
        int index = 0;

        for (int i = 0; i < this.size; i++){
            if ((aux).equals(unit)){
                index = i;
            }
            aux = aux.getNext();
        }

        return index;
    }

    @SuppressWarnings({ "unchecked" })
    public T peek(int num){
        return (T) this.first.getData();
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public boolean exists(T unit){

        Node aux = this.first;

        for (int i = 0; i < this.size; i++){
            if (((Comparable<T>) aux.getData()).compareTo(unit) == 0){
                return true;
            }
            aux = aux.getNext();
        }

        return false;
    }

    @SuppressWarnings("rawtypes")
    public int howMany(T unit){
        int count = 0;
        Node aux = this.first;

        for (int i = 0; i < this.size; i++){
            if (aux.getData().equals(unit)){
                count++;
            }
            aux = aux.getNext();
        }
        return count;
    }


    public void clear(){
        //this.first.setNext(null);
        //this.first.setPrevious(null);
        this.first = null;

        //this.last.setNext(null);
        //this.last.setPrevious(null);
        this.last = null;

        this.size = 0;
    }

    @SuppressWarnings("rawtypes")
    public void print(){

        Node aux = this.first;

        System.out.print("[");

        for (int i = 0; i < this.size; i++){
            if (i == this.size - 1){
                System.out.print(aux.getData());
            }
            else{
                System.out.print(aux.getData() + ", ");
            }
            aux = aux.getNext();
        }
        System.out.println("]");
    }
}
