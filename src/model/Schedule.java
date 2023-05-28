package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Schedule {
    public int monday;
    public int tuesday;
    public int wednesday;
    public int thursday;
    public int friday;
    public void Save( ){
        try{
            //database: Hospital, user: root, pwd: bayraaT1$DA
            Connection conn = Database.conn;
            String query = "INSERT INTO Schedule VALUES (NULL, ?, ?, ?, ?, ?);";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, monday);
            pst.setInt(2, tuesday);
            pst.setInt(3, wednesday);
            pst.setInt(4, thursday);
            pst.setInt(5, friday);
            pst.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
