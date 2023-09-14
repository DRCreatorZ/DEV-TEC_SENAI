import java.awt.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Calculadora extends JPanel{
    public Calculadora() {
        super(new BorderLayout());
        //mudando o Lyout daFrame
        BorderLayout border = new BorderLayout();
        this.setLayout(border);
        JPanel painelV = new JPanel();
        JPanel painelB = new JPanel();
        JPanel painelC = new JPanel();// padrao flowlayout
        this.add(painelV, BorderLayout.NORTH);
        this.add(painelB, BorderLayout.CENTER);
        this.add(painelC, BorderLayout.EAST);
       
        //adicionar o textField no PainelV
         JTextField visor = new JTextField(30);
        painelV.add(visor);
        // set layout do JPanel
        GridLayout grid = new GridLayout(4, 4);
        painelB.setLayout(grid);
        String textBotoes[] = { "9", "8", "7","6", "5", "4", "1", "2", "3","AC","0","="};
        for (int a = 0; a < textBotoes.length; a++) {
            painelB.add(new JButton(textBotoes[a]));
        }
        painelC.setLayout(new GridLayout(4, 1));
        painelC.add(new JButton("+"));
        painelC.add(new JButton("-"));
        painelC.add(new JButton("/"));
        painelC.add(new JButton("x"));

    }
}