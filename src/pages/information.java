package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import layout.constant;



public class information extends JPanel{
    private JLabel label;
    private JButton testResult;
    private JButton timeOrder;
    
    public information(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        ImageIcon icon = new ImageIcon(getClass().getResource("..\\asset\\images\\Fam1.jpg")) ;
        Image originalImage=icon.getImage().getScaledInstance(1250,800, Image.SCALE_SMOOTH);
        
        JLabel iconLabel = new JLabel(new ImageIcon(originalImage));

        iconLabel.setPreferredSize(new Dimension(1250, 800));
        
       
        JPanel aboutUs = new JPanel();
        aboutUs.setLayout(new BoxLayout(aboutUs, BoxLayout.Y_AXIS));
        aboutUs.setBackground(Color.green);
        aboutUs.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel("About Us");
        titleLabel.setFont(titleLabel.getFont().deriveFont(24f));
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel descriptionPanel = new JPanel();
        descriptionPanel.setBackground(Color.white);
        descriptionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        descriptionPanel.setLayout(new GridLayout(3, 2)); // Reduced size by 2 times

        JLabel label1 = new JLabel("Email:");
        JLabel label3 = new JLabel("Address:");
        JLabel label5 = new JLabel("Number:");

        JLabel label2 = new JLabel("se21d81@nmit.edu.mn");
        JLabel label4 = new JLabel("Bayanzureh duureg 13-r horoo Natuurii zam");
        JLabel label6 = new JLabel("99119999");

        label2.setHorizontalAlignment(SwingConstants.RIGHT);
        label4.setHorizontalAlignment(SwingConstants.RIGHT);
        label6.setHorizontalAlignment(SwingConstants.RIGHT);

        descriptionPanel.add(label1);
        descriptionPanel.add(label2);
        descriptionPanel.add(label3);
        descriptionPanel.add(label4);
        descriptionPanel.add(label5);
        descriptionPanel.add(label6);

        aboutUs.add(titleLabel);
        aboutUs.add(descriptionPanel);
        aboutUs.setPreferredSize(new Dimension(-50, 100));
        add(aboutUs, BorderLayout.NORTH);
        add(iconLabel, BorderLayout.NORTH);
        
    }
    

}

