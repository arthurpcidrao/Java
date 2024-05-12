public class HashingTable<T extends Comparable<T>> {
    
    private SortedPointers<String> array[];
    private int size;



    @SuppressWarnings("unchecked")
    public HashingTable(int length){
        this.array = new SortedPointers[length];
        this.size = 0;
    }


    public void add(String unit){
        int rest = hashingFunction(unit);

        if (this.array[rest] == null){
            this.array[rest] = new SortedPointers<>();
            this.size++;
        }

        this.array[rest].add(unit);
    }

    private int hashingFunction(String unit){

        char firstChar = unit.charAt(0);
        int asciiValue = firstChar;

        return asciiValue % this.array.length;
    }

    public void show(){
        for (int i = 0; i < this.array.length; i++){
            if (this.array[i] != null){
                System.out.print((i+1) + "°: ");
                this.array[i].print();
            }
        }
    }
}
