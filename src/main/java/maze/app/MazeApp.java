package maze.app;

import maze.Maze;
import maze.MazeFactory;
import maze.util.Coordinate;

import javax.swing.*;
import java.awt.*;

public class MazeApp extends JFrame {

    private static final int WIDTH = 125;
    private static final int HEIGHT = 75;

    MazePanel mazePanel;

    public MazeApp(String title) {
        super(title);

        Maze maze = MazeFactory.makeMaze(WIDTH, HEIGHT);
        maze.printMaze();

        mazePanel = new MazePanel(maze);

        JScrollPane scrollPane = new JScrollPane(mazePanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        scrollPane.getHorizontalScrollBar().setUnitIncrement(10);

        JPanel resetPanel = new JPanel();
        JButton reset = new JButton("Reset");
        reset.addActionListener(l -> mazePanel.reset());
        resetPanel.add(reset);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(mazePanel.minWidth() + 15, mazePanel.minHeight() + resetPanel.getHeight() + 70);
        setLocationRelativeTo(null);
//        add(BorderLayout.CENTER, mazePanel);
        add(BorderLayout.SOUTH, resetPanel);
        add(BorderLayout.CENTER, scrollPane);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MazeApp("Maze of DOOM!");
    }
}
