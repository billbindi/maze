package maze;

import com.google.common.base.Preconditions;
import maze.util.Coordinate;

import java.util.Arrays;

public final class Maze {
    Cell[][] walls;

    public Maze(Cell[][] walls) {
        Preconditions.checkNotNull(walls);
        Preconditions.checkArgument(walls.length > 0, "Cannot have 0 height maze");
        this.walls = walls;
    }

    public boolean wallRight(Coordinate coord) {
        return walls[coord.getY()][coord.getX()].isEast();
    }

    public boolean wallDown(Coordinate coord) {
        return walls[coord.getY()][coord.getX()].isSouth();
    }

    public int getHeight() {
        return walls.length;
    }

    public int getWidth() {
        if (getHeight() == 0) {
            return 0;
        } else {
            return walls[0].length;
        }
    }

    @SuppressWarnings("unused")
    public void printMaze() {
        int height = getHeight();
        int width = getWidth();

        // print top wall
        for (int i = 0; i < width; i++) {
            System.out.print(" _");
        }
        System.out.println();

        for (int y = 0; y < height; y++) {
            System.out.print("|");
            for (int x = 0; x < width; x++) {
                // check south
                if (walls[y][x].isSouth()) {
                    System.out.print("_");
                } else {
                    System.out.print(" ");
                }

                // check east
                if (walls[y][x].isEast()) {
                    System.out.print("|");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Maze maze = (Maze) o;
        return Arrays.deepEquals(walls, maze.walls);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(walls);
    }

    @Override
    public String toString() {
        return "Maze{" +
                "walls=" + Arrays.toString(walls) +
                '}';
    }
}
