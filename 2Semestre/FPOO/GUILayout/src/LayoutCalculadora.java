import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LayoutCalculadora {
    public LayoutCalculadora() {
        // construir o layout de uma calculadora
        JFrame janelaP = new JFrame("Janela Calculdora");
        JPanel painelB = new JPanel();// padrao flowlayout
        janelaP.getContentPane().add(painelB);
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