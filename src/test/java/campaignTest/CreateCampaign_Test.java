package campaignTest;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import pageObjects.CampaignPage;
import pageObjects.CreateCampaignPage;
import pageObjects.HomePage;
import pageObjects.LoginPage_POM;
import utility_Files.ExcelUtilityFile;
import utility_Files.JavaUtilityFile;
import utility_Files.PropertiesUtilityFile;
import utility_Files.WebDriverUtility;

@Listeners(genericUtilities.ListenerImplementation.class)

public class CreateCampaign_Test extends BaseClass{
	
	@Test(groups = {"smoke","regression"})
	public void CreateCampaign_With_MandatoryFields_Test() throws EncryptedDocumentException, IOException {

		String CampaignName = ExceLib.getExcelUtilityFile("Create_Campaign", 1, 2);
		String TargetSize = ExceLib.getExcelUtilityFile("Create_Campaign", 1,3);
		String AlertMsg = ExceLib.getExcelUtilityFile("Create_Campaign", 1, 4);
		
		CampaignPage campaignpage=new CampaignPage(driver);

		CreateCampaignPage createcampaignpage=new CreateCampaignPage(driver);

		HomePage homepage=new HomePage(driver);

		campaignpage.getGetAddCreateCampaignBtn().click();

		createcampaignpage.getCampaignNameTF().sendKeys(CampaignName);
//		createcampaignpage.getTargetsizeTF().clear();
		createcampaignpage.getTargetsizeTF().sendKeys(TargetSize);
		createcampaignpage.getCreatecampaignBTn().click();

		WebElement alertmsgtext = homepage.getToastMsg();
		wLib.waitUntilElementToBeVisible(driver, alertmsgtext);
		String msg = alertmsgtext.getText();
		
		Assert.assertTrue(msg.contains(AlertMsg));
		
//		if(alertmsgtext.getText().contains(AlertMsg)) {
//			System.out.println("campaign created");
//		}
//		else
//		{
//			System.out.println("campaign not created");
//		}	
		
		homepage.getToastCloseBtn().click();
		 

	}
	
	
	@Test(groups = "smoke")
	public void CreateCampaign_With_status_Test() throws IOException {

		String CampaignName = ExceLib.getExcelUtilityFile("Create_Campaign", 4, 2);
		String Status = ExceLib.getExcelUtilityFile("Create_Campaign", 4,3);
		String TargetSize = ExceLib.getExcelUtilityFile("Create_Campaign", 4,4);
		String AlertMsg = ExceLib.getExcelUtilityFile("Create_Campaign", 4, 5);

		CampaignPage campaignpage=new CampaignPage(driver);

		CreateCampaignPage createcampaignpage=new CreateCampaignPage(driver);

		HomePage homepage=new HomePage(driver);

		campaignpage.getGetAddCreateCampaignBtn().click();

		createcampaignpage.getCampaignNameTF().sendKeys(CampaignName);
		createcampaignpage.getCampaignstatusTF().sendKeys(Status);
		createcampaignpage.getTargetsizeTF().sendKeys(TargetSize);
		createcampaignpage.getCreatecampaignBTn().click();

		WebElement alertmsgtext = homepage.getToastMsg();
		wLib.waitUntilElementToBeVisible(driver, alertmsgtext);
		
		String msg = alertmsgtext.getText();
		Assert.assertTrue(msg.contains(AlertMsg));
		
//		if(alertmsgtext.getText().contains(AlertMsg)) {
//			System.out.println("campaign created");
//		}
//		else
//		{
//			System.out.println("campaign not created");
//		}
		
		homepage.getToastCloseBtn().click();

	}
	
	
	@Test(groups = "smoke")
	public void CreateCampaign_With_ExpectedCloseDate_Test() throws EncryptedDocumentException, IOException {
		
//		PropertiesUtilityFile propLib=new PropertiesUtilityFile();
//
//		ExcelUtilityFile ExceLib=new ExcelUtilityFile();
//
//		WebDriverUtility wLib=new WebDriverUtility();
//
//		 String BROWSER = propLib.getPropertiesUtilityFile("Browser");
//		 String URL = propLib.getPropertiesUtilityFile("URl");
//		 String USERNAME = propLib.getPropertiesUtilityFile("username");
//		 String PASSWORD = propLib.getPropertiesUtilityFile("password");

		 String CampaignName = ExceLib.getExcelUtilityFile("Create_Campaign", 7, 2);
		 String Status = ExceLib.getExcelUtilityFile("Create_Campaign", 7,3);
		 String TargetSize = ExceLib.getExcelUtilityFile("Create_Campaign", 7,4);
		 String AlertMsg = ExceLib.getExcelUtilityFile("Create_Campaign", 7, 5);

//		ChromeOptions settings = new ChromeOptions();
//		Map<String, Object> prefs = new HashMap<>();
//		prefs.put("profile.password_manager_leak_detection", false);
//		settings.setExperimentalOption("prefs", prefs);
//
//		WebDriver driver=null;
//		
//		if(BROWSER.equalsIgnoreCase("chrome")) {
//			driver=new ChromeDriver(settings);
//		}
//		else if(BROWSER.equalsIgnoreCase("edge")) {
//			driver=new EdgeDriver();
//		}
//		else if(BROWSER.equalsIgnoreCase("firefox")) {
//			driver=new FirefoxDriver();
//		}
//
//		driver.manage().window().maximize();
//
//		wLib.implicitlyWait(driver);
//
//		LoginPage_POM loginpagePOM=new LoginPage_POM(driver);
//
//		loginpagePOM.loginToApp(URL, USERNAME, PASSWORD);

		CampaignPage campaignpage=new CampaignPage(driver);

		CreateCampaignPage createcampaignpage=new CreateCampaignPage(driver);

		JavaUtilityFile jLib=new JavaUtilityFile();

		HomePage homepage=new HomePage(driver);

		campaignpage.getGetAddCreateCampaignBtn().click();

		createcampaignpage.getCampaignNameTF().sendKeys(CampaignName);
		createcampaignpage.getCampaignstatusTF().sendKeys(Status);
		createcampaignpage.getTargetsizeTF().sendKeys(TargetSize);
		createcampaignpage.getExpectedClosedateTF().sendKeys(jLib.getRequireddate(5));
		createcampaignpage.getCreatecampaignBTn().click();
		
		WebElement alertmsgtext = homepage.getToastMsg();
		wLib.waitUntilElementToBeVisible(driver, alertmsgtext);
		
		String msg = alertmsgtext.getText();
		Assert.assertTrue(msg.contains(AlertMsg));
		
//		if(alertmsgtext.getText().contains(AlertMsg)) {
//			System.out.println("campaign created");
//		}
//		else
//		{
//			System.out.println("campaign not created");
//		}
		
		homepage.getToastCloseBtn().click();

	}
	
	
	@Test(groups = "smoke")
	public void CreateCampaign_CompleteTest() throws IOException {

		 String CampaignName = ExceLib.getExcelUtilityFile("Create_Campaign", 10, 2);
		 String Status = ExceLib.getExcelUtilityFile("Create_Campaign", 10,3);
		 String TargetSize = ExceLib.getExcelUtilityFile("Create_Campaign", 10,4);
		 String TargetAudience = ExceLib.getExcelUtilityFile("Create_Campaign", 10,5);
		 String Description= ExceLib.getExcelUtilityFile("Create_Campaign", 10,6);
		 String AlertMsg = ExceLib.getExcelUtilityFile("Create_Campaign", 10, 7);

		CampaignPage campaignpage=new CampaignPage(driver);

		CreateCampaignPage createcampaignpage=new CreateCampaignPage(driver);

		JavaUtilityFile jLib=new JavaUtilityFile();

		HomePage homepage=new HomePage(driver);

		campaignpage.getGetAddCreateCampaignBtn().click();

		createcampaignpage.getCampaignNameTF().sendKeys(CampaignName);
		createcampaignpage.getCampaignstatusTF().sendKeys(Status);
		createcampaignpage.getTargetsizeTF().sendKeys(TargetSize);
		createcampaignpage.getExpectedClosedateTF().sendKeys(jLib.getRequireddate(5));
		createcampaignpage.getTargetAudienceTF().sendKeys(TargetAudience);
		createcampaignpage.getDescriptionTF().sendKeys(Description);
		createcampaignpage.getCreatecampaignBTn().click();

		WebElement alertmsgtext = homepage.getToastMsg();
		wLib.waitUntilElementToBeVisible(driver, alertmsgtext);
		
		String msg = alertmsgtext.getText();
		Assert.assertTrue(msg.contains(AlertMsg));
		
//		if(alertmsgtext.getText().contains(AlertMsg)) {
//			System.out.println("campaign created");
//		}
//		else
//		{
//			System.out.println("campaign not created");
//		}
		
		homepage.getToastCloseBtn().click();

		
	}
	

}
