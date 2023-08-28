import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class FlowLayoutExemplo2 {
    public FlowLayoutExemplo2() {
        JFrame janela1 = new JFrame("Janela Principal");
        janela1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        FlowLayout flow = new FlowLayout();
        janela1.setLayout(flow);
        JLabel texto1 = new JLabel("Nº de botão");
        janela1.add(texto1);
        JTextField caixa1 = new JTextField(25);
        janela1.add(caixa1);

        janela1.setDefaultCloseOperation(2);
        janela1.pack();
        janela1.setVisible(true);
    }
}