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
            List<Character> symbolsInLine = new ArrayList<>();
            String line = mapFileReader.nextLine();
            for (char c : line.toCharArray()) {
                symbolsInLine.add(c);
            }
            lines.add(symbolsInLine);
        }
    }

    public int getVSize(){
        return lines.size();
    }

    public int getUSize(){
        return lines.get(0).size();
    }

    public char getSymbol(int u, int v){
        return lines.get(v).get(u);
    }
} //todo zamknac inputStream mapFile
