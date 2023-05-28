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
    public static String currentIndex;
    public static String status;

    public static TreatmentType treatment;
    public static Vector<String> doctors;
    public static JPanel mainBody;
    public static Vector <String> maindata;
    public static CardLayout cardLayout;
    public  void asyncTask(){
        try {
            doctors = new Vector<String>();
            if(Database.hasDB){
                doctors = Database.trtIDtoDoctorInfo(Integer.parseInt(currentIndex));
            }
            else{
                doctors.add("khuslen");
                doctors.add("1");
                doctors.add("adiya");
                doctors.add("2");
            }
            if(Database.hasDB){
                
                treatment = Database.treatmentInfoForId(Integer.parseInt(currentIndex));
                
            }
            else{
                treatment.category="";
                treatment.price=1000;
                treatment.jobtype="";
                treatment.treatmentdesc="hahah";
                treatment.treatmentname=maindata.get(1);
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }
    
    public inspection(Vector <String> data){
        maindata=data;
        setLayout(new BorderLayout());
        
        
       
        
        
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
        currentIndex=maindata.get(1);
        try{
            asyncTask();
        }
        catch(Exception e){

        }
        
        cardLayout=new CardLayout();
        mainBody= new JPanel();
        mainBody.setLayout(cardLayout);
        
        JPanel panel1=new treatmentInfo(treatment, doctors);
        
        mainBody.add(panel1, "panel1");
        cardLayout.show(mainBody, "panel1");
        

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
        doctors = new Vector<String>();
        currentIndex=maindata.get(Integer.parseInt(id)*2+1);
        if(Database.hasDB){
            doctors = Database.trtIDtoDoctorInfo(Integer.parseInt(maindata.get(Integer.parseInt(id)*2+1)));
        }
        else{
            doctors.add("khuslen");
            doctors.add("1");
            doctors.add("adiya");
            doctors.add("2");
        }
        if(Database.hasDB){
            treatment = Database.treatmentInfoForId(Integer.parseInt(currentIndex));
        }
        else{
            treatment.category="";
            treatment.price=1000;
            treatment.jobtype="";
            treatment.treatmentdesc="hahah";
            treatment.treatmentname=maindata.get(Integer.parseInt(id)*2+1);
        }
        JPanel temp=new treatmentInfo(treatment, doctors);
        
        mainBody.add(temp, "panel"+(Integer.parseInt(id)*2+1));
        cardLayout.show(mainBody, "panel"+(Integer.parseInt(id)*2+1));

        String name=source.getName();
        if(selectedButton.getName()!=name){
            selectedButton.setBackground(Color.GRAY);
            selectedButton=source;
            source.setBackground(Color.blue);
        }
    }

    
    
}
