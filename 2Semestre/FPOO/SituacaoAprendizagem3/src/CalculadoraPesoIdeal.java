import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraPesoIdeal extends JPanel implements ActionListener {
    private JTextField alturaField, nomeField;  // Declaração dos campos de texto para altura e nome
    private JComboBox<String> sexoComboBox;   // Declaração do menu suspenso para seleção de sexo
    private JButton calcularButton, apagarButton;  // Declaração dos botões de calcular e apagar

    // Construtor da classe CalculadoraPesoIdeal
    public CalculadoraPesoIdeal() {
        super();
        setPreferredSize(new Dimension(400, 200));  // Define o tamanho preferencial do painel
        setLayout(new GridBagLayout());  // Define o layout do painel como GridBagLayout

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);  // Define margens entre os componentes
        gbc.anchor = GridBagConstraints.WEST;  // Define alinhamento à esquerda

        // Adiciona um rótulo e um campo de texto para inserir o nome
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Inserir seu Nome:"), gbc);

        gbc.gridx = 1;
        nomeField = new JTextField(10);  // Cria um campo de texto para o nome com 10 colunas
        add(nomeField, gbc);

        // Adiciona um rótulo e um campo de texto para inserir a altura
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Inserir altura (metros):"), gbc);

        gbc.gridx = 1;
        alturaField = new JTextField(10);  // Cria um campo de texto para a altura com 10 colunas
        add(alturaField, gbc);

        // Adiciona um rótulo e um menu suspenso para selecionar o sexo
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Escolher sexo:"), gbc);

        gbc.gridx = 1;
        String[] sexoOptions = {"Masculino", "Feminino"};
        sexoComboBox = new JComboBox<>(sexoOptions);  // Cria um menu suspenso com opções de sexo
        add(sexoComboBox, gbc);

        // Adiciona botão "Apagar" e configura o ActionListener para lidar com eventos
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        apagarButton = new JButton("Apagar");
        apagarButton.addActionListener(this);
        add(apagarButton, gbc);

        // Adiciona botão "Peso Ideal" em um painel separado para melhor alinhamento
        JPanel botoesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        calcularButton = new JButton("Peso Ideal");
        calcularButton.addActionListener(this);
        botoesPanel.add(calcularButton);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(botoesPanel, gbc);

        // Adiciona botões numéricos e botão "C" em um painel separado
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(criarBotoesNumericos(), gbc);  // Utiliza o método para criar e adicionar os botões numéricos
    }

    // Método para criar os botões numéricos e o botão "C"
    private JPanel criarBotoesNumericos() {
        JPanel botoesNumericosPanel = new JPanel(new GridLayout(3, 5, 5, 5));  // Cria um painel com layout de grade

        for (int i = 0; i <= 9; i++) {
            JButton botao = new JButton(String.valueOf(i));  // Cria botões de 0 a 9
            botao.addActionListener(this);  // Adiciona um ActionListener para lidar com eventos
            botoesNumericosPanel.add(botao);  // Adiciona o botão ao painel
        }

        JButton botaoPonto = new JButton(".");  // Cria um botão de ponto
        botaoPonto.addActionListener(this);  // Adiciona um ActionListener para lidar com eventos
        botoesNumericosPanel.add(botaoPonto);  // Adiciona o botão de ponto ao painel

        JButton botaoC = new JButton("C");  // Cria um botão "C"
        botaoC.addActionListener(this);  // Adiciona um ActionListener para lidar com eventos
        botoesNumericosPanel.add(botaoC);  // Adiciona o botão "C" ao painel

        return botoesNumericosPanel;  // Retorna o painel com os botões numéricos
    }

    // Método chamado quando um evento ocorre
    @Override
    public void actionPerformed(ActionEvent e) {
        // Lógica para lidar com diferentes eventos (botões pressionados)
        // ...
    }
}
