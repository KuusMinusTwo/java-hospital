package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JLabel;

public class TreatmentType {
    public String jobtype;
    public String treatmentname;
    public String treatmentdesc;
    public String category;
    public int price;
    public void Save( ){
        try{
            //database: Hospital, user: root, pwd: bayraaT1$DA
            Connection conn = Database.conn;
            String query = "INSERT INTO TreatmentType VALUES (NULL, ?, ?, ?, ?, ?);";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, jobtype);
            pst.setString(2, treatmentname);
            pst.setString(3, treatmentdesc);
            pst.setString(4,category);
            pst.setInt(5, price);
            pst.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void add(JLabel replay) {
    }
}
