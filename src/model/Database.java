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
    public static Vector<String> inspectionResult(int id, String reg){
        Vector<String> result=new Vector<String>();
        try{
            //database: Hospital, user: root, pwd: bayraaT1$DA
            ResultSet resultset = null;
            PreparedStatement preparedStatement = null;
            String sql = "select * from Service inner join TreatmentType on TreatmentType.TreatmentID = Service.TreatmentID where (select Register from Patient where PatientID = (select patientid from Service where ServiceID = ?)) = ? AND ServiceID = ?;";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, reg);
            preparedStatement.setInt(3, id);
            resultset = preparedStatement.executeQuery();
           
            boolean noquery = true;
            while(resultset.next()){
                noquery = false;
                result.add(reg);
                result.add(patientNameGetter(resultset.getInt("PatientID")));
                result.add(doctorNameGetter(resultset.getInt("DoctorID")));
                result.add(treatmentNameGetter(resultset.getInt("TreatmentID")));
                result.add(resultset.getString("TreatmentDescription"));
                result.add(Integer.toString(resultset.getInt("Price")));
                result.add(resultset.getString("Status"));
                result.add(resultset.getString("ServiceDate"));
                result.add(resultset.getString("TreatmentReport"));
            }
            if(noquery) {
                System.out.println("Algoo");
            }
            return result;

        }catch (Exception e){
            System.out.println("pisdaa");
            return result;
        }
    }
    public static String doctorNameGetter(int id){
        try{
            //database: Hospital, user: root, pwd: bayraaT1$DA
            ResultSet resultset = null;
            PreparedStatement preparedStatement = null;
            String sql = "select Firstname from Doctor where EmployeeID = ?;";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultset = preparedStatement.executeQuery();
            resultset.next();
            return resultset.getString("Firstname");

        }catch (Exception e){
            System.out.println("pisdaa");
            return "";
        }  
    }
    public static String patientNameGetter(int id){
        try{
            //database: Hospital, user: root, pwd: bayraaT1$DA
            ResultSet resultset = null;
            PreparedStatement preparedStatement = null;
            String sql = "select FirstName from Patient where PatientID = ?;";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultset = preparedStatement.executeQuery();
            resultset.next();
            return resultset.getString("FirstName");

        }catch (Exception e){
            System.out.println("pisdaa");
            return "";
        }  
    }
    public static String treatmentNameGetter(int id){
        try{
            //database: Hospital, user: root, pwd: bayraaT1$DA
            ResultSet resultset = null;
            PreparedStatement preparedStatement = null;
            String sql = "select TreatmentName from TreatmentType where TreatmentID = ?;";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultset = preparedStatement.executeQuery();
            resultset.next();
            return resultset.getString("TreatmentName");

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
    public static TreatmentType treatmentInfoForId(int id){
        TreatmentType treatmentType = new TreatmentType();
        try{
            //database: Hospital, user: root, pwd: bayraaT1$DA
            ResultSet resultset = null;
            PreparedStatement preparedStatement = null;
            String sql = "select * from TreatmentType where TreatmentID = ?;";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultset = preparedStatement.executeQuery();
            boolean noquery = true;
            while(resultset.next()){
                treatmentType.jobtype = resultset.getString("JobType");
                treatmentType.treatmentname = resultset.getString("TreatmentName");
                treatmentType.treatmentdesc = resultset.getString("TreatmentDescription");
                treatmentType.category = resultset.getString("Category");
                treatmentType.price = resultset.getInt("Price");
                noquery = false;
            }
            if(noquery) {
                System.out.println("Algoo");
            }
            return treatmentType;
        }catch (Exception e){
            System.out.println("pisdaaaa");
            return treatmentType;
        }
    }
}
