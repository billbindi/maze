package maze.app;

import maze.Maze;
import maze.MazeSolver;
import maze.util.Coordinate;
import maze.util.MazeSettings;

import java.util.ArrayList;
import java.util.List;

public class MazeModel {

    private Maze maze;
    private Coordinate player;
    private boolean isSolved = false;

    private final List<Coordinate> steps = new ArrayList<>();

    public MazeModel(Maze maze) {
        this.maze = maze;
        setPlayer(new Coordinate(0, 0));
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

    public boolean isSolved() {
        return isSolved;
    }

    public void setSolved(boolean solved) {
        isSolved = solved;
    }

    public void setPlayer(Coordinate player) {
        this.player = player;
        steps.add(player.copy());
    }

    public int getHeight() {
        return maze.getHeight();
    }

    public int getWidth() {
        return maze.getWidth();
    }

    public List<Coordinate> getPlayerSteps() {
        return steps;
    }

    public List<Coordinate> solve() {
        return MazeSolver.solve(this);
    }

    public Coordinate getExit() {
        return new Coordinate(maze.getWidth() - 1, maze.getHeight() - 1);
    }

    public boolean canMoveLeft() {
        return canMoveLeft(player);
    }

    public boolean canMoveLeft(Coordinate location) {
        Coordinate left = location.coordinateLeft();
        return left.isInBounds(maze.getWidth(), maze.getHeight()) && !maze.wallRight(left);
    }

    public boolean canMoveDown() {
        return canMoveDown(player);
    }

    public boolean canMoveDown(Coordinate location) {
        Coordinate down = location.coordinateDown();
        return down.isInBounds(maze.getWidth(), maze.getHeight()) && !maze.wallDown(location);
    }

    public boolean canMoveRight() {
        return canMoveRight(player);
    }

    public boolean canMoveRight(Coordinate location) {
        Coordinate right = location.coordinateRight();
        return right.isInBounds(maze.getWidth(), maze.getHeight()) && !maze.wallRight(location);
    }

    public boolean canMoveUp() {
        return canMoveUp(player);
    }

    public boolean canMoveUp(Coordinate location) {
        Coordinate up = location.coordinateUp();
        return up.isInBounds(maze.getWidth(), maze.getHeight()) && !maze.wallDown(up);
    }

    public int minHeight() {
        return (MazeSettings.CELL_PADDING * 2) + (MazeSettings.CELL_HEIGHT * getHeight());
    }

    public int minWidth() {
        return (MazeSettings.CELL_PADDING * 2) + (MazeSettings.CELL_WIDTH * getWidth());
    }
}
