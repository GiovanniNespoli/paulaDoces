package Services;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Models.Request;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;

public class RequestService {
    public void createRequest(String request, String phone, String adress, String complement, Date deliveryDate,
            Connection con) {
        try {
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO request (request,phone,adress,deliveryDate,status) VALUES(\"" + request + "\",\""
                    + phone + "\",\"" + adress + " " + complement + "\",\"" + deliveryDate + "\", 'A Fazer');");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Request> index(Connection con) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM request");

            List<Request> requests = new ArrayList<>();

            while (rs.next()) {
                requests.add(new Request(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString((4)), rs.getDate((5)), rs.getString(6)));
            }

            System.out.println(requests);

            return requests;

        } catch (Exception e) {
            System.out.println(e);
            List<Request> requests = new ArrayList<>();
            return requests;
        }
    }

    public List<Request> listDoneRequests(Connection con) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM request WHERE status = 'Feito'");

            List<Request> requests = new ArrayList<>();

            while (rs.next()) {
                requests.add(new Request(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString((4)), rs.getDate((5)), rs.getString(6)));
            }

            System.out.println(requests);

            return requests;

        } catch (Exception e) {
            System.out.println(e);
            List<Request> requests = new ArrayList<>();
            return requests;
        }
    }

    public void delete(Connection con, int id) {
        try {
            Statement stmt = con.createStatement();
            stmt.execute("DELETE FROM request WHERE id = " + id);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void update(Connection con, int id) {
        try {
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE request SET status = 'Feito' WHERE id = " + id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
