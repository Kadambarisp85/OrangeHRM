package util;

import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.observer.entity.MediaEntity;

public class BaseTest {

	protected static ExtentReports extent;
	protected ExtentTest test;

	
	@BeforeSuite
	public void setUpReport()
	{
		extent=ExtentReportManager.getReportInstanec();
	}
	
	@AfterSuite
	public void tearDownReport(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
//			String screenshotPath = ExtentReportManager.captureScreenshot(driver, "Login fail");
//			test.fail("Test fail.....chck screen shot",
//					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		
		extent.flush();
	}
}
