import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);
        double a, b, c;

        a = input.nextDouble();
        b = input.nextDouble();
        c = input.nextDouble();

        input.close();

        double result;

        if ((a < b + c) && (b < a + c) && (c < a + b)){
            Triangle triangulo = new Triangle(a, b, c);
            result = valor(triangulo);
            System.out.printf("Perimetro = %.1f\n", result);
        }
        else{
            Trapezium trapezio = new Trapezium(a, b, c);
            result = valor(trapezio);
            System.out.printf("Area = %.1f\n", result);
        }

    }

    public static double valor(Points poligono){
        double value = poligono.calcula();
        return value;
    }
}
