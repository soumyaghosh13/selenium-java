package com.HRA.helper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private ExcelUtils() {

	}

	private static XSSFSheet excelInputWSheet;
	private static XSSFWorkbook excelInputWBook;
	private static XSSFRow inputRow;
	private static XSSFCell inputCell;

	// This method is to set the File path and to open the Excel file
	// Pass Excel Path and SheetName as Arguments to this method
	public static void setInputExcelFile(String filePath) {
		try (FileInputStream excelFile = new FileInputStream(filePath)) {

			excelInputWBook = new XSSFWorkbook(excelFile);
		} catch (Exception e) {
			System.out.println("Class ExcelUtils | Method setInputExcelFile | Exception desc : " + e.getMessage());
		}

	}

	// This method is to set the File path and to open the Excel file
	// Pass Excel Path and SheetName as Arguments to this method
	public static void setExcelFile(String filePath) {
		try (FileInputStream excelFile = new FileInputStream(filePath)) {
			excelInputWBook = new XSSFWorkbook(excelFile);
		} catch (Exception e) {
			System.out.println("Class ExcelUtils | Method setExcelFile | Exception desc : " + e.getMessage());

		}

	}

	// This method is to read the test data from the Excel cell
	// In this we are passing parameters/arguments as Row Num and Col Num
	public static String getCellData(int rowNum, int colNum, String sheetName) {
		try {
			excelInputWSheet = excelInputWBook.getSheet(sheetName);
			inputCell = excelInputWSheet.getRow(rowNum).getCell(colNum);

			if (inputCell == null)
				return "";

			if (inputCell.getCellType().equals(CellType.STRING)) {
				return inputCell.getStringCellValue();
			} else if (inputCell.getCellType().equals(CellType.NUMERIC)
					|| inputCell.getCellType().equals(CellType.FORMULA)) {
				return String.valueOf((int) inputCell.getNumericCellValue());
			} else if (inputCell.getCellType().equals(CellType.BLANK)) {
				return "";
			} else {
				return String.valueOf(inputCell.getBooleanCellValue());
			}

		} catch (Exception e) {
			if (e.getMessage() == null) {
				return "";
			} else {
				
				return "";
			}

		}
	}

	// This method is to get the row count used of the excel sheet
	public static int getRowCount(String sheetName) {
		int iNumber = 0;
		try {
			excelInputWSheet = excelInputWBook.getSheet(sheetName);
			iNumber = excelInputWSheet.getLastRowNum() + 1;
		} catch (Exception e) {
			System.out.println("Class ExcelUtils | Method getRowCount | Exception desc : " + e.getMessage());

		}
		return iNumber;
	}

	// get Column count
	public static int getColumnCount(String sheetName) {
		int iNumber = 0;
		try {
			excelInputWSheet = excelInputWBook.getSheet(sheetName);
			iNumber = excelInputWSheet.getRow(0).getLastCellNum();
		} catch (Exception e) {
			System.out.println("Class ExcelUtils | Method getRowCount | Exception desc : " + e.getMessage());

		}
		return iNumber;
	}

	// get Column Number

	public static int getColumnNum(String sheetName, String str) {
		int iNumber = 0;
		try {
			excelInputWSheet = excelInputWBook.getSheet(sheetName);
			for (iNumber = 0; iNumber < excelInputWSheet.getRow(0).getLastCellNum(); iNumber++) {
				if (excelInputWSheet.getRow(0).getCell(iNumber).getStringCellValue().equals(str))
					break;
			}

		} catch (Exception e) {
			System.out.println("Class ExcelUtils | Method getRowCount | Exception desc : " + e.getMessage());

		}

		if (iNumber == excelInputWSheet.getRow(0).getLastCellNum())
			return -1;
		else
			return iNumber;
	}

	// //This method is use to write value in the excel sheet
	// //This method accepts four arguments (Result, Row Number, Column Number &
	// Sheet Name)
	public static void setCellData(String result, int rowNum, int colNum, String sheetName) {
		try {
			excelInputWSheet = excelInputWBook.getSheet(sheetName);
			inputRow = excelInputWSheet.getRow(rowNum);

			if (inputRow == null) {
				inputRow = excelInputWSheet.createRow(rowNum);
			}
			inputCell = inputRow.getCell(colNum, MissingCellPolicy.RETURN_BLANK_AS_NULL);
			if (inputCell == null) {
				inputCell = inputRow.createCell(colNum);
				inputCell.setCellValue(result);
			} else {
				inputCell.setCellValue(result);
			}

		} catch (Exception e) {
			System.out.println("Class ExcelUtils | Method setCellData | Exception desc : " + e.getMessage());
		}

	}

	// public static void setTextCenter(int rowNum, int colNum, String
	// sheetName){
	public static void setRedColor(int rowNum, int colNum, String sheetName) {
		try {

			excelInputWSheet = excelInputWBook.getSheet(sheetName);
			inputRow = excelInputWSheet.getRow(rowNum);
			inputCell = inputRow.getCell(colNum, MissingCellPolicy.RETURN_BLANK_AS_NULL);

			// inputCell.set

			// Get access to HSSFCellStyle
			XSSFCellStyle cellStyle = excelInputWBook.createCellStyle();
			// We will now specify a background cell color
			// cellStyle.setFillPattern(FillPatternType.FINE_DOTS );
			cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

			// cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
			// cellStyle.setFillBackgroundColor(IndexedColors.RED.getIndex());
			cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());

			inputCell.setCellStyle(cellStyle);

			// Constant variables Test Data path and Test Data file name
			/*
			 * FileOutputStream fileOut = new
			 * FileOutputStream(Constants.RATING_DATA_FILE);
			 * excelInputWBook.write(fileOut); fileOut.flush(); fileOut.close();
			 * excelInputWBook = new XSSFWorkbook(new
			 * FileInputStream(Constants.RATING_DATA_FILE));
			 */
		} catch (Exception e) {
			System.out.println("Class ExcelUtils | Method setTextCenter | Exception desc : " + e.getMessage());

		}
	}

	public static void createExcel(Object[] header, String filePath, String sheetName) throws IOException {
		try (XSSFWorkbook workbook = new XSSFWorkbook()) {
			XSSFSheet sheet = workbook.createSheet(sheetName);
			XSSFRow row;
			XSSFCell cell;

			int rowCount = 0;

			row = sheet.createRow(rowCount);

			int columnCount = 0;

			for (Object o : header) {
				cell = row.createCell(columnCount++);
				if (o instanceof String) {
					cell.setCellValue((String) o);
				} else if (o instanceof Integer) {
					cell.setCellValue((Integer) o);
				}
			}

			try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
				workbook.write(outputStream);
			}
		} catch (Exception e) {
			System.out.println("Failed to create new excel file.");
		}

	}

	public static void closeWorkbook() {
		try {
			excelInputWBook.close();
		} catch (IOException e) {
			System.out.println("Failed to close the work book");
		}
	}

	public static void writeWorkbook(FileOutputStream fileOut) {
		try {
			excelInputWBook.write(fileOut);
		} catch (IOException e) {
			System.out.println("Class ExcelUtils | Method writeWorkbook | Exception desc : " + e.getMessage());
		}
	}

}
