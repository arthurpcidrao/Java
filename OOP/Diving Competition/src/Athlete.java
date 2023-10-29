public class Athlete {
    private String name;
    private double diffic;
    private double nota;    

    public Athlete(String name, double nota){
        this.name = name;
        this.nota = nota;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getDiffic(){
        return diffic;
    }

    public void setDiffic(double diffic){
        this.diffic = diffic;
    }

    public double getNota(){
        return nota;
    }

    public void setNota(double nota){
        this.nota = nota;
    }

    public void imprimeDados(){
        System.out.printf("%s %.2f\n", getName(), getNota());
    }

}
