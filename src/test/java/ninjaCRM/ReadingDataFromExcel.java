package ninjaCRM;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.common.collect.Table.Cell;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
//		FileInputStream fis=new FileInputStream("C:\\Users\\pabol\\OneDrive\\Documents\\ninjaCRM.xlsx");
//		
//		Workbook wb=WorkbookFactory.create(fis);
//		
//		Sheet sh=wb.getSheet("Sheet1");
//		
//		Row rw=sh.getRow(1);
//		
//		org.apache.poi.ss.usermodel.Cell cl = rw.getCell(2);
//		
//		String campaignName = cl.getStringCellValue();
//		
//		System.out.println(campaignName);
//		
//		wb.close();
//		
//		//reading data with the help of Method chaining
//		org.apache.poi.ss.usermodel.Cell clvalue = wb.getSheet("Sheet1").getRow(1).getCell(3);
//		
//		String cellvaluefromMC = clvalue.getStringCellValue();
//		
//		System.out.println(cellvaluefromMC);
		

		FileInputStream fis=new FileInputStream("C:\\Users\\pabol\\OneDrive\\Documents\\ninjaCRM.xlsx");
		
		Workbook wb=WorkbookFactory.create(fis);
		
		Sheet sh=wb.getSheet("Sheet1");
		
		Row rw=sh.getRow(2);
		
		org.apache.poi.ss.usermodel.Cell cl = rw.getCell(2);
		
		String cellvalue = cl.getStringCellValue();
		
		System.out.println(cellvalue);
		
		org.apache.poi.ss.usermodel.Cell secondcell = wb.getSheet("sheet1").getRow(2).getCell(3);
		
		String secondcellval = secondcell.getStringCellValue();
		
		System.out.println(secondcellval);
		
		wb.close();
		
		//FileInputStream fisi=new FileInputStream(System.getProperty("user-dir")+"/src/test/resources/NinjaData.properties")

	}

}
