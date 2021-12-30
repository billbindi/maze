package maze.app;

import maze.util.MazeSettings;

import javax.swing.*;

public class MazeActionPanel extends JPanel {

    public MazeActionPanel() {
        super();

        JButton easy = new JButton("Easy");
        easy.addActionListener(l -> MazeApp.start(MazeSettings.EASY_WIDTH, MazeSettings.EASY_HEIGHT));
        add(easy);

        JButton medium = new JButton("Medium");
        medium.addActionListener(l -> MazeApp.start(MazeSettings.MEDIUM_WIDTH, MazeSettings.MEDIUM_HEIGHT));
        add(medium);

        JButton hard = new JButton("Hard");
        hard.addActionListener(l -> MazeApp.start(MazeSettings.HARD_WIDTH, MazeSettings.HARD_HEIGHT));
        add(hard);

        JButton custom = new JButton("Custom");
        custom.addActionListener(l -> {
            JTextField widthField = new JTextField(3);
            JTextField heightField = new JTextField(3);

            JPanel sizePanel = new JPanel();
            sizePanel.add(new JLabel("width:"));
            sizePanel.add(widthField);
            sizePanel.add(Box.createHorizontalStrut(15)); // a spacer
            sizePanel.add(new JLabel("height:"));
            sizePanel.add(heightField);

            int result = JOptionPane.showConfirmDialog(null, sizePanel,
                    "Please enter width and height values.", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                int width = Integer.parseInt(widthField.getText());
                int height = Integer.parseInt(heightField.getText());
                MazeApp.start(width, height);
            }
        });
        add(custom);
    }
}
