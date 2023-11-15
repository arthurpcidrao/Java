import java.awt.*;
import javax.swing.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Interativo extends JFrame {
    private JPanel tela;
    private int px;
    private int py;
    private boolean jogando = true;
    private boolean controleTecla[] = new boolean[4];

    private final int FPS = 1000/20;

    public Interativo(){
        this.addKeyListener(new KeyListener() {
            
            @Override //evento para tecla apertada
            public void keyTyped(KeyEvent e){
            }

            @Override //evento para tecla liberada
            public void keyReleased(KeyEvent e){
                setaTecla(e.getKeyCode(), false);
            }

            @Override
            //evento para tecla pressionada
            public void keyPressed(KeyEvent e){
                setaTecla(e.getKeyCode(), true);
            }
            
        });

        tela = new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, tela.getWidth(), tela.getHeight());

                int x = tela.getWidth()/2 - 20 + px;
                int y = tela.getHeight()/2 - 20 + py;

                g.setColor(Color.BLUE);
                g.fillRect(x, y, 40, 40);
                g.drawString("Agora eu estou em " + x + "x" + y, 5, 10);
            }
        };
        getContentPane().add(tela);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        setVisible(true);
    }

    public void inicia(){
        long proxAtualizacao = 0;
        while(jogando){
            if (System.currentTimeMillis() >= proxAtualizacao){
                atualizaJogo();
                tela.repaint();
                proxAtualizacao = System.currentTimeMillis() + FPS;
            }
        }
    }

    public void atualizaJogo(){
        if (controleTecla[0]){
            py--;
        }
        else if (controleTecla[1]){
            py++;
        }

        if (controleTecla[2]){
            px--;
        }
        else if (controleTecla[3]){
            px++;
        }
    }

    private void setaTecla(int tecla, boolean pressionada){
        switch(tecla){
            case KeyEvent.VK_ESCAPE: // tecla ESC
            jogando = false;
            dispose();
            break;

            case KeyEvent.VK_UP:
            controleTecla[0] = pressionada;
            break;

            case KeyEvent.VK_DOWN:
            controleTecla[1] = pressionada;
            break;

            case KeyEvent.VK_LEFT:
            controleTecla[2] = pressionada;
            break;

            case KeyEvent.VK_RIGHT:
            controleTecla[3] = pressionada;
            break;
        }
    }

    
}
