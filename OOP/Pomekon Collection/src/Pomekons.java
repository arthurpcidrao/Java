public class Pomekons {
    private String name;

    public Pomekons(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void imprimePomekon(){
        System.out.println(this.name);
    }
}
