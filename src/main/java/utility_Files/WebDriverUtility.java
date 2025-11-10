package utility_Files;

import java.time.Duration;

import javax.swing.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void implicitlyWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void waitUntilElementToBeVisible(WebDriver driver, WebElement webelement) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(webelement));
	}
	
	public void select(WebElement element, String value) {
		Select obj=new Select(element);
		obj.selectByValue(value);
	}
	
	public void select(String text, WebElement element) {
		Select obj=new Select(element);
		obj.selectByValue(text);
	}
	
	public void select(WebElement element, int index) {
		Select obj=new Select(element);
		obj.selectByIndex(index);
	}
	
	public void mouseHoverOnWebElement(WebDriver driver, WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).click().perform();
	}
	
	public void clickOnWebElement(WebDriver driver, WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).click().perform();
	}
}
