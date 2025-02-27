package src.gui;
import src.services.ExcelParser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileChooserListener implements ActionListener {
    private JFrame frame;
    private ExcelParser excelParser;

    public FileChooserListener(JFrame frame) {
        this.frame = frame;
        this.excelParser = excelParser;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int res = fileChooser.showOpenDialog(frame);
        if (res == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + file.getAbsolutePath());
            excelParser.parseExcel(file);
        }
    }

}
