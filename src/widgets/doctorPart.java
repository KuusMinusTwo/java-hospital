package widgets;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import layout.constant;
import model.Database;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;



public class doctorPart extends JPanel {

    public static JPanel myContentPanel;
    public static CardLayout cardLayout;

    public static JButton selectedDoc;

    ActionListener doctorListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String id=source.getName();
            if(selectedDoc.getName()!=id){
                
                selectedDoc.setBackground(Color.gray);
                selectedDoc=source;
                selectedDoc.setBackground(Color.blue);
                cardLayout.show(myContentPanel, "Card "+id);
            }
            
            
        }
    };
    public doctorPart(Vector<String> doctors){
        try{
            cardLayout= new CardLayout();
            JPanel contentPanel = new JPanel(cardLayout);
            myContentPanel=contentPanel;
            contentPanel.setPreferredSize(new Dimension((constant.width-1000)-200, 400));
    
            JPanel navPart= new JPanel();
            JPanel navPanel = new JPanel();
            navPanel.setLayout(new GridLayout(10, 1));
            navPanel.setBackground(Color.LIGHT_GRAY);
    
            for(int i=0;i<doctors.size();i++){
                JButton button1 = createStyledButton(doctors.get(i), doctors.get(i+1));
                if(i==0){
                    selectedDoc=button1;
                    selectedDoc.setBackground(Color.BLUE);
                }
                navPanel.add(button1, BorderLayout.NORTH);
                Vector<String> data=new Vector<String>();
                if(Database.hasDB){
                    data =Database.doctIDtoDoctorInfo(Integer.parseInt(doctors.get(i+1)) );
                }
                else{
                    
    
                }
                JPanel temp= new JPanel();
                temp.setLayout(new BoxLayout(temp, BoxLayout.Y_AXIS));

                JLabel templ=new JLabel(data.get(0));
                templ.setFont(new Font(templ.getFont().getName(), Font.PLAIN, 20));
                temp.add( templ, BorderLayout.NORTH);
                

                templ=new JLabel(data.get(1));
                templ.setFont(new Font(templ.getFont().getName(), Font.PLAIN, 20));
                temp.add( templ, BorderLayout.NORTH);

                templ=new JLabel(data.get(2));
                templ.setFont(new Font(templ.getFont().getName(), Font.PLAIN, 20));
                temp.add( templ, BorderLayout.NORTH);
               

                templ=new JLabel(data.get(3));
                templ.setFont(new Font(templ.getFont().getName(), Font.PLAIN, 20));
                temp.add( templ, BorderLayout.NORTH);
                
                
                templ=new JLabel(data.get(4));
                templ.setFont(new Font(templ.getFont().getName(), Font.PLAIN, 20));
                temp.add( templ, BorderLayout.NORTH);


                contentPanel.add(temp, "Card "+doctors.get(i+1));
                i++;
            }
            
    
           
            navPart.add(navPanel, BorderLayout.NORTH);
            navPart.setPreferredSize(new Dimension(200, 400));
    
            JScrollPane scrollPane = new JScrollPane(navPanel);
            
            
    
            JPanel containerPanel = new JPanel(new BorderLayout());
            containerPanel.add(scrollPane, BorderLayout.EAST);
            containerPanel.add(contentPanel, BorderLayout.CENTER);
    
            add(containerPanel);
        }
        catch(Exception e){
            int n;
        }
    }
    static class CustomComboBoxRenderer extends DefaultListCellRenderer {
        private static final long serialVersionUID = 1L;

        public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index,
                    isSelected, cellHasFocus);
            label.setFont(label.getFont().deriveFont(Font.BOLD, 16)); 
            label.setBorder(new EmptyBorder(5, 5, 5, 5)); 
            return label;
        }
    }
    private JButton createStyledButton(String text, String id) {
        JButton button = new JButton(text);
        button.setName(id);
        button.setBackground(Color.GRAY);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(200, 70));
        button.addActionListener(doctorListener);
        return button;
    }
    
        
}
