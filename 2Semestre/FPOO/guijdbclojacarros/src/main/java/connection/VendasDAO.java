package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Vendas;

public class VendasDAO {
    // atributo
    private Connection connection;
    private List<Vendas> vendas;

    // construtor
    public VendasDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    // criar Tabela
    public void criaTabela() {
       String sql = "CREATE TABLE IF NOT EXISTS vendas_lojacarros ("
                    + "carro VARCHAR(255), "
                    + "cliente VARCHAR(255), "
                    + "valor_venda VARCHAR(255), "
                    + "forma_pagamento VARCHAR(255), "
                    + "data_venda VARCHAR(255), "
                    + "PRIMARY KEY (cliente, data_venda)"
                    + ")";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso.");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }
// Método para cadastrar uma nova venda no banco de dados
    public void cadastrar(String carro, String cliente, String valorVenda, String formaPagamento, String dataVenda) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConnectionFactory.getConnection();
            String sql = "INSERT INTO vendas_lojacarros (carro, cliente, valor_venda, forma_pagamento, data_venda) VALUES (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, carro);
            stmt.setString(2, cliente);
            stmt.setString(3, valorVenda);
            stmt.setString(4, formaPagamento);
            stmt.setString(5, dataVenda);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
    }

    // Método para listar todas as vendas no banco de dados
    public List<Vendas> listarTodos() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Vendas> vendas = new ArrayList<>();

        try {
            conn = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM vendas_lojacarros";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Vendas venda = new Vendas(rs.getString("carro"), rs.getString("cliente"),
                        rs.getString("valor_venda"), rs.getString("forma_pagamento"), rs.getString("data_venda"));
                vendas.add(venda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }

        return vendas;
    }

    // Método para atualizar os dados de uma venda no banco de dados
    public void atualizar(String carro, String cliente, String valorVenda, String formaPagamento, String dataVenda) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConnectionFactory.getConnection();
            String sql = "UPDATE vendas_lojacarros SET valor_venda = ?, forma_pagamento = ? WHERE carro = ? AND cliente = ? AND data_venda = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, valorVenda);
            stmt.setString(2, formaPagamento);
            stmt.setString(3, carro);
            stmt.setString(4, cliente);
            stmt.setString(5, dataVenda);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
    }

    // Método para apagar uma venda do banco de dados
    public void apagar(String cliente, String dataVenda) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConnectionFactory.getConnection();
            String sql = "DELETE FROM vendas_lojacarros WHERE cliente = ? AND data_venda = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente);
            stmt.setString(2, dataVenda);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
    }
}
