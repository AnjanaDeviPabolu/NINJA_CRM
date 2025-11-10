package ninja_CRM_Official;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObjects.CampaignPage;
import pageObjects.ContactsPage;
import pageObjects.CreateCampaignPage;
import pageObjects.CreateContactPage;
import pageObjects.HomePage;
import pageObjects.LoginPage_POM;
import pageObjects.SelectcampaignPage;
import utility_Files.ExcelUtilityFile;
import utility_Files.JavaUtilityFile;
import utility_Files.PropertiesUtilityFile;
import utility_Files.WebDriverUtility;

public class CreateContact_With_Email {

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
		 String CampaignName = ExceLib.getExcelUtilityFile("Create_Contact", 7, 2);
		 String TargetSize = ExceLib.getExcelUtilityFile("Create_Contact", 7, 3);
		 String CampaignAlertMsg = ExceLib.getExcelUtilityFile("Create_Contact", 7, 4);
		 String Organization = ExceLib.getExcelUtilityFile("Create_Contact", 7, 5);
		 String Title = ExceLib.getExcelUtilityFile("Create_Contact", 7,6);
		 String Department=ExceLib.getExcelUtilityFile("Create_Contact", 7, 7);
		 String ContactName = ExceLib.getExcelUtilityFile("Create_Contact", 7,8);
		 String EMail = ExceLib.getExcelUtilityFile("Create_Contact", 7,9);
		 String SiteTitle = ExceLib.getExcelUtilityFile("Create_Contact", 7,10);
		 String ContactAlertmsg = ExceLib.getExcelUtilityFile("Create_Contact", 7,11);
		 
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
		
		//Java page object class
		JavaUtilityFile jLib=new JavaUtilityFile();
		
		//Home page object class
		HomePage homepage=new HomePage(driver);
		
		//Contacts page object class
		ContactsPage contactspage=new ContactsPage(driver);
		
		//Create contact page object class
		CreateContactPage createcontactpage=new CreateContactPage(driver);
		
		//click on create campaign button
		campaignpage.getGetAddCreateCampaignBtn().click();
		
		//create campaign Action
		createcampaignpage.getCampaignNameTF().sendKeys(CampaignName);
		createcampaignpage.getTargetsizeTF().sendKeys(TargetSize);
		createcampaignpage.getCreatecampaignBTn().click();
		
		//verification
		WebElement alertmsgtext = homepage.getToastMsg();
		wLib.waitUntilElementToBeVisible(driver, alertmsgtext);
		if(alertmsgtext.getText().contains(CampaignAlertMsg)) {
			System.out.println("campaign created");
		}
		else
		{
			System.out.println("campaign not created");
		}
		
		homepage.getToastCloseBtn().click();
			
		//Now in the navbar click on contacts option
		homepage.getContactsBTn().click();
		
		//Now click on the create contact button
		contactspage.getAddCreateContactBtn().click();
		
		//Create contacts action
		createcontactpage.getOrganizationNameTF().sendKeys(Organization);
		createcontactpage.getTitleTF().sendKeys(Title);
		createcontactpage.getDepartmentTF().sendKeys(Department);
		createcontactpage.getContactNameTF().sendKeys(ContactName);
		createcontactpage.getMobileTF().sendKeys("9"+jLib.generateNineDigitNum());
		createcontactpage.getEmailTF().sendKeys(EMail);
		createcontactpage.getCreatecampaignPlusBtn().click();
		
		//child window popup
		//get the window Id's
		String parentId = driver.getWindowHandle();
		Set<String> allIds = driver.getWindowHandles();
		
		for (String Ids : allIds) {
			driver.switchTo().window(Ids);
			if(driver.getTitle().contains(SiteTitle)) {
				break;
			}
		}
		
		//now inside the child window click
		SelectcampaignPage selectcampaignpage=new SelectcampaignPage(driver);
		
		WebElement childropdown = selectcampaignpage.getDropdown();
		
		wLib.select(childropdown, "campaignName");
		
		selectcampaignpage.getSearchBarField().sendKeys(CampaignName);
		WebElement selectBtn=selectcampaignpage.getSelectBtn();
		wLib.waitUntilElementToBeVisible(driver, selectBtn);
		selectBtn.click();
		
		//Switch to parent window
		driver.switchTo().window(parentId);
		
		//click on create contact button
		createcontactpage.getCreateContactBtn().click();
		
		//verification
		WebElement contactalertmsgtext = homepage.getToastMsg();
		wLib.waitUntilElementToBeVisible(driver, contactalertmsgtext);
		if(alertmsgtext.getText().contains(ContactAlertmsg)) {
			System.out.println("contact created");
		}
		else
		{
			System.out.println("contact not created");
		}
		
		homepage.getToastCloseBtn().click();
		
		//log out Action
		homepage.logout();
		
		//Quit the Driver
		driver.quit();


	}

}
