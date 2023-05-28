package widgets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import layout.constant;
import layout.mainLayout;
import model.TreatmentType;
import pages.userInfo;
import java.awt.Dimension;
import java.awt.Toolkit;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class treatmentInfo extends JPanel{
    ActionListener OrderListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            userInfo loginPanel = new userInfo();
           
            loginPanel.setPreferredSize(new Dimension(600, 600));
            mainLayout.dialog.getContentPane().removeAll();
            mainLayout.dialog.getContentPane().add(loginPanel);
            mainLayout.dialog.pack();
            mainLayout.dialog.setLocationRelativeTo(null);
            mainLayout.dialog.setVisible(true);
        }
    };
    public treatmentInfo(TreatmentType treatment){

        
        
        setBackground(Color.white);
        
        JPanel rightSide = new JPanel();
        
        JPanel timeTable= new JPanel();
        timeTable.setPreferredSize(new Dimension(300, 500));
        timeTable.setBackground(Color.CYAN);

        JButton order = new JButton("Захиалах");
        order.setPreferredSize(new Dimension(300, 100));
        order.addActionListener(OrderListener);
        rightSide.add(timeTable, BorderLayout.NORTH);
        rightSide.add(order, BorderLayout.SOUTH);
        


       
        JPanel leftSide = new JPanel();
        leftSide.setLayout(new BoxLayout(leftSide, BoxLayout.Y_AXIS));
        
        JPanel treatmentPart=new JPanel(new FlowLayout());
        treatmentPart.setPreferredSize(new Dimension((constant.width-1000), 500));
        treatmentPart.setBackground(Color.white);
        JLabel replay = new JLabel(treatment.treatmentname, SwingConstants.LEFT);
        replay.setFont(new Font("Arial", Font.BOLD, 25));
        replay.setPreferredSize(new Dimension(200, 100)); // Adjust the preferred size
        treatmentPart.add(replay); 
        
        JLabel price = new JLabel("Үнэ: "+treatment.price, SwingConstants.RIGHT);
        price.setFont(new Font("Arial", Font.BOLD, 25));
        price.setPreferredSize(new Dimension(200, 100)); // Adjust the preferred size
        treatmentPart.add(price);

        JLabel disc = new JLabel("<html>"+treatment.treatmentdesc+"</HTML>", SwingConstants.CENTER);
        disc.setFont(new Font("Arial", Font.BOLD, 19));
        disc.setPreferredSize(new Dimension(500, 400)); // Adjust the preferred size
        treatmentPart.add(disc);

























        leftSide.add(treatmentPart, BorderLayout.NORTH);
        doctorPart servicePart=new doctorPart();
        servicePart.setPreferredSize(new Dimension((constant.width-1000), 400));
        
        leftSide.add(servicePart, BorderLayout.NORTH);


        rightSide.setPreferredSize(new Dimension(300, 900));
        add(leftSide, BorderLayout.CENTER);
        add(rightSide, BorderLayout.EAST);
        
    }
    private void add(TreatmentType treatment) {
    }
}
