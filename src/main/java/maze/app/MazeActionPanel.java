package maze.app;

import javax.swing.*;

public class MazeActionPanel extends JPanel {

    public MazeActionPanel() {
        super();

        JButton easy = new JButton("Easy");
        easy.addActionListener(l -> MazeApp.start(15, 10));
        add(easy);

        JButton medium = new JButton("Medium");
        medium.addActionListener(l -> MazeApp.start(20, 20));
        add(medium);

        JButton hard = new JButton("Hard");
        hard.addActionListener(l -> MazeApp.start(81, 49));
        add(hard);

        JButton custom = new JButton("Custom");
        custom.addActionListener(l -> {
            JTextField widthField = new JTextField(5);
            JTextField heightField = new JTextField(5);

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
