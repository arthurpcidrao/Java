import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tela {

    public Tela(int largura, int altura){
        criaTela(largura, altura);
    }
    
    public static final void criaTela(int largura, int altura){
        JFrame frame = new JFrame("Tetris do Arthur Paraiba");
        frame.setSize(largura, altura);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.setContentPane(panel);
        
    }
}
