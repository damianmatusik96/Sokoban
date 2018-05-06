package dmatusik.sokoban;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GameConfig {

    private static File conf;
    private static Properties properties;
    private static InputStream is;


    private int START_LIFE;
    private int FRAME_WIDTH;
    private int FRAME_HEIGHT;
    private String pathName;

    public GameConfig() {
        pathName = "C:\\Users\\Damian 1\\Desktop\\Projekt_Proze\\Sokoban\\src\\main\\resources\\MapsConfig\\GameConfig.properties";
        conf = new File(pathName);
        properties = new Properties();
        loadFile();
        getGameConfig();
    }

    private void getGameConfig() {
        START_LIFE = Integer.parseInt(properties.getProperty("START_LIFE"));
        FRAME_HEIGHT = Integer.parseInt(properties.getProperty("FRAME_HEIGHT"));
        FRAME_WIDTH = Integer.parseInt(properties.getProperty("FRAME_HEIGHT"));

    }

    public void loadFile(){
        try {
            is = new FileInputStream(conf);
            properties.load(is);
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getSTART_LIFE() {
        return START_LIFE;
    }

    public int getFRAME_WIDTH() {
        return FRAME_WIDTH;
    }

    public int getFRAME_HEIGHT() {
        return FRAME_HEIGHT;
    }
}
