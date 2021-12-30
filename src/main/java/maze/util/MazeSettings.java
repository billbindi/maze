package maze.util;

import java.awt.*;

public final class MazeSettings {

    // maze dimensions
    public static int WIDTH = 20;
    public static int HEIGHT = 20;

    // draw settings
    public static final int CELL_PADDING = 5;
    public static final int CELL_WIDTH = 20;
    public static final int CELL_HEIGHT = 20;

    // colors
    public static final Color BACKGROUND_COLOR = Color.white;
    public static final Color BORDER_COLOR = Color.black;
    public static final Color WALL_COLOR = Color.black;
    public static final Color PLAYER_COLOR = Color.red;
    public static final Color EXIT_COLOR = Color.green;

    private MazeSettings() {
        // no instantiation
    }
}
