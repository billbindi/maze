package maze.app;

import maze.Maze;
import maze.util.Coordinate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MazePanel extends JPanel {
    private static final int PADDING = 5;
    private static final int CELL_WIDTH = 20;
    private static final int CELL_HEIGHT = 20;

    private final Maze maze;
    private Coordinate player = new Coordinate(0, 0);

    public MazePanel(Maze maze) {
        this.maze = maze;
        setBorder(BorderFactory.createLineBorder(Color.black));
        setBackground(Color.white);
    }

    @Override
    public Dimension getPreferredSize() {
        int width = minWidth();
        int height = minHeight();
        return new Dimension(width, height);
    }

    public int minHeight() {
        return (PADDING * 2) + (CELL_HEIGHT * maze.getHeight());
    }

    public int minWidth() {
        return (PADDING * 2) + (CELL_WIDTH * maze.getWidth());
    }

    public void moveLeft() {
        tryMove(player.coordinateLeft());
    }

    public void moveUp() {
        tryMove(player.coordinateUp());
    }

    public void moveRight() {
        tryMove(player.coordinateRight());
    }

    public void moveDown() {
        tryMove(player.coordinateDown());
    }

    private void tryMove(Coordinate newCoord) {
        if (newCoord.isInBounds(maze.getWidth(), maze.getHeight())) {
            player = newCoord;
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        drawTop(g);
        drawLeft(g);
        drawMaze(g);

        g.setColor(Color.RED);
        drawPlayer(g);

        g.setColor(Color.GREEN);
        drawExit(g);
    }

    private void drawMaze(Graphics g) {
        for (int x = 0; x < maze.getWidth(); x++) {
            for (int y = 0; y < maze.getHeight(); y++) {
                Coordinate cell = new Coordinate(x, y);
                if (maze.wallRight(cell)) {
                    g.drawLine(rightX(cell), topY(cell), rightX(cell), bottomY(cell));
                }

                if (maze.wallDown(cell)) {
                    g.drawLine(leftX(cell), bottomY(cell), rightX(cell), bottomY(cell));
                }
            }
        }
    }

    private void drawPlayer(Graphics g) {
        g.fillRect(leftX(player) + 2, topY(player) + 2, CELL_WIDTH - 4, CELL_HEIGHT - 4);
    }

    private void drawExit(Graphics g) {
        Coordinate exit = new Coordinate(maze.getWidth() - 1, maze.getHeight() - 1);
        g.fillRect(leftX(exit) + 1, topY(exit) + 1, CELL_WIDTH - 2, CELL_HEIGHT - 2);
    }

    private void drawTop(Graphics g) {
        int width = maze.getWidth();
        Coordinate start = new Coordinate(0, 0);
        Coordinate end = new Coordinate(width - 1, 0);
        g.drawLine(leftX(start), topY(start),
                rightX(end), topY(end));
    }

    private void drawLeft(Graphics g) {
        int height = maze.getHeight();
        Coordinate start = new Coordinate(0, 0);
        Coordinate end = new Coordinate(0, height - 1);
        g.drawLine(leftX(start), topY(start),
                leftX(end), bottomY(end));
    }

    private static int leftX(Coordinate coord) {
        return PADDING + (coord.getX() * CELL_WIDTH);
    }

    private static int rightX(Coordinate coord) {
        return PADDING + ((coord.getX() + 1) * CELL_WIDTH);
    }

    private static int topY(Coordinate coord) {
        return PADDING + (coord.getY() * CELL_HEIGHT);
    }

    private static int bottomY(Coordinate coord) {
        return PADDING + ((coord.getY() + 1) * CELL_HEIGHT);
    }
}
