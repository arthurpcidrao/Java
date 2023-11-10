import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;  // criação de janela
import javax.swing.JPanel;  // criação de pinturas

public class ScreenAnimation extends JFrame {
    private JPanel tela;
    
    public ScreenAnimation() {
        tela = new JPanel() {
            @Override
            public void paintComponent(Graphics g){
                // a pintura acontece aqui
                g.setColor(Color.BLUE);
                g.drawLine(0, 240, 640, 240);               // desenha linha
                g.drawRect(10, 25, 20, 20);            // desenha um quadrado
                g.drawOval(30, 20, 40, 30);            // desenha oval

                g.setColor(Color.YELLOW);
                g.drawLine(320, 0, 320, 480);
                g.fillRect(110, 125, 120, 120);        // preenche quadrado
                g.fillOval(230, 220, 240, 230);        // preenche oval

                g.setColor(Color.RED);
                g.drawString("Eu seria um ótimo Score",5, 10);
            }
        };

        getContentPane().add(tela);  // com isso, adicionamos a tela na janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        setVisible(true);
        tela.repaint();
    }
}
