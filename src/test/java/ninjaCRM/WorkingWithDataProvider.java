package ninjaCRM;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage_POM;
import utility_Files.ExcelUtilityFile;

public class WorkingWithDataProvider {

	@Test(dataProvider = "loginDetails")
	public void login(String username,String password) {
		
		ChromeOptions settings = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		settings.setExperimentalOption("prefs", prefs);
		
		WebDriver driver=new ChromeDriver(settings);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage_POM loginPage=new LoginPage_POM(driver);
		loginPage.loginToApp("http://49.249.28.218:8098/", username, password);
	
		pageObjects.HomePage homePage=new pageObjects.HomePage(driver);
		homePage.logout();
		driver.quit();
	}
	
	@DataProvider
	public  Object[][] loginDetails() throws EncryptedDocumentException, IOException {
		
		Object [][] objArr=new Object[5][2];	
//		objArr[0][0]="rmgyantra";
//		objArr[0][1]="rmgy@9999";
//		objArr[1][0]="rmgyantra";
//		objArr[1][1]="rmgy@9999";
//		objArr[2][0]="rmgyantra";
//		objArr[2][1]="rmgy@9999";
//		objArr[3][0]="rmgyantra";
//		objArr[3][1]="rmgy@9999";
//		objArr[4][0]="rmgyantra";
//		objArr[4][1]="rmgy@9999";
//		
//		return objArr;
		
		ExcelUtilityFile eLib=new ExcelUtilityFile();
		
		for(int i=1;i<=5;i++) {
			objArr[i-1][0]=eLib.getExcelUtilityFile("DataProvider", i, 0);
			objArr[i-1][1]=eLib.getExcelUtilityFile("DataProvider", i, 1);
		}
	
		return objArr;
	}
}