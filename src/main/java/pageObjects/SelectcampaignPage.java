package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectcampaignPage {
	
	WebDriver driver;
	
	public SelectcampaignPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="search-criteria")
	private WebElement dropdown;
	
	@FindBy(id="search-input")
	private WebElement searchBarField;
	
	@FindBy(className = "select-btn")
	private WebElement selectBtn;

	public WebElement getDropdown() {
		return dropdown;
	}

	public WebElement getSearchBarField() {
		return searchBarField;
	}

	public WebElement getSelectBtn() {
		return selectBtn;
	}
	
	

	
	
	
}
