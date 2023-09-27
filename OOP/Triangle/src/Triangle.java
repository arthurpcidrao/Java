public class Triangle extends Points {

    public Triangle(double a, double b, double c){
        super(a, b, c);
    }

    public double calcula(){
        return this.getA() + this.getB() + this.getC();
    }
}

