import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ExercicioAddBotao extends JFrame {
    int NewButCount = 0;

    public ExercicioAddBotao() {
        super("JFrame");
        FlowLayout flow = new FlowLayout();
        this.setLayout(flow);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JButton but = new JButton("I am the button Nº " + NewButCount++);
        JPanel painel = new JPanel();
        painel.add(but);
        this.getContentPane().add(painel);
        this.setBounds(50, 100, 2000, 1500);
        JPanel painel2 = new JPanel();
        this.getContentPane().add(painel2);
        but.addActionListener(e -> {
            JButton butt = new JButton("1" + NewButCount++);
            painel2.add(butt);
            
        });
        this.pack();
        this.setVisible(true);

    }
}