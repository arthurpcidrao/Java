public class Headphone {
    
    // Atributos
    private String marca;   // (encapsulamento)
    public String cor;
    public String material;
    public char tamanho;
    public boolean bluetooth;
    public boolean ligado;
    public int volume = 0;

    //---------------------------------------//

    // Métodos

    public void setMarca( String marca) {
        this.marca = marca;  // forma convencional
    }

    public String getMarca() {
        return marca;
    }

    public void on() {
        ligado = true;
    }

    public void off() {
        ligado = false;
    }

    public void AumentarVolume() {
        if (this.ligado == true) {
            this.volume++;
        }
    }

    public void DiminuirVolume() {
        if (this.ligado == true) {
            this.volume--;
        }
    }

    public void setTamanho(char t) {
        tamanho = t;
    }

    public char getTamanho() {
        return tamanho;
    }

    //-------------------------------------//
}
