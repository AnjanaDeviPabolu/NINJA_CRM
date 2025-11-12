package genericUtilities;

import java.io.File;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utility_Files.JavaUtilityFile;

public class ListenerImplementation implements ITestListener, ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report configuration");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report Backup");
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testcaseName=result.getMethod().getMethodName();
		System.out.println(testcaseName+" Execution started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testcaseName=result.getMethod().getMethodName();
		System.out.println(testcaseName+" Execution Success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testcaseName=result.getMethod().getMethodName();
		System.out.println(testcaseName+" Execution failed");
		JavaUtilityFile jLib=new JavaUtilityFile();
		TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:/Users/pabol/eclipse-workspace/AdvancedSelenium/Screenshots"+testcaseName+jLib.getCurrentdateandTime()+".png");
		try {
			FileHandler.copy(temp, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testcaseName=result.getMethod().getMethodName();
		System.out.println(testcaseName+" Execution Skipped");
	}

}
