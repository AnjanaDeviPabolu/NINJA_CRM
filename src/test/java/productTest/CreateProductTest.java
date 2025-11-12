package productTest;

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
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import pageObjects.AddProductpage;
import pageObjects.HomePage;
import pageObjects.LoginPage_POM;
import pageObjects.ProductPage;
import utility_Files.ExcelUtilityFile;
import utility_Files.JavaUtilityFile;
import utility_Files.PropertiesUtilityFile;
import utility_Files.WebDriverUtility;

@Listeners(genericUtilities.ListenerImplementation.class)

public class CreateProductTest extends BaseClass{
	
	@Test
	public void CreateProduct_With_MandatoryFields_Test() throws EncryptedDocumentException, IOException {
		
		//data from Excel file 
		 String productname = ExceLib.getExcelUtilityFile("createProduct", 1, 2);
		 String productcategory = ExceLib.getExcelUtilityFile("createProduct", 1, 3);
		 String productQuantity = ExceLib.getExcelUtilityFile("createProduct", 1, 4);
		 String productPricePerUnit = ExceLib.getExcelUtilityFile("createProduct", 1, 5);
		 String productvendor = ExceLib.getExcelUtilityFile("createProduct", 1, 6);
		 
		//java library
		JavaUtilityFile Jlib=new JavaUtilityFile();
		
		//Home page pom class
		HomePage homepagepom=new HomePage(driver);
		
		//product page pom
		ProductPage productpagepom=new ProductPage(driver);
		
		//Add product page POM
		AddProductpage addProductpagePOM=new AddProductpage(driver);
		
		//IN NAVBAR CLICK ON PRODUCTS OPTION
		homepagepom.getProductsBtn().click();
		
		//Click on Add product button
		productpagepom.getAddProductBtn().click();
		
		//now entered into add product page
		addProductpagePOM.getProductNameTf().sendKeys(productname+"_"+Jlib.generateThreeDigitNum());
		addProductpagePOM.getProductCategoryTf().sendKeys(productcategory);
		addProductpagePOM.getProductQuantityTf().sendKeys(productQuantity);
		addProductpagePOM.getProductPriceTf().clear();
		addProductpagePOM.getProductPriceTf().sendKeys(productPricePerUnit);
		addProductpagePOM.getProductVendorIdTf().sendKeys(productvendor);
		addProductpagePOM.getProductAddBtn().click();
		
		//verify the toast
		
		WebElement alertmsg = homepagepom.getToastMsg();
		wLib.waitUntilElementToBeVisible(driver, alertmsg);
		if(alertmsg.getText().contains("Successfully Added")) {
			System.out.println("Product Successfully Added");
		}
		else {
			System.out.println("Product not added");
		}

		homepagepom.getToastCloseBtn().click();

	}
	
	
	@Test
	public void Createproduct_with_MandatoryFields_SelectcategoryByValue_Test() throws EncryptedDocumentException, IOException {	

		//java library
		JavaUtilityFile Jlib=new JavaUtilityFile();
		
		//data from Excel file 
		 String productname = ExceLib.getExcelUtilityFile("createProduct", 4, 2);
		 String productcategory = ExceLib.getExcelUtilityFile("createProduct", 4, 3);
		 String productQuantity = ExceLib.getExcelUtilityFile("createProduct", 4, 4);
		 String productPricePerUnit = ExceLib.getExcelUtilityFile("createProduct", 4, 5);
		 String productvendor = ExceLib.getExcelUtilityFile("createProduct", 4, 6);
		
		//Home page pom class
		HomePage homepagepom=new HomePage(driver);
		
		//product page pom
		ProductPage productpagepom=new ProductPage(driver);
		
		//Add product page POM
		AddProductpage addProductpagePOM=new AddProductpage(driver);
		
		//IN NAVBAR CLICK ON PRODUCTS OPTION
		homepagepom.getProductsBtn().click();
		
		//Click on Add product button
		productpagepom.getAddProductBtn().click();
		
		//now entered into add product page
		addProductpagePOM.getProductNameTf().sendKeys(productname+"_"+Jlib.generateThreeDigitNum());
		 WebElement productCategoryDropdwon = addProductpagePOM.getProductCategoryTf();
		 wLib.select(productCategoryDropdwon, productcategory);
		addProductpagePOM.getProductQuantityTf().sendKeys(productQuantity);
		addProductpagePOM.getProductPriceTf().clear();
		addProductpagePOM.getProductPriceTf().sendKeys(productPricePerUnit);
		WebElement VendorDropdwon = addProductpagePOM.getProductVendorIdTf();
		wLib.select(VendorDropdwon,productvendor);
		addProductpagePOM.getProductAddBtn().click();
		
		//verify the toast
		
		WebElement alertmsg = homepagepom.getToastMsg();
		wLib.waitUntilElementToBeVisible(driver, alertmsg);
		if(alertmsg.getText().contains("Successfully Added")) {
			System.out.println("Product Successfully Added");
		}
		else {
			System.out.println("Product not added");
		}

		homepagepom.getToastCloseBtn().click();

	}
	
	
	@Test
	public void Createproduct_with_MandatoryFields_SelectcategoryByIndex_Test() throws EncryptedDocumentException, IOException {	

		//java library
		JavaUtilityFile Jlib=new JavaUtilityFile();
		
		//data from Excel file 
		 String productname = ExceLib.getExcelUtilityFile("createProduct", 7, 2);
		 String productcategory = ExceLib.getExcelUtilityFile("createProduct", 7, 3);
		 int productcategoryIndex = Integer.parseInt(productcategory);
		 String productQuantity = ExceLib.getExcelUtilityFile("createProduct", 7, 4);
		 String productPricePerUnit = ExceLib.getExcelUtilityFile("createProduct", 7, 5);
		 String productvendor = ExceLib.getExcelUtilityFile("createProduct", 7, 6);
		 int productvendorIndex = Integer.parseInt(productvendor);
		
		//Home page pom class
		HomePage homepagepom=new HomePage(driver);
		
		//product page pom
		ProductPage productpagepom=new ProductPage(driver);
		
		//Add product page POM
		AddProductpage addProductpagePOM=new AddProductpage(driver);
		
		//IN NAVBAR CLICK ON PRODUCTS OPTION
		homepagepom.getProductsBtn().click();
		
		//Click on Add product button
		productpagepom.getAddProductBtn().click();
		
		//now entered into add product page
		addProductpagePOM.getProductNameTf().sendKeys(productname+"_"+Jlib.generateThreeDigitNum());
		 WebElement productCategoryDropdwon = addProductpagePOM.getProductCategoryTf();
		 wLib.select(productCategoryDropdwon,productcategoryIndex );
		addProductpagePOM.getProductQuantityTf().sendKeys(productQuantity);
		addProductpagePOM.getProductPriceTf().clear();
		addProductpagePOM.getProductPriceTf().sendKeys(productPricePerUnit);
		WebElement VendorDropdwon = addProductpagePOM.getProductVendorIdTf();
		wLib.select(VendorDropdwon,productvendorIndex);
		addProductpagePOM.getProductAddBtn().click();
		
		//verify the toast
		
		WebElement alertmsg = homepagepom.getToastMsg();
		wLib.waitUntilElementToBeVisible(driver, alertmsg);
		if(alertmsg.getText().contains("Successfully Added")) {
			System.out.println("Product Successfully Added");
		}
		else {
			System.out.println("Product not added");
		}

		homepagepom.getToastCloseBtn().click();
	}
	
	
	@Test
	public void CreateProduct_with_EmptyFields_Test() throws IOException {	

		//java library
		JavaUtilityFile Jlib=new JavaUtilityFile();
		
		//Home page pom class
		HomePage homepagepom=new HomePage(driver);
		
		//product page pom
		ProductPage productpagepom=new ProductPage(driver);
		
		//Add product page POM
		AddProductpage addProductpagePOM=new AddProductpage(driver);
		
		//IN NAVBAR CLICK ON PRODUCTS OPTION
		homepagepom.getProductsBtn().click();
		
		//Click on Add product button
		productpagepom.getAddProductBtn().click();
		
		//HTML5 input fields expose a built-in property called validationMessage-- use this to get the required popup message.
		String validationMsg=addProductpagePOM.getProductNameTf().getAttribute("validationMessage");
		System.out.println(validationMsg);
		
		//Entered into products page and without filling any data click on Add button and check the validation message for the required fields.
		addProductpagePOM.getProductAddBtn().click();
		
		if(validationMsg.contains("Please fill out this field.")) {
			System.out.println("Test passed");
		}
		else {
			System.out.println("Test failed");
		}

	}
	
	
	@Test
	public void CreateProduct_with_Productname_Test() throws IOException {

		//java library
		JavaUtilityFile Jlib=new JavaUtilityFile();
		
		//data from Excel file 
		 String productname = ExceLib.getExcelUtilityFile("createProduct", 13, 2);
		
		//Home page pom class
		HomePage homepagepom=new HomePage(driver);
		
		//product page pom
		ProductPage productpagepom=new ProductPage(driver);
		
		//Add product page POM
		AddProductpage addProductpagePOM=new AddProductpage(driver);
		
		//IN NAVBAR CLICK ON PRODUCTS OPTION
		homepagepom.getProductsBtn().click();
		
		//Click on Add product button
		productpagepom.getAddProductBtn().click();
		
		//now enter product name
		addProductpagePOM.getProductNameTf().sendKeys(productname+"_"+Jlib.generateThreeDigitNum());
		
		//Entered into products page and without filling any data click on Add button and check the validation message for the required fields.
		addProductpagePOM.getProductAddBtn().click();
		
		//HTML5 input fields expose a built-in property called validationMessage-- use this to get the required popup message.
		String validationMsg=addProductpagePOM.getProductCategoryTf().getAttribute("validationMessage");
		System.out.println(validationMsg);
		
		if(validationMsg.contains("Please select an item in the list.")) {
			System.out.println("Test passed");
		}
		else {
			System.out.println("Test failed");
		}
	}
	
	
	@Test
	public void CreateProduct_with_ProductCategory_Test() throws IOException {

		//java library
		JavaUtilityFile Jlib=new JavaUtilityFile();
		
		//data from Excel file 
		 String productname = ExceLib.getExcelUtilityFile("createProduct", 16, 2);
		 String productcategory = ExceLib.getExcelUtilityFile("createProduct", 16, 3);
		
		//Home page pom class
		HomePage homepagepom=new HomePage(driver);
		
		//product page pom
		ProductPage productpagepom=new ProductPage(driver);
		
		//Add product page POM
		AddProductpage addProductpagePOM=new AddProductpage(driver);
		
		//IN NAVBAR CLICK ON PRODUCTS OPTION
		homepagepom.getProductsBtn().click();
		
		//Click on Add product button
		productpagepom.getAddProductBtn().click();
		
		//now enter product name
		addProductpagePOM.getProductNameTf().sendKeys(productname+"_"+Jlib.generateThreeDigitNum());
		addProductpagePOM.getProductCategoryTf().sendKeys(productcategory);
		
		//Entered into products page and without filling any data click on Add button and check the validation message for the required fields.
		addProductpagePOM.getProductAddBtn().click();
		
		//HTML5 input fields expose a built-in property called validationMessage-- use this to get the required popup message.
		String validationMsg=addProductpagePOM.getProductQuantityTf().getAttribute("validationMessage");
		System.out.println(validationMsg);
		
		if(validationMsg.contains("Value must be greater than or equal to 1.")) {
			System.out.println("Test passed");
		}
		else {
			System.out.println("Test failed");
		}

	}
	
	
	@Test
	public void CreateProduct_with_Quantity_Test() throws EncryptedDocumentException, IOException {	

		//java library
		JavaUtilityFile Jlib=new JavaUtilityFile();
		
		//data from Excel file 
		 String productname = ExceLib.getExcelUtilityFile("createProduct", 19, 2);
		 String productcategory = ExceLib.getExcelUtilityFile("createProduct", 19, 3);
		 String productQuantity = ExceLib.getExcelUtilityFile("createProduct", 19, 4);
		
		//Home page pom class
		HomePage homepagepom=new HomePage(driver);
		
		//product page pom
		ProductPage productpagepom=new ProductPage(driver);
		
		//Add product page POM
		AddProductpage addProductpagePOM=new AddProductpage(driver);
		
		//IN NAVBAR CLICK ON PRODUCTS OPTION
		homepagepom.getProductsBtn().click();
		
		//Click on Add product button
		productpagepom.getAddProductBtn().click();
		
		//now enter product name
		addProductpagePOM.getProductNameTf().sendKeys(productname+"_"+Jlib.generateThreeDigitNum());
		addProductpagePOM.getProductCategoryTf().sendKeys(productcategory);
		addProductpagePOM.getProductQuantityTf().sendKeys(productQuantity);
		
		//Entered into products page and without filling any data click on Add button and check the validation message for the required fields.
		addProductpagePOM.getProductAddBtn().click();
		
		//HTML5 input fields expose a built-in property called validationMessage-- use this to get the required popup message.
		String validationMsg=addProductpagePOM.getProductVendorIdTf().getAttribute("validationMessage");
		System.out.println(validationMsg);
		
		if(validationMsg.contains("Please select an item in the list.")) {
			System.out.println("Test passed");
		}
		else {
			System.out.println("Test failed");
		}
	}
	
	
	
	@Test
	public void Createproduct_with_EmptyUnitField_Test() throws IOException {	

		//java library
		JavaUtilityFile Jlib=new JavaUtilityFile();
		
		//data from Excel file 
		 String productname = ExceLib.getExcelUtilityFile("createProduct", 22, 2);
		 String productcategory = ExceLib.getExcelUtilityFile("createProduct", 22, 3);
		 String productQuantity = ExceLib.getExcelUtilityFile("createProduct", 22, 4);
			
		//Home page pom class
		HomePage homepagepom=new HomePage(driver);
		
		//product page pom
		ProductPage productpagepom=new ProductPage(driver);
		
		//Add product page POM
		AddProductpage addProductpagePOM=new AddProductpage(driver);
		
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
	}
	
	
	@Test
	public void CreateProductFieldType_Test() throws IOException {

		//java library
		JavaUtilityFile Jlib=new JavaUtilityFile();
		
		//Home page pom class
		HomePage homepagepom=new HomePage(driver);
		
		//product page pom
		ProductPage productpagepom=new ProductPage(driver);
		
		//Add product page POM
		AddProductpage addProductpagePOM=new AddProductpage(driver);
		
		//IN NAVBAR CLICK ON PRODUCTS OPTION
		homepagepom.getProductsBtn().click();
		
		//Click on Add product button
		productpagepom.getAddProductBtn().click();
		
		//Validations for field types
		String ProductNameFieldType=addProductpagePOM.getProductNameTf().getAttribute("type");
		System.out.println("ProductNameFieldType:"+ProductNameFieldType);
		
		if(ProductNameFieldType.contains("text")) {
			System.out.println("Product name accepts text");
		}
		else {
			System.out.println("Product name does not accepts text");
		}
		
		String ProductQuantityFieldType=addProductpagePOM.getProductQuantityTf().getAttribute("type");
		System.out.println("ProductQuantityFieldType:"+ProductQuantityFieldType);
		
		if(ProductQuantityFieldType.contains("number")) {
			System.out.println("Product Quantity accepts number");
		}
		else {
			System.out.println("Product Quantity does not accepts number");
		}
		
		String ProductPriceFieldType=addProductpagePOM.getProductPriceTf().getAttribute("type");
		System.out.println("ProductPriceFieldType:"+ProductPriceFieldType);

		if(ProductPriceFieldType.contains("number")) {
			System.out.println("Product price accepts number");
		}
		else {
			System.out.println("Product price does not accepts number");
		}		

	}

}
