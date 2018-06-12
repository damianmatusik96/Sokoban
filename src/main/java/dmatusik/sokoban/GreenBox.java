package dmatusik.sokoban;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import static java.awt.event.KeyEvent.VK_DOWN;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_UP;

public class GreenBox implements Renderable {
    private Rectangle boxBounds;
    private GamePanel gamePanel;

    public GreenBox(GamePanel gamePanel, int size, int u, int v) {
        int x = size * u;
        int y = size * v;
        boxBounds = new Rectangle(x, y, size, size);
        this.gamePanel = gamePanel;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(boxBounds.x, boxBounds.y, boxBounds.width, boxBounds.height);
        g.setColor(Color.WHITE);
        g.drawRect(boxBounds.x, boxBounds.y, boxBounds.width, boxBounds.height);
    }


   /* @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("typed");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(isAnimated) {
            return;
        }
        switch(e.getKeyCode()) {
            case VK_UP:
                move(Direction.UP);
                break;

            case VK_DOWN:
                move(Direction.DOWN);
                break;

            case VK_LEFT:
                move(Direction.LEFT);
                break;

            case VK_RIGHT:
                move(Direction.RIGHT);
                break;

            default:
                // donothing
        }
        System.out.println("pressed " + e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("release " + e.getKeyCode());
    }
    @Override
    public void animationCompleted() {
        this.isAnimated = false;
    }*/
    public void moveBox(Direction direction) {
        GreenBoxMover greenBoxMover = new GreenBoxMover(gamePanel, 1000L, 33L, boxBounds, direction);
        greenBoxMover.start();
    }
    public Rectangle getBoxBounds() {
        return boxBounds;
    }
}
