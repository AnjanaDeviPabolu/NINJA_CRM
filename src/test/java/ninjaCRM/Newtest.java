package ninjaCRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Newtest {
	
//	@Test(priority=2, invocationCount=0)
//	public void testcreation() {
//		Reporter.log("hello",true);
//	}
//	
//	@Test(priority=1, invocationCount=5, threadPoolSize = 2)
//	public void Testmodification() throws InterruptedException {
//		WebDriver driver=new EdgeDriver();
//		Thread.sleep(5000);
//		driver.close();
//	}
	
	@Test
	public void testcreation() {
		Reporter.log("Test Creation",true);
	}
	
//	@Test(dependsOnMethods = "testcreation")
//	public void Testupdation() {
//		Reporter.log("Test Updation",true);
//	}
	
	@Test(dependsOnMethods = {"testcreation","Testupdation"})
	public void testdeletion() {
		Reporter.log("Test Deletion",true);
	}

}
