package dmatusik.sokoban;

import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameButton extends JMenuItem implements ActionListener {
    private GamePanel gamePanel;
    private int tileSize;
    private int index;

    public NewGameButton(int tileSize, GamePanel gamePanel) {
        super("Nowa gra");
        this.tileSize = tileSize;
        this.gamePanel = gamePanel;
        index = 0;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MapConfig firstMap = new MapConfig(index);
        Level firstLevel = new Level(index, tileSize, firstMap, gamePanel);
        firstLevel.render();
    }
}
