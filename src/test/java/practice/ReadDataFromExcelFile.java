package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// Step 1 : Open the Doc in java read format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");

		// Step 2 : Create a WorkBook
		Workbook wb = WorkbookFactory.create(fis);

		// Step 3: Navigate to Sheet
		Sheet sh = wb.getSheet("Contact");

		// Step 4 : Navigate to row
		Row rw = sh.getRow(1);

		// Step 5: Navigate to cell
		Cell cl = rw.getCell(2);

		// Step 6 : Capture the data
		String value = cl.getStringCellValue();
		System.out.println(value);

		// close the workbook
		wb.close();

	}
}
