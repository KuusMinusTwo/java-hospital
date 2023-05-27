package model;

import java.sql.Connection;
import java.sql.DriverManager;
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
}
