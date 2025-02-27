package src.services;

import java.io.File;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelParser {
    private JTextArea textArea;

    public ExcelParser(JTextArea textArea) {
        this.textArea = textArea;
    }

    public void parseExcel(File file) {
        textArea.setText("");
        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                StringBuilder rowText = new StringBuilder();

                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    rowText.append(cell.toString()).append(" | ");
                }

                textArea.append(rowText.toString() + "\n");
            }
        } catch (IOException e) {
            textArea.setText("Error upon reading file: " + e.getMessage());
        }
    }
}
