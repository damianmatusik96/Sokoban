package dmatusik.sokoban;

import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;

public class Launch {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame("Sokoban", 500, 500);
                MenuBar bar = createMenuBar();
                GamePanel panel = new GamePanel(300, 300);
                frame.setLayout(new BorderLayout());
                frame.setJMenuBar(bar);
                frame.add(panel, BorderLayout.CENTER);
                frame.setVisible(true);
            }
        });

    }
    private static MenuBar createMenuBar(){
        JMenuItem newgame = new NewGameButton();
        JMenuItem highscore = new HighscoreButton();
        JMenuItem help = new HelpButton();
        JMenuItem exit = new ExitButton();
        return new MenuBar(newgame, highscore, help, exit);
    }
}
