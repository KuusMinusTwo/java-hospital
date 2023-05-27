import javax.swing.JFrame;

import layout.mainLayout;

public class App {
    static mainLayout myApp;
    public static void main(String[] args) throws Exception {
        try{
        myApp=new mainLayout();
        myApp.setExtendedState(JFrame.MAXIMIZED_BOTH);
        myApp.setVisible(true);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
