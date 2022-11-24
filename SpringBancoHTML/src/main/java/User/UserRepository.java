package User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class UserRepository {
    public boolean login (String email, String password, Connection con) {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from dados");
    }

    public void cadastro (String nome, String email, String password, Connection con) {

    }

    public void pedido (
            String pedido,
            String telefone,
            String endereco,
            String complemento,
            Date entrega,
            Connection con) {

    }

}
