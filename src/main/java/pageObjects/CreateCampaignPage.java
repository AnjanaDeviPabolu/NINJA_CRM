package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	
	WebDriver driver;
	
	public CreateCampaignPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="campaignName")
	private WebElement CampaignNameTF;
	
	@FindBy(xpath="//input[@name='campaignStatus']")
	private WebElement CampaignstatusTF;
	
	@FindBy(name="targetSize")
	private WebElement TargetsizeTF;
	
	@FindBy(xpath="//input[@name='expectedCloseDate']")
	private WebElement ExpectedClosedateTF;
	
	@FindBy(name = "targetAudience")
	private WebElement TargetAudienceTF;
	
	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement DescriptionTF;
	
	@FindBy(xpath="//button[text()='Create Campaign']")
	private WebElement createcampaignBTn;

	public WebElement getCampaignNameTF() {
		return CampaignNameTF;
	}

	public WebElement getCampaignstatusTF() {
		return CampaignstatusTF;
	}

	public WebElement getTargetsizeTF() {
		return TargetsizeTF;
	}

	public WebElement getExpectedClosedateTF() {
		return ExpectedClosedateTF;
	}

	public WebElement getTargetAudienceTF() {
		return TargetAudienceTF;
	}

	public WebElement getDescriptionTF() {
		return DescriptionTF;
	}

	public WebElement getCreatecampaignBTn() {
		return createcampaignBTn;
	}
	
	
	

}
