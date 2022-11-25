package User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class UserRepository {
    public boolean login (String email, String password, Connection con) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Usuario where email = \""+ email + "\" and password = \""+ password + "\"; ");

            if (rs != null) {
                System.out.println("foi");
                return true;
            }

            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cadastro (String nome, String email, String password, Connection con) {
        try {
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO Usuario (name, email, password) VALUES(\"" + nome + "\",\"" + email + "\", \"" + password + "\";");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void pedido (
            String pedido,
            String telefone,
            String endereco,
            String complemento,
            Date entrega,
            Connection con) {
        try {
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO Usuario (name, email, password) " +
                    "VALUES(\"" + nome + "\",\"" + email + "\", \"" + password + "\";");
        }catch (SQLException e) {
            throw new RuntimeException(e)
        }
    }

}
