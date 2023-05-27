package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Patient {
    public void SavePatient( String firstname, String lastname, String dateofbirth, int age){
        try{
            //database: Hospital, user: root, pwd: bayraaT1$DA
            Connection conn = Database.conn;
            String query = "INSERT INTO Patient VALUES (NULL, ?, ?, ?, ?);";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, firstname);
            pst.setString(2, lastname);
            pst.setString(3, dateofbirth);
            pst.setInt(4, age);
            pst.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
