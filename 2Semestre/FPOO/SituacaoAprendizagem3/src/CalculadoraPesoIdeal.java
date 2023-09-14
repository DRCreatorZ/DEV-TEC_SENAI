import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraPesoIdeal extends JPanel implements ActionListener {
    private JTextField alturaField, idadeField, sexoField, pesoField;
    private JButton calcularButton, apagarButton, sairButton;

    public CalculadoraPesoIdeal() {
        super();
        setPreferredSize(new Dimension(400, 200));//altura e largura
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento interno
        gbc.anchor = GridBagConstraints.WEST;

        // Campo e rótulo para Altura
        gbc.gridx = 0;//coluna
        gbc.gridy = 0;//linha
        add(new JLabel("Inserir altura (m):"), gbc);

        gbc.gridx = 1;
        alturaField = new JTextField(10);
        add(alturaField, gbc);

        // Campo e rótulo para Idade
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Inserir idade (anos):"), gbc);

        gbc.gridx = 1;
        idadeField = new JTextField(10);
        add(idadeField, gbc);

        // Campo e rótulo para Sexo
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Inserir sexo (Mas=1/Fem=2:)"), gbc);

        gbc.gridx = 1;
        sexoField = new JTextField(10);
        add(sexoField, gbc);
       
        // Botão Apagar
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1; //componente deve ocupar horizontalmente
        gbc.anchor = GridBagConstraints.WEST; // Alinhar à esquerda
        apagarButton = new JButton("Apagar");
        apagarButton.addActionListener(this);
        add(apagarButton, gbc);

        // Painel para os botões (Calcular, Sair)
        JPanel botoesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Botão Calcular (no centro)
        calcularButton = new JButton("Peso Ideal");
        calcularButton.addActionListener(this);
        botoesPanel.add(calcularButton);

        // Botão Sair (à direita)
        sairButton = new JButton("Sair");
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Fecha a aplicação
            }
        });
        botoesPanel.add(sairButton);

        // Adicionar o painel de botões à grade
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST; // Alinhar à direita
        add(botoesPanel, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == apagarButton) {
            // Limpa os campos de entrada
            alturaField.setText("");
            idadeField.setText("");
            sexoField.setText("");
            pesoField.setText("");
        } else if (e.getSource() == calcularButton) {
            try {
                double altura = Double.parseDouble(alturaField.getText());
                double sexo = Double.parseDouble(sexoField.getText());
                double pesoIdealHomem = 72.7 * altura - 58;
                double pesoIdealMulher = 62.1 * altura - 44.7;
               
                if (sexo == 1) {
                    String mensagem = "Seu peso ideal é: " + pesoIdealHomem + "Kg.";
                    JOptionPane.showMessageDialog(this, mensagem, "Resultado do Cálculo de IMC:", JOptionPane.INFORMATION_MESSAGE);
                } else if (sexo == 2) {
                    // Realiza o cálculo do custo da viagem
                    String mensagem = "Seu peso ideal é: " + pesoIdealMulher + "Kg.";
                    JOptionPane.showMessageDialog(this, mensagem, "Resultado do Cálculo de IMC:", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }   
    }

