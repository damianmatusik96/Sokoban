package dmatusik.sokoban;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel {
    private BufferedImage view;
    private List<Renderable> renderables;


    public GamePanel(int viewXSize, int viewYSize){
        view = new BufferedImage(viewXSize, viewYSize, BufferedImage.TYPE_INT_ARGB);
        renderables = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        for(Renderable renderable : renderables) {
            renderable.render(view.createGraphics());
        }
        g.drawImage(view, 0, 0, getWidth(), getHeight(), null);

    }
    public void setRenderables(List<Renderable> renderables) {
        this.renderables.clear();
        this.renderables.addAll(renderables);
    }

    public int getViewXSize() {
        return view.getWidth();
    }

    public int getViewYSize() {
        return view.getHeight();
    }

}
