import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;

import java.util.Random;

public class AppJogo {
    public static void main(String[] args) throws Exception {
        boolean jogando = true;
        boolean fimJogo = false;
        
        // ------------------- DEFINIÇÕES DA TELA ------------------- //
        JFrame frame = new JFrame("Tetris do Arthur Paraiba");
        frame.setSize(800, 672);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.setContentPane(panel);

        JLabel rotulo = new JLabel();
        rotulo.setText("olá");
        rotulo.setForeground(Color.WHITE);
        rotulo.setFont(new Font("Tahoma",Font.BOLD, 15));

        
        panel.add(rotulo);
        panel.setBackground(Color.DARK_GRAY);
        

    }

}
