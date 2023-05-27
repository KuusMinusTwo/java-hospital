import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import layout.mainLayout;
import model.Database;
import model.Patient;

public class App {
    static mainLayout myApp;
    public static void main(String[] args) throws Exception {
        try{
        Database.init();
        Patient m = new Patient();
        m.firstname = "Батаа";
        m.lastname = "Ганаа";
        m.age = 19;
        m.dateofbirth = "1999-09-08";
        m.SavePatient();

        myApp=new mainLayout();
        SwingUtilities.invokeLater(() -> {
            myApp.setExtendedState(JFrame.MAXIMIZED_BOTH);
            myApp.setVisible(true);
        });
        
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
