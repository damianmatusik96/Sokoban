package dmatusik.sokoban;

import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitButton extends JMenuItem implements ActionListener {
    public ExitButton() {
        super("Zamknij");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //todo
    }
}
