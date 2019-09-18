package com.netbuilder.test.common.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class ExcelSpreadsheetReader {

    public static String readCategorySpreadsheet(String category) {
        try {
            FileInputStream file = new FileInputStream(new File(System.getProperty("category-data-path")));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell.getStringCellValue().equals(category)) {
                        return cellIterator.next().getStringCellValue();
                    }
                }
                file.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       return "CHECK DATA SPREADSHEET";
    }
}
