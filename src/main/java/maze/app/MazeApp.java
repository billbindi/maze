package maze.app;

import maze.Maze;
import maze.MazeFactory;
import maze.util.MazeSettings;

import javax.swing.*;
import java.awt.*;

public class MazeApp extends JFrame {

    private static MazeApp mazeApp;

    public MazeApp(String title, int width, int height) {
        super(title);

        Maze maze = MazeFactory.makeMaze(width, height);
        MazeModel mazeModel = new MazeModel(maze);
        MazePanel mazePanel = new MazePanel(mazeModel);

        JScrollPane scrollPane = new JScrollPane(mazePanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(MazeSettings.VERTICAL_SCROLL_SPEED);
        scrollPane.getHorizontalScrollBar().setUnitIncrement(MazeSettings.HORIZONTAL_SCROLL_SPEED);

        JPanel actionPanel = new MazeActionPanel(mazePanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int pixelWidth = Math.max(mazeModel.minWidth() + 25, MazeSettings.MIN_WIDTH_PIXELS);
        int pixelHeight = Math.max(mazeModel.minHeight() + actionPanel.getHeight() + 80, MazeSettings.MIN_HEIGHT_PIXELS);
        setSize(pixelWidth, pixelHeight);
        if (width >= 80 || height >= 50) {
            setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        } else {
            setLocationRelativeTo(null);
        }

        add(BorderLayout.SOUTH, actionPanel);
        add(BorderLayout.CENTER, scrollPane);
        setVisible(true);
    }

    public static void start(int width, int height) {
        mazeApp.setVisible(false);
        mazeApp = new MazeApp(MazeSettings.TITLE, width, height);
    }

    public static void main(String[] args) {
        mazeApp = new MazeApp(MazeSettings.TITLE, MazeSettings.STARTING_WIDTH, MazeSettings.STARTING_HEIGHT);
    }
}
