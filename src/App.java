import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import layout.mainLayout;

public class App {
    static mainLayout myApp;
    public static void main(String[] args) throws Exception {
        try{
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
