import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Tela do Arthur");
        JPanel panel = new JPanel();

        Window janela = new Window(frame, panel);
        janela.cadastro();
    }
}
