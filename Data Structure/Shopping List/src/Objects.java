public class Objects implements Comparable<Objects>{
    
    private String object = "";

    public Objects(String object){
        this.object = object;
    }

    public String getObject(){
        return this.object;
    }

    @Override
    public int compareTo(Objects other) {
        return this.object.compareTo(other.object);
    }

}
