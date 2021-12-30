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

            while (true) {
                int result = JOptionPane.showConfirmDialog(null, sizePanel,
                        "Please enter width and height values.", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    try {
                        int width = Integer.parseInt(widthField.getText());
                        int height = Integer.parseInt(heightField.getText());
                        if (width > 0 && height > 0) {
                            MazeApp.start(width, height);
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "Please enter a POSITIVE integer for BOTH width and height.", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid integer for width and height.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (result == JOptionPane.CANCEL_OPTION) {
                    break;
                }
            }
        });
        add(custom);
    }

    public boolean isValidSize(String input) {
        return input.matches("\\d+") && Integer.parseInt(input) > 0;
    }
}
