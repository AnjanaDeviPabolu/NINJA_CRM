package ninjaCRM;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.LoginPage_POM;
import utility_Files.WebDriverUtility;

public class CC_GetDataFromExcel {

	public static void main(String[] args) throws IOException {

		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Ninjadata.properties");
		
		Properties prop=new Properties();
		
		prop.load(fis);
		
		FileInputStream fisi=new FileInputStream("C:\\Users\\pabol\\OneDrive\\Documents\\ninjaCRM.xlsx");
		
		Workbook wb=WorkbookFactory.create(fisi);
		
		Cell secondcell = wb.getSheet("Sheet1").getRow(2).getCell(2);
		
		Cell targetSizes = wb.getSheet("Sheet1").getRow(2).getCell(3);
		
		String secondcellval = secondcell.getStringCellValue();
		
		String targetSizeVal = targetSizes.getStringCellValue();

		String BROWSER = prop.getProperty("Browser");
		
		String URL = prop.getProperty("URl");
		
		String USERNAME = prop.getProperty("username");
		
		String PASSWORD = prop.getProperty("password");

		ChromeOptions settings = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		settings.setExperimentalOption("prefs", prefs);
		
		WebDriverUtility wLib=new WebDriverUtility();
		
		WebDriver driver=null;
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver(settings);
		}
		else if(BROWSER.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		
		wLib.implicitlyWait(driver);
		
//		driver.get(URL);
//		
//		driver.findElement(By.id("username")).sendKeys(USERNAME);
//		
//		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
//		
//		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		//login
		LoginPage_POM loginPage=new LoginPage_POM(driver);
		loginPage.loginToApp(URL, USERNAME, PASSWORD);
		
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		
		driver.findElement(By.name("campaignName")).sendKeys(secondcellval);
		
		WebElement targetSize = driver.findElement(By.name("targetSize"));
		
		driver.findElement(By.xpath("//input[@name='campaignStatus']")).sendKeys("Active");
		
		targetSize.clear();
		
		targetSize.sendKeys(targetSizeVal);
		
		Date date=new Date();
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		
		sdf.format(date);
		
		Calendar cal=sdf.getCalendar();
		
		cal.add(Calendar.DAY_OF_MONTH, 10);
		
		String requiredtime = sdf.format(cal.getTime());
		
		driver.findElement(By.xpath("//input[@name='expectedCloseDate']")).sendKeys(requiredtime);
		
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		
		WebElement alertmsg = driver.findElement(By.xpath("//div[@role='alert']"));
		
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
//		
//		wait.until(ExpectedConditions.visibilityOf(alertmsg));
		
		wLib.waitUntilElementToBeVisible(driver, alertmsg);
		
		if(alertmsg.getText().contains("Successfully Added")) {
			System.out.println("campaign created");
		}
		else
		{
			System.out.println("campaign not created");
		}
		
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		
//		Actions act=new Actions(driver);
//		
//		WebElement usericon = driver.findElement(By.xpath("//div[@class='user-icon']"));
//		
//		act.moveToElement(usericon).perform();
//		
//		driver.findElement(By.xpath("//div[text()='Logout ']")).click();
		
		WebElement usericon = driver.findElement(By.xpath("//div[@class='user-icon']"));
		wLib.mouseHoverOnWebElement(driver, usericon);
		 WebElement logoutBtn = driver.findElement(By.xpath("//div[text()='Logout ']"));
		 wLib.clickOnWebElement(driver, logoutBtn);
		
		driver.quit();


	}

}
