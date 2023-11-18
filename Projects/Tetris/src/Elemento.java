public class Elemento {

    private int x, y, largura, altura;
    private double velocidade;

    public Elemento(int x, int y, int largura, int altura){
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
    }

    public int getX(){
        return x;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getY(){
        return y;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getLargura(){
        return largura;
    }
    public void setLargura(int largura){
        this.largura = largura;
    }
    public int getAltura(){
        return altura;
    }
    public void setAltura(int altura){
        this.altura = altura;
    }
    public double getVelocidade(){
        return velocidade;
    }
    public void setVelocidade(double velocidade){
        this.velocidade = velocidade;
    }
    
}
