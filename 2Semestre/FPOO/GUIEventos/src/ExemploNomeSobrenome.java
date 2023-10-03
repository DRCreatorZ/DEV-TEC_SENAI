import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;

public class ExemploNomeSobrenome extends JFrame{
    //construtor
    public ExemploNomeSobrenome() {
        super("Nome Sobrenome");
        //criar painel principal -> gridLayout 
        JPanel mainPanel = new JPanel(new GridLayout(3,2));
        this.add(mainPanel);
        //criar os componentes e add
        mainPanel.add(new JLabel("Nome:"));
        JTextField caixa1 = new JTextField();
        mainPanel.add(caixa1);
        mainPanel.add(new JLabel("Sobrenome:"));
        JTextField caixa2 = new JTextField();
        mainPanel.add(caixa2);
        JButton botao = new JButton("Concatenar");
        mainPanel.add(botao);
        JLabel texto = new JLabel();
        mainPanel.add(texto);
        //set do Frame
        this.setDefaultCloseOperation(2);
        this.setBounds(100, 100, 300, 150);
        this.setVisible(true);
        //tratamento de eventos
        //e->{}
        botao.addActionListener(e->{
            texto.setText(caixa1.getText()+" "+caixa2.getText());
        });
    }    
}