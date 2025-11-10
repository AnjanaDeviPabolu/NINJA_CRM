package ninjaCRM;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataBackToExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\pabol\\OneDrive\\Documents\\MobilePhonesList.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sheetname = wb.getSheet("MobileBrands");
		
		Row rownum = sheetname.getRow(2);
		
		Cell cellval = rownum.createCell(1, CellType.STRING);
		
		cellval.setCellValue("Redmi Pro");
		
		FileOutputStream fos=new FileOutputStream("C:\\Users\\pabol\\OneDrive\\Documents\\MobilePhonesList.xlsx");
		
		wb.write(fos);
		
		wb.close();

	}

}
