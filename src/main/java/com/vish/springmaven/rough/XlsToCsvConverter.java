package com.vish.springmaven.rough;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.*;
import java.util.Iterator;
import java.util.Objects;

public class XlsToCsvConverter {

   private static void xls(File inputFile, File outputFile) throws IOException {

        // For storing data into CSV files
        StringBuilder data = new StringBuilder();
        FileOutputStream fos = null;
        XSSFWorkbook workbook = null;
        try
        {
            fos = new FileOutputStream(outputFile);

            // Get the workbook object for XLS file
            workbook = new XSSFWorkbook(new FileInputStream(inputFile));
            // Get first sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
            Cell cell;
            Row row;

            // Iterate through each rows from first sheet
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext())
            {
                row = rowIterator.next();
                // For each row, iterate through each columns
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    cell = cellIterator.next();
                    data.append(cell.getStringCellValue() + ",");
                }
                data.append('\n');
            }

            fos.write(data.toString().getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(Objects.nonNull(fos)){
                fos.close();
            }
            if(Objects.nonNull(workbook)) {
                workbook.close();
            }
        }
    }

    private static void xlsx(File inputFile, File outputFile) throws IOException {

        // For storing data into CSV files
        StringBuilder data = new StringBuilder();
        FileOutputStream fos = null;
        Workbook workbook = null;
        try {
            fos = new FileOutputStream(outputFile);

            // Get the workbook object for XLS file
            workbook = WorkbookFactory.create(inputFile);
            // Get first sheet from the workbook
            Sheet sheet = workbook.getSheetAt(0);
            Cell cell;
            Row row;

            // Iterate through each rows from first sheet
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext())
            {
                row = rowIterator.next();
                // For each row, iterate through each columns
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    cell = cellIterator.next();
                    data.append(cell.getStringCellValue() + ",");
                }
                data.append('\n');
            }

            fos.write(data.toString().getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(Objects.nonNull(fos)){
                fos.close();
            }
            if(Objects.nonNull(workbook)) {
                workbook.close();
            }
        }
    }


    public static void main(String[] args) throws IOException {
        File inputFile = new File("C:\\Users\\visweswara.pepala\\workspace\\Rough\\test1.xls");
        File outputFile = new File("C:\\Users\\visweswara.pepala\\workspace\\Rough\\output2.csv");
        xlsx(inputFile, outputFile);
    }
}
