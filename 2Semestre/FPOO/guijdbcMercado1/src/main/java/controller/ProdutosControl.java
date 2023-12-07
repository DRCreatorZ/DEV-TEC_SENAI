package controller;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connection.ProdutosDAO;
import model.Produtos;

/**
 * ProdutosControl
 */
public class ProdutosControl {
    // Atributos
    private List<Produtos> produtos;
    private DefaultTableModel tableModel;
    private JTable table;

    // Construtor
public ProdutosControl(List<Produtos> produtos, DefaultTableModel tableModel, JTable table)
{
this.produtos = produtos;
this.tableModel = tableModel;
this.table = table;
}

//Métodos do produto CRUD
// Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        produtos = new ProdutosDAO().listarTodos();
        // Obtém os produtos atualizados do banco de dados
        for (Produtos produto : produtos) {
            // Adiciona os dados de cada produto como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { produto.getQuantidade(), produto.getProduto(),
                produto.getMarca(), produto.getCodigo(), produto.getValor() });
        }
    }

    // Método para cadastrar um novo produto no banco de dados
    public void cadastrar(String quantidade, String produto, String marca, String codigo, String valor) {
        new ProdutosDAO().cadastrar(quantidade, produto, marca, codigo, valor);
        // Chama o método de cadastro no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após o cadastro
    }

    // Método para atualizar os dados de um produto no banco de dados
    public void atualizar(String quantidade, String produto, String marca, String codigo, String valor) {
        new ProdutosDAO().atualizar(quantidade, produto, marca, codigo, valor);
        // Chama o método de atualização no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a atualização
    }

    // Método para apagar um produto do banco de dados
    public void apagar(String codigo) {
        new ProdutosDAO().apagar(codigo);
        // Chama o método de exclusão no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a exclusão
    }
}
