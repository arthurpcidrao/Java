public class LinkedArray<T extends Comparable<T>> {
    
    @SuppressWarnings("rawtypes")    
    private Node first;

    @SuppressWarnings("rawtypes")
    private Node last = null;

    private int size;

    public LinkedArray(){
        this.last = null;
        this.size = 0;
    }

    @SuppressWarnings({ "rawtypes"})
    public void add(T unit){
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

    @SuppressWarnings({ "rawtypes"})
    public void add(T unit, int pos){
        Node aux = this.first;
        Node middle = new Node<>(unit);

        if (pos >= 0 && pos <= this.size){
            for (int i = 0; i < pos-1; i++){
                aux = aux.getNext();
            }
            middle.setNext(aux.getNext()); // introduzindo o nó que liga o meio com o fim
            aux.setNext(middle); // colocando o começo com o meio
            this.size++;
        }
    }

    public int size(){
        return this.size;
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

    public void remove(){
        if (this.first != null){
            if (this.size == 1){
                clear();
            }
            else{
                this.last.getPrevious().setNext(null);
                this.last = this.last.getPrevious();
                this.size--;
            }
        }
    }

    @SuppressWarnings("rawtypes")
    public void remove(int pos){
        
        if (pos >= 0 && pos < this.size){

            if (this.first != null){
                Node aux = this.first;

                if (this.size == 1){
                    clear();
                }
                else{
                    if (pos == 0){
                        this.first.getNext().setPrevious(null);
                        this.first = this.first.getNext();
                        this.size--;
                    }
                    else if (pos == this.size - 1){
                        remove();
                    }
                    else{
                        for (int i = 0; i < pos - 1; i++){
                            aux = aux.getNext();
                        }
                        aux.getNext().getNext().setPrevious(aux);
                        aux.setNext(aux.getNext().getNext());
                        this.size--;
                    }
                }
            }
        }
            
    }

    @SuppressWarnings("rawtypes")
    public void remove(T unit){
        Node aux = this.first;
        boolean exists = false;
        int pos = 0;

        for (int i = 0; i < this.size; i++){
            if (unit.equals(aux.getData())){
                pos = i;
                exists = true;
                break;
            }
            aux = aux.getNext();
        }
        if(exists){
            remove(pos);
        }
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
