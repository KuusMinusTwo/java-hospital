package pages.services;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import layout.mainLayout;
import model.TreatmentType;
import pages.userInfo;
import widgets.treatmentInfo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;



public class inspection extends JPanel implements ActionListener{
    public static JButton selectedButton;

    public static String status;

    
    
    public inspection(Vector <String> data){
        setLayout(new BorderLayout());
        // CompletableFuture<Void> asyncTask = CompletableFuture.runAsync(() -> {
        //     // Perform some asynchronous task
        //     System.out.println("Asynchronous task started...");
        //     try {
        //         TimeUnit.SECONDS.sleep(2); 
        //         status="true";
        //     } catch (InterruptedException e) {
                
        //         e.printStackTrace();
        //     }
        //     System.out.println("Asynchronous task completed.");
            
        // });
        // try{
        //     asyncTask.get();
        // }
        // catch(Exception e){

        // }
        
        
        setPreferredSize(new Dimension(300, HEIGHT));
        setBackground(Color.GRAY);
        setBorder(BorderFactory.createEmptyBorder(10, 0, 00, 0));
        JPanel rightside = new JPanel();
        JPanel menuJPanel = new JPanel();
        menuJPanel.setLayout(new GridLayout(data.size(), 1));
        menuJPanel.setPreferredSize(new Dimension(200, 100*data.size()));
        rightside.setPreferredSize(new Dimension(200, getHeight()));
        menuJPanel.setBackground(Color.GRAY);

        JButton temp;
        for(int i=0;i<data.size();i++){
            temp=createStyledButton(data.get(i));
            
            temp.setName("button"+i);
            if(i==0){
                selectedButton=temp;
                temp.setBackground(Color.blue);
            }
            menuJPanel.add(temp);
        }
        rightside.add(menuJPanel, BorderLayout.NORTH);

       
        
        add(rightside, BorderLayout.EAST);
       
        status="false";

        TreatmentType treatment=new TreatmentType();

        treatmentInfo mainBody=new treatmentInfo();
        

        add(mainBody);
        


        
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(Color.GRAY);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.addActionListener(this);
        
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
