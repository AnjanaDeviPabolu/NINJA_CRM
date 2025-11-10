package ninja_CRM_Official;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import pageObjects.CampaignPage;
import pageObjects.CreateCampaignPage;
import pageObjects.HomePage;
import pageObjects.LoginPage_POM;
import utility_Files.ExcelUtilityFile;
import utility_Files.PropertiesUtilityFile;
import utility_Files.WebDriverUtility;

public class CreateCampaignWith_Status {

	public static void main(String[] args) throws IOException {
		
		//method from property utility file
		PropertiesUtilityFile propLib=new PropertiesUtilityFile();
		
		//method from Excel utility file
		ExcelUtilityFile ExceLib=new ExcelUtilityFile();
		
		//webdriver method from webdriver utility file
		WebDriverUtility wLib=new WebDriverUtility();
		
		//get common data from properties file
		 String BROWSER = propLib.getPropertiesUtilityFile("Browser");
		 String URL = propLib.getPropertiesUtilityFile("URl");
		 String USERNAME = propLib.getPropertiesUtilityFile("username");
		 String PASSWORD = propLib.getPropertiesUtilityFile("password");
		 
		 //get testScript data from Excel file
		 String CampaignName = ExceLib.getExcelUtilityFile("Create_Campaign", 4, 2);
		 String Status = ExceLib.getExcelUtilityFile("Create_Campaign", 4,3);
		 String TargetSize = ExceLib.getExcelUtilityFile("Create_Campaign", 4,4);
		 String AlertMsg = ExceLib.getExcelUtilityFile("Create_Campaign", 4, 5);
		 
		 //code for avoid chrome popup
		ChromeOptions settings = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		settings.setExperimentalOption("prefs", prefs);
		
		//launching WebDriver
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
		
		//maximize the browser
		driver.manage().window().maximize();
		
		//Global wait
		wLib.implicitlyWait(driver);
		
		//Login page page object class
		LoginPage_POM loginpagePOM=new LoginPage_POM(driver);
		
		//login action
		loginpagePOM.loginToApp(URL, USERNAME, PASSWORD);
		
		//campaign page object class
		CampaignPage campaignpage=new CampaignPage(driver);
		
		//create campaign page object class
		CreateCampaignPage createcampaignpage=new CreateCampaignPage(driver);
		
		//Home page object class
		HomePage homepage=new HomePage(driver);
		
		//click on create campaign button
		campaignpage.getGetAddCreateCampaignBtn().click();
		
		//create campaign Action
		createcampaignpage.getCampaignNameTF().sendKeys(CampaignName);
		createcampaignpage.getCampaignstatusTF().sendKeys(Status);
		createcampaignpage.getTargetsizeTF().sendKeys(TargetSize);
		createcampaignpage.getCreatecampaignBTn().click();
		
		//verification
		WebElement alertmsgtext = homepage.getToastMsg();
		wLib.waitUntilElementToBeVisible(driver, alertmsgtext);
		if(alertmsgtext.getText().contains(AlertMsg)) {
			System.out.println("campaign created");
		}
		else
		{
			System.out.println("campaign not created");
		}
		
		homepage.getToastCloseBtn().click();
		
		//log out Action
		homepage.logout();
		
		//Quit the Driver
		driver.quit();


	}

}
