import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.FlowLayout;

public class Container extends JFrame {
    public Container(){
        this.setBounds(100, 100, 200, 300); // Seta posição e tamanho
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        FlowLayout flow = new FlowLayout(FlowLayout.LEFT); // Define o layout do container
        this.setLayout(flow); // Seta layout do container
        JLabel label = new JLabel("Exemplo de Texto");
        this.add(label);
        JTextField campo = new JTextField(15);
        this.add(campo);
        //this.pack();
        for (int i = 1; i <= 6; i++)
            this.add(new JButton("Aperte " + i)); // Adiciona um botão
        this.setVisible(true); // Exibe a janela
    }
}
