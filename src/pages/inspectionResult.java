package pages;

//import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class inspectionResult extends JPanel{

    public inspectionResult(Vector<String> data){
        setBackground(Color.orange);
        add(new JLabel(data.get(0)));
    }
    
}
