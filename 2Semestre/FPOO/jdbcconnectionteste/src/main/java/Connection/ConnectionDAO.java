package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDAO {
    // atributo
    private Connection connection; // Atributo para armazenar a conexão com o banco de dados

    // construtor
    public ConnectionDAO() {
        this.connection = ConnectionFactory.getConnection(); // Inicializa a conexão ao criar uma instância da classe
    }

    // método para criar a tabela
    public void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS MINHA_TABELA (ID SERIAL PRIMARY KEY,NOME VARCHAR(255),EMAIL VARCHAR(255))";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql); // Executa o SQL para criar a tabela
            System.out.println("Tabela criada com sucesso."); // Mensagem de sucesso
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e); // Em caso de erro, lança uma exceção
        } finally {
            ConnectionFactory.closeConnection(this.connection); // Garante que a conexão seja fechada, independente de ter ocorrido um erro ou não
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
            ConnectionFactory.closeConnection(this.connection); // Garante que a conexão seja fechada, independente de ter ocorrido um erro ou não
        }
    }

    // método para inserir dados na tabela
    public void inserir(String nome, String email) {
        String sql = "INSERT INTO MINHA_TABELA (NOME, EMAIL) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome); // Define o valor do primeiro ponto de interrogação no SQL como 'nome'
            stmt.setString(2, email); // Define o valor do segundo ponto de interrogação no SQL como 'email'
            stmt.executeUpdate(); // Executa a inserção
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e); // Em caso de erro, lança uma exceção
        } finally {
            ConnectionFactory.closeConnection(this.connection); // Garante que a conexão seja fechada, independente de ter ocorrido um erro ou não
        }
    }

    // método para buscar por ID na tabela
    public void buscarPorId(int id) {
        String sql = "SELECT * FROM MINHA_TABELA WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id); // Define o valor do ponto de interrogação no SQL como 'id'
            ResultSet resultSet = stmt.executeQuery(); // Executa a consulta e armazena os resultados em um ResultSet
            while (resultSet.next()) {
                int idBuscado = resultSet.getInt("ID"); // Obtém o valor do campo 'ID'
                String nomeBuscado = resultSet.getString("NOME"); // Obtém o valor do campo 'NOME'
                String emailBuscado = resultSet.getString("EMAIL"); // Obtém o valor do campo 'EMAIL'
                System.out.println("o Resultado da busca é id " + idBuscado + " nome " +
                        nomeBuscado + " email " + emailBuscado); // Imprime os resultados
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar dados no banco de dados.", e); // Em caso de erro, lança uma exceção
        } finally {
            ConnectionFactory.closeConnection(this.connection); // Garante que a conexão seja fechada, independente de ter ocorrido um erro ou não
        }
    }
}
