package layout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class header extends JPanel implements ActionListener{
    public header(){
       
        setBackground(Color.LIGHT_GRAY);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(getWidth(), 100));

        // Create the icon label
       
        ImageIcon icon = new ImageIcon(getClass().getResource("..\\asset\\images\\hospital-icon.png")) ;
        Image originalImage=icon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        
        JLabel iconLabel = new JLabel(new ImageIcon(originalImage));

        iconLabel.setPreferredSize(new Dimension(200, 200));
        this.add(iconLabel, BorderLayout.WEST);

        // Create the title label
        JLabel titleLabel = new JLabel("Title");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titleLabel, BorderLayout.CENTER);

        // Create the button
        JButton button = new JButton();
        button.setName("profile");
        JLabel label = new JLabel("Profile");
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 50)); 
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        button.add(label);
        button.setFocusPainted(false);
        button.setOpaque(false);
        button.setContentAreaFilled(false);  // Set the button's content area to be non-filled
        button.setBorderPainted(false);
        this.add(button, BorderLayout.EAST);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the source button that was clicked
        JButton source = (JButton) e.getSource();

        // Determine which button was clicked
        if (source.getName().equals("profile")) {
            
            System.out.println("Profile  clicked");
        } 
    }
}
