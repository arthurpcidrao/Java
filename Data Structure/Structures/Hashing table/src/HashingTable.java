public class HashingTable<T extends Comparable<T>> {
    
    private LinkedList<T> array[];
    private int size;



    @SuppressWarnings("unchecked")
    public HashingTable(int length){
        this.array = new LinkedList[length];
        this.size = 0;
    }


    public void add(int unit){
        int rest = unit % this.array.length;


    }

    @SuppressWarnings("unused")
    private int hashingFunction(int unit){
        return unit % this.array.length;
    }
}
