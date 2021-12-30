package maze.util;

import java.awt.*;

public final class MazeSettings {

    // maze start
    public static final String TITLE = "Maze of DOOM!";
    public static final int STARTING_WIDTH = 20;
    public static final int STARTING_HEIGHT = 20;
    public static final int MIN_WIDTH_PIXELS = 330;
    public static final int MIN_HEIGHT_PIXELS = 290;

    // draw settings
    public static final int CELL_PADDING = 5;
    public static final int CELL_WIDTH = 20;
    public static final int CELL_HEIGHT = 20;

    // colors
    public static final Color BACKGROUND_COLOR = Color.WHITE;
    public static final Color BORDER_COLOR = Color.BLACK;
    public static final Color WALL_COLOR = Color.BLACK;
    public static final Color PLAYER_COLOR = Color.RED;
    public static final Color EXIT_COLOR = Color.GREEN;
    public static final Color SOLVE_PATH_COLOR = Color.BLUE;
    public static final Color PLAYER_PATH_COLOR = Color.MAGENTA;

    // scrolling
    public static final int HORIZONTAL_SCROLL_SPEED = 10;
    public static final int VERTICAL_SCROLL_SPEED = 10;

    private MazeSettings() {
        // no instantiation
    }
}
