package sfUtility;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import salesforceFWTest.BaseTest;

public class SfTestNgListeners implements ITestListener{
	 protected static SFExtentReports extentreport = null;
	 protected WebDriver driver;
	 
	@Override
	public void onTestStart(ITestResult result) { //method
		//System.out.println("Testscript started");
		extentreport.startSingleTestReport(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentreport.logTestPassed(result.getMethod().getMethodName());
		//System.out.println("Test completed ");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("some Test failed"+result);
		extentreport.logTestFailed(result.getMethod().getMethodName());
		BaseTest ob = new BaseTest();
		driver =ob.returnDriverInstance();
		String path =ob.getScreenshottBase64(driver);
		extentreport.logTestFailedwithException(result.getThrowable());
		extentreport.logTestScreenshot(path);
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod().getMethodName());
	}

	@Override
	public void onStart(ITestContext context) {  //before starts any of the test methods/test
		
		extentreport =SFExtentReports.getInstance();
    	extentreport.startExtentReport();
    	//extentreport.logTestInfo("Test started");
	}

	@Override
	public void onFinish(ITestContext context) { //after all test methods
		System.out.println("Test completed successfully");
		extentreport.endReport();
	}

}
