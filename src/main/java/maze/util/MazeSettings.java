package maze.util;

import java.awt.*;

public final class MazeSettings {

    // maze start
    public static final String TITLE = "Maze of DOOM!";
    public static final int STARTING_WIDTH = 25;
    public static final int STARTING_HEIGHT = 25;
    public static final int MIN_WIDTH_PIXELS = 330;
    public static final int MIN_HEIGHT_PIXELS = 110;

    // easy size based on button panel width
    public static final int EASY_WIDTH = 15;
    public static final int EASY_HEIGHT = 10;

    // medium size is just starting maze
    public static final int MEDIUM_WIDTH = STARTING_WIDTH;
    public static final int MEDIUM_HEIGHT = STARTING_HEIGHT;

    // Hard size based on laptop screen size
    public static final int HARD_WIDTH = 81;
    public static final int HARD_HEIGHT = 49;

    // draw settings
    public static final int CELL_PADDING = 5;
    public static final int CELL_WIDTH = 20;
    public static final int CELL_HEIGHT = 20;

    // colors
    public static final Color BACKGROUND_COLOR = Color.BLACK;
    public static final Color BORDER_COLOR = Color.BLACK;
    public static final Color WALL_COLOR = Color.WHITE;
    public static final Color PLAYER_COLOR = Color.RED;
    public static final Color EXIT_COLOR = Color.GREEN;
    public static final Color SOLVE_PATH_COLOR = Color.CYAN;
    public static final Color PLAYER_PATH_COLOR = Color.MAGENTA;

    // scrolling
    public static final int HORIZONTAL_SCROLL_SPEED = 10;
    public static final int VERTICAL_SCROLL_SPEED = 10;

    private MazeSettings() {
        // no instantiation
    }
}
