package Models;

import java.sql.Date;

public class Request {
    private int id;
    private String request, phone, adress, complement, status;
    private Date deliveryDate;

    public Request() {
    }

    public Request(int id, String request, String phone, String adress, String complement, Date deliveryDate, String status) {
        this.id = id;
        this.request = request;
        this.phone = phone;
        this.adress = adress;
        this.complement = complement;
        this.deliveryDate = deliveryDate;
        this.status = status;
    }

    public Request(int id, String request, String phone, String adress, Date deliveryDate, String status) {
        this.id = id;
        this.request = request;
        this.phone = phone;
        this.adress = adress;
        this.deliveryDate = deliveryDate;
        this.status = status;
    }
    
    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
