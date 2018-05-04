package dmatusik.sokoban;

import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpButton extends JMenuItem implements ActionListener {
    public HelpButton() {
        super("Pomoc");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //todo
    }
}
