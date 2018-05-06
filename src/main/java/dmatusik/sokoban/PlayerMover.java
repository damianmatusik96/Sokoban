package dmatusik.sokoban;

import javax.swing.SwingUtilities;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PlayerMover implements Runnable {
    private int maxI;
    private int i;
    private Rectangle playerBounds;
    private GamePanel gamePanel;
    private long period;
    private MotionObserver observer;
    private Direction direction;
    private ScheduledExecutorService loop;

    public PlayerMover(GamePanel gamePanel, long duration, long period, Rectangle playerBounds, Direction direction) {
        i = 0;
        maxI = (int)((float)duration/period);
        this.period = period;
        observer = null;
        this.gamePanel = gamePanel;
        this.playerBounds = playerBounds;
        this.direction = direction;
        loop = Executors.newSingleThreadScheduledExecutor();
    }

    public void setMotionObserver(MotionObserver observer){
        this.observer = observer;
    }

    public void start() {
        loop.scheduleAtFixedRate(this, 0, period, TimeUnit.MILLISECONDS);
    }

    @Override
    public void run() {
        if(i++ < maxI) {
            SwingUtilities.invokeLater(new Runnable(){
                @Override
                public void run() {
                    MathTools.moveBox(direction, playerBounds, 1);
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
