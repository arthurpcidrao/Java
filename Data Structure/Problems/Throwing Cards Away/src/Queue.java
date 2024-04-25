public class Queue<T extends Comparable<T>> {
    
    //attributes
    private Comparable<T> array[];
    private int size;
    private int begin;
    private int end;
    private int capacity;

    // methods
    @SuppressWarnings("unchecked")
    public Queue(){ // constructor
        this.array = (Comparable<T>[]) new Comparable[8];
        this.size = 0;
        this.begin = 0;
        this.end = 0;
    }

    @SuppressWarnings("unchecked")
    public Queue(int capacity){ // constructor
        this.array = (Comparable<T>[]) new Comparable[capacity];
        this.size = 0;
        this.begin = 0;
        this.end = 0;
        this.capacity = capacity;
    }

    public void enqueue(T unit){
        if(this.size < this.capacity){
            this.array[this.end] = unit;
            this.end = (this.end + 1) % this.capacity;
            this.size++;
        }
    }

    @SuppressWarnings("unchecked")
    public T dequeue(){

        T aux = null;

        if (this.size > 0){
            aux = (T) this.array[this.begin];

            this.begin = (this.begin + 1) % this.capacity;
            this.size--;
        }
            
        return aux;
    }

    @SuppressWarnings({ "unchecked", "rawtypes", "unused" })
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

    @SuppressWarnings("unchecked")
    public T peek(){
        return (T) this.array[this.begin];
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

    //@SuppressWarnings("unchecked")
    public void clear(){
        //this.array = (Comparable<T>[]) new Comparable[8];
        this.size = 0;
        this.begin = 0;
        this.end = 0;
    }

    public void print(){
        if(this.size == 1){
            System.out.print(this.array[this.begin]);
        }
        else{
            for (int i = this.begin; i < this.end; i++){
                
                if (i == this.end - 1){
                    System.out.print(this.array[i]);
                }
                else{
                    System.out.print(this.array[i] + ", ");
                }
            }
        }
        //System.out.println();
    }
}
