/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package maze;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import maze.util.Coordinate;
import maze.util.UnionFind;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class MazeFactory {

    public static Maze makeMaze(int width, int height) {
        Preconditions.checkArgument(width > 0);
        Preconditions.checkArgument(height > 0);

        Cell[][] maze = allWalls(width, height);
        return randomRemove(maze);
    }

    private static Maze randomRemove(Cell[][] maze) {
        int height = maze.length;
        int width = maze[0].length;
        int size = height * width;

        // Union Find data structure for tracking connectedness
        UnionFind unionFind = UnionFind.create(size);

        // random order to enumerate the cells
        List<Coordinate> ints = IntStream.range(0, size)
                .mapToObj(i -> twoD(maze, i))
                .collect(Collectors.toList());
        Collections.shuffle(ints);

        for (Coordinate cell : ints) {
            Coordinate right = cell.coordinateRight();
            Coordinate down = cell.coordinateDown();
            checkRemoveRightWall(maze, unionFind, cell, right);
            checkRemoveDownWall(maze, unionFind, cell, down);
        }
        return new Maze(maze);
    }

    private static void checkRemoveRightWall(Cell[][] maze, UnionFind unionFind, Coordinate cell, Coordinate right) {
        int height = maze.length;
        int width = maze[0].length;
        int cellNum = oneD(maze, cell);
        int rightNum = oneD(maze, right);
        if (right.isInBounds(width, height) && !unionFind.areSame(cellNum, rightNum)) {
            maze[cell.getY()][cell.getX()].setEast(false);
            unionFind.union(cellNum, rightNum);
        }
    }

    private static void checkRemoveDownWall(Cell[][] maze, UnionFind unionFind, Coordinate cell, Coordinate down) {
        int height = maze.length;
        int width = maze[0].length;
        int cellNum = oneD(maze, cell);
        int downNum = oneD(maze, down);
        if (down.isInBounds(width, height) && !unionFind.areSame(cellNum, downNum)) {
            maze[cell.getY()][cell.getX()].setSouth(false);
            unionFind.union(cellNum, downNum);
        }
    }

    @VisibleForTesting
    static int oneD(Cell[][] maze, int x, int y) {
        return (y * maze.length) + x;
    }

    private static int oneD(Cell[][] maze, Coordinate coord) {
        return oneD(maze, coord.getX(), coord.getY());
    }

    @VisibleForTesting
    static Coordinate twoD(Cell[][] maze, int num) {
        int x = num % maze[0].length;
        int y = num / maze.length;
        return new Coordinate(x, y);
    }

    private static Cell[][] allWalls(int width, int height) {
        Cell[][] maze = new Cell[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                maze[y][x] = new Cell();
            }
        }
        return maze;
    }

    private MazeFactory() {
        // no instantiation
    }
}
