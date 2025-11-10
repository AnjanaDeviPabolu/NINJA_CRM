package ninjaCRM;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.LoginPage_POM;
import utility_Files.WebDriverUtility;

public class Create_Campaign_test {

	public static void main(String[] args) {
		
		ChromeOptions settings = new ChromeOptions();
		
		Map<String, Object> prefs = new HashMap<>();
		
		prefs.put("profile.password_manager_leak_detection", false);
		
		settings.setExperimentalOption("prefs", prefs);
		
		WebDriverUtility wLib=new WebDriverUtility();
		
		WebDriver driver=new ChromeDriver(settings);
		
		driver.manage().window().maximize();
		
		wLib.implicitlyWait(driver);
		
//		driver.get("http://49.249.28.218:8098/");
//		
//		driver.findElement(By.id("username")).sendKeys("rmgyantra");
//		
//		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
//		
//		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		//login
		LoginPage_POM loginPage=new LoginPage_POM(driver);
		loginPage.loginToApp(null, null, null);
		
		
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		
		driver.findElement(By.name("campaignName")).sendKeys("Dummycampaign");
		
		WebElement targetSize = driver.findElement(By.name("targetSize"));
		
		targetSize.clear();
		
		targetSize.sendKeys("2");
		
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		
		WebElement alertmsg = driver.findElement(By.xpath("//div[@role='alert']"));
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		
		wait.until(ExpectedConditions.visibilityOf(alertmsg));
		
		if(alertmsg.getText().contains("Successfully Added")) {
			System.out.println("campaign created");
		}
		else
		{
			System.out.println("campaign not created");
		}
		
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		
		Actions act=new Actions(driver);
		
		WebElement usericon = driver.findElement(By.xpath("//div[@class='user-icon']"));
		
		act.moveToElement(usericon).perform();
		
		driver.findElement(By.xpath("//div[text()='Logout ']")).click();
		
		driver.quit();
		
	

	}

}
