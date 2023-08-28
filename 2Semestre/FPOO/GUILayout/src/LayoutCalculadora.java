import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LayoutCalculadora {
    public LayoutCalculadora() {
        // construir o layout de uma calculadora
        JFrame janelaP = new JFrame("Janela Calculdora");
        //mudando o Lyout daFrame
        BorderLayout border = new BorderLayout();
        janelaP.setLayout(border);
        JPanel painelV = new JPanel();
        JPanel painelB = new JPanel();// padrao flowlayout
        janelaP.getContentPane().add(painelB, BorderLayout.CENTER);
        janelaP.getContentPane().add(painelV, BorderLayout.NORTH);
        //adicionar o textField no PainelV
         JTextField caixa1 = new JTextField(25);
        painelV.add(caixa1);
        // set layout do JPanel
        GridLayout grid = new GridLayout(4, 4);
        painelB.setLayout(grid);
        // Vetor com os txtos dos botoes
        String textBotoes[] = { "C", "9", "8", "7", "/", "6", "5", "4", "*", "3", "2", "1", "-", "+", "0","="};
        for (int i = 0; i < textBotoes.length; i++) {
            painelB.add(new JButton(textBotoes[i]));
        }
        //set do Frame
        janelaP.setDefaultCloseOperation(2);
        janelaP.pack();
        janelaP.setVisible(true);
    }
}