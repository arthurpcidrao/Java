import java.util.Scanner;

public class Example_OOP {
    public static void main(String[] args) throws Exception {
        // Criando um objeto
        Headphone ArthurPhone;
        ArthurPhone = new Headphone();

        // Chamando os atributos (variáveis)
        ArthurPhone.marca = "Sony";
        ArthurPhone.cor = "Preto";

        // Chamando os métodos (funções)
        ArthurPhone.on();
        ArthurPhone.AumentarVolume();
        ArthurPhone.AumentarVolume();
        
    }
}
