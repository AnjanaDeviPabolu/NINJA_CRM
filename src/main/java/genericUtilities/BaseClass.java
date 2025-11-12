package genericUtilities;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage_POM;
import utility_Files.ExcelUtilityFile;
import utility_Files.PropertiesUtilityFile;
import utility_Files.WebDriverUtility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseClass {

	public WebDriver driver = null;
	public PropertiesUtilityFile propLib = new PropertiesUtilityFile();
	public ExcelUtilityFile ExceLib = new ExcelUtilityFile();
	public WebDriverUtility wLib = new WebDriverUtility();
	public static WebDriver sdriver = null;

	@BeforeSuite(groups= {"smoke","regression"})
	public void beforeSuite() {
		System.out.println("Establish the database connection");
	}

	@BeforeTest(groups= {"smoke","regression"})
	public void beforeTest() {
		System.out.println("Pre-conditions for parallel execution");
	}

	@BeforeClass(groups= {"smoke","regression"})
	public void beforeClass() throws IOException {

		Reporter.log("Launching the Browser", true);

		String BROWSER = propLib.getPropertiesUtilityFile("Browser");

		ChromeOptions settings = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		settings.setExperimentalOption("prefs", prefs);

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver(settings);
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		sdriver = driver;

		driver.manage().window().maximize();

		wLib.implicitlyWait(driver);

	}

	@BeforeMethod(groups= {"smoke","regression"})
	public void beforeMethod() throws IOException {

		String URL = propLib.getPropertiesUtilityFile("URl");
		String USERNAME = propLib.getPropertiesUtilityFile("username");
		String PASSWORD = propLib.getPropertiesUtilityFile("password");

		LoginPage_POM loginpagePOM = new LoginPage_POM(driver);

		loginpagePOM.loginToApp(URL, USERNAME, PASSWORD);
	}

	@AfterMethod(groups= {"smoke","regression"})
	public void afterMethod() {
		HomePage homepage = new HomePage(driver);
		homepage.logout();
	}

	@AfterClass(groups= {"smoke","regression"})
	public void afterClass() {
		Reporter.log("Driver Quit", true);
		driver.quit();
	}

	@AfterTest(groups= {"smoke","regression"})
	public void afterTest() {
		System.out.println("Post-conditions for parallel execution");
	}

	@AfterSuite(groups= {"smoke","regression"})
	public void afterSuite() {
		System.out.println("Close the database connection");
	}

}
