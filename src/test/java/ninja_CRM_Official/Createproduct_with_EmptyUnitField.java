package ninja_CRM_Official;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import pageObjects.AddProductpage;
import pageObjects.HomePage;
import pageObjects.LoginPage_POM;
import pageObjects.ProductPage;
import utility_Files.ExcelUtilityFile;
import utility_Files.JavaUtilityFile;
import utility_Files.PropertiesUtilityFile;
import utility_Files.WebDriverUtility;

public class Createproduct_with_EmptyUnitField {

	public static void main(String[] args) throws IOException {

		WebDriver driver=null;
		
		//Property utility file
		PropertiesUtilityFile propUtilityFile=new PropertiesUtilityFile();
		
		//Excel utility File
		ExcelUtilityFile excelutilFile=new ExcelUtilityFile();
		
		//web Driver utility file
		WebDriverUtility webdriverutility=new WebDriverUtility();	

		//java library
		JavaUtilityFile Jlib=new JavaUtilityFile();
		
		//data from properties file
		String BROWSER=propUtilityFile.getPropertiesUtilityFile("Browser");
		String URL=propUtilityFile.getPropertiesUtilityFile("URl");
		String USERNAME=propUtilityFile.getPropertiesUtilityFile("username");
		String PASSWORD=propUtilityFile.getPropertiesUtilityFile("password");
		
		//data from Excel file 
		 String productname = excelutilFile.getExcelUtilityFile("createProduct", 22, 2);
		 String productcategory = excelutilFile.getExcelUtilityFile("createProduct", 22, 3);
		 String productQuantity = excelutilFile.getExcelUtilityFile("createProduct", 22, 4);
		
		//code for avoid chrome popup
		ChromeOptions settings = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		settings.setExperimentalOption("prefs", prefs);
		
		//WebDriver launching
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver(settings);
		}
		else if(BROWSER.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			driver=new SafariDriver();
		}
		
		//window maximize
		driver.manage().window().maximize();
		
		//Global wait
		webdriverutility.implicitlyWait(driver);
		
		//login page pom class
		LoginPage_POM loginPage=new LoginPage_POM(driver);
		
		//Home page pom class
		HomePage homepagepom=new HomePage(driver);
		
		//product page pom
		ProductPage productpagepom=new ProductPage(driver);
		
		//Add product page POM
		AddProductpage addProductpagePOM=new AddProductpage(driver);
		
		//Login action
		loginPage.loginToApp(URL, USERNAME, PASSWORD);
		
		//IN NAVBAR CLICK ON PRODUCTS OPTION
		homepagepom.getProductsBtn().click();
		
		//Click on Add product button
		productpagepom.getAddProductBtn().click();
		
		//now enter product name
		addProductpagePOM.getProductNameTf().sendKeys(productname+"_"+Jlib.generateThreeDigitNum());
		addProductpagePOM.getProductCategoryTf().sendKeys(productcategory);
		addProductpagePOM.getProductQuantityTf().sendKeys(productQuantity);
		addProductpagePOM.getProductPriceTf().clear();
		
		//Entered into products page and without filling any data click on Add button and check the validation message for the required fields.
		addProductpagePOM.getProductAddBtn().click();
		
		//HTML5 input fields expose a built-in property called validationMessage-- use this to get the required popup message.
		String validationMsg=addProductpagePOM.getProductPriceTf().getAttribute("validationMessage");
		System.out.println(validationMsg);
		
		if(validationMsg.contains("Please fill out this field.")) {
			System.out.println("Test passed");
		}
		else {
			System.out.println("Test failed");
		}
		
		//log out Action
		homepagepom.logout();


	}

}
