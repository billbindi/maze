package maze.util;

import java.util.Objects;

/**
 * Simple class for a coordinate on a grid. Assumes (0, 0) in top left.
 * In other words, increasing x moves left, increasing y moves down.
 */
public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coordinate coordinateLeft() {
        return new Coordinate(x - 1, y);
    }

    public Coordinate coordinateRight() {
        return new Coordinate(x + 1, y);
    }

    public Coordinate coordinateUp() {
        return new Coordinate(x, y - 1);
    }

    public Coordinate coordinateDown() {
        return new Coordinate(x, y + 1);
    }

    // check if this coordinate is in bounds in a WxH bounding box
    public boolean isInBounds(int width, int height) {
        return x >= 0 && y >= 0 && x < width && y < height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "util.Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
