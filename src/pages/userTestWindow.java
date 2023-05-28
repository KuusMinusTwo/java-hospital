package pages;
import javax.swing.*;

import layout.mainLayout;
import model.Database;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class userTestWindow extends JPanel{
    public userTestWindow() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(Color.WHITE);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel usernameLabel = new JLabel("Регистер:");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 30));
        JTextField usernameField = new JTextField(15);
        usernameField.setMaximumSize(usernameField.getPreferredSize());
        Font font = new Font(usernameField.getFont().getName(), Font.PLAIN, 30);
        usernameField.setFont(font);
        usernameField.setMaximumSize(usernameField.getPreferredSize());
        JLabel passwordLabel = new JLabel("Шинжилгээний дугаар:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 20));
        JTextField passwordField = new JTextField();
        passwordField.setFont(font);
        font = new Font(passwordField.getFont().getName(), Font.PLAIN, 30);
        passwordField.setMaximumSize(passwordField.getPreferredSize());

        JButton backButton = new JButton("Буцах");
        // backButton.setPreferredSize(new Dimension(300, 50));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainLayout.dialog.setVisible(false);
            }
        });

        JButton continueButton = new JButton("Үргэлжлүүлэх");
        // backButton.setPreferredSize(new Dimension());
        continueButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector<String> data=new Vector<String>();
                if(Database.hasDB){
                    // data = Database.inspectionResult(1, "УО02280410");
                    data = Database.inspectionResult(Integer.parseInt(passwordField.getText()), usernameField.getText());
                }
                else{
                    data.add("УО02280410");
                    data.add("Баяржавхлан");
                    data.add("Зүрхний үзлэг");
                    data.add("Зүрхний үзлэгийг төхөөрөмжөөр нарийн үзэх");
                    data.add("200000");
                    data.add("Эмчилсэн");
                    data.add("2013-03-07");
                    data.add("Зүрх нь муудсан");
                }

                mainLayout.dialog.setVisible(false);
                inspectionResult loginPanel = new inspectionResult(data);
            
                loginPanel.setPreferredSize(new Dimension(600, 270));
                mainLayout.dialog.getContentPane().removeAll();
                mainLayout.dialog.getContentPane().add(loginPanel);
                mainLayout.dialog.pack();
                mainLayout.dialog.setLocationRelativeTo(null);
                mainLayout.dialog.setVisible(true);
            }
        });

        JPanel username=new JPanel(new GridLayout(1, 2));
        username.setBackground(Color.white);
        username.add(usernameLabel);
        username.add(usernameField);

        JPanel password=new JPanel(new GridLayout(1, 2));
        password.setBackground(Color.white);
        password.add(passwordLabel);
        password.add(passwordField);

        JPanel buttons=new JPanel(new GridLayout(1, 2));
        buttons.setBackground(Color.white);
        
        buttons.add(backButton, BorderLayout.WEST);
        
        buttons.add(continueButton,BorderLayout.EAST);

        formPanel.add(username);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        formPanel.add(password);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        formPanel.add(buttons);
        // formPanel.setPreferredSize(new Dimension(getWidth(), 100));
        // formPanel.setBorder(new EmptyBorder(50, 10, 10, 50));

        JLabel title = new JLabel("Шинжилгээний хариу харах", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        JLabel sentence = new JLabel("<html><div style='text-align: center;'>Регистрийн дугаар болон шилжилгээний дугаарыг оруулна уу</div></html>", SwingConstants.CENTER);
        sentence.setFont(new Font("Arial", Font.BOLD, 15));
        JPanel top=new JPanel(new GridLayout(2, 1));
        top.setBackground(Color.white);
        top.add(title);
        top.add(sentence);

        add(top, BorderLayout.NORTH );
        add(formPanel, BorderLayout.CENTER);

        
    }

    
}
