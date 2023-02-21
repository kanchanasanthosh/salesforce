package salesforceFWTest;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import sfUtility.PropUtility;
import sfUtility.SFExtentReports;
import sfUtility.SfConstants;

public class BaseTest {
	
	static WebDriver driver =null;
    static PropUtility propertiesUtil=null;
    protected static  Logger logger = null;
   static SFExtentReports extentreport = SFExtentReports.getInstance();
    
    @BeforeTest
    public void setUpBeforeTest() {
    	logger = LogManager.getLogger(BaseTest.class.getName());
    	//extentreport.logTestInfo("started before Testmethod " );
    }
    
	@BeforeMethod
	public void setup(Method method) throws IOException {
		
		logger.info("Testscript name = "+method.getName());//replaced syso
		//extentreport.logTestInfo("started Testscript name "+method.getName() );
		propertiesUtil = new PropUtility();  
		propertiesUtil.loadFile();
		String url = propertiesUtil.getPropertyValue("url");
		GetDriverInstance("chrome");
		goToUrl(url);
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	
	
	public static void login() throws InterruptedException, IOException {
		String user =propertiesUtil.getPropertyValue("login.valid.username");
		String pass = propertiesUtil.getPropertyValue("login.valid.password");
		Thread.sleep(3000);
		WebElement username = driver.findElement(By.id("username"));
		enterText(username,user,"UserNameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText( password,pass,"PassWordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("tryLexDialogX")).click();
		waitUntilPageLoads();
		extentreport.logTestInfo("logged in success ");
	}
	public static void enterText(WebElement element,String text,String name) {
		if(element.isDisplayed()) {
			clearElement(element,name);
			element.sendKeys(text);
			logger.info(name+"text entered");
			extentreport.logTestInfo(name+"text entered");
		}
		else {
			logger.info(name+"Web element not displayed");
			extentreport.logTestInfo(name+"Web element not displayed");
		}
		driver.getTitle();
	}
	
	public static void clearElement(WebElement element,String objname) {
		if(element.isDisplayed()) {
			element.clear();
		} else {
			logger.info(objname+" "+"element not diaplayed");
			
		}
	}
	
	public static void goToUrl(String url) {
		driver.get(url);
	}
	
	public static void GetDriverInstance(String browserName) {
		
		switch(browserName) {
		case "firefox": WebDriverManager.firefoxdriver().setup();
		 driver=new FirefoxDriver();
		driver.manage().window().maximize();
		break;
		
		case "chrome": WebDriverManager.chromedriver().setup();
		               driver=new ChromeDriver();
		               driver.manage().window().maximize();
	                   break;
	  default:logger.info("not entered proper browser name");
	}	
}
	public static void waitUntilPageLoads() {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	public WebDriver returnDriverInstance() {
		return driver;
	}
	
	public String getScreenshottBase64(WebDriver driver) {
		String date =new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
		String curdir = SfConstants.USER_DIR;
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		String img = screenshot.getScreenshotAs(OutputType.BASE64);
		return img;
		
		
	}
	
	
	
	public static void getScreenshotOfThePage() {
		String date =new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
		String curdir = System.getProperty("user.dir");
		TakesScreenshot screenShot = (TakesScreenshot)driver;
		File imgFile =screenShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(SfConstants.SCREENSHOT_DIRECTORY_PATH+date+".png");
		try {
			FileHandler.copy(imgFile, destFile);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		logger.info("screenshot taken");
		extentreport.logTestInfo("screenshot taken");
	}
	
	public static String getScreenshotOfThePage(WebDriver driver) {
		String date =new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
		
		TakesScreenshot screenShot = (TakesScreenshot)driver;
		File imgFile =screenShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(SfConstants.SCREENSHOT_DIRECTORY_PATH+date+".png");
		try {
			FileHandler.copy(imgFile, destFile);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		logger.info("screenshot taken");
		extentreport.logTestInfo("screenshot taken");
		return destFile.getAbsolutePath();
	}
	public static void datepicker(WebDriver driver,WebElement element,String dateval) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value','"+dateval+"');",element);
		System.out.println("date selected");
	}
	
	public static void log(WebDriver driver2) throws InterruptedException, IOException {
		login();
		driver.findElement(By.id("Lead_Tab")).click();
		System.out.println(" Leads home page displayed");
		Thread.sleep(2000);
		Select select = new Select(driver.findElement(By.id(("fcf"))));
		select.getFirstSelectedOption().getText().compareTo("Today's Leads");
		System.out.println("Today's Leads home page displayed");
		Thread.sleep(2000);
		 driver.findElement(By.id("userNav")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]")).click();
		
	}
	
	public static void relogin(WebDriver drivers) throws InterruptedException, IOException {
		login();
	}
	
	public static void Timepicker(WebDriver driver,WebElement element,String timeval) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value','"+timeval+"');",element);
		System.out.println("time selected");
	}
	
	
	
         
}