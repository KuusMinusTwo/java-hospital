package pages;


import javax.swing.*;

import layout.mainLayout;
import model.Database;
import model.Patient;
import model.Service;
import pages.services.inspection;
import widgets.HourTable;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class userInfo extends JPanel{
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField dobField;
    private JTextField ageField;
    private JTextField registerField;
    public void success(int id){
        success loginPanel = new success(Integer.toString(id) );
           
            loginPanel.setPreferredSize(new Dimension(600, 600));
            mainLayout.dialog.getContentPane().removeAll();
            mainLayout.dialog.getContentPane().add(loginPanel);
            mainLayout.dialog.pack();
            mainLayout.dialog.setLocationRelativeTo(null);
            mainLayout.dialog.setVisible(true);

    }

    public userInfo() {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        // First Name
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(firstNameLabel, gbc);

        gbc.gridx = 1;
        add(firstNameField, gbc);

        // Last Name
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lastNameLabel, gbc);

        gbc.gridx = 1;
        add(lastNameField, gbc);

        // Date of Birth
        JLabel dobLabel = new JLabel("Date of Birth (YYYY-MM-DD):");
        dobField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(dobLabel, gbc);

        gbc.gridx = 1;
        add(dobField, gbc);

        // Age
        JLabel ageLabel = new JLabel("Age:");
        ageField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(ageLabel, gbc);

        gbc.gridx = 1;
        add(ageField, gbc);

        // Register
        JLabel registerLabel = new JLabel("Register:");
        registerField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(registerLabel, gbc);

        gbc.gridx = 1;
        add(registerField, gbc);

        // Fail
        JLabel failLabel = new JLabel("Та бүгдийг нь бүрэн зөв бөглөнө үү!");

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(failLabel, gbc);
        failLabel.setVisible(false);
        failLabel.setForeground(Color.RED);

        // Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(120, 30));

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(submitButton, gbc);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(firstNameField.getText().equals("") ||
                    lastNameField.getText().equals("") ||
                    dobField.getText().equals("") ||
                    ageField.getText().equals("") ||
                    registerField.getText().equals("")){
                        failLabel.setVisible(true); // Make label visible when clicked
                }
                else {
                    failLabel.setVisible(false);

                    Patient user = new Patient();
                    user.firstname = firstNameField.getText();
                    user.lastname = lastNameField.getText();
                    user.dateofbirth  = dobField.getText();
                    user.age = Integer.parseInt(ageField.getText());
                    user.register = registerField.getText();
                    if(Database.hasDB){
                        user.Save();
                    }

                    String treatmentId =inspection.currentIndex;

                    Service service = new Service();
                    
                    
                    service.servicedate = HourTable.dropdownMenu.getSelectedItem().toString();
                    service.servicetime = Integer.parseInt(HourTable.selectedTime.getName());
                    service.doctorid = 0;
                    service.patientid = Database.patientNametoPatientID(user.firstname, user.lastname, user.dateofbirth, user.age, user.register);
                    service.treatmentid = Integer.parseInt(treatmentId);
                    service.treatmentreport = "";
                    service.category = Database.treatmentNameGetter(Integer.parseInt(treatmentId));
                    service.price = Database.treatmentPriceGetter(Integer.parseInt(treatmentId));
                    service.status = "Үүсгэсэн";
                    if(Database.hasDB){
                        int id=service.Save();
                        if(id!=-1){
                            success(id);
                        }
                    }
                    else{
                        success(-1);
                    }
                    
                }
                // Save the input here, e.g., in a variable or data structure
            }
        });
    }
}
