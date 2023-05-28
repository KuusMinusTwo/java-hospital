package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Service {
    public String servicedate;
    public int servicetime;
    public int doctorid;
    public int patientid;
    public int treatmentid;
    public String treatmentreport;
    public int price;
    public String category;
    public String status;
    public int Save(){
        try{
            //database: Hospital, user: root, pwd: bayraaT1$DA
            Connection conn = Database.conn;
            String query = "INSERT INTO Service VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, servicedate);
            pst.setInt(2,servicetime);
            pst.setInt(3, doctorid);
            pst.setInt(4, patientid);
            pst.setInt(5, treatmentid);
            pst.setString(6, treatmentreport);
            pst.setString(7, category);
            pst.setInt(8, price);
            pst.setString(9, status);
            pst.execute();
            return 1;
        }catch (Exception e){
            
            e.printStackTrace();
            return -1;
        }
    }
}
