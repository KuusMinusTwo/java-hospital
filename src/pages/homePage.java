package pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import layout.sidebar;

public class homePage extends JPanel{
    private JLabel label;
    private JButton testResult;
    private JButton timeOrder;
    private BufferedImage backgroundImage;
    ActionListener testResultListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    };
    ActionListener timeOrderListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            sidebar.serviceBtn.doClick();
        }
    };
    public homePage(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JPanel top = new JPanel(new BorderLayout());
        top.setOpaque(false);
        
        top.setPreferredSize(new Dimension(getWidth(), 950));
        //Border border = BorderFactory.createLineBorder(Color.RED, 2);  // Create a red line border
        
        
        try {
            backgroundImage = ImageIO.read(new File("C:/School/java/hospital/java-hospital/src/asset/images/home-background.jpg")); 
        } catch (IOException e) {
            e.printStackTrace();
        }

       
        label = new JLabel("Label");
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0)); 
        label.setFont(new Font("Arial", Font.BOLD, 60));
        label.setForeground(Color.white);

        JPanel buttons = new JPanel();
        buttons.setLayout(new BorderLayout());

        
        testResult = new JButton();
        JLabel text=new JLabel("<html><div style='text-align: center;'>Шинжилгээний хариу харах</div></html>" );
        
        text.setFont(new Font("Arial", Font.BOLD, 27));
        testResult.setPreferredSize(new Dimension(300, 200));
        testResult.add(text);
        testResult.addActionListener(testResultListener);

        

        timeOrder = new JButton();
        JLabel text1=new JLabel("Цаг авах" , SwingConstants.CENTER);
        text1.setFont(new Font("Arial", Font.BOLD, 27));
        timeOrder.setLayout(new GridLayout());
        timeOrder.add(text1);
        timeOrder.setPreferredSize(new Dimension(300, 200));
        timeOrder.addActionListener(timeOrderListener);

        buttons.add(testResult, BorderLayout.WEST);
        buttons.add(timeOrder, BorderLayout.EAST);
       
        top.setLayout(new GridBagLayout());
        GridBagConstraints loc = new GridBagConstraints();
        loc.anchor = GridBagConstraints.WEST;
        loc.insets = new Insets(0, 0, 10, 10); 

        
        loc.gridx = 0;
        loc.gridy = 0;
        loc.weightx = 1.0;
        loc.weighty = 1.0;
        loc.insets = new Insets(10, 100, 0, 0);
        top.add(label, loc);

        
        loc.gridx = 0;
        loc.gridy = 1;
        top.add(buttons, loc);
        add(top);
        JPanel aboutUs = new JPanel();
        aboutUs.setBackground(Color.green);
        aboutUs.setPreferredSize(new Dimension(getWidth(), 500));
        add(aboutUs);
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            int width = getWidth();
            int height = (int) ((double) width / backgroundImage.getWidth() * backgroundImage.getHeight());
            g.drawImage(backgroundImage, 0, 0, width, height, this);
            
        }
    }
    
    
}
