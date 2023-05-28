package widgets;

import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import layout.constant;
import layout.header;
import layout.mainLayout;
import model.TreatmentType;
import pages.homePage;
import pages.userInfo;
import java.awt.Dimension;
import java.awt.Toolkit;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JPanel;

public class HourTable extends JPanel {
    public HourTable(){
        setLayout(new GridBagLayout());

        // Create the dropdown menu
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        JComboBox<String> dropdownMenu = new JComboBox<>(daysOfWeek);

        // Set preferred size for the dropdown menu
        Dimension dropdownSize = new Dimension(200, 30);
        dropdownMenu.setPreferredSize(dropdownSize);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Add the dropdown menu
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(dropdownMenu, gbc);

        // Create and add buttons to the panel
        for (int i = 1; i <= 8; i++) {
            JButton button = new JButton("Button " + i);
            gbc.gridx = (i - 1) % 2;
            gbc.gridy = (i - 1) / 2 + 1;
            gbc.anchor = GridBagConstraints.CENTER;
            add(button, gbc);
        }
    
    }
    
}
