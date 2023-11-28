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
    private JTextField pQuantidadeField, pProdutoField, pMarcaField, pCodigoField,
            pValorField;
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
        pQuantidadeField = new JTextField(20);
        inputPanel.add(pQuantidadeField);
        inputPanel.add(new JLabel("Produto"));
        pProdutoField = new JTextField(20);
        inputPanel.add(pProdutoField);
        inputPanel.add(new JLabel("Marca"));
        pMarcaField = new JTextField(20);
        inputPanel.add(pMarcaField);
        inputPanel.add(new JLabel("Código"));
        pCodigoField = new JTextField(20);
        inputPanel.add(pCodigoField);
        inputPanel.add(new JLabel("Valor"));
        pValorField = new JTextField(20);
        inputPanel.add(pValorField);
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
                    pQuantidadeField.setText((String) table.getValueAt(linhaSelecionada, 0));
                    pProdutoField.setText((String) table.getValueAt(linhaSelecionada, 1));
                    pMarcaField.setText((String) table.getValueAt(linhaSelecionada, 2));
                    pCodigoField.setText((String) table.getValueAt(linhaSelecionada, 3));
                    pValorField.setText((String) table.getValueAt(linhaSelecionada, 4));
                }
            }
        });
        // Cria um objeto operacoes da classe ProdutosControl para executar operações no
        // banco de dados
        ProdutosControl operacoes = new ProdutosControl(produtos, tableModel, table);

        // Configura a ação do botão "cadastrar" para adicionar um novo registro no
        // bancco de dados
        cadastrar.addActionListener(e -> {
            operacoes.cadastrar(pQuantidadeField.getText(), pProdutoField.getText(), pMarcaField.getText(),
                    pCodigoField.getText(), pValorField.getText());
            // Limpa os campos de entrada após a operação de cadastro
            pQuantidadeField.setText("");
            pProdutoField.setText("");
            pMarcaField.setText("");
            pCodigoField.setText("");
            pValorField.setText("");
        });
        // Configura a ação do botão "editar" para atualizar um registro no banco de
        // dados
        editar.addActionListener(e -> {
            operacoes.atualizar(pQuantidadeField.getText(), pProdutoField.getText(), pMarcaField.getText(),
                    pCodigoField.getText(), pValorField.getText());
            // Limpa os campos de entrada após a operação de atualização
            pQuantidadeField.setText("");
            pProdutoField.setText("");
            pMarcaField.setText("");
            pCodigoField.setText("");
            pValorField.setText("");
        });
        // Configura a ação do botão "apagar" para excluir um registro no banco de dados
        apagar.addActionListener(e -> {
            operacoes.apagar(pCodigoField.getText());
            // Limpa os campos de entrada após a operação de exclusão
            pQuantidadeField.setText("");
            pProdutoField.setText("");
            pMarcaField.setText("");

            pCodigoField.setText("");
            pValorField.setText("");
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
