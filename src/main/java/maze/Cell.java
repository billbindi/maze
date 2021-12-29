package maze;

import java.util.Objects;

// Only need to track south and east walls
public class Cell {
    boolean south;
    boolean east;

    public Cell() {
        this(true, true);
    }

    public Cell(boolean south, boolean east) {
        this.south = south;
        this.east = east;
    }

    public boolean isSouth() {
        return south;
    }

    public boolean isEast() {
        return east;
    }

    public void setSouth(boolean south) {
        this.south = south;
    }

    public void setEast(boolean east) {
        this.east = east;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return south == cell.south && east == cell.east;
    }

    @Override
    public int hashCode() {
        return Objects.hash(south, east);
    }

    @Override
    public String toString() {
        return "Cell{" +
                "south=" + south +
                ", east=" + east +
                '}';
    }

}
