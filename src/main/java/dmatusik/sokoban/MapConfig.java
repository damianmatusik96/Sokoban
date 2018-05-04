package dmatusik.sokoban;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MapConfig {
    private List<List<Character>> lines;

    public MapConfig(int index) {
        lines = new ArrayList<>();
        String mapFilePath = "/MapsConfig/Map" + index + ".txt";
        InputStream mapFile = MapConfig.class.getResourceAsStream(mapFilePath);
        Scanner mapFileReader = new Scanner(mapFile);
        while (mapFileReader.hasNextLine()) {
            List<Character> charsInLine = new ArrayList<>();
            String line = mapFileReader.nextLine();
            for (char c : line.toCharArray()) {
                charsInLine.add(c);
            }
            lines.add(charsInLine);
        }
    }
} //todo zamknac inputStream mapFile
