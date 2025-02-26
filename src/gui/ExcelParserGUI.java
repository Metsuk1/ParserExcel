package src.gui;

import javax.swing.*;

public class ExcelParserGUI {
    private JFrame frame;
    private JButton button;

    public ExcelParserGUI() {
        frame = new JFrame("Excel Parser");
        button = new JButton("Choose Excel File");

        button.addActionListener(new FileChooserListener(frame));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);

        frame.add(button);
        frame.setVisible(true);
    }

}
