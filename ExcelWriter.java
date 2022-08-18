package com.HRA.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {

    public void writeExcel(String filePath,String fileName,String sheetName,String[] dataToWrite) throws IOException{
        File file =    new File(filePath+"\\"+fileName);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = null;
        String fileExtensionName = fileName.substring(fileName.indexOf("."));
        if(fileExtensionName.equals(".xlsx")){
        workbook = new XSSFWorkbook(inputStream);
        }
        else if(fileExtensionName.equals(".xls")){
            workbook = new HSSFWorkbook(inputStream);
        }
        Sheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
        Row row = sheet.getRow(0);
        Row newRow = sheet.createRow(rowCount+1);
        for(int j = 0; j < row.getLastCellNum(); j++){
            Cell cell = newRow.createCell(j);
            cell.setCellValue(dataToWrite[j]);
        }
        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(file);
        workbook.write(outputStream);
        outputStream.close();
    }
    
    public boolean removeRowExcel(String filePath,String fileName,String sheetName, int rowNo) throws IOException{
        File file =    new File(filePath+"\\"+fileName);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = null;
        String fileExtensionName = fileName.substring(fileName.indexOf("."));
        if(fileExtensionName.equals(".xlsx")){
        workbook = new XSSFWorkbook(inputStream);
        }
        else if(fileExtensionName.equals(".xls")){
            workbook = new HSSFWorkbook(inputStream);
        }
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            return false;
        }
        int lastRowNum = sheet.getLastRowNum();
        if (rowNo >= 0 && rowNo < lastRowNum) {
            sheet.shiftRows(rowNo + 1, lastRowNum, -1);
        }
        if (rowNo == lastRowNum) {
            Row removingRow=sheet.getRow(rowNo);
            if(removingRow != null) {
                sheet.removeRow(removingRow);
            }
        }
        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(file);
        workbook.write(outputStream);
        outputStream.close();
		return false;
    }
}