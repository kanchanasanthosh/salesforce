package salesforceFWTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(sfUtility.SfTestNgListeners.class)
public class AutomationSF extends BaseTest{
	@Test
	public static void Error_login_salesforece1() throws InterruptedException, IOException {
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		String expected="Please enter your password.";
		String user =propertiesUtil.getPropertyValue("login.invalid.username");
		String pass = propertiesUtil.getPropertyValue("login.null.password");
		Thread.sleep(3000);
		WebElement username = driver.findElement(By.id("username"));
		String name=	username.getTagName();
		logger.info("tag name from the username field"+name);
		enterText(username,user,"UserNameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText( password,pass,"PassWordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);
		String actual=driver.findElement(By.id("error")).getText();
		Assert.assertEquals(actual,expected);
		logger.error(actual);
		logger.info("Testcase ended");
		extentreport.logTestInfo("method ended");
		//getScreenshotOfThePage();
	}
	
	
	@Test
	public static void loginSuccess2() throws InterruptedException, IOException {
		
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		String user =propertiesUtil.getPropertyValue("login.valid.username");
		String pass = propertiesUtil.getPropertyValue("login.valid.password");
		String expected = "Salesforce - Essentials Edition";
		Thread.sleep(3000);
		WebElement username = driver.findElement(By.id("username"));
		enterText(username,user,"UserNameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText( password,pass,"PassWordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("tryLexDialogX")).click();
		Thread.sleep(3000);
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected );
		logger.info(actual+"Testcase passed");
		logger.info("Testcase ended");
		extentreport.logTestInfo("method ended");
	}
	@Test
	public static void rememberme3() throws InterruptedException, IOException {
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		String user =propertiesUtil.getPropertyValue("login.valid.username");
		String pass = propertiesUtil.getPropertyValue("login.valid.password");
		waitUntilPageLoads();
		WebElement username = driver.findElement(By.id("username"));
		enterText(username,user,"UserNameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText( password,pass,"PassWordEle");
		driver.findElement(By.xpath("//*[@id=\"rememberUn\"]")).click();
		logger.info("login success");
		Thread.sleep(1000);
		logger.info("Testcase passed");
		extentreport.logTestInfo("method ended");
	}
	@Test
	public static void forgotPasswordTest4() throws IOException {
		String expected = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		String user =propertiesUtil.getPropertyValue("login.invalid.username");
		String pass = propertiesUtil.getPropertyValue("login.invalid.password");
		waitUntilPageLoads();
		WebElement username = driver.findElement(By.id("username"));
		enterText(username,user,"UserNameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText( password,pass,"PassWordEle");
		driver.findElement(By.id("Login")).click();
		waitUntilPageLoads();
		String actual = driver.findElement(By.id("error")).getText();
		Assert.assertEquals(actual, expected );
		logger.info(actual);
		logger.info("Testcase ended");
		extentreport.logTestInfo("method ended");
	}
	@Test
	public static void forgotPasswordTest4B() throws IOException, InterruptedException {
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		driver.findElement(By.id("forgot_password_link")).click();
		waitUntilPageLoads();
		Thread.sleep(3000);
	    logger.info("forgotpassword page displayed");
	    logger.info("Testcase ended");
	    extentreport.logTestInfo("method ended");
	}
	@Test
	public static void checkUsernameTest5() throws InterruptedException, IOException {
		String expected = "kanchana Santhosh";
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		String user =propertiesUtil.getPropertyValue("login.valid.username");
		String pass = propertiesUtil.getPropertyValue("login.valid.password");
		waitUntilPageLoads();
		WebElement username = driver.findElement(By.id("username"));
		enterText(username,user,"UserNameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText( password,pass,"PassWordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("tryLexDialogX")).click();
		String labelName = driver.findElement(By.id("userNavLabel")).getText();
		Assert.assertEquals(labelName,expected);
		logger.info(labelName);
		logger.info("Testcase ended");
		extentreport.logTestInfo("method ended");
	}
	@Test
	public static void usermenudropdown7() throws InterruptedException, IOException {
	
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		login();
		waitUntilPageLoads();
		WebElement usermenu = driver.findElement(By.id("userNavButton"));
		usermenu.click();
		List<WebElement> menu= driver.findElements(By.xpath("//*[@id=\"userNav-menuItems\"]/a[2]"));
		List<String> expecteditems  =Arrays.asList("My Profile","My Settings", "Developer Console","Switch to Lighting Experience"," Logout" );
		for(WebElement w : menu) {
			logger.info(w.getText());
			Assert.assertTrue(expecteditems.contains((w.getText())));
		}
		logger.info("user profile dropdown menu displayed");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[2]")).click();
		logger.info("my Settings page displayed");
		driver.findElement(By.id("PersonalInfo_font")).click();
		driver.findElement(By.xpath("//*[@id=\"LoginHistory_font\"]")).click();
		logger.info("login history displayed");
		driver.findElement(By.xpath("//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"DisplayAndLayout_font\"]")).click();
		driver.findElement(By.id("CustomizeTabs_font")).click();
		Thread.sleep(3000);
		logger.info(".csv file  downloaded");
		Select chatter = new Select(driver.findElement(By.xpath("//*[@id=\"p4\"]")));
		chatter.selectByValue("02uDn000002cxey");
		Thread.sleep(3000);
			Select availableT = new Select(driver.findElement(By.id("duel_select_0")));
			Thread.sleep(3000);
				availableT.selectByValue("report");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"duel_select_0_right\"]/img")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]")).submit();
				Thread.sleep(1000);
				logger.info("Reports field added to selected tab list");
				driver.findElement(By.id("EmailSetup_font")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("EmailSettings_font")).click();
				Thread.sleep(1000);
				WebElement ename = driver.findElement(By.id("sender_name"));
				ename.clear();
				ename.sendKeys("Kanchana Santhosh");
				Thread.sleep(1000);
				driver.findElement(By.id("EmailSettings_font")).click();
				WebElement email = driver.findElement(By.id("sender_email"));
				email.clear();
				email.sendKeys("bhc.bishophebercollege@gmail.com");
				Thread.sleep(1000);
				driver.findElement(By.id("auto_bcc1")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]")).click();
				Thread.sleep(1000);
				logger.info("mail options and my Settings page displayed");
				driver.findElement(By.id("CalendarAndReminders_font")).click();
				driver.findElement(By.id("Reminders_font")).click();
				Thread.sleep(1000);
				String originalWindow = driver.getWindowHandle();
				assert driver.getWindowHandles().size() == 1;
				driver.findElement(By.id("testbtn")).click();
				Thread.sleep(1000);
				for(String Winhandle :driver.getWindowHandles()) {
					if(!originalWindow.contentEquals( Winhandle));
					driver.switchTo().window(Winhandle);
					Thread.sleep(2000);
					logger.info("sample event pop window  displayed");
					driver.quit();
				}
				logger.info("Testcase ended");
				extentreport.logTestInfo("method ended");
				
		}
	@Test
	public static void userPost6() throws InterruptedException, IOException, AWTException {
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		login();
		WebElement post = driver.findElement(By.xpath("//span[contains(text(), 'Post')]"));
		post.click();
		WebElement frame1 = driver.findElement(By.xpath("//iframe[contains(@title,'Rich Text Editor, publisherRichTextEditor')]"));
		driver.switchTo().frame(frame1);
		WebElement fbody = driver.findElement(By.xpath("//body[contains(text(),'Share an update, @mention someone...')]"));
		fbody.click();
		fbody.sendKeys("Hello Everyone");
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//input[@id ='publishersharebutton'] ")).click();
		Thread.sleep(4000);
		logger.info("message posted");
		WebElement usermenu = driver.findElement(By.id("userNavButton"));
		usermenu.click();
		WebElement myprofile = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[1]"));
		myprofile.click();
		 driver.findElement(By.xpath("//*[@id=\"chatterTab\"]/div[2]/div[2]/div[1]/h3/div/div/a/img")).click();
		 Thread.sleep(2000);
		 WebElement frame2= driver.findElement(By.id("contactInfoContentId"));
			driver.switchTo().frame(frame2);
			WebElement contact= driver.findElement(By.xpath("//*[@id=\"contactTab\"]/a"));
			contact.click();
			Thread.sleep(4000);
			driver.findElement(By.id("aboutTab")).click();
			 WebElement lname = driver.findElement(By.id("lastName"));
			 lname.clear();
			 lname.sendKeys("Santhosh");
			 logger.info("lastname updated");
			Thread.sleep(1000);
				 driver.findElement(By.xpath("//*[@id=\"TabPanel\"]/div/div[2]/form/div/input[1]")).click();
				 logger.info("updated");
				 waitUntilPageLoads();
				  usermenu = driver.findElement(By.id("userNavButton"));
					usermenu.click();
					 myprofile = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[1]"));
					myprofile.click();
					driver.findElement(By.id("publisherAttachContentPost")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@id=\"chatterUploadFileAction\"]")).click();
					//driver.findElement(By.xpath("//*[@id=\"chatterFile\"]")).click();
					JavascriptExecutor executor=(JavascriptExecutor) driver;
					executor.executeScript("document.getElementById('chatterFile').click();");
					Thread.sleep(4000);
					StringSelection stringSelection = new StringSelection("\"C:\\Users\\kanch\\OneDrive\\Desktop\\Gitselenium\\Version1.txt\"");
					Thread.sleep(3000);
					Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
					Robot robot=new Robot();
					robot.delay(1000);
					 robot.keyPress(KeyEvent.VK_CONTROL);
			       robot.keyPress(KeyEvent.VK_V);
			       robot.keyRelease(KeyEvent.VK_V);
			       robot.keyRelease(KeyEvent.VK_CONTROL);
			       robot.keyPress(KeyEvent.VK_ENTER);
			       robot.keyRelease(KeyEvent.VK_ENTER);
			       Thread.sleep(2000);
			       driver.findElement(By.id("publishersharebutton")).click();
			       Thread.sleep(3000);
			      logger.info("file uploaded");
			      waitUntilPageLoads();
			      logger.info("testcase ended");
			       usermenu = driver.findElement(By.id("userNavButton"));
					usermenu.click();
					 myprofile = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[1]"));
					myprofile.click();
					driver.findElement(By.id("displayBadge")).click();
					Thread.sleep(2000);
					WebElement frame3 = driver.findElement(By.id("uploadPhotoContentId"));
					driver.switchTo().frame(frame3);
					Thread.sleep(3000);
					WebElement photo = driver.findElement(By.id("j_id0:uploadFileForm:uploadInputFile"));
					photo.sendKeys("C:\\Users\\kanch\\OneDrive\\Pictures\\Saved Pictures\\ppp.jpg");
					logger.info("pic opened");
					Thread.sleep(3000);
					WebElement saveBtnId = driver.findElement(By.id("j_id0:j_id7:save"));
					saveBtnId.click();
			        logger.info("photo uploaded successfullly");
			        logger.info("Testcase ended");
			        extentreport.logTestInfo("method ended");
	}
	@Test
	public static void developerconsole8() throws InterruptedException, IOException {
	login() ;
	logger.info("inside the testcase");
	extentreport.logTestInfo("inside the test method");
	WebElement usermenu = driver.findElement(By.id("userNavButton"));
	usermenu.click();
	List<WebElement> menu= driver.findElements(By.xpath("//*[@id=\"userNav-menuItems\"]/a[2]"));
	List<String> expecteditems  =Arrays.asList("My Profile","My Settings", "Developer Console","Switch to Lighting Experience"," Logout" );
	for(WebElement w : menu) {
		logger.info(w.getText());
		Assert.assertTrue(expecteditems.contains((w.getText())));
	}
	Thread.sleep(3000);
	logger.info("user dropdown menu displayed with options");
	String originalWindow = driver.getWindowHandle();
	assert driver.getWindowHandles().size() == 1;
	driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[3]")).click();
	Thread.sleep(1000);
	for(String Winhandle :driver.getWindowHandles()) {
		if(!originalWindow.contentEquals( Winhandle));
		driver.switchTo().window(Winhandle);
		Thread.sleep(2000);
	}
	logger.info("testcases ended");
	extentreport.logTestInfo("method ended");
	}
	@Test
	public static void developerconsole9() throws InterruptedException, IOException {
		login();
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		WebElement usermenu = driver.findElement(By.id("userNavButton"));
		usermenu.click();
		List<WebElement> menu= driver.findElements(By.xpath("//*[@id=\"userNav-menuItems\"]/a[2]"));
		List<String> expecteditems  =Arrays.asList("My Profile","My Settings", "Developer Console","Switch to Lighting Experience"," Logout" );
		for(WebElement w : menu) {
			System.out.println(w.getText());
			Assert.assertTrue(expecteditems.contains((w.getText())));
			logger.info("dropdown option selected");
			
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]")).click();
		logger.info("logout successfully");
		extentreport.logTestInfo("method ended");
	}
	@Test
	public static void createAcount10() throws InterruptedException, IOException {
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		login();
		driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a")).click();
		WebElement create =driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
		create.click();
		driver.findElement(By.id("acc2")).sendKeys("Santhoshkumar");
		Select type = new Select(driver.findElement(By.id("acc6")));
		type.selectByValue("Partner");
		Thread.sleep(3000);
		Select typeindustry = new Select(driver.findElement(By.id("acc7")));
		typeindustry.selectByValue("Technology");
		Thread.sleep(3000);
		driver.findElement(By.id("acc20")).sendKeys("Customer priority = 'HIGH'");
		driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]")).click();
		logger.info("Account created");
		Thread.sleep(3000);
		logger.info("Testcase ended");
		extentreport.logTestInfo("method ended");
		
	}
	@Test
	public static void createnewview11() throws InterruptedException, IOException {
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		login();
		driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("fname")).sendKeys("shanthi");
		Thread.sleep(1000);
		driver.findElement(By.id("devname")).sendKeys("kanachin");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[1]")).click();
		Thread.sleep(1000);
		logger.info("new view created");
		extentreport.logTestInfo("new view created");
		logger.info("Testcase ended");
		extentreport.logTestInfo("method ended");
	
	}
	
	public static void editview12() throws InterruptedException, IOException {
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		login();
		driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a")).click();
		Thread.sleep(1000);
		Select viewname = new Select(driver.findElement(By.id("fcf")));
		viewname.selectByValue("00BDn00000LY3yB");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[1]")).click();
		WebElement changename = driver.findElement(By.id("fname"));
		changename.clear();
		changename.sendKeys("Hari");
		Thread.sleep(1000);
		Select field = new Select(driver.findElement(By.id("fcol1")));
		field.selectByValue("ACCOUNT.NAME");
		Thread.sleep(3000);
		Select operator = new Select(driver.findElement(By.id("fop1")));
		operator.selectByValue("c");
		Thread.sleep(3000);
		driver.findElement(By.id("fval1"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[1]")).click();
		Thread.sleep(1000);
		logger.info("view name updated");
		extentreport.logTestInfo("view name updated");
		logger.info("Testcase ended");
		extentreport.logTestInfo("method ended");
		
	}
	
	@Test
	public static void mergeAccounts13() throws InterruptedException, IOException {
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		login();
		driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[2]/div/div/div/ul/li[4]/span/a")).click();
		WebElement search =driver.findElement(By.id("srch"));
		search.sendKeys("santhosh");
		driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[4]/input[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[5]/div/input[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[5]/div/input[2]")).click();
		Thread.sleep(1000);
		Alert alertpop = driver.switchTo().alert();
	    alertpop.accept();
	    Thread.sleep(3000);
	    logger.info("Acccount merged");
		extentreport.logTestInfo("Acccount merged");
		logger.info("Testcase ended");
		extentreport.logTestInfo("method ended");
		
	}
	
	public static void createReport14() throws InterruptedException, IOException {
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		login();
		driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div/div[1]/ul/li[2]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ext-gen49")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("saveReportDlg_reportNameField")).sendKeys("dailypppp");
		driver.findElement(By.id("saveReportDlg_DeveloperName")).sendKeys("saveReport_Arun");
		driver.findElement(By.id("ext-gen258")).click();
		Thread.sleep(3000);
		logger.info("report created");
		extentreport.logTestInfo("report created");
		logger.info("Testcase ended");
		extentreport.logTestInfo("method ended");
		
	}
	
	@Test
	public static void opportunity15() throws InterruptedException, IOException {
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		login();
		driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("fcf")).click();
		Thread.sleep(3000);
		logger.info("Opportunities drop down displayed");
		extentreport.logTestInfo("Opportunities drop down displayed");
		logger.info("Testcase ended");
		extentreport.logTestInfo("method ended");
	}
	
	
	@Test
	public static void opportunity16() throws InterruptedException, IOException {
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		login();
		driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("opp3")).sendKeys("Product Trading");
		Thread.sleep(1000);
		driver.findElement(By.id("opp4")).sendKeys("Santhosh");
		Thread.sleep(1000);
		Select stage = new Select(driver.findElement(By.id("opp11")));
		stage.selectByValue("Proposal/Price Quote");
		Thread.sleep(1000);
		WebElement date = driver.findElement(By.id("opp9"));
		String dateval ="03/19/2023";
		datepicker(driver,date,dateval);
		Thread.sleep(1000);
		WebElement  probability =driver.findElement(By.id("opp12"));
		probability.clear();
		probability.sendKeys("75");
		Thread.sleep(1000);
		Select lead = new Select(driver.findElement(By.id("opp6")));
		lead.selectByValue("Trade Show");
		driver.findElement(By.id("opp14")).sendKeys("Primary Compaign");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]")).click();
		Thread.sleep(1000);
		logger.info("New Opportunity page displayed");
		extentreport.logTestInfo("New Opportunity page displayed");
		logger.info("Testcase ended");
		extentreport.logTestInfo("method ended");
		
	}
	
	
	@Test
	public static void opportunity17() throws InterruptedException, IOException {
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		login();
		driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[1]/a")).click();
		Thread.sleep(3000);
		logger.info("Opportunities with report page displayed");
		extentreport.logTestInfo("Opportunities with report page displayed");
		logger.info("Testcase ended");
		extentreport.logTestInfo("method ended");
		
	}
	
	
	@Test
	public static void opportunity18() throws InterruptedException, IOException {
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		login();
		driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[2]/a")).click();
		Thread.sleep(3000);
		logger.info("stuck oppprtunities displayed");
		extentreport.logTestInfo("stuck oppprtunities displayed");
		logger.info("Testcase ended");
		extentreport.logTestInfo("method ended");
		
	}
	
	@Test
	public static void opportunity19() throws InterruptedException, IOException {
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		login();
		driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a")).click();
		Thread.sleep(1000);
		Select interval = new Select(driver.findElement(By.id("quarter_q")));
		interval.selectByValue("curfy");
		Thread.sleep(1000);
		Select opt = new Select(driver.findElement(By.id("open")));
		opt.selectByValue("open");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"lead_summary\"]/table/tbody/tr[3]/td/input")).click();
		logger.info("report page with opportunities satisfied criteria ");
		extentreport.logTestInfo("report page with opportunities satisfied criteria ");
		logger.info("Testcase ended");
		extentreport.logTestInfo("method ended");
		
	}
	
	
	@Test
	public static  void leadsTab20() throws InterruptedException, IOException {
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		login();
		driver.findElement(By.xpath("//*[@id=\"Lead_Tab\"]")).click();
		Thread.sleep(1000);
		System.out.println("leads page displayed");
		driver.findElement(By.id("userNav")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]")).click();
		Thread.sleep(1000);
		logger.info("Leads home page displayed ");
		extentreport.logTestInfo("Leads home page displayed ");
		logger.info("Testcase ended");
		extentreport.logTestInfo("method ended");
		
	}
	
	
	@Test
	public static void selectview21() throws InterruptedException, IOException {
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		login();
		driver.findElement(By.xpath("//*[@id=\"Lead_Tab\"]")).click();
		Thread.sleep(1000);
		String[] str= {"All Open Leads","Lost Leads","My Unread Leads","Recently Viewed Leads","Today's Leads"};
		Select select = new Select(driver.findElement(By.id(("fcf"))));
	    List<WebElement> option = select.getOptions();
	    for(WebElement w :option) {
	    	for(int i=0;i<str.length; i++) {
	    		if(w.getText().equalsIgnoreCase(str[i])) {
	    			System.out.println(w.getText()+" "+"validated");
	    		}			
	    	}
	    }	
	    driver.findElement(By.id("userNav")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]")).click();
		Thread.sleep(1000);
		logger.info("Leads dropdown contents displayed ");
		extentreport.logTestInfo("Leads dropdown contents  displayed ");
		logger.info("Testcase ended");
		extentreport.logTestInfo("method ended");
		
	}
	
	
	@Test
	public static void defaultView22() throws InterruptedException, IOException {
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		login();
		driver.findElement(By.xpath("//*[@id=\"Lead_Tab\"]")).click();
		Thread.sleep(1000);
		Select select = new Select(driver.findElement(By.id(("fcf"))));
		select.selectByValue("00BDn00000LpUMC");
		Thread.sleep(1000);
		System.out.println("My Unread Leads page displayed");
		Thread.sleep(3000);
		select.selectByValue("00BDn00000LpUKz");
		Thread.sleep(1000);
		  driver.findElement(By.id("userNav")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]")).click();
			Thread.sleep(1000);
 		Thread.sleep(6000);
 		log(driver); 
 		logger.info("default view  displayed ");
		extentreport.logTestInfo("default view  displayed ");
		logger.info("Testcase ended");
		extentreport.logTestInfo("method ended");
		
	}
	
	
	@Test
	public static void leadview23() throws InterruptedException, IOException {
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		login();	
		driver.findElement(By.id("Lead_Tab")).click();
		Select select =new Select(driver.findElement(By.id("fcf")));
		select.selectByValue("00BDn00000LpUKz");
		driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[1]/input")).click();
		Thread.sleep(2000);
		logger.info("Today's lead page displayed");
		extentreport.logTestInfo("Today's lead page displayed");
		Thread.sleep(2000);
		 driver.findElement(By.id("userNav")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]")).click();
		logger.info("Testcase ended");
		extentreport.logTestInfo("method ended");
		
		
	}
	
	@Test
	public static void createleadview24() throws InterruptedException, IOException {
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		login();
		driver.findElement(By.id("Lead_Tab")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("name_lastlea2")).sendKeys("ABCD");
		driver.findElement(By.id("lea3")).sendKeys("ABCD");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]")).click();
		Thread.sleep(3000);
		logger.info("Newly created lead view displayed");
		extentreport.logTestInfo("newly created lead view displayed");
		logger.info("Testcase ended");
		extentreport.logTestInfo("method ended");
	}
		
	
	@Test
	public static void createcontact25() throws InterruptedException, IOException {
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		login();
		driver.findElement(By.id("Contact_Tab")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("name_lastcon2")).sendKeys("EFGH");
		driver.findElement(By.id("con4")).sendKeys("Santhosh");
		driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]")).click();
		Thread.sleep(3000);
		logger.info("New contact created ");
		extentreport.logTestInfo("New contact created");
		logger.info("Testcase ended");
		extentreport.logTestInfo("method ended");
		
	}
	
	
	
	@Test
	public static void createviewpage26() throws InterruptedException, IOException {
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		login();
		driver.findElement(By.id("Contact_Tab")).click();
		Thread.sleep(1000);
		System.out.println("contact home displayed");
		driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[2]")).click();
		driver.findElement(By.id("fname" )).sendKeys("santhoshkumar");
		Thread.sleep(1000);
		driver.findElement(By.id("devname")).sendKeys("kanachin");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[1]")).click();
		Thread.sleep(3000);
		logger.info(" contacts home page displayed with dropdown ");
		extentreport.logTestInfo("contacts home page displayed with dropdown");
		logger.info("Testcase ended");
		extentreport.logTestInfo("method ended");
		
	}
	
	
	
	@Test
	public static void checkrecentContact27() throws InterruptedException, IOException {
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		login();
		driver.findElement(By.id("Contact_Tab")).click();
		Thread.sleep(1000);
		Select recent = new Select(driver.findElement(By.id("hotlist_mode")));
		recent.selectByValue("2");
		Thread.sleep(3000);
		logger.info("recently created contact diaplayed");
		extentreport.logTestInfo("recently created contact diaplayed");
		logger.info("Testcase ended");
		extentreport.logTestInfo("method ended");
	}
	
	
	
	@Test
	public static void myContacts28() throws InterruptedException, IOException {
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		login();
		driver.findElement(By.id("Contact_Tab")).click();
		Thread.sleep(1000);
		Select select = new Select(driver.findElement(By.id("fcf")));
		select.selectByValue("00BDn00000LpUKw");
		Thread.sleep(1000);
		logger.info("My Contacts view page displayed");
		extentreport.logTestInfo("My Contacts view page displayed");
		logger.info("Testcase ended");
		extentreport.logTestInfo("method ended");
		
	}
	
	
	
	@Test
	public static void viewContact29() throws InterruptedException, IOException {
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		login();
		driver.findElement(By.id("Contact_Tab")).click();
		Thread.sleep(1000);
		Select select = new Select(driver.findElement(By.id("hotlist_mode")));
		select.selectByValue("2");
		
		int rowcount = driver.findElements(By.xpath("//table[@class='list']//tr")).size();		
		int colcount = driver.findElements(By.xpath("//table[@class='list']//th")).size();
		System.out.println(rowcount);
		System.out.println(colcount);
		Thread.sleep(7000);
		List<WebElement> allRows = driver.findElements(By.xpath("//*[@id=\"bodyCell\"]/div[3]/div[1]/div/div[2]/table")); 

		
		for (WebElement row : allRows) { 
		    List<WebElement> cells = row.findElements(By.tagName("td")); 

		   
		    for (WebElement cell : cells) {         

		    	logger.info (cell.getText());
		    	extentreport.logTestInfo (cell.getText());
		    }

		}	
		logger.info("contact page with information displayed");
		extentreport.logTestInfo("contact page with information displayed");
		logger.info("Testcase ended");
		extentreport.logTestInfo("method ended");
		
	}
	
	
	@Test
	public static void checkErrormessage30() throws InterruptedException, IOException {
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		login();
		driver.findElement(By.id("Contact_Tab")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[2]")).click();
		driver.findElement(By.id("devname")).sendKeys("EFGH");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='btn primary']")).click();
		Thread.sleep(1000);
		logger.info("Error message displayed");
		extentreport.logTestInfo("Error message displayed");
		logger.info("Testcase ended");
		extentreport.logTestInfo("method ended");
		
	}
	
	
	
	@Test
	public static void checkCancelbutton31() throws InterruptedException, IOException {
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		login();
		driver.findElement(By.id("Contact_Tab")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("fname")).sendKeys("ABCD");
		Thread.sleep(1000);
		driver.findElement(By.id("devname")).sendKeys("EFGH");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[2]")).click();
		Thread.sleep(1000);
		logger.info("Contacts home page displayed and ABCD not created");
		extentreport.logTestInfo("Contacts home page displayed and ABCD not created");
		logger.info("Testcase ended");
		extentreport.logTestInfo("method ended");
		
	}
	@Test
	public static void saveandNew32() throws InterruptedException, IOException {
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		login();
		driver.findElement(By.id("Contact_Tab")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("name_firstcon2")).sendKeys("santhi");
		driver.findElement(By.id("name_lastcon2")).sendKeys("subramani");
		driver.findElement(By.id("con4")).sendKeys("Santhosh");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[2]")).click();
		Thread.sleep(2000);
		logger.info("New contact page displayed");
		extentreport.logTestInfo("New contact page displayed");
		logger.info("Testcase ended");
		extentreport.logTestInfo("method ended");
		
	}
	
	
	@Test	
	public static void verifyName33() throws InterruptedException, IOException {
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		login();
		String expected = "kanchana santhosh ";
		Thread.sleep(2000);
		driver.findElement(By.id("userNavLabel")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("tailBreadcrumbNode")).getText().equalsIgnoreCase(expected);
		Thread.sleep(3000);
		logger.info("first and lastname verified");
		extentreport.logTestInfo("New contact page displayed");
		logger.info("first and lastname verified");
		extentreport.logTestInfo("method ended");
	}
	
	
	@Test
	public static void editLastname34() throws InterruptedException, IOException {
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		login();
		driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div/span[1]/h1")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"chatterTab\"]/div[2]/div[2]/div[1]/h3/div/div/a/img")).click();
		Thread.sleep(3000);
		WebElement frame1= driver.findElement(By.id("contactInfoContentId"));
		driver.switchTo().frame(frame1);
		System.out.println("updated2");
		WebElement contact= driver.findElement(By.xpath("//*[@id=\"contactTab\"]/a"));
		contact.click();
		Thread.sleep(4000);
		driver.findElement(By.id("aboutTab")).click();
		 WebElement lname = driver.findElement(By.id("lastName"));
		 lname.clear();
		 lname.sendKeys("Abcd");
		 System.out.println("updated2");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"TabPanel\"]/div/div[2]/form/div/input[1]")).click();
		logger.info("Lastname updated");
		 extentreport.logTestInfo("Lastname updated");
		logger.info("first and lastname verified");
		extentreport.logTestInfo("method ended");
		
	}

	
	
	@Test
	public static void customizeTab35() throws InterruptedException, IOException {
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		login();
		driver.findElement(By.xpath("//*[@id=\"AllTab_Tab\"]/a/img")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[3]/div[1]/table/tbody/tr/td[2]/input")).click();
		Thread.sleep(3000);
		Select tab = new Select(driver.findElement(By.id("duel_select_1")));
		tab.selectByValue("CollaborationGroup");
		driver.findElement(By.id("duel_select_0_left")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("userNavLabel")).click();
		driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]")).click();
		Thread.sleep(3000);
		relogin(driver);
		logger.info("removed tab not present in the tab menu");
		extentreport.logTestInfo("removed tab not present in the tab menu");
		logger.info("first and lastname verified");
		extentreport.logTestInfo("method ended");
	}
	
	
	@Test
	public static void  blockingEvent36() throws InterruptedException, IOException {
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		login();	
		driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div/span[2]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"p:f:j_id25:j_id61:28:j_id64\"]/a")).click();
	    driver.findElement(By.id("evt5")).sendKeys("Other");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]")).click();
	    Thread.sleep(3000);
	    driver.close();
	    logger.info("other event scheduled");
	    extentreport.logTestInfo("other event scheduled");
	    logger.info("first and lastname verified");
		extentreport.logTestInfo("method ended");
		
	}
	
	@Test
	public static void blockEvent37() throws InterruptedException, IOException {
		logger.info(" inside Testcase");
		extentreport.logTestInfo("inside the test method");
		login();
		driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div/span[2]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("p:f:j_id25:j_id61:20:j_id64")).click();
		driver.findElement(By.id("evt5")).sendKeys("Other");
	    Thread.sleep(3000);
	    WebElement dropdown =  driver.findElement(By.id("EndDateTime_time"));
	   dropdown.sendKeys("7:00 PM");
	   dropdown.click();
	   System.out.println("time selected");
		Thread.sleep(1000);
		driver.findElement(By.id("IsRecurrence")).click();
		driver.findElement(By.id("rectypeftw")).click();
		driver.findElement(By.id("wi")).sendKeys("2");
		driver.findElement(By.id("RecurrenceEndDateOnly")).sendKeys("2/28/2023");
		driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]")).click();
		logger.info("Another event blocked");
	    extentreport.logTestInfo("Another event blocked");
	    logger.info("first and lastname verified");
		extentreport.logTestInfo("method ended");
	}
	
}
