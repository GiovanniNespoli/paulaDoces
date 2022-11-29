package Services;

import java.sql.Statement;
import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
import java.sql.ResultSet;
// import java.sql.SQLException;

public class UserService {

    public boolean Login(String email, String password, Connection con) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt
                    .executeQuery("SELECT * FROM user email = \"" + email + "\" AND password = \"" + password + "\";");

            System.out.println(rs);
            if (rs != null) {
                System.out.println("Foi");
                return true;
            }

            return false;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
