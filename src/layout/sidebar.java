package layout;
import javax.swing.*;

import widgets.timeTable;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class sidebar extends JPanel implements ActionListener{
    public static JButton selectedButton;
    public static JButton homeBtn;
    public static JButton serviceBtn;
    public static JButton infoBtn;
    public static JButton nurseBtn;
    public sidebar() {
        
        
        setLayout(new BorderLayout());

        
        setPreferredSize(new Dimension(300, HEIGHT));
        setBackground(Color.GRAY);
        setBorder(BorderFactory.createEmptyBorder(10, 0, 00, 0));
        
        JPanel navigation = new JPanel();
        navigation.setLayout(new GridLayout(4, 1));
        
        homeBtn = createStyledButton("Нүүр хуудас");
        homeBtn.setName("homeBtn");
        serviceBtn = createStyledButton("Үйлчилгээ");
        serviceBtn.setName("serviceBtn");
        infoBtn = createStyledButton("Мэдээлэл");
        infoBtn.setName("infoBtn");
        nurseBtn = createStyledButton("Хариу оруулах");
        nurseBtn.setName("nurseBtn");

        navigation.add(homeBtn);
        navigation.add(serviceBtn);
        navigation.add(infoBtn);
        navigation.add(nurseBtn);

        timeTable timeTable = new timeTable();
        // timeTable.add(new JLabel("timeTable"));
        timeTable.setPreferredSize(new Dimension(getWidth(), 350));


        add(navigation, BorderLayout.NORTH);
        add(timeTable, BorderLayout.SOUTH);

        selectedButton=homeBtn;
        homeBtn.setBackground(Color.blue);
        


        
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(Color.GRAY);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(getWidth(), 60));
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the source button that was clicked
        JButton source = (JButton) e.getSource();
        String name=source.getName();
        if(selectedButton.getName()!=name){
            selectedButton.setBackground(Color.GRAY);
            selectedButton=source;
            source.setBackground(Color.blue);
        }
        switch(name){
            case "homeBtn":
                mainLayout.cardLayout.show(mainLayout.contentPanel, "HomePage");
            break;
            case "serviceBtn":
                mainLayout.cardLayout.show(mainLayout.contentPanel, "Services");
            break;
            case "infoBtn":
                mainLayout.cardLayout.show(mainLayout.contentPanel, "Information");
            break;
            case "nurseBtn":
                mainLayout.cardLayout.show(mainLayout.contentPanel, "Nurse");
            break;
        }
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new sidebar();
            }
        });
    }
}
