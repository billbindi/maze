package maze.app;

import maze.util.Coordinate;
import maze.util.MazeSettings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MazePanel extends JPanel {

    private final MazeModel model;

    public MazePanel(MazeModel model) {
        this.model = model;
        setBorder(BorderFactory.createLineBorder(MazeSettings.BORDER_COLOR));
        setBackground(MazeSettings.BACKGROUND_COLOR);

        keyBindings();
        reset();

    }

    public void reset() {
        setPlayer(new Coordinate(0, 0));
    }

    private void keyBindings() {
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "moveRight");
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "moveDown");
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "moveLeft");
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "moveUp");

        getActionMap().put("moveRight", KeyBindings.moveRight(this));
        getActionMap().put("moveDown", KeyBindings.moveDown(this));
        getActionMap().put("moveLeft", KeyBindings.moveLeft(this));
        getActionMap().put("moveUp", KeyBindings.moveUp(this));
    }

    @Override
    public Dimension getPreferredSize() {
        int width = minWidth();
        int height = minHeight();
        return new Dimension(width, height);
    }

    public int minHeight() {
        return (MazeSettings.CELL_PADDING * 2) + (MazeSettings.CELL_HEIGHT * model.getHeight());
    }

    public int minWidth() {
        return (MazeSettings.CELL_PADDING * 2) + (MazeSettings.CELL_WIDTH * model.getWidth());
    }

    public void moveLeft() {
        if (model.canMoveLeft()) {
            setPlayer(model.getPlayer().coordinateLeft());
        }
    }

    public void moveUp() {
        if (model.canMoveUp()) {
            setPlayer(model.getPlayer().coordinateUp());
        }
    }

    public void moveRight() {
        if (model.canMoveRight()) {
            setPlayer(model.getPlayer().coordinateRight());
        }
    }

    public void moveDown() {
        if (model.canMoveDown()) {
            setPlayer(model.getPlayer().coordinateDown());
        }
    }

    private void setPlayer(Coordinate coord) {
        model.setPlayer(coord);
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(MazeSettings.WALL_COLOR);
        drawWalls(g);

        g.setColor(MazeSettings.PLAYER_COLOR);
        drawPlayer(g);

        g.setColor(MazeSettings.EXIT_COLOR);
        drawExit(g);
    }

    private void drawWalls(Graphics g) {
        drawTop(g);
        drawLeft(g);
        drawMaze(g);
    }

    private void drawMaze(Graphics g) {
        for (int x = 0; x < model.getWidth(); x++) {
            for (int y = 0; y < model.getHeight(); y++) {
                Coordinate cell = new Coordinate(x, y);
                if (model.getMaze().wallRight(cell)) {
                    g.drawLine(rightX(cell), topY(cell), rightX(cell), bottomY(cell));
                }

                if (model.getMaze().wallDown(cell)) {
                    g.drawLine(leftX(cell), bottomY(cell), rightX(cell), bottomY(cell));
                }
            }
        }
    }

    private void drawPlayer(Graphics g) {
        Coordinate player = model.getPlayer();
        g.fillRect(leftX(player) + 2, topY(player) + 2, MazeSettings.CELL_WIDTH - 4, MazeSettings.CELL_HEIGHT - 4);
    }

    private void drawExit(Graphics g) {
        Coordinate exit = model.getExit();
        g.fillRect(leftX(exit) + 1, topY(exit) + 1, MazeSettings.CELL_WIDTH - 2, MazeSettings.CELL_HEIGHT - 2);
    }

    private void drawTop(Graphics g) {
        int width = model.getWidth();
        Coordinate start = new Coordinate(0, 0);
        Coordinate end = new Coordinate(width - 1, 0);
        g.drawLine(leftX(start), topY(start),
                rightX(end), topY(end));
    }

    private void drawLeft(Graphics g) {
        int height = model.getHeight();
        Coordinate start = new Coordinate(0, 0);
        Coordinate end = new Coordinate(0, height - 1);
        g.drawLine(leftX(start), topY(start),
                leftX(end), bottomY(end));
    }

    private static int leftX(Coordinate coord) {
        return MazeSettings.CELL_PADDING + (coord.getX() * MazeSettings.CELL_WIDTH);
    }

    private static int rightX(Coordinate coord) {
        return MazeSettings.CELL_PADDING + ((coord.getX() + 1) * MazeSettings.CELL_WIDTH);
    }

    private static int topY(Coordinate coord) {
        return MazeSettings.CELL_PADDING + (coord.getY() * MazeSettings.CELL_HEIGHT);
    }

    private static int bottomY(Coordinate coord) {
        return MazeSettings.CELL_PADDING + ((coord.getY() + 1) * MazeSettings.CELL_HEIGHT);
    }

}
