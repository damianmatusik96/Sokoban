package dmatusik.sokoban;

import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;

public class Launch {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame("Sokoban", 400, 400);
                GamePanel panel = new GamePanel(300, 300);
                MenuBar bar = createMenuBar(panel);
                frame.setLayout(new BorderLayout());
                frame.setJMenuBar(bar);
                frame.add(panel, BorderLayout.CENTER);
                panel.setFocusable(true);
                frame.setVisible(true);
            }
        });
    }
    private static MenuBar createMenuBar(GamePanel gamePanel){
        JMenuItem newgame = new NewGameButton(30, gamePanel);
        JMenuItem highscore = new HighscoreButton();
        JMenuItem help = new HelpButton();
        JMenuItem exit = new ExitButton();
        return new MenuBar(newgame, highscore, help, exit);
    }
}
