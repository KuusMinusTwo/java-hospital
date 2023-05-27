package layout;

import javax.swing.*;

import pages.homePage;
import pages.information;
import pages.serviceList;
import pages.services.inspection;

import java.awt.*;


public class mainLayout extends JFrame {
    public static sidebar sidebarPanel;
    public static JPanel contentPanel;
    public static CardLayout cardLayout;
    public static header header;
    public static JDialog dialog = new JDialog((Frame)null, "dialog", true);
            
    
    public mainLayout()  {
        try{
        setTitle("Hospital");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        
        sidebarPanel = new sidebar();
        
        contentPanel = new JPanel();
        cardLayout = new CardLayout();
        contentPanel.setLayout(cardLayout);
        
        homePage panel1 = new homePage();
        serviceList panel2 = new serviceList();
        
        // inspection panel2 = new inspection();
        // panel2.add(new JLabel("Content 2"));
        information panel3 = new information();
        
        
        contentPanel.add(scroll(panel1), "HomePage");
        contentPanel.add(scroll(panel2), "Services");
        
        contentPanel.add(scroll(panel3), "Information");
        
        header=new header();

        add(header, BorderLayout.NORTH);
        add(sidebarPanel, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
        
        pack();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }

    

    public JScrollPane scroll(JPanel a) {
        JScrollPane scrollPane = new JScrollPane(a);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(20);
        return scrollPane;
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new mainLayout();
            }
        });
    }
}