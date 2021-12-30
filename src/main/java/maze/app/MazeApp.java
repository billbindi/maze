package maze.app;

import maze.Maze;
import maze.MazeFactory;
import maze.util.MazeSettings;

import javax.swing.*;
import java.awt.*;

public class MazeApp extends JFrame {

    MazePanel mazePanel;
    MazeModel mazeModel;

    public MazeApp(String title) {
        super(title);

        Maze maze = MazeFactory.makeMaze(MazeSettings.WIDTH, MazeSettings.HEIGHT);
        mazeModel = new MazeModel(maze);
        mazePanel = new MazePanel(mazeModel);

        JScrollPane scrollPane = new JScrollPane(mazePanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(MazeSettings.VERTICAL_SCROLL_SPEED);
        scrollPane.getHorizontalScrollBar().setUnitIncrement(MazeSettings.HORIZONTAL_SCROLL_SPEED);

        JPanel resetPanel = new JPanel();
        JButton reset = new JButton("Reset");
        reset.addActionListener(l -> mazePanel.reset());
        resetPanel.add(reset);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(mazeModel.minWidth() + 15, mazeModel.minHeight() + resetPanel.getHeight() + 70);
        setLocationRelativeTo(null);
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);

        add(BorderLayout.SOUTH, resetPanel);
        add(BorderLayout.CENTER, scrollPane);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MazeApp("Maze of DOOM!");
    }
}
