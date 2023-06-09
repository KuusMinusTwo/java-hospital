package pages;

import layout.mainLayout;
import model.Database;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class nurse extends JPanel {
    public nurse(){
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(Color.WHITE);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel usernameLabel = new JLabel("Шинжилгээний дугаар:");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 30));
        JTextField usernameField = new JTextField(15);
        usernameField.setMaximumSize(usernameField.getPreferredSize());
        Font font = new Font(usernameField.getFont().getName(), Font.PLAIN, 30);
        usernameField.setFont(font);
        usernameField.setMaximumSize(usernameField.getPreferredSize());
        JLabel passwordLabel = new JLabel("Хариу:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 30));
        JTextField passwordField = new JTextField();
        passwordField.setFont(font);
        font = new Font(passwordField.getFont().getName(), Font.PLAIN, 30);
        passwordField.setMaximumSize(passwordField.getPreferredSize());

        

        JButton continueButton = new JButton("Үргэлжлүүлэх");
        continueButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector<String> data=new Vector<String>();
                int n=-1;
                if(Database.hasDB){
                    n=Database.changingReport(Integer.parseInt(usernameField.getText()),passwordField.getText());
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

               
                if(n==1) {successNurse loginPanel = new successNurse(Integer.toString(n));
            
                loginPanel.setPreferredSize(new Dimension(600, 270));
                mainLayout.dialog.getContentPane().removeAll();
                mainLayout.dialog.getContentPane().add(loginPanel);
                mainLayout.dialog.pack();
                mainLayout.dialog.setLocationRelativeTo(null);
                mainLayout.dialog.setVisible(true);
                }
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

        JPanel buttons=new JPanel(new GridLayout(1, 1));
        buttons.setBackground(Color.white);
        
        
        
        buttons.add(continueButton,BorderLayout.EAST);

        formPanel.add(username);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        formPanel.add(password);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        formPanel.add(buttons);
        // formPanel.setPreferredSize(new Dimension(getWidth(), 100));
        // formPanel.setBorder(new EmptyBorder(50, 10, 10, 50));

        JLabel title = new JLabel("Шинжилгээний хариу бөглөх", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        // JLabel sentence = new JLabel("<html><div style='text-align: center;'>Регистрийн дугаар болон шилжилгээний дугаарыг оруулна уу</div></html>", SwingConstants.CENTER);
        // sentence.setFont(new Font("Arial", Font.BOLD, 15));
        JPanel top=new JPanel(new GridLayout(2, 1));
        top.setBackground(Color.white);
        top.add(title);
        // top.add(sentence);

        add(top, BorderLayout.NORTH );
        add(formPanel, BorderLayout.CENTER);
    }
}
