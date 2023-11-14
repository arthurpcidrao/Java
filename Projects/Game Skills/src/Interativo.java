import java.awt.*;
import javax.swing.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Interativo extends JFrame {
    private JPanel tela;
    private int px;
    private int py;
    private boolean jogando = true;

    private final int FPS = 1000/20;

    public Interativo(){
        super.addKeyListener(new KeyListener() {
            
            @Override
            //evento para tecla apertada
            public void keyTyped(keyEvent e){
            }

            @Override
            //evento para tecla liberada
            public void keyReleased(keyEvent e){
            }

            @Override
            //evento para tecla pressionada
            public void keyPressed(KeyEvent e){
                int tecla = e.getKeyCode();
                switch (tecla) {
                    case KeyEvent.VK_ESCAPE://tecla ESC
                        jogando = false;
                        dispose(); //para fechar a janela
                        break;
                    case KeyEvent.VK_UP:
                        py--;
                        break;
                    case KeyEvent.VK_DOWN:
                        py++;
                        break;
                    case KeyEvent.VK_LEFT:
                        px--;
                        break;
                    case KeyEvent.VK_RIGHT:
                        px++;
                        break;
                }
            }
            //abaixo tem sugestão do JAVA para um erro que apareceu
            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
            }
        });
    }

    public void inicia(){
        long proxAtualizacao = 0;
        while(jogando){
            if (System.currentTimeMillis() >= proxAtualizacao){
                tela.repaint();
                proxAtualizacao = System.currentTimeMillis() + FPS;
            }
        }
    }

    //ainda tem mais código...
}
