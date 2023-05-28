package layout;

import java.awt.Dimension;
import java.awt.Toolkit;

public class constant {
    public static int width;
    public static int height;

    public static void run(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        width=screenSize.width;
        height=screenSize.height;
    }
}
