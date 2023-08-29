import java.util.Scanner;

public class Example_OOP {
    public static void main(String[] args) throws Exception {
        // Criando um objeto
        Headphone arthurPhone = new Headphone();

        Scanner input = new Scanner(System.in); // entrada de dados pode ser referido ao objeto TECLADO do pc

        // Chamando os atributos (variáveis)
        arthurPhone.setMarca("Sony");  // forma PRIVADA
        arthurPhone.setTamanho('P');  // forma PRIVADA
        
        System.out.println(arthurPhone.getMarca());  // forma PRIVADA
        System.out.println(arthurPhone.getTamanho());  // forma PRIVADA

        arthurPhone.cor = "Preto";  // forma PÚBLICA
        arthurPhone.material = "aluminio";  // forma PÚBLICA

        // Chamando os métodos (funções)
        arthurPhone.on();
        arthurPhone.AumentarVolume();
        arthurPhone.AumentarVolume();
        input.close();
        
    }
}
