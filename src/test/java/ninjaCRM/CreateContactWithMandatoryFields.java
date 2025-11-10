package ninjaCRM;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.CampaignPage;
import pageObjects.ContactsPage;
import pageObjects.CreateCampaignPage;
import pageObjects.CreateContactPage;
import pageObjects.LoginPage_POM;
import pageObjects.SelectcampaignPage;
import utility_Files.JavaUtilityFile;
import utility_Files.WebDriverUtility;

public class CreateContactWithMandatoryFields {

	public static void main(String[] args) throws IOException {
		
		//get the prop file
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/NinjaData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		//create variables for prop values
		String BROWSER = prop.getProperty("Browser");
		String URL = prop.getProperty("URl");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		
		//get the Excel file
		FileInputStream excel=new FileInputStream("C:\\Users\\pabol\\OneDrive\\Documents\\CampaignData_CreateContact.xlsx");
		Workbook wb = WorkbookFactory.create(excel);
		Sheet sheetname = wb.getSheet("data");
		
		//create variables for values from Excel
		String campaign_name = sheetname.getRow(1).getCell(2).getStringCellValue();
		String campaign_status = sheetname.getRow(1).getCell(3).getStringCellValue();
		String target_size = sheetname.getRow(1).getCell(4).getStringCellValue();
		String target_auidence = sheetname.getRow(1).getCell(5).getStringCellValue();
		String description = sheetname.getRow(1).getCell(6).getStringCellValue();
		String organization = sheetname.getRow(1).getCell(7).getStringCellValue();
		String Title = sheetname.getRow(1).getCell(8).getStringCellValue();
		String Contact_Name = sheetname.getRow(1).getCell(9).getStringCellValue();
		String Mobile = sheetname.getRow(1).getCell(10).getStringCellValue();
		
		//Expected close date code setup
		java.util.Date date=new java.util.Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		sdf.format(date);
		
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.MONTH, 1);
		String expected_date = sdf.format(cal.getTime());
		
		
		//code to ignore chrome popup
		ChromeOptions settings = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		settings.setExperimentalOption("prefs", prefs);
		
		WebDriverUtility wLib=new WebDriverUtility();
		
		JavaUtilityFile jlib=new JavaUtilityFile();
		
		//launching the browser
		WebDriver driver=null;
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver(settings);
		}
		else if(BROWSER.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Firefox")){
			driver=new FirefoxDriver();
		}
		
		//maximize window and some global wait
		driver.manage().window().maximize();
		wLib.implicitlyWait(driver);
		
		//now login page code
//		driver.get(URL);
//		driver.findElement(By.id("username")).sendKeys(USERNAME);
//		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
//		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		//login
		LoginPage_POM loginPage=new LoginPage_POM(driver);
		loginPage.loginToApp(URL, USERNAME, PASSWORD);
		
		//Create campaign code
		
//		//driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
//		driver.findElement(By.name("campaignName")).sendKeys(campaign_name);
//		driver.findElement(By.xpath("//input[@name='campaignStatus']")).sendKeys(campaign_status);
//		WebElement targetSize = driver.findElement(By.name("targetSize"));
//		targetSize.clear();
//		targetSize.sendKeys(target_size);
//		driver.findElement(By.xpath("//input[@name='expectedCloseDate']")).sendKeys(expected_date);
//		driver.findElement(By.xpath("//input[@name='targetAudience']")).sendKeys(target_auidence);
//		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(description);
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		CampaignPage campaign_page=new CampaignPage(driver);
		
		campaign_page.getGetAddCreateCampaignBtn().click();
		
		CreateCampaignPage createcampaign_page=new CreateCampaignPage(driver);
		
		JavaUtilityFile jLib=new JavaUtilityFile();
		
		createcampaign_page.getCampaignNameTF().sendKeys(campaign_name);
		createcampaign_page.getCampaignstatusTF().sendKeys(campaign_status);
		createcampaign_page.getTargetsizeTF().clear();
		createcampaign_page.getTargetsizeTF().sendKeys(target_size);
		createcampaign_page.getExpectedClosedateTF().sendKeys(jLib.getRequireddate(2));
		createcampaign_page.getCreatecampaignBTn().click();
		
		//create campaign success popup
		WebElement alertmsg = driver.findElement(By.xpath("//div[@role='alert']"));
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.visibilityOf(alertmsg));4
		wLib.waitUntilElementToBeVisible(driver, alertmsg);
		
		if(alertmsg.getText().contains("Successfully Added")) {
			System.out.println("campaign created");
		}
		else
		{
			System.out.println("campaign not created");
		}
		
		//close the popup
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		
		//Now click on contacts button in the navbar
		driver.findElement(By.linkText("Contacts")).click();
		
		//Now click on the create contact button
		ContactsPage contactspage=new ContactsPage(driver);
		
		CreateContactPage createcontactpage=new CreateContactPage(driver);
		
		contactspage.getAddCreateContactBtn().click();
		createcontactpage.getOrganizationNameTF().sendKeys(organization);
		createcontactpage.getTitleTF().sendKeys(Title);
		createcontactpage.getContactNameTF().sendKeys(Contact_Name);
		createcontactpage.getMobileTF().sendKeys("9"+jLib.generateNineDigitNum());
		createcontactpage.getCreatecampaignPlusBtn().click();
		
		//driver.findElement(By.xpath("//span[text()='Create Contact']")).click();
		
		//Now enter the details in the contacts section
		//driver.findElement(By.xpath("//input[@name='organizationName']")).sendKeys(organization);
//		driver.findElement(By.xpath("//input[@name='title']")).sendKeys(Title);
//		driver.findElement(By.xpath("//input[@name='contactName']")).sendKeys(Contact_Name);
//		driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys("9"+jlib.generateNineDigitNum());
//		driver.findElement(By.xpath("//*[name()='svg' and @data-icon='plus']")).click();
		
		//get the window Id's
		String parentId = driver.getWindowHandle();
		Set<String> allIds = driver.getWindowHandles();
		
		for (String Ids : allIds) {
			driver.switchTo().window(Ids);
			if(driver.getTitle().contains("Select Campaign")) {
				break;
			}
		}
		
		//now inside the child window click
		
		SelectcampaignPage selectcampaignpage=new SelectcampaignPage(driver);
		
		WebElement childropdown = selectcampaignpage.getDropdown();
		
//		WebElement childropdown = driver.findElement(By.id("search-criteria"));
//		Select dropdown=new Select(childropdown);
//		dropdown.selectByValue("campaignName");
		
		wLib.select(childropdown, "campaignName");
		
		selectcampaignpage.getSearchBarField().sendKeys(campaign_name);
		
		WebElement selectBtn=selectcampaignpage.getSelectBtn();
		
		wLib.waitUntilElementToBeVisible(driver, selectBtn);
		
		//driver.findElement(By.id("search-input")).sendKeys(campaign_name);
//		WebElement selectBtn = driver.findElement(By.className("select-btn"));
//		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait1.until(ExpectedConditions.visibilityOf(selectBtn));
		
		
		selectBtn.click();
		
		driver.switchTo().window(parentId);
		
		
		//click on create contact button
		createcontactpage.getCreateContactBtn().click();
		//driver.findElement(By.xpath("//button[text()='Create Contact']")).click();
		
		//verify the alert of create contact
		WebElement contactalertmsg = driver.findElement(By.xpath("//div[@role='alert']"));
		WebDriverWait wait2=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait2.until(ExpectedConditions.visibilityOf(contactalertmsg));
		
		if(contactalertmsg.getText().contains("Successfully Added")) {
			System.out.println("Contact created");
		}
		else
		{
			System.out.println("Contact not created");
		}
		
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		
		//Log out
//		Actions act=new Actions(driver);
//		WebElement usericon = driver.findElement(By.xpath("//div[@class='user-icon']"));
//		act.moveToElement(usericon).perform();
//		driver.findElement(By.xpath("//div[text()='Logout ']")).click();
		
		WebElement usericon = driver.findElement(By.xpath("//div[@class='user-icon']"));
		wLib.mouseHoverOnWebElement(driver, usericon);
		 WebElement logoutBtn = driver.findElement(By.xpath("//div[text()='Logout ']"));
		 wLib.clickOnWebElement(driver, logoutBtn);
		
		
		driver.quit();
		

	}

}
