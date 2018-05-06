package dmatusik.sokoban;

import java.awt.Color;
import java.awt.Graphics;

public class Background implements Renderable {
    private Color color;
    private int viewWidth;
    private int viewHeight;

    public Background(Color color, int viewWidth, int viewHeight) {
        this.color = color;
        this.viewWidth = viewWidth;
        this.viewHeight = viewHeight;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect(0,0, viewWidth, viewHeight);

    }
}
