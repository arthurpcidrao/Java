public class Headphone {
    String marca;
    String cor;
    String material;
    char tamanho;
    boolean bluetooth;
    boolean ligado;
    int volume = 0;

    void on() {
        ligado = true;
    }

    void off() {
        ligado = false;
    }

    void AumentarVolume() {
        if (ligado == true) {
            volume++;
        }
    }

    void DiminuirVolume() {
        if (ligado == true) {
            volume--;
        }
    }
}
