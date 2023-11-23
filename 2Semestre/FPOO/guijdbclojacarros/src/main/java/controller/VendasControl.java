package controller;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import connection.VendasDAO;
import model.Vendas;

public class VendasControl {
    private List<Vendas> vendas;
    private DefaultTableModel tableModel;
    private JTable table;

    // Corrigir o construtor
    public VendasControl(List<Vendas> vendas, DefaultTableModel tableModel, JTable table) {
        this.vendas = vendas;
        this.tableModel = tableModel;
        this.table = table;
    }

    // Métodos do modelo CRUD
    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        vendas = new VendasDAO().listarTodos();
        // Obtém as vendas atualizadas do banco de dados
        for (Vendas venda : vendas) {
            // Adiciona os dados de cada venda como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { venda.getCarro(), venda.getCliente(),
                    venda.getValorVenda(), venda.getFormaPagamento(), venda.getDataVenda() });
        }
    }

    // Método para cadastrar uma nova venda no banco de dados
    public void cadastrar(String carro, String cliente, String valorVenda, String formaPagamento, String dataVenda) {
        new VendasDAO().cadastrar(carro, cliente, valorVenda, formaPagamento, dataVenda);
        // Chama o método de cadastro no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após o cadastro
    }

    // Método para atualizar os dados de uma venda no banco de dados
    public void atualizar(String carro, String cliente, String valorVenda, String formaPagamento, String dataVenda) {
        new VendasDAO().atualizar(carro, cliente, valorVenda, formaPagamento, dataVenda);
        // Chama o método de atualização no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a atualização
    }

    // Método para apagar uma venda do banco de dados
    public void apagar(String cliente, String dataVenda) {
        new VendasDAO().apagar(cliente, dataVenda);
        // Chama o método de exclusão no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a exclusão
    }
}
