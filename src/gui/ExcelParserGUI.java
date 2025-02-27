package src.gui;

import src.services.ExcelParser;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ExcelParserGUI extends JFrame {
    private JButton button;
    private JButton exitButton;
    private JTextArea textArea;
    private ExcelParser excelParser;

    public ExcelParserGUI() {
        super("Excel Parser"); // Заголовок окна

        button = new JButton("Choose Excel File");
        exitButton =  new JButton("Exit");

        textArea = new JTextArea(20, 40);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        excelParser = new ExcelParser(textArea);

        button.addActionListener(e -> chooseFile()); // Выбор файла
        exitButton.addActionListener(e -> System.exit(0));

        JPanel panel = new JPanel();
        panel.add(button);
        panel.add(exitButton);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void chooseFile() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            excelParser.parseExcel(selectedFile); // Парсим Excel
        }
    }
}
