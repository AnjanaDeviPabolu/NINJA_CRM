package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	
	WebDriver driver;
	
	public CreateContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='organizationName']")
	private WebElement OrganizationNameTF;
	
	@FindBy(xpath="//input[@name='title']")
	private WebElement TitleTF;
	
	@FindBy(name = "department")
	private WebElement DepartmentTF;
	
	@FindBy(xpath="//input[@name='contactName']")
	private WebElement ContactNameTF;
	
	@FindBy(xpath="//input[@name='mobile']")
	private WebElement MobileTF;
	
	@FindBy(name = "email")
	private WebElement EmailTF;
	
	@FindBy(xpath="//*[name()='svg' and @data-icon='plus']")
	private WebElement CreatecampaignPlusBtn;
	
	@FindBy(xpath="//button[text()='Create Contact']")
	private WebElement createContactBtn;

	public WebElement getOrganizationNameTF() {
		return OrganizationNameTF;
	}

	public WebElement getTitleTF() {
		return TitleTF;
	}

	
	public WebElement getDepartmentTF() {
		return DepartmentTF;
	}

	public WebElement getEmailTF() {
		return EmailTF;
	}

	public WebElement getContactNameTF() {
		return ContactNameTF;
	}

	public WebElement getMobileTF() {
		return MobileTF;
	}

	public WebElement getCreatecampaignPlusBtn() {
		return CreatecampaignPlusBtn;
	}

	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}

	
	
}
