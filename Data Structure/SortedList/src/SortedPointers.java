public class SortedPointers<T extends Comparable<T>> {
    
    @SuppressWarnings("rawtypes")    
    private Node first = null;

    @SuppressWarnings("rawtypes")
    private Node last = null;

    private int size;

    public SortedPointers(){
        this.last = null;
        this.size = 0;
    }

    @SuppressWarnings({ "rawtypes", "unchecked"})
    public void add(T unit){
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

    @SuppressWarnings("rawtypes")
    public boolean exists(T unit){
        
        Node aux = this.first;

        for (int i = 0; i < this.size; i++){
            if (aux.getData().equals(unit)){
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

    public void remove(){
        this.last.getPrevious().setNext(null);
        this.last = this.last.getPrevious();
        this.size--;
    }

    @SuppressWarnings("rawtypes")
    public void remove(int pos){
        Node aux = this.first;

        if (pos >= 0 && pos < this.size){
            for (int i = 0; i < pos - 1; i++){
                aux = aux.getNext();
            }
            aux.setNext(aux.getNext().getNext());
            aux.getNext().getNext().setPrevious(aux.getPrevious().getPrevious());  // verificar
            this.size--;    
        }
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
            if (i == this.size - 1){
                System.out.print(aux.getData());
            }
            else{
                System.out.print(aux.getData() + " ");
            }
            aux = aux.getNext();
        }
        System.out.println("]");
    }
}
