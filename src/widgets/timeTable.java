package widgets;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class timeTable extends JPanel{
    public timeTable(){
        add(new JLabel("<html><b><br><span style='font-size: 17pt;'><table style='border-collapse: collapse;'><tr><th>Өдөр</th><th>Цагийн хуваарь</th></tr></table></span></br></b></html>"));
        add(new JLabel("<html><br><span style='font-size: 15pt;'><table style='border-collapse: collapse;'><tr><td>Даваа</td><td>8:00 AM - 5:00 PM</td></tr>" +
                        "<tr><td>Мягмар</td><td>8:00 AM - 5:00 PM</td></tr>" +
                        "<tr><td>Лхагва</td><td>8:00 AM - 5:00 PM</td></tr>" +
                        "<tr><td>Пүрэв</td><td>8:00 AM - 5:00 PM</td></tr>" +
                        "<tr><td>Баасан</td><td>8:00 AM - 5:00 PM</td></tr>" +
                        "<tr><td>Бямба</td><td>10:00 AM - 4:00 PM</td></tr>" +
                        "<tr><td>Ням</td><td>10:00 AM - 4:00 PM</td></tr>" +
                        "</table></span></br></html>"));
    }
}
