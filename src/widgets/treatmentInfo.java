package widgets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
            mainLayout.dialog.getContentPane().add(loginPanel);
            mainLayout.dialog.pack();
            mainLayout.dialog.setLocationRelativeTo(null);
            mainLayout.dialog.setVisible(true);
           
        }
    };
    public treatmentInfo(TreatmentType treatmentType){

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int width=screenSize.width;
        int height=screenSize.height;
        
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
        JPanel userPart=new JPanel();
        userPart.setPreferredSize(new Dimension((width-1000), 200));
        userPart.setBackground(Color.BLUE);
        leftSide.add(userPart, BorderLayout.NORTH);
        JPanel treatmentPart=new JPanel();
        treatmentPart.setPreferredSize(new Dimension((width-1000), 300));
        treatmentPart.setBackground(Color.yellow);
        leftSide.add(treatmentPart, BorderLayout.NORTH);
        JPanel servicePart=new JPanel();
        servicePart.setPreferredSize(new Dimension((width-1000), 400));
        servicePart.setBackground(Color.pink);
        leftSide.add(servicePart, BorderLayout.NORTH);


        rightSide.setPreferredSize(new Dimension(300, 900));
        add(leftSide, BorderLayout.CENTER);
        add(rightSide, BorderLayout.EAST);
        
    }
}
