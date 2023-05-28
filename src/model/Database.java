package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import pages.serviceList;

public class Database {
    public static boolean hasDB = false;
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
                doctorIDGetter(resultset.getInt("DoctorID"))  + " " +  resultset.getInt("PatientID") + " " + resultset.getInt("TreatmentID") +
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
    public static String doctorIDGetter(int id){
        try{
            //database: Hospital, user: root, pwd: bayraaT1$DA
            ResultSet resultset = null;
            PreparedStatement preparedStatement = null;
            String sql = "select Firstname from Doctor where EmployeeID = ?;";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultset = preparedStatement.executeQuery();
            return resultset.getString("Firstname");

        }catch (Exception e){
            System.out.println("pisdaa");
            return "";
        }
        
    }
    public static Vector<String> treatmentSelect(String category){
        Vector<String> result=new Vector<String>();
        try{
            //database: Hospital, user: root, pwd: bayraaT1$DA
            ResultSet resultset = null;
            PreparedStatement preparedStatement = null;
            String sql = "select TreatmentName from TreatmentType where Category = ?;";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, category);
            resultset = preparedStatement.executeQuery();
            
            boolean noquery = true;
            while(resultset.next()){
                result.add(resultset.getString("TreatmentName"));
                noquery = false;
            }
            if(noquery) {
                System.out.println("Algoo");
            }
            System.out.println(result);
            return result;
        }catch (Exception e){
            System.out.println("pisdaaaa");
            return result;
        }
    }
}
