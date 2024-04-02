public class Queue<T extends Comparable<T>> {
    
    //attributes
    private Comparable<T> array[];
    private int size;

    // methods
    @SuppressWarnings("unchecked")
    public Queue(){ // constructor
        this.array = (Comparable<T>[]) new Comparable[8];
        this.size = 0;
    }

    public void enqueue(T unit){
        if(this.size == this.array.length){
            extraSpace();
        }
        this.array[this.size] = unit;
        this.size++;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private void extraSpace(){
        Comparable newArray[] = (Comparable<T>[])new Comparable[2*this.array.length];
        for(int i = 0; i < this.array.length; i++){
            newArray[i] = this.array[i];
        }
        this.array = newArray;
        
    }

    public int size(){
        return this.size;
    }

    public boolean isNull(){
        if (this.size == 0){
            return true;
        }
        else{
            return false;
        }
    }

    // Implementar esse método
    public boolean isFull(){
        return true;
    }

    @SuppressWarnings("unchecked")
    public T peek(){
        return (T) this.array[0];
    }

    @SuppressWarnings("unchecked")
    public T dequeue(){
        T aux = null;

        aux  = (T) this.array[0];

        for (int i = 0; i < this.size; i++){
            this.array[i] = this.array[i+1];
        }
        this.size--;

        return aux;
    }

    @SuppressWarnings("unchecked")
    public boolean exists(T unit){
        for (int i = 0; i < this.size; i++){
            if(((T)this.array[i]).compareTo(unit) == 0){
                return true;
            }
        }
        return false;
    }

    public int howMany(T unit){
        int count = 0;
        
        for (int i = 0; i < this.size; i++){
            if(this.array[i].equals(unit)){
                count++;
            }
        }
        return count;
    }

    @SuppressWarnings("unchecked")
    public void clear(){
        this.array = (Comparable<T>[]) new Comparable[8];
        this.size = 0;
    }

    public void print(){
        System.out.print("[");
        if(this.size == 1){
            System.out.print(this.array[0]);
        }
        else{
            for (int i = 0; i < this.size; i++){
                
                if (i == this.size - 1){
                    System.out.print(this.array[i]);
                }
                else{
                    System.out.print(this.array[i] + ", ");
                }
            }
        }
        System.out.println("]");
    }
}
