package utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class CommonMethods {
WebDriver driver;
static XSSFRow row;
static XSSFWorkbook workBook;
static XSSFSheet sheet;

	public CommonMethods(WebDriver driver){
		this.driver=driver;
	}
	
	public String readData(String sSheetName, int rowNumber, int columnNumber) throws Exception {
		String sCellValue = null;
		FileInputStream fis = new FileInputStream(new File("data\\Input.xlsx"));

		workBook = new XSSFWorkbook(fis);
		sheet = workBook.getSheet(sSheetName);

		row = sheet.getRow(rowNumber);

		System.out.println(row.getCell(columnNumber).getStringCellValue());
		sCellValue = row.getCell(columnNumber).getStringCellValue();
		fis.close();
		return sCellValue;
	}
	
	public static void createSheet(String sSheetName) {

		workBook = new XSSFWorkbook();
		sheet = workBook.createSheet(sSheetName);
		int lastRownumber = sheet.getLastRowNum();
		row = sheet.createRow(lastRownumber);
		row.createCell(0).setCellValue("SNO");
		row.createCell(1).setCellValue("Step Description");
		row.createCell(2).setCellValue("Expected Value");
		row.createCell(3).setCellValue("Result");

	}

	public static void enterData(String sDescription, String Expected, String Result) {

		int lastRownumber = sheet.getLastRowNum();

		row = sheet.createRow(lastRownumber + 1);

		row.createCell(0).setCellValue(lastRownumber+1);
		row.createCell(1).setCellValue(sDescription);
		row.createCell(2).setCellValue(Expected);
		row.createCell(3).setCellValue(Result);

	}

	public static void createReport(String sWorkbookName) throws Exception {

		FileOutputStream fos = new FileOutputStream(
				new File("data\\" + sWorkbookName + ".xlsx"));

		workBook.write(fos);

		workBook.close();
	}


	
	
}

