public class Trapezium extends Points {
    
    public Trapezium(double a, double b, double c){
        super(a, b, c);
    }

    public double calcula(){
        return ((this.getA() + this.getB())*this.getC())/2;
    }
}
