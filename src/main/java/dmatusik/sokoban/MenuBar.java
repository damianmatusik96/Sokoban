package dmatusik.sokoban;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar {
    private JMenuItem newgame, highscore, help, exit;

    public MenuBar(){
        newgame = new JMenuItem("Nowa gra");
        highscore = new JMenuItem("Lista najlepszych wynikow");
        help = new JMenuItem("Pomoc");
        exit = new JMenuItem("Zakoncz");
        add(newgame);
        add(highscore);
        add(help);
        add(exit);
    }
}
