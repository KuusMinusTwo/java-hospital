package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Service {
    public String servicedate;
    public int doctorid;
    public int patientid;
    public int treatmentid;
    public String treatmentreport;
    public int price;
    public String category;
    public String status;
    public void Save(){
        try{
            //database: Hospital, user: root, pwd: bayraaT1$DA
            Connection conn = Database.conn;
            String query = "INSERT INTO Service VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, servicedate);
            pst.setInt(2, doctorid);
            pst.setInt(3, patientid);
            pst.setInt(4, treatmentid);
            pst.setString(5, treatmentreport);
            pst.setString(6, category);
            pst.setInt(7, price);
            pst.setString(8, status);
            pst.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
