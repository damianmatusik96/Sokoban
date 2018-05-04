package dmatusik.sokoban;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class GamePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(0,0, getWidth(), getHeight());
        g.setColor(Color.CYAN);
        g.drawString("ELo",getWidth()/2, getHeight()/2);
    }
}
