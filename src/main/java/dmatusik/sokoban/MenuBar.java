package dmatusik.sokoban;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {
    public MenuBar(JMenuItem... menuButtons){
        JMenu menu = new JMenu("Start");
        for(JMenuItem menuButton : menuButtons) {
            menu.add(menuButton);
        }
        add(menu);
    }
}
