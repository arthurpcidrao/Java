import javax.swing.*;
import java.awt.*;

public class TabelaExemplo extends JFrame {
    private JTable table;

    public TabelaExemplo() {
        setTitle("Exemplo de Tabela");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Dados da tabela
        Object[][] data = {
                {"Alice", 25, "Feminino"},
                {"Bob", 30, "Masculino"},
                {"Charlie", 28, "Masculino"},
                {"Diana", 22, "Feminino"}
                // Adicione mais linhas conforme necessário
        };

        // Nomes das colunas
        String[] columnNames = {"Nome", "Idade", "Gênero"};

        // Cria a tabela com os dados e nomes das colunas
        table = new JTable(data, columnNames);

        // Adiciona a tabela a um JScrollPane para rolagem, se necessário
        JScrollPane scrollPane = new JScrollPane(table);
        

        // Adiciona o JScrollPane (com a tabela) ao JFrame
        add(scrollPane, BorderLayout.EAST);
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TabelaExemplo tabelaExemplo = new TabelaExemplo();
            tabelaExemplo.setVisible(true);
        });
    }
}
