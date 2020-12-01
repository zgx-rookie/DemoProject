package com.zgx;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFName;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

public class ExcelTest {

    @Test
    public void copyExcel() throws Exception {
        String originalExcelPath = "d:\\excel\\original.xlsx";
        String targetExcelPath = "d:\\excel\\target.xlsx";
        FileInputStream originalStream = new FileInputStream(originalExcelPath);
        FileInputStream targetStream = new FileInputStream(targetExcelPath);
        XSSFWorkbook originalWorkbook = new XSSFWorkbook(originalStream);
        XSSFWorkbook targetWorkbook = new XSSFWorkbook(targetStream);
        SXSSFWorkbook sOriginalWorkbook = new SXSSFWorkbook(originalWorkbook);
        SXSSFWorkbook sTargetWorkbook = new SXSSFWorkbook(targetWorkbook);
        setValueAndStyleToSheet(originalExcelPath,sOriginalWorkbook, targetExcelPath,sTargetWorkbook);

    }

    private void setValueAndStyleToSheet(String originalExcelPath, SXSSFWorkbook sOriginalWorkbook, String targetExcelPath, SXSSFWorkbook sTargetWorkbook) throws Exception {
        /*if (null != sOriginalWorkbook.getSheet("Sheet1")) {
            sOriginalWorkbook.removeSheetAt(sOriginalWorkbook.getSheetIndex(sOriginalWorkbook.getSheet("Sheet1")));
        }*/
        //SXSSFSheet sheet1 = sOriginalWorkbook.createSheet("Sheet1");
        SXSSFSheet sheet1 = sOriginalWorkbook.getSheet("Sheet1");
        InputStream worksheetXMLInputStream = sheet1.getWorksheetXMLInputStream();
        /*for (int i = 0; i < 1000; i++) {
            SXSSFRow row = sheet1.createRow(i);
            for (int j = 0; j < 20; j++) {
                SXSSFCell cell = row.createCell(j);
                cell.setCellValue(i * j + "tll");
                CellStyle cellStyle = cell.getSheet().getWorkbook().createCellStyle();
                cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                if (j % 2 == 0) {
                    cellStyle.setFillForegroundColor(IndexedColors.RED1.index);
                }else if(j % 3 == 0) {
                    cellStyle.setFillForegroundColor(IndexedColors.YELLOW1.index);
                } else {
                    cellStyle.setFillForegroundColor(IndexedColors.PINK.index);
                }
                cell.setCellStyle(cellStyle);
            }
        }*/
//        FileOutputStream fileOutputStream = new FileOutputStream(originalExcelPath);
        /*if (null != sTargetWorkbook.getSheet("Sheet1")) {
            sTargetWorkbook.removeSheetAt(sOriginalWorkbook.getSheetIndex(sOriginalWorkbook.getSheet("Sheet1")));
        }*/

        FileOutputStream fileOutputStream = new FileOutputStream(targetExcelPath);
        worksheetXMLInputStream.transferTo(fileOutputStream);
        // FileOutputStream fileOutputStream1 = new FileOutputStream(worksheetXMLInputStream);

        sTargetWorkbook.write(fileOutputStream);
        /*sOriginalWorkbook.write(fileOutputStream);
        fileOutputStream.close();
        sOriginalWorkbook.close();*/
    }
}
