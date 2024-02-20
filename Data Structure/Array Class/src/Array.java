public class Array {
    
    //attributes
    private Object array[];
    private int size;

    // methods
    public Array(int capacity){
        this.array = new Object[capacity];
        this.size = 0;
    }

    public void add(Object unit){
        if(this.size == this.array.length){
            extraSpace();
        }
        this.array[this.size] = unit;
        this.size++;
    }

    public void add(Object unit, int pos){
        // pos >= 0
        if(this.size == this.array.length){
            extraSpace();
        }
        if(pos >= 0 && pos <= this.size){
            for (int i = this.size; i > pos; i--){
                this.array[i] = this.array[i-1];
            }
            this.array[pos] = unit;
            this.size++;
        }
    }

    public void extraSpace(){
        Object newArray[] = new Object[2*this.array.length];
        for(int i = 0; i < this.array.length; i++){
            newArray[i] = this.array[i];
        }
        this.array = newArray;
        
    }

    public int size(){
        return this.size;
    }

    public Object getUnit(int i){
        if (i >= 0 && i < this.size){
            return this.array[i];
        }
        return null;
    }

    public boolean exists(Object unit){
        for (int i = 0; i < this.size; i++){
            if(this.array[i].equals(unit)){
                return true;
            }
        }
        return false;
    }

    public int howMany(Object unit){
        int count = 0;
        
        for (int i = 0; i < this.size; i++){
            if(this.array[i].equals(unit)){
                count++;
            }
        }
        return count;
    }

    public void remove(Object unit){
        int pos = 0;
        boolean exists = false;
        for (int i = 0; i < this.size; i++){
            if(this.array[i].equals(unit)){
                pos = i;
                exists = true;
                break;
            }
        }
        if(exists){
            remove(pos);
        }
    }

    public void remove(int pos){
        for (int i = pos; i < this.size - 1; i++){
            this.array[i] = this.array[i+1];
        }
        this.size--;
    }

    public void print(){
        System.out.print("[");
        if(this.size == 1){
            System.out.printf("%s", this.array[0]);
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
