

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class ConnectionDAO {
    // atributo
    private Connection connection; // Atributo para armazenar a conexão com o banco de dados
    private List<Task> tasks;
    // construtor
    public ConnectionDAO() {
        this.connection = ConnectionFactory.getConnection(); // Inicializa a conexão ao criar uma instância da classe
    }

    // método para criar a tabela
    public void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS task_todolist (DESCRICAO VARCHAR(255),STATUS BOOLEAN)";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql); // Executa o SQL para criar a tabela
            System.out.println("Tabela criada com sucesso."); // Mensagem de sucesso
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e); // Em caso de erro, lança uma
                                                                                        // exceção
        } finally {
            ConnectionFactory.closeConnection(this.connection); // Garante que a conexão seja fechada, independente de
                                                                // ter ocorrido um erro ou não
        }
    }

    // método para apagar a tabela
    public void apagarTabela() {
        String sql = "DROP TABLE MINHA_TABELA";
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql); // Executa o SQL para apagar a tabela
            System.out.println("Tabela apagada com sucesso."); // Mensagem de sucesso
        } catch (Exception e) {
            throw new RuntimeException("Erro ao apagar tabela.", e); // Em caso de erro, lança uma exceção
        } finally {
            ConnectionFactory.closeConnection(this.connection); // Garante que a conexão seja fechada, independente de
                                                                // ter ocorrido um erro ou não

        }
    }

    // Método para inserir dados na tabela com ID especificado
    public void inserir(int id, String nome, String email) {
        // Define a instrução SQL parametrizada para inserir dados com ID
        String sql = "INSERT INTO MINHA_TABELA (ID, NOME, EMAIL) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, nome);
            stmt.setString(3, email);
            stmt.executeUpdate(); // Executa a instrução SQL
            System.out.println("Dados inseridos com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Método para inserir dados na tabela sem especificar um ID
    public void inserir(String nome, String email) {
        // Define a instrução SQL parametrizada para inserir dados sem ID
        String sql = "INSERT INTO MINHA_TABELA (NOME, EMAIL) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.executeUpdate(); // Executa a instrução SQL
            System.out.println("Dados inseridos com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Método para buscar dados na tabela com base em um ID específico
    public void buscarPorId(int id) {
        // Define a instrução SQL parametrizada para buscar dados por ID
        String sql = "SELECT * FROM MINHA_TABELA WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery(); // Executa a consulta e obtém resultados

            while (resultSet.next()) {
                int idBuscado = resultSet.getInt("ID");
                String nomeBuscado = resultSet.getString("NOME");
                String emailBuscado = resultSet.getString("EMAIL");
                System.out.println(
                        "O resultado da busca é id " + idBuscado + " nome " + nomeBuscado

                                + " email " + emailBuscado);

            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Método para apagar um dado da tabela com base em um ID
    // específico
    public void apagarID(int id) {
        // Define a instrução SQL parametrizada para apagar dados por ID
        String sql = "DELETE FROM Minha_Tabela WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate(); // Executa a instrução SQL
            System.out.println("Dado apagado com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Método para atualizar dados na tabela com base em um ID específico
    public void atualizarID(int id, String novoNome, String novoEmail) {
        // Define a instrução SQL parametrizada para atualizar dados por ID
        String sql = "UPDATE MINHA_TABELA SET nome = ?, email = ? WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, novoNome);
            stmt.setString(2, novoEmail);
            stmt.setInt(3, id);
            stmt.executeUpdate(); // Executa a instrução SQL

            System.out.println("Dados atualizados com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Método para listar todos os valores cadastrados na tabela
    public void listarTodos() {
        ResultSet rs = null;
        // Define a instrução SQL para selecionar todos os registros da tabela
        String sql = "SELECT * FROM minha_tabela";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            rs = stmt.executeQuery(); // Executa a consulta e obtém resultados
            while (rs.next()) {
                System.out.println("id : " + rs.getInt("id") +
                        " nome: " + rs.getString("nome") +
                        " email: " + rs.getString("email"));

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(connection);
        }
    }
}