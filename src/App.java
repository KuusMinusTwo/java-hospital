import java.util.Vector;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.xml.crypto.Data;

import layout.mainLayout;
import model.Database;
import model.Patient;

public class App {
    static mainLayout myApp;
    public static void main(String[] args) throws Exception {
        try{
            if(Database.hasDB){
                Database.init();
                Database.trtIDtoDoctorInfo(4);
            }
        
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
