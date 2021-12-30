package maze.app;

import maze.Maze;
import maze.util.Coordinate;
import maze.util.MazeSettings;

public class MazeModel {

    private Maze maze;
    private Coordinate player;

    public MazeModel(Maze maze) {
        this.maze = maze;
        this.player = new Coordinate(0, 0);
    }

    public Maze getMaze() {
        return maze;
    }

    public Coordinate getPlayer() {
        return player;
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    public void setPlayer(Coordinate player) {
        this.player = player;
    }

    public int getHeight() {
        return maze.getHeight();
    }

    public int getWidth() {
        return maze.getWidth();
    }

    public boolean canMoveLeft() {
        Coordinate left = player.coordinateLeft();
        return left.isInBounds(maze.getWidth(), maze.getHeight())
                && !maze.wallRight(left);
    }

    public boolean canMoveDown() {
        Coordinate down = player.coordinateLeft();
        return down.isInBounds(maze.getWidth(), maze.getHeight()) && !maze.wallDown(player);
    }

    public boolean canMoveRight() {
        Coordinate right = player.coordinateLeft();
        return right.isInBounds(maze.getWidth(), maze.getHeight()) && !maze.wallRight(player);
    }

    public boolean canMoveUp() {
        Coordinate up = player.coordinateLeft();
        return up.isInBounds(maze.getWidth(), maze.getHeight()) && !maze.wallDown(up);
    }

    public int minHeight() {
        return (MazeSettings.CELL_PADDING * 2) + (MazeSettings.CELL_HEIGHT * getHeight());
    }

    public int minWidth() {
        return (MazeSettings.CELL_PADDING * 2) + (MazeSettings.CELL_WIDTH * getWidth());
    }
}
