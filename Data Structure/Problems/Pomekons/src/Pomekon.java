public class Pomekon implements Comparable<Pomekon> {

    private String name;

    public Pomekon(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public int compareTo(Pomekon other){
        return this.name.compareTo(other.name);
    }
}
