package pages;

import model.Database;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import java.io.IOException;
import javax.imageio.ImageIO;

import layout.mainLayout;
import pages.services.inspection;
import java.util.Vector;

public class serviceList extends JPanel {
    private BufferedImage backgroundImage;
    ActionListener treatmentTypeListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // try{
            // JComboBox<String> source = (JComboBox<String>) e.getSource();
            // String selectedOption = (String) source.getSelectedItem();
            // System.out.println("Selected Option: " + selectedOption);
            // inspection inspection=new inspection();
            // mainLayout.contentPanel.add(inspection, "inspection");
            // mainLayout.cardLayout.show(mainLayout.contentPanel, "inspection");
            // }
            // catch(Exception ex){

            // }
            try{
            JButton source = (JButton) e.getSource();
            String selectedOption = (String) source.getText();
            Vector<String> data= new Vector<String>();
            
            if(Database.hasDB) {
                data = Database.treatmentSelect(source.getName());
            }
            else{
                data.add("shinjilgee 1");
                data.add("1");
                data.add("shinjilgee 2");
                data.add("2");
                data.add("shinjilgee 3");
                data.add("3");
            }

            inspection inspection=new inspection(data);
            mainLayout.contentPanel.add(inspection, "inspection");
            mainLayout.cardLayout.show(mainLayout.contentPanel, "inspection");
            }
            catch(Exception ex){

            }
        }
    };
    public serviceList(){

        try {
            backgroundImage = ImageIO.read(getClass().getResource("../asset/images/home-background.jpg")); 
        } catch (IOException e) {
            e.printStackTrace();
        }
        JPanel panel = new JPanel(new GridBagLayout()
        );
        panel.setBackground(new Color(0, 0, 0, 1));
        GridBagConstraints gbc = new GridBagConstraints();

        JButton jButton1= new JButton("Шинжилгээ");
        jButton1.setName("shinjilgee");
        jButton1.addActionListener(treatmentTypeListener);
        jButton1.setPreferredSize(new Dimension(400, 60));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.insets = new Insets(10, 10, 0, 10); 
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(jButton1, gbc);
        JButton jButton2= new JButton("Шинжилгээ");
        jButton2.setName("uzleg");
        jButton2.addActionListener(treatmentTypeListener);
        jButton2.setPreferredSize(new Dimension(400, 60));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.insets = new Insets(10, 10, 0, 10); 
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(jButton2, gbc);
        JButton jButton3= new JButton("Шинжилгээ");
        jButton3.addActionListener(treatmentTypeListener);
        jButton3.setName("emchilgee");
        jButton3.setPreferredSize(new Dimension(400, 60));
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.insets = new Insets(10, 10, 0, 10); 
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(jButton3, gbc);
        

        // JComboBox<String> dropdown1 = new JComboBox<>(new String[]{"Option 1", "Option 2", "Option 3"});
        // dropdown1.setRenderer(new CustomComboBoxRenderer());
        // dropdown1.addActionListener(dropDownListener);
        // dropdown1.setPreferredSize(new Dimension(400, 60));
        // gbc.gridx = 0;
        // gbc.gridy = 0;
        // gbc.weightx = 1;
        // gbc.insets = new Insets(10, 10, 0, 10); 
        // gbc.anchor = GridBagConstraints.WEST;
        // panel.add(dropdown1, gbc);

        // JComboBox<String> dropdown2 = new JComboBox<>(new String[]{"Option A", "Option B", "Option C"});
        // dropdown2.setRenderer(new CustomComboBoxRenderer());
        // dropdown2.addActionListener(dropDownListener);
        // dropdown2.setPreferredSize(new Dimension(400, 60));
        // gbc.gridx = 1;
        // gbc.gridy = 0;
        // gbc.weightx = 1;
        // gbc.insets = new Insets(10, 0, 0, 10); 
        // panel.add(dropdown2, gbc);

        // JComboBox<String> dropdown3 = new JComboBox<>(new String[]{"Choice X", "Choice Y", "Choice Z"});
        // dropdown3.setRenderer(new CustomComboBoxRenderer());
        // dropdown3.addActionListener(dropDownListener);
        // dropdown3.setPreferredSize(new Dimension(400, 60));
        // gbc.gridx = 2;
        // gbc.gridy = 0;
        // gbc.weightx = 1;
        // gbc.insets = new Insets(10, 0, 0, 10); 
        // panel.add(dropdown3, gbc);

        add(panel, BorderLayout.NORTH);

    }
    // static class CustomComboBoxRenderer extends DefaultListCellRenderer {
    //     private static final long serialVersionUID = 1L;

    //     public Component getListCellRendererComponent(JList<?> list, Object value, int index,
    //             boolean isSelected, boolean cellHasFocus) {
    //         JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index,
    //                 isSelected, cellHasFocus);
    //         label.setFont(label.getFont().deriveFont(Font.BOLD, 16)); 
    //         label.setBorder(new EmptyBorder(5, 5, 5, 5)); 
    //         return label;
    //     }
    // }
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
