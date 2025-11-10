package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility_Files.WebDriverUtility;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignBTn;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsBTn;
	
	@FindBy(linkText = "Products")
	private WebElement productsBtn;
	
	@FindBy(className = "user-icon")
	private WebElement UserIconBtn;
	
	@FindBy(className = "logout")
	private WebElement LogOutBtn;
	
	@FindBy(xpath="//div[@role='alert']")
	private WebElement toastMsg;
	
	@FindBy(xpath = "//button[@aria-label='close']")
	private WebElement ToastCloseBtn;
	
	public WebElement getToastMsg() {
		return toastMsg;
	}

	public void setToastMsg(WebElement toastMsg) {
		this.toastMsg = toastMsg;
	}

	public WebElement getCampaignBTn() {
		return campaignBTn;
	}

	public WebElement getContactsBTn() {
		return contactsBTn;
	}
	
	public WebElement getProductsBtn() {
		return productsBtn;
	}

	public WebElement getUserIconBtn() {
		return UserIconBtn;
	}

	public WebElement getLogOutBtn() {
		return LogOutBtn;
	}

	public WebElement getToastCloseBtn() {
		return ToastCloseBtn;
	}

	public void logout() {
		WebDriverUtility wLib=new WebDriverUtility();
		wLib.mouseHoverOnWebElement(driver, UserIconBtn);
		wLib.clickOnWebElement(driver, LogOutBtn);
		
	}
}
