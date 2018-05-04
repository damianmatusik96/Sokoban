package dmatusik.sokoban;

import javax.swing.SwingUtilities;
import java.awt.BorderLayout;

public class Launch {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame("Sokoban", 500, 500);
                MenuBar bar = new MenuBar();
                GamePanel panel = new GamePanel();
                frame.setLayout(new BorderLayout());
                frame.setJMenuBar(bar);
                frame.add(panel, BorderLayout.CENTER);
                frame.setVisible(true);
            }
        });

    }
}
