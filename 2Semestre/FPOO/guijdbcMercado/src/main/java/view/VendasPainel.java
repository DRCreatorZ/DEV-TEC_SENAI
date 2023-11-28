package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import connection.ProdutosDAO;
import connection.ClientesDAO;
import connection.VendasDAO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ProdutosControl;
import controller.ClientesControl;
import controller.VendasControl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.awt.*;

import model.Produtos;
import model.Vendas;
import model.Clientes;


public class VendasPainel extends JPanel {
    // atributos - componentes
    // campo de texto - JTextField
    private JTextField inputData;
    private JTextField inputCliente;
    private JTextField inputValor;
    private JTextField inputProduto;

    // campo escrito - JLabel
    private JLabel labelData;
    private JLabel labelCliente;
    private JLabel labelValor;
    private JLabel labelProduto;

    private DefaultTableModel tableModel; // lógica
    private JTable table; // visual
    private List<Vendas> vendas = new ArrayList<>();
    private List<Produtos> produtos;
    private List<Clientes> clientes;
    private int linhaSelecionada = -1;
    private JButton cadastrarButton, apagarButton, editarButton, atualizarButton;

    JComboBox<String> produtosComboBox;
    JComboBox<String> clientesComboBox;

    public VendasPainel() {
        JPanel frame1 = new JPanel(new BorderLayout());
        JPanel inputFrame = new JPanel();
        JPanel botoes = new JPanel();

        produtosComboBox = new JComboBox<>();
        clientesComboBox = new JComboBox<>();

        // construir a tabela
        tableModel = new DefaultTableModel();
        
        tableModel.addColumn("Cliente");
        tableModel.addColumn("Data");
        tableModel.addColumn("Produto");
        tableModel.addColumn("Valor");
        
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setViewportView(table);

        // criar os componentes
        inputCliente = new JTextField(20);
        inputData = new JTextField(10);
        inputProduto = new JTextField(20);
        inputValor = new JTextField(10);

        // criar os componentes - labels
         labelProduto = new JLabel("Produto");

        labelData = new JLabel("Data");
       
        labelValor = new JLabel("Valor");

        // botões
        cadastrarButton = new JButton("Comprar");
        cadastrarButton.setBackground(Color.white);
        apagarButton = new JButton("Apagar");
        apagarButton.setBackground(Color.white);
        editarButton = new JButton("Editar");
        editarButton.setBackground(Color.white);
        atualizarButton = new JButton("Atualizar");
        atualizarButton.setBackground(Color.white);

        // adicionar os componentes
         inputFrame.add(clientesComboBox);
        inputFrame.add(produtosComboBox);
        inputFrame.add(labelData);
        inputFrame.add(inputData);

        inputFrame.add(labelValor);
        inputFrame.add(inputValor);

        botoes.add(cadastrarButton);
        botoes.add(editarButton);
        botoes.add(apagarButton);
        botoes.add(atualizarButton);

        this.add(frame1);
        frame1.add(scrollPane, BorderLayout.CENTER);
        frame1.add(inputFrame, BorderLayout.SOUTH);
        frame1.add(botoes, BorderLayout.NORTH);

        produtosComboBox.addItem("Selecione um Produto");
        produtos = new ProdutosDAO().listarTodos();
        for (Produtos produto : produtos) {
            produtosComboBox.addItem(produto.getMarca() + " " + produto.getModelo());
        }

        clientesComboBox.addItem("Selecione um cliente");
        clientes = new ClientesDAO().listarTodos();
        // criar um método para atualizar o combobox
        for (Clientes cliente : clientes) {
            clientesComboBox.addItem(cliente.getNome() + " " + cliente.getCpf());
        }

        // adicionando o JComboBox ao painel
       

        // Criar o banco de dados
        new VendasDAO().criaTabela();

        // incluir os elementos do banco na criação do painel
        atualizarTabela();

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                   inputCliente.setText((String) table.getValueAt(linhaSelecionada, 0));
                     inputData.setText((String) table.getValueAt(linhaSelecionada, 1));
                    inputValor.setText((String) table.getValueAt(linhaSelecionada, 2));
                    inputProduto.setText((String) table.getValueAt(linhaSelecionada, 3));
                }
            }
        });

        VendasControl operacoes = new VendasControl(vendas, tableModel, table);

        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = inputData.getText();
                String valor = inputValor.getText();
                String clienteSelecionado = (String) clientesComboBox.getSelectedItem(); // pegar o cliente selecionado
                                                                                         // no ComboBox
                String produtoSelecionado = (String) produtosComboBox.getSelectedItem(); // pegar o produto selecionado no
                                                                                     // ComboBox

                if (data.isEmpty() || valor.isEmpty() || clienteSelecionado.equals("Selecione um cliente")
                        || produtoSelecionado.equals("Selecione um Produto")) {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
                } else {
                    if (!valor.matches("[0-9]+")) {
                        JOptionPane.showMessageDialog(null, "O campo 'Valor' deve conter apenas números.");
                    } else {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    dateFormat.setLenient(false);
                    
                    try {
                        // Tentar fazer o parse da data para verificar se é uma data válida
                        Date parsedDate = dateFormat.parse(data);
                        if (!data.equals(dateFormat.format(parsedDate))) {
                            throw new ParseException("Formato inválido", 0);
                        }
        
                        String cliente = clienteSelecionado.split(" ")[0];
                        operacoes.cadastrar(data, cliente, valor, produtoSelecionado);
                        inputData.setText("");
                        inputValor.setText("");
                        clientesComboBox.setSelectedIndex(0);
                        produtosComboBox.setSelectedIndex(0);
                        new ProdutosDAO().apagar(produtoSelecionado);
                        JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso!");
                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(null, "Formato de data inválido. Utilize o formato dd/MM/yyyy.");
                    }
                }
            }
            }
        });
        editarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String clienteSelecionado = (String) clientesComboBox.getSelectedItem(); // pegar o cliente selecionad no ComboBox
                String produtoSelecionado = (String) produtosComboBox.getSelectedItem(); // pegar o produto selecionado no ComboBox
                if (inputProduto.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Selecione algo para editar");
                } else {
                    operacoes.atualizar(inputData.getText(), clienteSelecionado, inputValor.getText(),
                            produtoSelecionado);

                    // Limpa os campos de entrada após a operação de atualização
                    inputData.setText("");
                    inputValor.setText("");
                    clientesComboBox.setSelectedIndex(0);
                    produtosComboBox.setSelectedIndex(0);
                    JOptionPane.showMessageDialog(null, "Editado com Sucesso!");
                }

            }
        });

        // Configura a ação do botão "apagar" para excluir um registro no banco de dados
        apagarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String produtoSelecionado = (String) produtosComboBox.getSelectedItem(); // pegar o produto selecionado no ComboBox
                if (inputProduto.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Selecione um registro para apagar.");
                } else {
                    int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja apagar os campos?", "Confirmação", JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {
                    // Chama o método "apagar" do objeto operacoes com o valor do campo de entrada
                    // "codigo"
                    operacoes.apagar(inputProduto.getText());
                    JOptionPane.showMessageDialog(null, "A venda deletada com Sucesso!");

                    // Limpa os campos de entrada após a operação de exclusão
                    inputData.setText("");
                    inputValor.setText("");
                    clientesComboBox.setSelectedIndex(0);
                    produtosComboBox.setSelectedIndex(0);
                } else{
                    JOptionPane.showMessageDialog(null,"A venda foi Cancelada!");
                }
            }
            }
        });

        // atualizar as comboBox com os valores atuais
        atualizarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizarComboBoxClientes();
                atualizarComboBoxProdutos();
            }
        });

    }

     // atualizar Tabela de Produtos com o Banco de Dados
     private void atualizarTabela() {
        // atualizar tabela pelo banco de dados
        tableModel.setRowCount(0);
        vendas = new VendasDAO().listarTodos();
        for (Vendas venda : vendas) {
            tableModel.addRow(new Object[] { venda.getCliente(), venda.getData(), venda.getTipoProduto(), venda.getValor()});
        }

    }

    // Método para atualizar ComboBox de Clientes
    private void atualizarComboBoxClientes() {
        clientesComboBox.removeAllItems();
        clientesComboBox.addItem("Selecione um cliente");
        clientes = new ClientesDAO().listarTodos();
        for (Clientes cliente : clientes) {
            clientesComboBox.addItem(cliente.getNome() + " " + cliente.getCpf());
        }
    }

    // Método para atualizar ComboBox de Produtos
    private void atualizarComboBoxProdutos() {
        produtosComboBox.removeAllItems();
        produtosComboBox.addItem("Selecione um Produto");
        produtos = new ProdutosDAO().listarTodos();
        for (Produtos produto : produtos) {
            produtosComboBox.addItem(produto.getMarca() + " " + produto.getModelo());
        }
    }
}
