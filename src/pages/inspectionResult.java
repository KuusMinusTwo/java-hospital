package pages;

//import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class inspectionResult extends JPanel{

    public inspectionResult(Vector<String> data){
        JPanel panel = new JPanel();
        Color color = new Color(88, 214, 141); // Color code for green
        setBackground(color);
        
        
        
        // add(new JLabel(data.get(0)));
        JPanel left = new JPanel();
        Color leftColor = new Color(88, 214, 141); // Color code for green
        left.setBackground(leftColor);
        left.setPreferredSize(new Dimension(550, 100));
        
        left.setLayout(new GridLayout(3, 2));

        JLabel fName = new JLabel("Овог: Ганхуяг");
        fName.setFont(new Font("Arial", Font.BOLD, 23));
        add(fName);
        JLabel lName = new JLabel("Нэр: Мөнх-Оргил");
        lName.setFont(new Font("Arial", Font.BOLD, 23));
        add(lName);
        
        JLabel register = new JLabel("Регистер: УЖ03261631");
        register.setFont(new Font("Arial", Font.BOLD, 23));
        add(register);
        
        JLabel age = new JLabel("Нас: 20");
        age.setFont(new Font("Arial", Font.BOLD, 23));
        add(age);
        JLabel testGroup = new JLabel("Шинжилгээ: Цусны шинжилгээ");
        testGroup.setFont(new Font("Arial", Font.BOLD, 15));
        add(testGroup);
        JLabel testDate = new JLabel("Огноо: 2023.05.25");
        testDate.setFont(new Font("Arial", Font.BOLD, 15));
        add(testDate);

        lName.setHorizontalAlignment(SwingConstants.RIGHT);
        age.setHorizontalAlignment(SwingConstants.RIGHT);
        testDate.setHorizontalAlignment(SwingConstants.RIGHT);

        left.add(fName);
        left.add(lName);
        left.add(register);
        left.add(age);
        left.add(testGroup);
        left.add(testDate);
        add(left);

        JPanel replay = new JPanel();
        Color replayColor = new Color(88, 214, 141); // Color code for green
        replay.setBackground(replayColor);
        replay.setPreferredSize(new Dimension(550, 40));
        JLabel testReplay = new JLabel("Шинжилгээний хариу:");
        testReplay.setFont(new Font("Arial", Font.CENTER_BASELINE, 25));
        add(testReplay);
        replay.add(testReplay);
        add(replay);

        JPanel comment = new JPanel();
        Color commentColor = new Color(88, 214, 141); // Color code for green
        comment.setBackground(commentColor);
        comment.setPreferredSize(new Dimension(550, 100));
        JLabel testComment = new JLabel("<html>WBC- Цагаан эс,RBC- Улаан эс,PLT- Ялтас эc,HGB- Гемоглобин,<br>HCT- Гематокрит,MCV- Улаан эсийн дундаж эзэлхүүн (80-100fl) <br>нормоцит, макроцит, микроцит</html>");
        testComment.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 17));
        add(testComment);
        comment.add(testComment);
        add(comment);
    }
}
