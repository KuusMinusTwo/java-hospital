package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
    public static Connection conn;
    public static void init(){
        try {
            //setup driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex){
            System.out.println("mysql driver not found");
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hospital", "root", "bayraaT1$DA");
        } catch (SQLException e) {
            e.printStackTrace();
        };
    }
    public static void inspectionResult(String reg, int id){
        try{
            //database: Hospital, user: root, pwd: bayraaT1$DA
            ResultSet resultset = null;
            PreparedStatement preparedStatement = null;
            String sql = "select * from Service where (select Register from Patient where PatientID = (select patientid from Service where ServiceID = ?)) = ? AND ServiceID = ?;";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, reg);
            preparedStatement.setInt(3, id);
            resultset = preparedStatement.executeQuery();
           
            boolean noquery = true;
            while(resultset.next()){
                noquery = false;
                System.out.println(resultset.getInt("ServiceID") + " " + resultset.getString("ServiceDate") + " " + 
                resultset.getInt("DoctorID") + " " +  resultset.getInt("PatientID") + " " + resultset.getInt("TreatmentID") +
                " " + resultset.getString("TreatmentReport") + " " + resultset.getString("Category") + " " + resultset.getInt("Price")
                + " " + resultset.getString("Status")
                );
            }
            if(noquery) {
                System.out.println("Algoo");
            }

        }catch (Exception e){
            System.out.println("pisdaa");
        }
    }
    public static void TreatmentSelect(String category){
        try{
            //database: Hospital, user: root, pwd: bayraaT1$DA
            ResultSet resultset = null;
            PreparedStatement preparedStatement = null;
            String sql = "select * from TreatmentType where Category = ?;";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, category);
            resultset = preparedStatement.executeQuery();

            boolean noquery = true;
            while(resultset.next()){
                noquery = false;
                System.out.println(resultset.getInt(1) + " " + resultset.getString(2) + " " + 
                resultset.getString(3) + " " +  resultset.getString(4) + " " + resultset.getString(5) +
                " " + resultset.getInt(6));
            }
            if(noquery) {
                System.out.println("Algoo");
            }
        }catch (Exception e){
            System.out.println("pisdaaaa");
        }
    }
}
