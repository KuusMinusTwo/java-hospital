package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import pages.serviceList;

public class Database {
    public static boolean hasDB = true;
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
                result.add(resultset.getString("ServiceDateDay"));
                result.add(resultset.getString("TreatmentReport"));
            }
            if(noquery) {
                System.out.println("Algoo");
            }
            return result;

        }catch (Exception e){
            System.out.println("bolq bn");
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
            System.out.println("bolq bn");
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
            System.out.println("bolq bn");
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
            System.out.println("bolq bn");
            return "";
        }  
    }
    public static Vector<String> treatmentSelect(String category){
        Vector<String> result=new Vector<String>();
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
                result.add(resultset.getString("TreatmentName"));
                result.add(resultset.getString("TreatmentID"));
                noquery = false;
            }
            if(noquery) {
                System.out.println("Algoo");
            }
            return result;
        }catch (Exception e){
            System.out.println("bolq bn");
            return result;
        }
    }
    public static Vector<String> trtIDtoDoctorInfo(int id){
        Vector<String> result=new Vector<String>();
        try{
            //database: Hospital, user: root, pwd: bayraaT1$DA
            ResultSet resultset = null;
            PreparedStatement preparedStatement = null;
            String sql = "select * from TreatmentType inner join Doctor on Doctor.JobType = TreatmentType.JobType where TreatmentID = ?;";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultset = preparedStatement.executeQuery();
            
            boolean noquery = true;
            while(resultset.next()){
                result.add(resultset.getString("FirstName"));
                result.add(Integer.toString(resultset.getInt("EmployeeID")));
                noquery = false;
            }
            if(noquery) {
                System.out.println("Algoo");
            }
            return result;
        }catch (Exception e){
            System.out.println("Bolq bn");
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
            System.out.println("bolq bn");
            return treatmentType;
        }
    }
    public static Vector<String> doctIDtoServDate(int id){
        Vector<String> result=new Vector<String>();
        try{
            //database: Hospital, user: root, pwd: bayraaT1$DA
            ResultSet resultset = null;
            PreparedStatement preparedStatement = null;
            String sql = "SELECT * FROM Service where DoctorID = ?;";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultset = preparedStatement.executeQuery();
            
            boolean noquery = true;
            while(resultset.next()){
                result.add(resultset.getString("ServiceDateDay"));
                result.add(resultset.getString("ServiceDateHour"));
                noquery = false;
            }
            if(noquery) {
                System.out.println("Algoo");
            }
            return result;
        }catch (Exception e){
            System.out.println("bolq bn");
            return result;
        }
    }
    public static Vector<String> servDatetoDoctID(String servicedateday, int servicedatehour){
        Vector<String> result=new Vector<String>();
        try{
            //database: Hospital, user: root, pwd: bayraaT1$DA
            ResultSet resultset = null;
            PreparedStatement preparedStatement = null;
            String sql = "select * from Service where ServiceDateDay = ? and ServiceDateHour = ?;";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, servicedateday);
            preparedStatement.setInt(2, servicedatehour);
            resultset = preparedStatement.executeQuery();
            
            boolean noquery = true;
            while(resultset.next()){
                result.add(Integer.toString(resultset.getInt("DoctorID")));
                noquery = false;
            }
            if(noquery) {
                System.out.println("Algoo");
            }
            return result;
        }catch (Exception e){
            System.out.println("bolq bn");
            return result;
        }
    }
    public static int patientNametoPatientID(String firstname, String lastname, String dob, int age, String register){
        try{
            //database: Hospital, user: root, pwd: bayraaT1$DA
            ResultSet resultset = null;
            PreparedStatement preparedStatement = null;
            String sql = "select * from Patient where FirstName = ? and LastName = ? and DateOfBirth = ? and Age = ? and Register = ?;";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, dob);
            preparedStatement.setInt(4, age);
            preparedStatement.setString(5, register);
            resultset = preparedStatement.executeQuery();
            
            resultset.next();
            return resultset.getInt("PatientID");
        }catch (Exception e){
            System.out.println("bolq bn");
            return 0;
        }
    }
    public static int treatmentPriceGetter(int id){
        try{
            //database: Hospital, user: root, pwd: bayraaT1$DA
            ResultSet resultset = null;
            PreparedStatement preparedStatement = null;
            String sql = "select Price from TreatmentType where TreatmentID = ?;";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultset = preparedStatement.executeQuery();
            resultset.next();
            return resultset.getInt("Price");

        }catch (Exception e){
            System.out.println("bolq bn");
            return 0;
        }  
    }
    public static Vector<String> doctIDtoDoctorInfo(int id){
        Vector<String> result=new Vector<String>();
        try{
            //database: Hospital, user: root, pwd: bayraaT1$DA
            ResultSet resultset = null;
            PreparedStatement preparedStatement = null;
            String sql = "select * from Doctor where EmployeeID = ?;";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultset = preparedStatement.executeQuery();
            
            boolean noquery = true;
            while(resultset.next()){
                result.add(resultset.getString("FirstName"));
                result.add(resultset.getString("LastName"));
                result.add(resultset.getString("JobType"));
                result.add(Integer.toString(resultset.getInt("Age")));
                result.add(Integer.toString(resultset.getInt("Room")));
                noquery = false;
            }
            if(noquery) {
                System.out.println("Algoo");
            }
            return result;
        }catch (Exception e){
            System.out.println("Bolq bn");
            return result;
        }
    }
    public static int servInfotoServID(String servDateDay, int servDateHour, int doctorID, int patientID, int treatmentID){
        try{
            //database: Hospital, user: root, pwd: bayraaT1$DA
            ResultSet resultset = null;
            PreparedStatement preparedStatement = null;
            String sql = "select * from Service where ServiceDateDay = ? and ServiceDateHour = ? and DoctorID = ? and PatientID = ? and TreatmentID = ?;";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, servDateDay);
            preparedStatement.setInt(2, servDateHour);
            preparedStatement.setInt(3, doctorID);
            preparedStatement.setInt(4, patientID);
            preparedStatement.setInt(5, treatmentID);
            resultset = preparedStatement.executeQuery();
            
            resultset.next();
            return resultset.getInt("ServiceID");
        }catch (Exception e){
            System.out.println("bolq bn");
            return 0;
        }
    }
    public static int changingReport(int serviceid, String report){
        try{
            //database: Hospital, user: root, pwd: bayraaT1$DA
            ResultSet resultset = null;
            PreparedStatement preparedStatement = null;
            String sql = "update Service set TreatmentReport = ?, Status = 'Дүгнэсэн' where ServiceID = ?;";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, report);
            preparedStatement.setInt(2, serviceid);
            preparedStatement.executeUpdate();
            return 1;

        }catch (Exception e){
            System.out.println("bolq bn");
            return 0;
        }  
    }
}
