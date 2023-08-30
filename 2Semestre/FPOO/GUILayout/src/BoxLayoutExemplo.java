import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * BoxLayoutExemplo
 */
public class BoxLayoutExemplo extends JFrame {
    public BoxLayoutExemplo() {
        super("Exemplo Box Layout");
        BorderLayout border = new BorderLayout();
        this.setLayout(border);
        // Criar dois paineis
        JPanel painel1 = new JPanel();
        JPanel painel2 = new JPanel();
        // Adicionar os paineis ao frame
        this.add(painel1, BorderLayout.WEST);
        this.add(painel2, BorderLayout.SOUTH);
        // Layout dos painéis
        painel1.setLayout(new BoxLayout(painel1, BoxLayout.Y_AXIS));
        painel2.setLayout(new BoxLayout(painel2, BoxLayout.X_AXIS));
        // Adicionar elementos aos paineis
        for (int i = 0; i < 5; i++) {
            painel1.add(new JButton(""+i+1));
            painel2.add(new JButton(""+i+1));
        }
        // Set do frame
        this.setDefaultCloseOperation(2);
        this.pack();
        this.setVisible(true);
    }
}