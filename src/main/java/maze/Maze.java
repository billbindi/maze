package maze;

import com.google.common.base.Preconditions;

import java.util.Arrays;

public final class Maze {
    Cell[][] walls;

    public Maze(Cell[][] walls) {
        Preconditions.checkNotNull(walls);
        Preconditions.checkArgument(walls.length > 0, "Cannot have 0 height maze");
        this.walls = walls;
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
