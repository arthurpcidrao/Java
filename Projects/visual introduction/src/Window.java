import javax.swing.*;

public class Window extends JFrame{

    private JFrame frame;
    private JPanel panel;
    private String nome;
    private String idade;

    public JFrame getFrame(){
        return frame;
    }

    public void setFrame(JFrame frame){
        this.frame = frame;
    }

    public JPanel getPanel(){
        return panel;
    }

    public void setPanel(JPanel panel){
        this.panel = panel;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getIdade(){
        return idade;
    }

    public void setIdade(String idade){
        this.idade = idade;
    }

    public Window(JFrame frame, JPanel panel){
        this.frame = frame;
        this.panel = panel;

        frame.setSize(640, 480);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
    }

    public void cadastro(){
        JLabel rotulo = new JLabel();
        rotulo.setText("Digite seu nome");
        panel.add(rotulo);

        JTextField textField = new JTextField(30);
        panel.add(textField);

        JButton salvarBtn = new JButton("Salvar");
        panel.add(salvarBtn);

        MyListener listener = new MyListener();
        salvarBtn.addActionListener(listener);

    }
    
}
