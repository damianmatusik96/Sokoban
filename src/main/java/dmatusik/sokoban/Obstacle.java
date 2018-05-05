package dmatusik.sokoban;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Obstacle implements Renderable {
    private Rectangle boxBounds;

    public Obstacle(int size, int u, int v) {
        int x = size * u;
        int y = size * v;
        boxBounds = new Rectangle(x, y, size, size);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(boxBounds.x, boxBounds.y, boxBounds.width, boxBounds.height);
        g.setColor(Color.WHITE);
        g.drawRect(boxBounds.x, boxBounds.y, boxBounds.width, boxBounds.height);
    }
}
