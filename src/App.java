import javax.swing.JFrame;

import layout.mainLayout;
import model.Database;

public class App {
    static mainLayout myApp;
    public static void main(String[] args) throws Exception {
        try{
        new test();
        Database.init();
        myApp=new mainLayout();
        myApp.setExtendedState(JFrame.MAXIMIZED_BOTH);
        myApp.setVisible(true);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
