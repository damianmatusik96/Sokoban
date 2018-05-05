package dmatusik.sokoban;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Level {
    private int tileSize;
    private int index;
    private GamePanel gamePanel;
    private List<Obstacle> obstacles;

    public Level(int index, int tileSize, MapConfig map, GamePanel gamePanel) {
        this.index = index;
        this.tileSize = tileSize;
        obstacles = new ArrayList<>();
        this.gamePanel = gamePanel;
        for(int v = 0; v < map.getVSize(); v++) {
            for(int u = 0; u < map.getUSize(); u++) {
                char symbol = map.getSymbol(u, v);
                createAndAddObject(u, v, symbol);
            }
        }
    }
    private void createAndAddObject(int u, int v, char symbol) {
        switch(symbol){
            case '#':
                createAndAddObstacle(u, v);
                break;
            default:
                //todo throw runtime exception
        }
    }
    private void createAndAddObstacle(int u, int v){
        Obstacle obstacle = new Obstacle(tileSize, u, v);
        obstacles.add(obstacle);
    }

    public void render() {
        Graphics g = gamePanel.getGraphics();
        gamePanel.renderBackground(Color.GRAY);
        for(Obstacle obstacle : obstacles) {
            obstacle.render(g);
        }
        gamePanel.repaint();
    }

}
