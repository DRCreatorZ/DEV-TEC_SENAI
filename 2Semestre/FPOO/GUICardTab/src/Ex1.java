import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;

public class Ex1 extends JFrame{
    //construtor
    public Ex1() {
        super("Exercício 1");
        JPanel painel1 = new JPanel();//principal
        //botao de seleçao de Cards
        JButton botao = new JButton(("NEXT"));
        painel1.add(botao);
        //criar os cards
        JPanel cards = new JPanel();//card principal - vai permitir a navegação
        CardLayout cl = new CardLayout();
        cards.setLayout(cl);
        //criar os cards da pilha
        JPanel card1 = new JPanel();
        card1.add(new JButton("Botão 1"));
        card1.add(new JButton("Botão 2"));
        card1.add(new JButton("Botão 3"));

        JPanel card2 = new JPanel();
        card2.add(new JTextField("Card com Jtext", 20));

        //adicionar card no botao
        this.add(painel1);
        painel1.add(cards);
        cards.add(card1);
        cards.add(card2);
        
        //set do Frame
        this.setDefaultCloseOperation(2);
        this.setBounds(100, 100, 300, 300);
        this.setVisible(true);

        //criar a ação para o botao
        botao.addActionListener(e->{
            cl.next(cards);
        });
    }
}
