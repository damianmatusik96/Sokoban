package dmatusik.sokoban;

import javax.swing.SwingUtilities;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PlayerAnimation implements Runnable {
    private int maxI;
    private int i;
    private Rectangle animationBox;
    private GamePanel gamePanel;
    private long period;
    private AnimationObserver observer;
    private Direction direction;
    private ScheduledExecutorService loop;

    public PlayerAnimation(GamePanel gamePanel, long duration, long period, Rectangle boxBounds, Direction direction) {
        i = 0;
        maxI = (int)((float)duration/period);
        this.period = period;
        observer = null;
        this.gamePanel = gamePanel;
        animationBox = new Rectangle(boxBounds);
        this.direction = direction;
        loop = Executors.newSingleThreadScheduledExecutor();
    }

    public void setAnimationObserver(AnimationObserver observer){
        this.observer = observer;
    }

    public void start() {
        loop.scheduleAtFixedRate(this, 0, period, TimeUnit.MILLISECONDS);
    }

    @Override
    public void run() {
        Graphics g = gamePanel.getGraphics();

        if(i++ < maxI) {
            SwingUtilities.invokeLater(new Runnable(){
                @Override
                public void run() {
                    DrawingTools.clearTile(g, animationBox);
                    MathTools.moveBox(direction, animationBox, 1);
                    DrawingTools.renderPlayer(g, animationBox);
                    gamePanel.repaint();
                }
            });
        } else {
            loop.shutdown();
            if(observer != null) {
                observer.animationCompleted();
            }
        }
    }

}
