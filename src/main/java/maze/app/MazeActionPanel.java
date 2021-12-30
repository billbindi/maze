package maze.app;

import javax.swing.*;

public class MazeActionPanel extends JPanel {

    public MazeActionPanel(MazePanel mazePanel) {
        super();

        JButton reset = new JButton("Reset");
        reset.addActionListener(l -> mazePanel.reset());
        add(reset);

        JButton easy = new JButton("Easy");
        easy.addActionListener(l -> MazeApp.start(15, 10));
        add(easy);

        JButton medium = new JButton("Medium");
        medium.addActionListener(l -> MazeApp.start(20, 20));
        add(medium);

        JButton hard = new JButton("Hard");
        hard.addActionListener(l -> MazeApp.start(81, 49));
        add(hard);
    }
}
