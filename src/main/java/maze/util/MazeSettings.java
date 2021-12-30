package maze.util;

import java.awt.*;

public final class MazeSettings {

    // maze start
    public static final String TITLE = "Maze of DOOM!";
    public static final int STARTING_WIDTH = 20;
    public static final int STARTING_HEIGHT = 20;
    public static final int MIN_WIDTH_PIXELS = 400;
    public static final int MIN_HEIGHT_PIXELS = 300;

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

    // scrolling
    public static final int HORIZONTAL_SCROLL_SPEED = 10;
    public static final int VERTICAL_SCROLL_SPEED = 10;

    private MazeSettings() {
        // no instantiation
    }
}
