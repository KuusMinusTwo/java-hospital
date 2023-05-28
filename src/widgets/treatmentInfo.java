package widgets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import layout.mainLayout;
import model.TreatmentType;
import pages.userInfo;

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
    public treatmentInfo(TreatmentType treatment){
        
        setBackground(Color.white);

        JPanel rightSide = new JPanel();
        rightSide.setPreferredSize(new Dimension(300, this.getHeight()));
        JPanel timeTable= new JPanel();
        timeTable.setPreferredSize(new Dimension(300, 500));
        timeTable.setBackground(Color.CYAN);

        JButton order = new JButton("Захиалах");
        order.setPreferredSize(new Dimension(200, 100));
        order.addActionListener(OrderListener);
        rightSide.add(timeTable, BorderLayout.NORTH);
        rightSide.add(order, BorderLayout.SOUTH);


        add(rightSide, BorderLayout.EAST);
        JPanel leftSide = new JPanel();
        leftSide.setLayout(new BoxLayout(leftSide, BoxLayout.Y_AXIS));
        JPanel userPart=new JPanel();
        userPart.setPreferredSize(new Dimension(leftSide.getWidth(), 200));
        userPart.setBackground(Color.BLUE);
        leftSide.add(userPart, BorderLayout.NORTH);
        JPanel treatmentPart=new JPanel();
        treatmentPart.setPreferredSize(new Dimension(leftSide.getWidth(), 300));
        treatmentPart.setBackground(Color.yellow);
        leftSide.add(treatmentPart, BorderLayout.NORTH);
        JPanel servicePart=new JPanel();
        servicePart.setPreferredSize(new Dimension(leftSide.getWidth(), 400));
        servicePart.setBackground(Color.pink);
        leftSide.add(servicePart, BorderLayout.NORTH);
        add(leftSide);
    }
}
