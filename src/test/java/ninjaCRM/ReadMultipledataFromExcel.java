package ninjaCRM;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipledataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\pabol\\OneDrive\\Documents\\MobilePhonesList.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sheetval = wb.getSheet("MobileBrands");
		
		int lastnum = sheetval.getLastRowNum();
		
		System.out.println("No.of Rows:"+lastnum);
		
		for(int i=1;i<=lastnum;i++) {
			String cellval = sheetval.getRow(i).getCell(0).getStringCellValue();
			
			System.out.println(cellval);
		}
		
		
		

	}

}
