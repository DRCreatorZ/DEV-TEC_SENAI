package controller;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connection.ClientesDAO;
import model.Clientes;

/**
 * ClientesControl
 */
public class ClientesControl {
    // Atributos
    private List<Clientes> clientes;
    private DefaultTableModel tableModel;
    private JTable table;

    // Construtor
public ClientesControl(List<Clientes> clientes, DefaultTableModel tableModel, JTable table)
{
this.clientes = clientes;
this.tableModel = tableModel;
this.table = table;
}

//Métodos do produto CRUD
// Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        clientes = new ClientesDAO().listarTodos();
        // Obtém os produtos atualizados do banco de dados
        for (Clientes cliente : clientes) {
            // Adiciona os dados de cada produto como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { cliente.getNome(), cliente.getEndereco(),
                cliente.getTelefone(), cliente.getCpf() });
        }
    }

    // Método para cadastrar um novo produto no banco de dados
    public void cadastrar(String nome, String endereco, String telefone, String cpf) {
        new ClientesDAO().cadastrar(nome, endereco, telefone, cpf);
        // Chama o método de cadastro no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após o cadastro
    }

    // Método para atualizar os dados de um produto no banco de dados
    public void atualizar(String nome, String endereco, String telefone, String cpf) {
        new ClientesDAO().atualizar(nome, endereco, telefone, cpf);
        // Chama o método de atualização no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a atualização
    }

    // Método para apagar um produto do banco de dados
    public void apagar(String cpf) {
        new ClientesDAO().apagar(cpf);
        // Chama o método de exclusão no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a exclusão
    }
}
