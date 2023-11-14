import java.awt.event.*;
import javax.swing.JButton;

public class MyListener implements ActionListener{
    private Window janela;
    
    public MyListener(){
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        JButton button = (JButton) e.getSource();
        button.setText("clicado");
    }
}
