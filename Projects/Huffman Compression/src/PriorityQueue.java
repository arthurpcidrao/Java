public class PriorityQueue<T extends Comparable<T>> {

    @SuppressWarnings("rawtypes")
    private Node first = null;

    @SuppressWarnings("rawtypes")
    private Node last = null;

    private int size;
    private LetterStructure structure;

    public PriorityQueue(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    @SuppressWarnings({ "rawtypes", "unchecked"})
    public void enqueue(T unit){
        Node newNode = new Node<>(unit);

        if (this.last == null){
            this.first = newNode;
            this.last = newNode;
        }
        else if (((T)newNode.getData()).compareTo((T)this.first.getData()) < 0){
            newNode.setNext(this.first);
            this.first.setPrevious(newNode);
            this.first = newNode;
        }
        else if (((T)newNode.getData()).compareTo((T)this.last.getData()) >= 0){
            this.last.setNext(newNode);
            newNode.setPrevious(this.last);
            this.last = newNode;
        }
        else{
            Node aux = this.first;
            while(((T)newNode.getData()).compareTo((T)aux.getData()) >= 0){
                aux = aux.getNext();
            }
            // conectando o novo elemento ao conjunto
            newNode.setPrevious(aux.getPrevious());
            newNode.setNext(aux);

            // conectando a primeira parte da lista ao novo elemento
            aux.getPrevious().setNext(newNode);

            // conectando a segunda parte da lista ao novo elemento
            aux.setPrevious(newNode);
        }

        this.size++;
    }

    public int size(){
        return this.size;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public T getData(Node data){
        return (T) data.getData();
    }
 
    @SuppressWarnings({ "rawtypes"})
    public int getIndex(T unit){
        Node aux = this.first;
        int index = 0;

        for (int i = 0; i < this.size; i++){
            if (aux.getData().equals(unit)){
                index = i;
                break;
            }
            aux = aux.getNext();
        }

        return index;
    }

    @SuppressWarnings({ "rawtypes"})
    public Node getMemory(T unit){
        Node aux = this.first;

        for (int i = 0; i < this.size; i++){
            if (aux.getData().equals(unit)){
                break;
            }
            aux = aux.getNext();
        }

        return aux;
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

    public void clear(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    @SuppressWarnings("rawtypes")
    public void print(){

        Node aux = this.first;

        System.out.print("[");

        for (int i = 0; i < this.size; i++){
            
            structure = (LetterStructure) aux.getData();
            
            if (i == this.size - 1){
                System.out.print(structure.getChar() + ": " + structure.getQtd());
            }
            else{
                System.out.print(structure.getChar() + ": " + structure.getQtd() + " | ");
            }
            aux = aux.getNext();
        }
        System.out.println("]");
    }
}