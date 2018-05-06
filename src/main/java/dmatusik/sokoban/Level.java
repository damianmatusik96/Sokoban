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
    private List<KeyField> keyFields;
    private List<GreenBox> greenBoxes;
    private Player player;
    private GameConfig gameConfig;

    public Level(int index, int tileSize, MapConfig map, GamePanel gamePanel) {
        this.index = index;
        this.tileSize = tileSize;
        obstacles = new ArrayList<>();
        keyFields = new ArrayList<>();
        greenBoxes = new ArrayList<>();
        gameConfig = new GameConfig();
        this.gamePanel = gamePanel;
        for(int v = 0; v < map.getVSize(); v++) {
            for(int u = 0; u < map.getUSize(); u++) {
                char symbol = map.getSymbol(u, v);
                createAndAddObject(u, v, symbol);
            }
        }
        gamePanel.addKeyListener(player);
    }
    private void createAndAddObject(int u, int v, char symbol) {
        switch(symbol){
            case '#':
                createAndAddObstacle(u, v);
                break;
            case '$':
                createAndAddPlayer(u, v);
                break;
            case 'x':
                createAndAddKeyField(u, v);
                break;
            case 'o':
                createAndAddGreenBox(u, v);
                break;
            default:

                //todo throw runtime exception
        }
    }

    private void createAndAddGreenBox(int u, int v) {
        GreenBox greenBox = new GreenBox(tileSize, u, v);
        greenBoxes.add(greenBox);

    }

    private void createAndAddPlayer(int u, int v) {
        player = new Player(tileSize, u, v, gamePanel);
    }

    private void createAndAddObstacle(int u, int v){
        Obstacle obstacle = new Obstacle(tileSize, u, v);
        obstacles.add(obstacle);
    }

    private void createAndAddKeyField(int u, int v) {
        KeyField keyField = new KeyField(tileSize, u, v);
        keyFields.add(keyField);
    }

    public void render() {
        Graphics g = gamePanel.getGraphics();
        gamePanel.renderBackground(Color.GRAY);
        for(Obstacle obstacle : obstacles) {
            obstacle.render(g);
        }
        for(KeyField keyField : keyFields) {
            keyField.render(g);
        }
        for(GreenBox greenBox : greenBoxes) {
            greenBox.render(g);
        }
        player.render(g);
        gamePanel.repaint();
    }

}
