package Services;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;

public class RequestService {
    public void createRequest(String request, String phone, String adress, String complement, Date deliveryDate,
            Connection con) {
        try {
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO request (request,phone,adress,deliveryDate) VALUES(\"" + request + "\",\""
                    + phone + "\",\"" + adress +  " " + complement + "\",\"" + deliveryDate + "\");");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
