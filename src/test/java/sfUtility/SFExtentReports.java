package sfUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SFExtentReports {
	public static ExtentReports report;
	public static ExtentSparkReporter spartReporter;
	public static ExtentTest testLogger;
	private static SFExtentReports extentObject;
	
	
	//singleton class
	private SFExtentReports() {
	
	}
	
	public static SFExtentReports getInstance() {
		
		if(extentObject ==null) {
			System.out.println("creating textent utility object");
			extentObject = new SFExtentReports();
		}
		return extentObject;
	}
	
	public void startExtentReport() {
		spartReporter = new ExtentSparkReporter(SfConstants.SPARKS_HTML_REPORT_PATH);
		report = new ExtentReports();
		report.attachReporter(spartReporter);
		
		report.setSystemInfo("Host Name", "Salesforce");
		report.setSystemInfo("Environment", "Automation Testing");
		report.setSystemInfo("User Name", "kanchanashree");
		
		spartReporter.config().setDocumentTitle("Test Execution Report");
		spartReporter.config().setReportName("Salesforce regression tests");
		spartReporter.config().setTheme(Theme.DARK);
	}
	
	public void startSingleTestReport(String testScript_name) {
		testLogger = report.createTest(testScript_name);
	}
	
	public void logTestInfo(String text) {
		testLogger.info(text);
	}
	
	public void logTestPassed(String testcaseName) {
		testLogger.pass(MarkupHelper.createLabel(testcaseName+"is  passTest", ExtentColor.GREEN));
	}
	public void logTestFailed(String testcaseName) {
		
		testLogger.pass(MarkupHelper.createLabel(testcaseName+"is  FailedTest", ExtentColor.RED));
	}
	public void logTestFailedwithException(Exception e) {
	testLogger.log(Status.FAIL, e);
	}
	
	public void logTestFailedwithException(Throwable e) {
		testLogger.log(Status.FAIL, e);
		}
	
	
	public void logTestScreenshotBase64(String path) {
		testLogger.addScreenCaptureFromBase64String(path);
	}
	
	public void logTestScreenshot(String path) {
		testLogger.addScreenCaptureFromPath(path);
	}
	public void endReport() {
		report.flush();
	}
	
}
