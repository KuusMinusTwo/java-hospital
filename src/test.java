import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {
    public test() {
        try {
            //setup driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex){
            System.out.println("mysql driver not found");
        }
        Connection conn = null;
        try{
            //database: Hospital, user: root, pwd: bayraaT1$DA
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hospital", "root", "bayraaT1$DA");
            //create query
            String query = "select * from Doctor";
            //open the statement
            Statement st = conn.createStatement(0, 0, 0);
            //handle the results
            ResultSet rs = st.executeQuery(query);

            //display the results
            while(rs.next()){
                int id = rs.getInt("EmployeeID");
                String firstname = rs.getString("FirstName");
                String lastname = rs.getString("LastName");
                String dateofbirth = rs.getString("DateOfBirth");
                int age = rs.getInt("Age");
                String jobtype = rs.getString("JobType");
                int room = rs.getInt("Room");

                System.out.format("%s, %s, %s, %s, %s, %s, %s \n", id, firstname, lastname, dateofbirth, age, jobtype, room);
            }
            st.close();

            ResultSet resultset = null;
            PreparedStatement preparedStatement = null;
            String sql = "SELECT * FROM Doctor WHERE EmployeeID = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, 2);
            resultset = preparedStatement.executeQuery();
            while(resultset.next()){
                System.out.println(resultset.getInt("EmployeeID") + " " + resultset.getString("FirstName") + " " + 
                resultset.getString("LastName") + " " +  resultset.getString("DateOfBirth") + " " + resultset.getInt("Age") +
                " " + resultset.getString("JobType") + " " + resultset.getInt("Room")
                );
            }

            String wtf = "INSERT INTO Doctor VALUES (NULL, ?, ?, ?, ?, ?, ?);";
            PreparedStatement pst = conn.prepareStatement(wtf);
            pst.setString(1, "Мөнх-Оргил");
            pst.setString(2, "Ганхуяг");
            pst.setString(3, "2003-01-01");
            pst.setInt(4, 19);
            pst.setString(5, "Нүдний эмч");
            pst.setInt(6, 203);
            pst.execute();

        } catch(SQLException ex){
            System.out.println("not connected");
        }

        

    }
}
