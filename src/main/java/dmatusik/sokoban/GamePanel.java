package dmatusik.sokoban;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {
    private BufferedImage view;

    public GamePanel(int xSize, int ySize){
        view = new BufferedImage(xSize, ySize, BufferedImage.TYPE_INT_ARGB);
    }

    @Override
    protected void paintComponent(Graphics g) {
        clearView();
        g.drawImage(view, 0,0, getWidth(), getHeight(), null);
    }

    private void clearView() {
        Graphics g = view.getGraphics();
        g.setColor(Color.BLUE);
        g.fillRect(0,0, view.getWidth(), view.getHeight());
        g.setColor(Color.CYAN);
        g.drawString("Sokoban",view.getWidth()/2, view.getHeight()/2);
    }
}
