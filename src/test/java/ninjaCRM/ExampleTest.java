package ninjaCRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ExampleTest {
  @Test
  public void test1() {
	  Reporter.log("Test1",true);
  }
  
  @Test
  public void test2() {
	  Reporter.log("Test2",true);
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  Reporter.log("Before Method",true);
  }

  @AfterMethod
  public void afterMethod() {
	  Reporter.log("After Method",true);
  }

  @BeforeClass
  public void beforeClass1() {
	  Reporter.log("Before Class 1",true);
  }

  @AfterClass
  public void afterClass1() {
	  Reporter.log("After Class 1",true);
  }
  
  @BeforeClass
  public void beforeClass2() {
	  Reporter.log("Before Class 2",true);
  }

  @AfterClass
  public void afterClass2() {
	  Reporter.log("After Class 2",true);
  }

  @BeforeTest
  public void beforeTest() {
	  Reporter.log("Before Test",true);
  }

  @AfterTest
  public void afterTest() {
	  Reporter.log("after Test",true);
  }

  @BeforeSuite
  public void beforeSuite() {
	  Reporter.log("Before suite",true);
  }

  @AfterSuite
  public void afterSuite() {
	  Reporter.log("After Suite",true);
  }

}
