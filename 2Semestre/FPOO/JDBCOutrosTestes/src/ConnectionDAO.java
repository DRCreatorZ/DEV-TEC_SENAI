import java.sql.*;

public class ConnectionDAO {
    public void cleanup() {
        Connection con = ConnectionFactory.getConnection();
        Statement stmt = null;
        try {
            stmt.executeUpdate("drop table tbl_basica");
            con.close();
        } catch (Exception ex) {
            // Ignorar todos os erros
        }
    }

    public void doexample() throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        Statement stmt = null;
        System.out.println("\nExecutando os testes:");
        // Cria a tabela que armazena os dados
        stmt.executeUpdate("create table tbl_basica (a int2, b int2)");

    }
}
