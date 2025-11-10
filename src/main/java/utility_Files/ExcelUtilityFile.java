package utility_Files;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilityFile {

	public String getExcelUtilityFile(String SheetName, int RowNumber, int ColumnNumber) throws EncryptedDocumentException, IOException {
		
		FileInputStream fisi=new FileInputStream("./src/test/resources/ninjaCRM.xlsx");
		Workbook wb = WorkbookFactory.create(fisi);
		String data = wb.getSheet(SheetName).getRow(RowNumber).getCell(ColumnNumber).getStringCellValue();
		wb.close();
		return data;

	}

}
