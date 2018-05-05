package dmatusik.sokoban;

import java.awt.Rectangle;

public class MathTools {
    public static void moveBox(Direction direction, Rectangle box, int distance) {
        box.setLocation(box.x + direction.dx * distance, box.y + direction.dy * distance);
    }
}
