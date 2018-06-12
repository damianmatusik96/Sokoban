package dmatusik.sokoban;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.awt.event.KeyEvent.*;

public class Player implements Renderable, KeyListener, MotionObserver {
    private Rectangle bounds;
    private boolean isAnimated;
    private GamePanel gamePanel;
    private Level level;

    public Player(int size, int u, int v, GamePanel gamePanel, Level level) {
        isAnimated = false;
        int x = size * u;
        int y = size * v;
        bounds = new Rectangle(x, y, size, size);
        this.gamePanel = gamePanel;
        this.level = level;
    }
    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawOval(bounds.x, bounds.y, bounds.width, bounds.height);
        g.setColor(Color.RED);
        g.fillOval(bounds.x, bounds.y, bounds.width, bounds.height);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() =='d') {
            System.out.println("referes");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(isAnimated){
            return;
        }

        switch(e.getKeyCode()) {
            case VK_UP:
                if(level.findGreenBox(bounds.x, bounds.y - bounds.height) != null) {
                    level.findGreenBox(bounds.x, bounds.y - bounds.height).moveBox(Direction.UP);
                }
                move(Direction.UP);
                break;

            case VK_DOWN:
                if(level.findGreenBox(bounds.x, bounds.y + bounds.height) != null) {
                    level.findGreenBox(bounds.x, bounds.y + bounds.height).moveBox(Direction.DOWN);
                }
                move(Direction.DOWN);
                break;

            case VK_LEFT:
                if(level.findGreenBox(bounds.x - bounds.width, bounds.y) != null) {
                    level.findGreenBox(bounds.x - bounds.width, bounds.y).moveBox(Direction.LEFT);
                }
                move(Direction.LEFT);
                break;

            case VK_RIGHT:
                if(level.findGreenBox(bounds.x + bounds.width, bounds.y) != null) {
                    level.findGreenBox(bounds.x + bounds.width, bounds.y).moveBox(Direction.RIGHT);
                }
                move(Direction.RIGHT);
                break;

            default:
                // donothing
        }
        System.out.println("pressed " + e.getKeyCode());
    }


    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("released " + e.getKeyCode());
    }

    @Override
    public void animationCompleted() {
        isAnimated = false;
    }

    private void move(Direction direction) {
        PlayerMover mover = new PlayerMover(gamePanel, 1000L, 33L, bounds, direction);
        mover.setMotionObserver(this);
        mover.start();
        isAnimated = true;
    }

}
