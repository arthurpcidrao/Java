import java.awt.Graphics;
import javax.swing.JFrame;  // criação de janela
import javax.swing.JPanel;  // criação de pinturas

public class AnimaTelaDesenho extends JFrame {
    private JPanel tela;
    
    public AnimaTelaDesenho(){

        tela = new JPanel() {
            @Override
            public void paintComponent(Graphics g){
                // a pintura acontece aqui
            }
        };
        super.getContentPane().add(tela);  // com isso, adicionamos a tela na janela

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        setVisible(true);
    }
}
