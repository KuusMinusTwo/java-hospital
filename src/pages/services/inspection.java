package pages.services;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import layout.mainLayout;
import model.Database;
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
    public static TreatmentType treatment;
    public static treatmentInfo mainBody;
    public static Vector <String> maindata;
    
    public inspection(Vector <String> data){
        maindata=data;
        setLayout(new BorderLayout());
        CompletableFuture<Void> asyncTask = CompletableFuture.runAsync(() -> {
            // Perform some asynchronous task
            System.out.println("Asynchronous task started...");
            try {
                TimeUnit.SECONDS.sleep(2); 
                if(Database.hasDB){

                }
                else{
                    treatment.category="";
                    treatment.price=1000;
                    treatment.jobtype="";
                    treatment.treatmentdesc="hahah";
                    treatment.treatmentname=data.get(1);
                }
            } catch (Exception e) {
                
                e.printStackTrace();
            }
            System.out.println("Asynchronous task completed.");
            
        });
       
        
        
        setPreferredSize(new Dimension(300, HEIGHT));
        setBackground(Color.GRAY);
        setBorder(BorderFactory.createEmptyBorder(10, 0, 00, 0));
        JPanel rightside = new JPanel();
        JPanel menuJPanel = new JPanel();
        menuJPanel.setLayout(new GridLayout(data.size()/2, 1));
        menuJPanel.setPreferredSize(new Dimension(200, 100*data.size()));
        rightside.setPreferredSize(new Dimension(200, getHeight()));
        menuJPanel.setBackground(Color.GRAY);

        JButton temp;
        for(int i=0;i<data.size();i++){
            temp=createStyledButton(data.get(i));
            
            temp.setName(Integer.toString(i/2));
            i++;
            if(i==1){
                selectedButton=temp;
                temp.setBackground(Color.blue);
            }
            menuJPanel.add(temp);
        }
        rightside.add(menuJPanel, BorderLayout.NORTH);

       
        
        add(rightside, BorderLayout.EAST);
       
        status="false";
        treatment=new TreatmentType();
        try{
            asyncTask.get();
        }
        catch(Exception e){

        }
        

        mainBody=new treatmentInfo(treatment);
        

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
        JButton source = (JButton) e.getSource();
        String id =source.getName();
        Vector<String> doctorNameID = new Vector<String>();
        if(Database.hasDB){
            doctorNameID = Database.trtIDtoDoctorInfo(Integer.parseInt(maindata.get(Integer.parseInt(id)*2+1)));
        }
        else{
            doctorNameID.add("khuslen");
            doctorNameID.add("1");
        }
        if(Database.hasDB){

        }
        else{
            treatment.category="";
            treatment.price=1000;
            treatment.jobtype="";
            treatment.treatmentdesc="hahah";
            treatment.treatmentname=maindata.get(Integer.parseInt(id));
        }
        mainBody=new treatmentInfo(treatment);

        String name=source.getName();
        if(selectedButton.getName()!=name){
            selectedButton.setBackground(Color.GRAY);
            selectedButton=source;
            source.setBackground(Color.blue);
        }
    }

    
    
}
