package controller;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connection.VendasDAO;
import model.Produtos;
import model.Vendas;

public class VendasControl {

    // Atributos
    private List<Vendas> vendas; // Lista de objetos Produtos
    private DefaultTableModel tableModel; // Produto da tabela Swing para exibição dos dados
    private JTable table; // Tabela Swing onde os dados são exibidos

     // Construtor
    public VendasControl(List<Vendas> vendas, DefaultTableModel tableModel, JTable table) {
        this.vendas = vendas; // Inicializa a lista de produtos
        this.tableModel = tableModel; // Inicializa o produto da tabela
        this.table = table; // Inicializa a tabela Swing
    }

     // Método para atualizar a tabela de exibição com dados do banco de dados
     private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        vendas = new VendasDAO().listarTodos(); // Obtém os produtos atualizados do banco de dados
        for (Vendas venda : vendas) {
            // Adiciona os dados de cada produto como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { venda.getData(), venda.getCliente(), venda.getValor(), venda.getTipoProduto()});
        }
    }

    // Método para cadastrar um novo produto no banco de dados
    public void cadastrar(String data, String cliente, String valor, String produto) {
        new VendasDAO().cadastrar(data, cliente, valor, produto);
        // Chama o método de cadastro no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após o cadastro
    }

     // Método para atualizar os dados de um produto no banco de dados
     public void atualizar(String data, String cliente, String valor, String produto) {
        new VendasDAO().atualizar(data, cliente, valor, produto); 
        // Chama o método de atualização no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a atualização
    }

    // Método para apagar um produto do banco de dados
    public void apagar(String produto) {
        new VendasDAO().apagar(produto); 
        // Chama o método de exclusão no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a exclusão
    }

}
