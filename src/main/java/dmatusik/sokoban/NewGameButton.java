package dmatusik.sokoban;

import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameButton extends JMenuItem implements ActionListener {
    public NewGameButton() {
        super("Nowa gra");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //todo
    }
}
