package Connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conectar {
    Connection conexao_MySql;
    String LINK = "jdbc:mysql://localhost:3306/ecommercepaula";
    String USER = "root";
    String PASSWORD = "20nov2004";

    // Método para fazer a conexão com um banco de dados MySql
    public Connection connectionMySql()  {
        
        try {
            conexao_MySql = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommercepaula", "root", "20nov2004");
            System.out.println("conexão OK!");
        } catch (SQLException e) {
            throw new RuntimeException("Ocorreu um problema na conexão com o BD", e);
        }
        return conexao_MySql;
    }
}
