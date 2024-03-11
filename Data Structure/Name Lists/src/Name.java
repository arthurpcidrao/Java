public class Name implements Comparable<Name>{
    
    private String name;
    private Integer size;

    public Name(String name){
        this.name = name;
        this.size = name.length();
    }

    public String getName(){
        return this.name;
    }

    public int getSize(){
        return this.size;
    }

    @Override
    public int compareTo(Name other) {
        return this.size.compareTo(other.size);
    }
}
