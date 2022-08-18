package com.HRA.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelReader {

	static WebDriver driver = Driver.getDriver();
    public static List<String> excelDataInList =new ArrayList<String>();

    public static void readExcel(String filePath, String fileName, String sheetName) throws IOException {
    	 //WebDriver driver = Driver.getDriver();
        File file = new File(filePath + "\\" + fileName);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workBook = null;
        String fileExtensionName = fileName.substring(fileName.indexOf("."));


        if (fileExtensionName.equals(".xlsx")) {
            workBook = new XSSFWorkbook(inputStream);
        } else if (fileExtensionName.equals(".xls")) {
            workBook = new HSSFWorkbook(inputStream);
        }
        Sheet sheet = workBook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        for (int i = 0; i < rowCount + 1; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                //System.out.print(row.getCell(j).getStringCellValue() + "|| ");
                excelDataInList.add(row.getCell(j).getStringCellValue());
            }
           
        }
        System.out.println(excelDataInList);
        
    }
}