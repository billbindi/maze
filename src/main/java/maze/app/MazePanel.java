package maze.app;

import maze.util.Coordinate;
import maze.util.MazeSettings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class MazePanel extends JPanel {

    private final MazeModel model;

    public MazePanel(MazeModel model) {
        this.model = model;
        setBorder(BorderFactory.createLineBorder(MazeSettings.BORDER_COLOR));
        setBackground(MazeSettings.BACKGROUND_COLOR);

        keyBindings();
        reset();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawWalls(g);
        drawExit(g);
        drawPlayerPath(g);

        if (model.isSolved()) {
            drawSolution(g);

        } else {
            drawPlayer(g);
        }
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
        if (coord.equals(model.getExit())) {
            model.setSolved(true);
        }
        repaint();
    }

    private void drawPlayerPath(Graphics g) {
        List<Coordinate> playerPath = model.getPlayerSteps();
        g.setColor(MazeSettings.PLAYER_PATH_COLOR);
        drawPath(g, playerPath, 1);
    }

    private void drawSolution(Graphics g) {
        g.setColor(MazeSettings.SOLVE_PATH_COLOR);
        List<Coordinate> solution = model.solve();
        drawPath(g, solution, -1);
    }

    private void drawPath(Graphics g, List<Coordinate> path, int offset) {
        for (int i = 0; i < path.size() - 1; i++) {
            Coordinate first = path.get(i);
            Coordinate second = path.get(i + 1);
            g.drawLine(centerX(first) + offset, centerY(first) + offset, centerX(second) + offset, centerY(second) + offset);
        }
    }

    private void drawWalls(Graphics g) {
        g.setColor(MazeSettings.WALL_COLOR);
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
        g.setColor(MazeSettings.PLAYER_COLOR);
        Coordinate player = model.getPlayer();
        g.fillRect(leftX(player) + 2, topY(player) + 2, MazeSettings.CELL_WIDTH - 4, MazeSettings.CELL_HEIGHT - 4);
    }

    private void drawExit(Graphics g) {
        g.setColor(MazeSettings.EXIT_COLOR);
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

    private static int centerX(Coordinate coord) {
        return leftX(coord) + (MazeSettings.CELL_WIDTH / 2);
    }

    private static int centerY(Coordinate coord) {
        return topY(coord) + (MazeSettings.CELL_HEIGHT / 2);
    }
}
