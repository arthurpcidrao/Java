public class LinkedStack<T extends Comparable<T>> {

    @SuppressWarnings("rawtypes")
    private Node first;

    @SuppressWarnings("rawtypes")
    private Node last = null;

    private int size;

    public LinkedStack(){
        this.last = null;
        this.size = 0;
    }

    @SuppressWarnings({ "rawtypes"})
    public void push(T unit){
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

    @SuppressWarnings("unchecked")
    public T top(){
        if (this.size == 0){
            return null;
        }
        return (T) this.last.getData();
    }

    public boolean isEmpty(){
        if (this.size == 0){
            return true;
        }
        return false;
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

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public T getUnit(int num){
        Node aux = this.first;

        if (num >= 0 && num < this.size){
            for (int i = 0; i < num; i++){
                aux = aux.getNext();
            }
            return (T) aux.getData();
        }
        return null;
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

    @SuppressWarnings("unchecked")
    public T pop(){
        if (this.first != null){
            Object aux;
            if (this.size == 1){
                aux = this.last.getData();
                clear();
            }
            else{
                aux = this.last.getData();
                this.last.getPrevious().setNext(null);
                this.last = this.last.getPrevious();
                this.size--;
            }
            return (T) aux;
        }
        return null;
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