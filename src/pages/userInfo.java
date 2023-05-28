package pages;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;

public class userInfo extends JPanel{
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField dobField;
    private JTextField ageField;
    private JTextField registerField;

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

        // Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(120, 30));

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(submitButton, gbc);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateAge();
            }
        });
    }

    private void calculateAge() {
        String dob = dobField.getText();
        LocalDate birthDate = LocalDate.parse(dob);
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(birthDate, currentDate).getYears();
        ageField.setText(Integer.toString(age));
    }
}
