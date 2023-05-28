package pages;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class userInfo extends JPanel{
    public userInfo(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JPanel aboutUs = new JPanel();
        aboutUs.setBackground(Color.green);
        aboutUs.setPreferredSize(new Dimension(getWidth(), 500));
        JPanel doctors = new JPanel();
        doctors.setBackground(Color.red);
        doctors.setPreferredSize(new Dimension(getWidth(), 500));
        JPanel newInformation = new JPanel();
        newInformation.setBackground(Color.orange);
        newInformation.setPreferredSize(new Dimension(getWidth(), 500));

        add(aboutUs, BorderLayout.NORTH);
        add(doctors, BorderLayout.NORTH);
        add(newInformation, BorderLayout.NORTH);
    }
}
