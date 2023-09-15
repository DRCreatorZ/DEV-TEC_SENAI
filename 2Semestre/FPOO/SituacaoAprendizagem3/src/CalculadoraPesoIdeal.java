import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraPesoIdeal extends JPanel implements ActionListener {
    private JTextField alturaField, nomeField;
    private JComboBox<String> sexoComboBox;
    private JButton calcularButton, apagarButton;

    public CalculadoraPesoIdeal() {
        super();
        setPreferredSize(new Dimension(400, 200));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Inserir seu Nome:"), gbc);

        gbc.gridx = 1;
        nomeField = new JTextField(10);
        add(nomeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Inserir altura (metros):"), gbc);

        gbc.gridx = 1;
        alturaField = new JTextField(10);
        add(alturaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Escolher sexo:"), gbc);

        gbc.gridx = 1;
        String[] sexoOptions = {"Masculino", "Feminino"};
        sexoComboBox = new JComboBox<>(sexoOptions);
        add(sexoComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        apagarButton = new JButton("Apagar");
        apagarButton.addActionListener(this);
        add(apagarButton, gbc);

        JPanel botoesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        calcularButton = new JButton("Peso Ideal");
        calcularButton.addActionListener(this);
        botoesPanel.add(calcularButton);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(botoesPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(criarBotoesNumericos(), gbc);
    }

    private JPanel criarBotoesNumericos() {
        JPanel botoesNumericosPanel = new JPanel(new GridLayout(3, 5, 5, 5));

        for (int i = 0; i <= 9; i++) {
            JButton botao = new JButton(String.valueOf(i));
            botao.addActionListener(this);
            botoesNumericosPanel.add(botao);
        }

        JButton botaoPonto = new JButton(".");
        botaoPonto.addActionListener(this);
        botoesNumericosPanel.add(botaoPonto);

        return botoesNumericosPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calcularButton) {
            String nome = nomeField.getText();
            double altura = Double.parseDouble(alturaField.getText());
            String sexo = (String) sexoComboBox.getSelectedItem(); // Obter o sexo selecionado

            double pesoIdeal;
            if (sexo.equals("Masculino")) {
                pesoIdeal = 72.7 * altura - 58;
            } else {
                pesoIdeal = 62.1 * altura - 44.7;
            }

            String mensagem = nome + ", seu peso ideal é: " + pesoIdeal + "Kg.";
            JOptionPane.showMessageDialog(this, mensagem, "Resultado do Cálculo de Peso Ideal:", JOptionPane.INFORMATION_MESSAGE);

        } else if (e.getSource() == apagarButton) {
            alturaField.setText("");
            nomeField.setText("");
        } else if (e.getSource() instanceof JButton) {
            String textoBotao = ((JButton) e.getSource()).getText();
            String textoCampo = alturaField.getText();

            if (textoBotao.equals(".") && !textoCampo.contains(".")) {
                alturaField.setText(textoCampo + textoBotao);
            } else if (!textoBotao.equals(".")) {
                alturaField.setText(textoCampo + textoBotao);
            }
        }
    }

}
