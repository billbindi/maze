package maze.app;

import maze.Maze;
import maze.MazeFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MazeApp {

    private static final int WIDTH = 40;
    private static final int HEIGHT = 40;

    public static void main(String[] args) {
        Maze maze = MazeFactory.makeMaze(WIDTH, HEIGHT);
        maze.printMaze();

        MazePanel mazePanel = new MazePanel(maze);

        JPanel resetPanel = new JPanel();
        JButton reset = new JButton("Reset");
        resetPanel.add(reset);

        JFrame frame = new JFrame("Maze of DOOM!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(mazePanel.minWidth() + 15, mazePanel.minHeight() + resetPanel.getHeight() + 70);
        frame.setLocationRelativeTo(null);
        addListners(frame, mazePanel);

        frame.getContentPane().add(BorderLayout.CENTER, mazePanel);
        frame.getContentPane().add(BorderLayout.SOUTH, resetPanel);

        frame.setVisible(true);
    }

    private static void addListners(JFrame frame, MazePanel mazePanel) {
        mazePanel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // probably nothing
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        mazePanel.moveUp();
                        break;
                    case KeyEvent.VK_DOWN:
                        mazePanel.moveDown();
                        break;
                    case KeyEvent.VK_LEFT:
                        mazePanel.moveLeft();
                        break;
                    case KeyEvent.VK_RIGHT :
                        mazePanel.moveRight();
                        break;
                    case KeyEvent.VK_D:
                        System.out.println("D");
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // probably nothing
            }
        });
    }
}
