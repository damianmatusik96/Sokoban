package dmatusik.sokoban;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Dimension;

public class MainFrame extends JFrame {

    public MainFrame(String title, int xmin, int ymin) {
        setTitle(title);
        setPreferredSize(new Dimension(xmin, ymin));
        setMinimumSize(new Dimension(xmin ,ymin));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
