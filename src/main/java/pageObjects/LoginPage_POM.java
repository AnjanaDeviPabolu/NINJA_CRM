package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_POM {
	
	WebDriver driver;
	
	//constructor
	public LoginPage_POM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement usernameTF;

	@FindBy(id="inputPassword")
	private WebElement passwordTF;
	
	@FindBy(css="button[type='submit']")
	private WebElement signInBtn;
	
	public WebElement getUsernameTF() {
		return usernameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getSignInBtn() {
		return signInBtn;
	}
	
	public void loginToApp(String siteurl, String username,String password) {
		driver.get(siteurl);
		usernameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		signInBtn.click();
	}

}
