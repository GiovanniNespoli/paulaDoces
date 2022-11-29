package Services;

import java.sql.Statement;
import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
import java.sql.ResultSet;
// import java.sql.SQLException;

public class UserService {

    public boolean Login(String email, String password, Connection con) {
        System.out.println("IN SERVICE " + email + " " + password);

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT * FROM user WHERE email = \"" + email + "\" AND password = \"" + password + "\";");

            System.out.println("RS " + rs);

            while(rs.next()) {
                return true;
            }

            return false;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
