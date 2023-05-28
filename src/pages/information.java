package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class information extends JPanel{
    private JLabel label;
    private JButton testResult;
    private JButton timeOrder;
    private BufferedImage backgroundImage;
    public information(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        ImageIcon icon = new ImageIcon(getClass().getResource("..\\asset\\images\\Fam1.jpg")) ;
        Image originalImage=icon.getImage().getScaledInstance(1250, 900, Image.SCALE_SMOOTH);
        
        JLabel iconLabel = new JLabel(new ImageIcon(originalImage));

        iconLabel.setPreferredSize(new Dimension(1250, 900));
        this.add(iconLabel, BorderLayout.CENTER);
        try {
            backgroundImage = ImageIO.read(getClass().getResource("../asset/images/Map.png")); 
        } catch (IOException e) {
            e.printStackTrace();
        }
        
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

