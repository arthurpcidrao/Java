import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;  // criação de janela
import javax.swing.JPanel;  // criação de pinturas

public class ScreenAnimation extends JFrame {
    private JPanel tela;
    private int fps = 1000/20;  // 1000 milissegundos, 20 movimentações (em 1 segundo, movimentar 20 vezes)
    private int count;
    private boolean anima = true;
    
    public ScreenAnimation() {
        tela = new JPanel() {
            @Override
            public void paintComponent(Graphics g){
                // a pintura acontece aqui

                g.setColor(Color.WHITE);
                g.fillRect(0, 0, tela.getWidth(), tela.getHeight());

                g.setColor(Color.BLUE);
                g.drawLine(0, 240 + count, 640, 240 + count);               // desenha linha
                g.drawRect(10, 25 + count, 20, 20);            // desenha um quadrado
                g.drawOval(30 + count, 20, 40, 30);            // desenha oval

                g.setColor(Color.YELLOW);
                g.drawLine(320 - count, 0, 320 - count, 480);
                g.fillRect(110, 125, 120 - count, 120 - count);        // preenche quadrado
                g.fillOval(230, 220, 240 + count, 230);        // preenche oval

                g.setColor(Color.RED);
                g.drawString("Eu seria um ótimo Score" + count,5, 10);
            }
        };

        getContentPane().add(tela);  // com isso, adicionamos a tela na janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        setVisible(true);
        tela.repaint();
    }

    public void beginAnimation(){
        long proxAtualizacao = 0;

        while(anima){
            if (System.currentTimeMillis() >= proxAtualizacao){
                count++;
                tela.repaint();

                proxAtualizacao = System.currentTimeMillis() + fps;

                if (count == 100){
                    anima = false;
                }
            }
        }
    }






}
