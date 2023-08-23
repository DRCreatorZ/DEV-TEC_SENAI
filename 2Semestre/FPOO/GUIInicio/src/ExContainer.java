import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ExContainer extends JFrame {
    int clicks = 0;
    public ExContainer(){
        super ("Botões");
        this.setBounds(100, 100, 200, 300);
        FlowLayout flow = new FlowLayout(); // Define o layout do container
        this.setLayout(flow);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JButton but = new JButton("I'm a Swing button");
        //JLabel texto = new JLabel("Button Add");
        JPanel painel = new JPanel();
        painel.add(but);
        //painel.add(texto);
        this.getContentPane().add(painel);
        //this.pack();
        this.setVisible(true);
        but.addActionListener(e ->{
            this.setVisible(true);
            this.add(new JButton("Botão:  "+ clicks++));
        });
    }
}
