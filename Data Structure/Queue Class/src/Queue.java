public class Queue<T extends Comparable<T>> {
    
    //attributes
    private Comparable<T> array[];
    private int size;
    private int begin;
    private int end;

    // methods
    @SuppressWarnings("unchecked")
    public Queue(){ // constructor
        this.array = (Comparable<T>[]) new Comparable[8];
        this.size = 0;
        this.begin = 0;
        this.end = 0;
    }

    public void enqueue(T unit){
        if(this.size == this.array.length){
            extraSpace();
        }
        this.array[this.size] = unit;
        this.size++;
        this.end++;
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

    @SuppressWarnings("unchecked")
    public T peek(){
        return (T) this.array[0];
    }

    @SuppressWarnings("unchecked")
    public T dequeue(){
        T aux = null;
        aux = (T) this.array[this.begin];

        this.begin++;
        this.size--;

        if (this.size == 0){
            clear();
        }

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
        System.out.println("]");
    }
}
