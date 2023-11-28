package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Clientes;
import model.Vendas;

public class VendasDAO {

    // atributos
    private Connection connection;
    private List<Vendas> vendas;

    public VendasDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    // Criar a Tabela no banco de dados
    public void criaTabela() {

        String sql = "CREATE TABLE IF NOT EXISTS vendas_mercado (DATA VARCHAR(255),CLIENTE VARCHAR(255),VALOR VARCHAR(255),CARRO VARCHAR(255) PRIMARY KEY)";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Listar todos os valores cadastrados
    public List<Vendas> listarTodos() {
        PreparedStatement stmt = null; // Declaração do objeto PreparedStatement para executar a consulta
        ResultSet rs = null; // Declaração do objeto ResultSet para armazenar os resultados da consulta
        vendas = new ArrayList<>(); // Cria uma lista para armazenar os produtos recuperados do banco de dados
    
        try {
            stmt = connection.prepareStatement("SELECT * FROM vendas_mercado"); 
            // Prepara a consulta SQL para selecionar todos os registros da tabela
            rs = stmt.executeQuery(); 
            // Executa a consulta e armazena os resultados no ResultSet
    
            while (rs.next()) {
                // Para cada registro no ResultSet, cria um objeto Produtos com os valores do registro
                Vendas venda = new Vendas(
                    rs.getString("data"),
                    rs.getString("cliente"),
                    rs.getString("valor"),
                    rs.getString("produto")
                );
                vendas.add(venda); // Adiciona o objeto Produtos à lista de produtos
            }
        } catch (SQLException ex) {
            System.out.println(ex); // Em caso de erro durante a consulta, imprime o erro
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs); // Fecha a conexão, o PreparedStatement e o ResultSet
        }
        return vendas; // Retorna a lista de produtos recuperados do banco de dados
    }

    //Cadastrar Produto no banco
    public void cadastrar(String data, String cliente, String valor, String produto) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para cadastrar na tabela
        String sql = "INSERT INTO vendas_mercado (cliente, data, produto, valor) VALUES (?, ?, ?, ?)";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente);
            stmt.setString(2, data);
            stmt.setString(3, produto);
            stmt.setString(4, valor);
            stmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection,stmt);
        }
    }

    //Atualizar dados no banco
    public void atualizar(String data, String cliente, String valor, String produto) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para atualizar dados pela codigo
        String sql = "UPDATE vendas_mercado SET data = ?, cliente = ?, valor = ? WHERE produto = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, data);
            stmt.setString(2, cliente);
            stmt.setString(3, valor);
            //codigo é chave primaria não pode ser alterada.
            stmt.setString(4, produto);
            
            stmt.executeUpdate();
            
            System.out.println("Dados atualizados com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

     // Apagar dados do banco
     public void apagar(String produto) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para apagar dados pela codigo
        String sql = "DELETE FROM vendas_mercado WHERE produto = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto);
            stmt.executeUpdate(); // Executa a instrução SQL
            System.out.println("Dado apagado com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }


}
