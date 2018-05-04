package dmatusik.sokoban;

import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HighscoreButton extends JMenuItem implements ActionListener {
    public HighscoreButton() {
        super("Lista najlepszych wynikow");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //todo
    }
}
