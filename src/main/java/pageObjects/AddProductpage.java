package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductpage {
	
	public AddProductpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="productName")
	private WebElement productNameTf;
	
	@FindBy(name="productCategory")
	private WebElement productCategoryTf;
	
	@FindBy(name="quantity")
	private WebElement productQuantityTf;
	
	@FindBy(name="price")
	private WebElement productPriceTf;
	
	@FindBy(name="vendorId")
	private WebElement productVendorIdTf;
	
	@FindBy(xpath = "//button[text()='Add']")
	private WebElement ProductAddBtn;

	public WebElement getProductNameTf() {
		return productNameTf;
	}

	public WebElement getProductCategoryTf() {
		return productCategoryTf;
	}

	public WebElement getProductQuantityTf() {
		return productQuantityTf;
	}

	public WebElement getProductPriceTf() {
		return productPriceTf;
	}

	public WebElement getProductVendorIdTf() {
		return productVendorIdTf;
	}

	public WebElement getProductAddBtn() {
		return ProductAddBtn;
	}
	
	
	

}
