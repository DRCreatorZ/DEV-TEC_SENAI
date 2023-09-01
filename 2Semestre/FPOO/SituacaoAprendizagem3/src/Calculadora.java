import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculadora {
    public Calculadora() {
        // construir o layout de uma calculadora
        JFrame janelaP = new JFrame("Janela Calculdora");
        //mudando o Lyout daFrame
        BorderLayout border = new BorderLayout();
        janelaP.setLayout(border);
        JPanel painelV = new JPanel();
        JPanel painelB = new JPanel();
        JPanel painelC = new JPanel();// padrao flowlayout
        janelaP.getContentPane().add(painelV, BorderLayout.NORTH);
        janelaP.getContentPane().add(painelB, BorderLayout.CENTER);
        janelaP.getContentPane().add(painelC, BorderLayout.EAST);
       
        //adicionar o textField no PainelV
         JTextField caixa1 = new JTextField(25);
        painelV.add(caixa1);
        // set layout do JPanel
        GridLayout grid = new GridLayout(4, 4);
        painelB.setLayout(grid);
        String textBotoes[] = { "9", "8", "7","6", "5", "4", "1", "2", "3","AC","0","="};
        for (int a = 0; a < textBotoes.length; a++) {
            painelB.add(new JButton(textBotoes[a]));
        }
        //GridLayout grid2 = new GridLayout(1, 1);
       // painelC.setLayout(grid2);
        painelC.setLayout(new GridLayout(4, 1));
        painelC.add(new JButton("+"));
        painelC.add(new JButton("-"));
        painelC.add(new JButton("/"));
        painelC.add(new JButton("x"));
    

       // String textBotoes2[] = {  "0","="};
        //for (int i = 0; i < textBotoes2.length; i++) {
           // painelB.add(new JButton(textBotoes2[i]));
        // Vetor com os txtos dos botoes
        
        //set do Frame
        janelaP.setDefaultCloseOperation(2);
        janelaP.pack();
        janelaP.setVisible(true);
        janelaP.setResizable(false);
    }
}