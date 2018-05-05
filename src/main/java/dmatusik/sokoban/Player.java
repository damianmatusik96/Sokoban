package dmatusik.sokoban;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.awt.event.KeyEvent.*;

public class Player implements Renderable, KeyListener, AnimationObserver {
    private Rectangle boxBounds;
    private boolean isAnimated;
    private GamePanel gamePanel;

    public Player(int size, int u, int v, GamePanel gamePanel) {
        isAnimated = false;
        int x = size * u;
        int y = size * v;
        boxBounds = new Rectangle(x, y, size, size);
        this.gamePanel = gamePanel;

    }
    @Override
    public void render(Graphics g) {
       if(!isAnimated) {
           DrawingTools.renderPlayer(g, boxBounds);
       }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() =='d') {
            System.out.println("referes");
            Launch.LVL.render();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(isAnimated){
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
        System.out.println("released " + e.getKeyCode());
    }

    @Override
    public void animationCompleted() {
        isAnimated = false;
    }
    private void move(Direction direction) {
        MathTools.moveBox(direction, boxBounds, boxBounds.width);
        PlayerAnimation animation = new PlayerAnimation(gamePanel, 1000L, 33L, boxBounds, direction);
        animation.setAnimationObserver(this);
        animation.start();
        isAnimated = true;
    }

}
