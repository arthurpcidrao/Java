public class Generics implements Comparable<Generics>{

    private String element;
    private String hash;

    public Generics(String element){
        this.element = element;
        this.hash = element;
    }

    public String getElement(){
        return this.element;
    }

    public void setElement(String element){
        this.element = element;
    }

    public String getHash(){
        return this.hash;
    }

    public void setHash(String hash){
        this.hash = hash;
    }


    @Override
    public int compareTo(Generics other) {

        return this.element.compareTo(other.element);
    }
    
}
