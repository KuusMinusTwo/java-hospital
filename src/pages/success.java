package pages;

import javax.swing.*;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class success extends JPanel {
    public success(String id){
        JLabel text1=new JLabel(id , SwingConstants.CENTER);
        text1.setFont(new Font("Arial", Font.BOLD, 60));
        
        JLabel text=new JLabel("Таны шинжилгээний дугаар" , SwingConstants.CENTER);
        text.setFont(new Font("Arial", Font.PLAIN, 20));

        JLabel text2=new JLabel("Та энэ дугаарын дагуу өөрийн шинжилгээний хариуг харна уу" , SwingConstants.CENTER);
        text2.setFont(new Font("Arial", Font.PLAIN, 20));

        add(text, BorderLayout.NORTH);
        add(text1, BorderLayout.CENTER);

    }
    
    
}
