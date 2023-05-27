package pages.services;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class inspection extends JPanel implements ActionListener{
    public static JButton selectedButton;
    public static JButton homeBtn;
    public static JButton serviceBtn;
    public static JButton infoBtn;
    public inspection() {
        setLayout(new BorderLayout());

        
        setPreferredSize(new Dimension(300, HEIGHT));
        setBackground(Color.GRAY);
        setBorder(BorderFactory.createEmptyBorder(10, 0, 00, 0));
        
        JPanel menuJPanel = new JPanel();
        menuJPanel.setLayout(new GridLayout(3, 1));
        menuJPanel.setPreferredSize(new Dimension(200, getHeight()));
        menuJPanel.setBackground(Color.GRAY);
        
        homeBtn = createStyledButton("Нүүр хуудас");
        homeBtn.setName("homeBtn");
        serviceBtn = createStyledButton("Үйлчилгээ");
        serviceBtn.setName("serviceBtn");
        infoBtn = createStyledButton("Мэдээлэл");
        infoBtn.setName("infoBtn");

        menuJPanel.add(homeBtn);
        menuJPanel.add(serviceBtn);
        menuJPanel.add(infoBtn);

        
        add(menuJPanel, BorderLayout.EAST);
       

        selectedButton=homeBtn;
        homeBtn.setBackground(Color.blue);
        


        
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(Color.GRAY);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(getWidth(), 100));
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
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new inspection();
            }
        });
    }
}
