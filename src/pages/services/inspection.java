package pages.services;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class inspection extends JPanel implements ActionListener{
    public static JButton selectedButton;
    
    public inspection(Vector <String> data) {
        setLayout(new BorderLayout());

        
        setPreferredSize(new Dimension(300, HEIGHT));
        setBackground(Color.GRAY);
        setBorder(BorderFactory.createEmptyBorder(10, 0, 00, 0));
        
        JPanel menuJPanel = new JPanel();
        menuJPanel.setLayout(new GridLayout(3, 1));
        menuJPanel.setPreferredSize(new Dimension(200, getHeight()));
        menuJPanel.setBackground(Color.GRAY);

        JButton temp;
        for(int i=0;i<data.size();i++){
            temp=createStyledButton(data.get(i));;
            if(i==0){
                selectedButton=temp;
                temp.setBackground(Color.blue);
            }
            menuJPanel.add(temp);
        }
        

       
        
        add(menuJPanel, BorderLayout.EAST);
       

        

        JPanel mainBody= new JPanel();
        mainBody.setBackground(Color.white);

        JPanel leftSide = new JPanel();
        JPanel timeTable= new JPanel();
        timeTable.setPreferredSize(new Dimension(getWidth(), 300));
        // timeTable
        // add(mainBody);
        


        
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

    
}
