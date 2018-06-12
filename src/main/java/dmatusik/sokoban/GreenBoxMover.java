package dmatusik.sokoban;

import javax.swing.SwingUtilities;
import java.awt.Rectangle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GreenBoxMover implements Runnable {
    private int i;
    private int maxI;
    private long period;
    private Rectangle boxBounds;
    private GamePanel gamePanel;
    private Player player;
    private MotionObserver observer;
    private Direction direction;
    private ScheduledExecutorService loop;

    public GreenBoxMover(GamePanel gamePanel, long duration, long period, Rectangle boxBounds, Direction direction) {
        i = 0;
        maxI = (int)((float)duration/period);
        this.period = period;
        observer = null;
        this.gamePanel = gamePanel;
        this.boxBounds = boxBounds;
        this.direction = direction;
        loop = Executors.newSingleThreadScheduledExecutor();
    }
    public void setMotionObserver(MotionObserver observer) {
        this.observer = observer;
    }
    public void start() {
        loop.scheduleAtFixedRate(this, 0, period, TimeUnit.MILLISECONDS);
    }
    @Override
    public void run() {
        if(i++ < maxI) {
            SwingUtilities.invokeLater(() -> {
                MathTools.moveBox(direction, boxBounds, 1);
                gamePanel.repaint();
            });
        } else {
            loop.shutdown();
            if (observer != null) {
                observer.animationCompleted();
            }
        }
    }
}
