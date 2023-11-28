package view;

import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import connection.ProdutosDAO;
import controller.ProdutosControl;
import java.awt.*;
import java.awt.event.*;
import model.Produtos;

public class ProdutosPainel extends JPanel {
    // Atributos(componentes)
    private JButton cadastrar, apagar, editar;
    private JTextField carMarcaField, carModeloField, carAnoField, carPlacaField,
            carValorField;
    private List<Produtos> produtos;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;

    // Construtor(GUI-JPanel)
    public ProdutosPainel() {
        super();
        // entrada de dados
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Cadastro Produtos"));
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Quantidade"));
        carMarcaField = new JTextField(20);
        inputPanel.add(carMarcaField);
        inputPanel.add(new JLabel("Produto"));
        carModeloField = new JTextField(20);
        inputPanel.add(carModeloField);
        inputPanel.add(new JLabel("Marca"));
        carAnoField = new JTextField(20);
        inputPanel.add(carAnoField);
        inputPanel.add(new JLabel("Código"));
        carPlacaField = new JTextField(20);
        inputPanel.add(carPlacaField);
        inputPanel.add(new JLabel("Valor"));
        carValorField = new JTextField(20);
        inputPanel.add(carValorField);
        add(inputPanel);
        JPanel botoes = new JPanel();
        botoes.add(cadastrar = new JButton("Cadastrar"));
        botoes.add(editar = new JButton("Editar"));
        botoes.add(apagar = new JButton("Apagar"));
        add(botoes);
        // tabela de produtos
        JScrollPane jSPane = new JScrollPane();
        add(jSPane);
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Quantidade", "Produto", "Marca", "Codigo", "Valor" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        // Cria o banco de dados caso não tenha sido criado
        new ProdutosDAO().criaTabela();
        // incluindo elementos do banco na criação do painel
        atualizarTabela();

        // tratamento de Eventos(construtor)
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    carMarcaField.setText((String) table.getValueAt(linhaSelecionada, 0));
                    carModeloField.setText((String) table.getValueAt(linhaSelecionada, 1));
                    carAnoField.setText((String) table.getValueAt(linhaSelecionada, 2));
                    carPlacaField.setText((String) table.getValueAt(linhaSelecionada, 3));
                    carValorField.setText((String) table.getValueAt(linhaSelecionada, 4));
                }
            }
        });
        // Cria um objeto operacoes da classe ProdutosControl para executar operações no
        // banco de dados
        ProdutosControl operacoes = new ProdutosControl(produtos, tableModel, table);

        // Configura a ação do botão "cadastrar" para adicionar um novo registro no
        // bancco de dados
        cadastrar.addActionListener(e -> {
            operacoes.cadastrar(carMarcaField.getText(), carModeloField.getText(), carAnoField.getText(),
                    carPlacaField.getText(), carValorField.getText());
            // Limpa os campos de entrada após a operação de cadastro
            carMarcaField.setText("");
            carModeloField.setText("");
            carAnoField.setText("");
            carPlacaField.setText("");
            carValorField.setText("");
        });
        // Configura a ação do botão "editar" para atualizar um registro no banco de
        // dados
        editar.addActionListener(e -> {
            operacoes.atualizar(carMarcaField.getText(), carModeloField.getText(), carAnoField.getText(),
                    carPlacaField.getText(), carValorField.getText());
            // Limpa os campos de entrada após a operação de atualização
            carMarcaField.setText("");
            carModeloField.setText("");
            carAnoField.setText("");
            carPlacaField.setText("");
            carValorField.setText("");
        });
        // Configura a ação do botão "apagar" para excluir um registro no banco de dados
        apagar.addActionListener(e -> {
            operacoes.apagar(carPlacaField.getText());
            // Limpa os campos de entrada após a operação de exclusão
            carMarcaField.setText("");
            carModeloField.setText("");
            carAnoField.setText("");

            carPlacaField.setText("");
            carValorField.setText("");
        });
    }

    // metodos de eventos (atualizar tabela)
    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        produtos = new ProdutosDAO().listarTodos();
        // Obtém os produtos atualizados do banco de dados
        for (Produtos produto : produtos) {
            // Adiciona os dados de cada produto como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { produto.getMarca(), produto.getModelo(),
                    produto.getAno(), produto.getPlaca(), produto.getValor() });
        }
    }
}
