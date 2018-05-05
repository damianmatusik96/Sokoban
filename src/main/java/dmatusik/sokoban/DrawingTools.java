package dmatusik.sokoban;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class DrawingTools {
    public static void renderPlayer(Graphics g, Rectangle box) {
        g.setColor(Color.WHITE);
        g.drawOval(box.x, box.y, box.width, box.height);
        g.setColor(Color.RED);
        g.fillOval(box.x, box.y, box.width, box.height);
    }

    public static void clearTile(Graphics g, Rectangle box) {
        g.setColor(Color.GRAY);
        g.fillRect(box.x, box.y, box.width, box.height);
    }

}

