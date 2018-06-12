package dmatusik.sokoban;

import java.awt.Color;
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
    private Background background;

    public Level(int index, int tileSize, MapConfig map, GamePanel gamePanel) {
        this.index = index;
        this.tileSize = tileSize;
        obstacles = new ArrayList<>();
        keyFields = new ArrayList<>();
        greenBoxes = new ArrayList<>();
        gameConfig = new GameConfig();
        this.gamePanel = gamePanel;
        background = new Background(Color.GRAY, gamePanel.getViewXSize(), gamePanel.getViewYSize());
        for (int v = 0; v < map.getVSize(); v++) {
            for (int u = 0; u < map.getUSize(); u++) {
                char symbol = map.getSymbol(u, v);
                createAndAddObject(u, v, symbol);
            }
        }
        List<Renderable> renderables = new ArrayList<>();
        renderables.add(background);
        renderables.addAll(obstacles);
        renderables.addAll(keyFields);
        renderables.addAll(greenBoxes);
        renderables.add(player);
        gamePanel.setRenderables(renderables);
        gamePanel.addKeyListener(player);
    }

    private void createAndAddObject(int u, int v, char symbol) {
        switch (symbol) {
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
        GreenBox greenBox = new GreenBox(gamePanel, tileSize, u, v);
        greenBoxes.add(greenBox);

    }

    private void createAndAddPlayer(int u, int v) {
        player = new Player(tileSize, u, v, gamePanel, this);
    }

    private void createAndAddObstacle(int u, int v) {
        Obstacle obstacle = new Obstacle(tileSize, u, v);
        obstacles.add(obstacle);
    }

    private void createAndAddKeyField(int u, int v) {
        KeyField keyField = new KeyField(tileSize, u, v);
        keyFields.add(keyField);
    }

    public GreenBox findGreenBox(int x, int y) {
        GreenBox localGreenbox = null;
        for (GreenBox greenBox : greenBoxes) {
            if (greenBox.getBoxBounds().x == x && greenBox.getBoxBounds().y == y) {
                localGreenbox =  greenBox;
            }
        }
        return localGreenbox;
    }

}
