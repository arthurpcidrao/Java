public class Heap<T extends Comparable<T>> {    
    
    private Comparable<T> array[];
    private int size;

    @SuppressWarnings("unchecked")
    public Heap(int length){
        this.array = new Comparable[length];
        this.size = 0;
    }

    public void add(T unit){
        if(this.size < this.array.length){
            this.array[this.size] = unit;
            rootAdd(this.size);
            this.size++;
        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private void rootAdd(int i){
        if(i <= 0){
            return;
        }
        else{
            int parentIndex = getParent(i);

            if (this.array[i].compareTo((T) this.array[parentIndex]) < 0){ // Alteração aqui
                Comparable aux = this.array[i];
                this.array[i] = this.array[parentIndex];
                this.array[parentIndex] = aux;
            }

            rootAdd(parentIndex);
        }
    }

    private int getLeft(int i){
        return (2*i + 1);
    }

    private int getRight(int i){
        return (2*i + 2);
    }

    private int getParent(int i){
        return (i - 1)/2;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public T next(){
        if (this.size > 0){
            this.size--;
            Comparable aux = this.array[0];
            this.array[0] = this.array[this.size];
            rootNext(0);
            return (T) aux;
        }
        return null;
    }

    @SuppressWarnings({ "unchecked" })
    public T seeNext(){
        if (this.size > 0){
            return (T) this.array[0];
        }
        return null;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private void rootNext(int i){
        int leftIndex = getLeft(i);
        int rightIndex = getRight(i);

        if (leftIndex < this.size){
            int min = leftIndex; // Alteração aqui

            if (rightIndex < this.size && this.array[rightIndex].compareTo((T) this.array[leftIndex]) < 0){ // Alteração aqui
                min = rightIndex;
            }

            if (this.array[i].compareTo((T) this.array[min]) > 0){ // Alteração aqui
                Comparable aux = this.array[i];
                this.array[i] = this.array[min];
                this.array[min] = aux;
            }
            rootNext(min);
        }
    }

    public boolean isFull(){
        if (this.size == 0){
            return true;
        }
        return false;
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
