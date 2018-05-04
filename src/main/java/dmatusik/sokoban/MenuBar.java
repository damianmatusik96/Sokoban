package dmatusik.sokoban;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar {
    private JMenuItem newgame, highscore, help, exit;
    private JMenu menu;

    public MenuBar(JMenuItem... menuButton){
        menu = new JMenu("Start");
        newgame = new JMenuItem("Nowa gra");
        highscore = new JMenuItem("Lista najlepszych wynikow");
        help = new JMenuItem("Pomoc");
        exit = new JMenuItem("Zakoncz");
        menu.add(newgame);
        menu.add(highscore);
        menu.add(help);
        menu.add(exit);
        add(menu);
    }
}
