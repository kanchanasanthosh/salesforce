package Testcase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestCase {
	@Test
	public static void Error_login_salesforece1() {
		String expected="Please enter your password.";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		WebElement username=driver.findElement(By.id("username"));
		String attriValue=username.getAttribute("class");
		System.out.println("attribute of the class ="+attriValue);
		String name=	username.getTagName();
		System.out.println("tag name fopr the username field"+name);
		username.sendKeys("username");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.id("Login")).click();
		String actual=driver.findElement(By.id("error")).getText();
		if(actual.equalsIgnoreCase(expected))
		{
			System.out.println("Error_login_salesforece script passed"+actual);
		}
		else {
			System.out.println("Error_login_salesforece script failed");
		}
		driver.close();
	}

	public static void loginSuccess2() {
		String expected = "Salesforce - Essentials Edition";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("bhc.bishophebercollege-zhkb@force.com");
		driver.findElement(By.id("password")).sendKeys("Harsen@1009");
		driver.findElement(By.id("Login")).click();
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected );
		System.out.println(actual);
		driver.close();
	}

	
	public static void rememberme3() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("bhc.bishophebercollege-zhkb@force.com");
		driver.findElement(By.id("password")).sendKeys("Harsen@1009");
		driver.findElement(By.xpath("//*[@id=\"rememberUn\"]")).click();
		driver.findElement(By.id("Login")).click();
		System.out.println("login success");
		Thread.sleep(1000);
		driver.close();
	}
	
	public static void forgotPasswordTest4() {
		String expected = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("bhc.fgfhgdg@force.com");
		driver.findElement(By.id("password")).sendKeys("hfjhf465");
		driver.findElement(By.id("Login")).click();
		String actual = driver.findElement(By.id("error")).getText();
		Assert.assertEquals(actual, expected );
		System.out.println(actual);
		driver.close();
	}
	@Test
	public static void checkUsernameTest5() throws InterruptedException {
		String expected = "kanchana santhosh";
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("bhc.bishophebercollege-zhkb@force.com");
		driver.findElement(By.id("password")).sendKeys("Harsen@1009");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("tryLexDialogX")).click();
		String labelName = driver.findElement(By.id("userNavLabel")).getText();
		Assert.assertEquals(labelName,expected);
		System.out.println(labelName);
		driver.close();
	}
	
	public static void userPost6() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("bhc.bishophebercollege-zhkb@force.com");
		driver.findElement(By.id("password")).sendKeys("Harsen@1009");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("tryLexDialogX")).click();
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
		System.out.println("message posted");
		driver.close();
	}
	@Test
	public static void editprofile() throws InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("bhc.bishophebercollege-zhkb@force.com");
		driver.findElement(By.id("password")).sendKeys("Harsen@1009");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("tryLexDialogX")).click();
		Thread.sleep(3000);
		WebElement usermenu = driver.findElement(By.id("userNavButton"));
		usermenu.click();
		WebElement myprofile = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[1]"));
		myprofile.click();
		 driver.findElement(By.xpath("//*[@id=\"chatterTab\"]/div[2]/div[2]/div[1]/h3/div/div/a/img")).click();
		 Thread.sleep(2000);
		 WebElement frame1= driver.findElement(By.id("contactInfoContentId"));
			driver.switchTo().frame(frame1);
			WebElement contact= driver.findElement(By.xpath("//*[@id=\"contactTab\"]/a"));
			contact.click();
			Thread.sleep(4000);
			driver.findElement(By.id("aboutTab")).click();
			 WebElement lname = driver.findElement(By.id("lastName"));
			 lname.clear();
			 lname.sendKeys("Santhosh");
			 System.out.println("updated");
			Thread.sleep(1000);
				 driver.findElement(By.xpath("//*[@id=\"TabPanel\"]/div/div[2]/form/div/input[1]")).click();
				 System.out.println("updated");
			     driver.close();
			
		 }
	
	
	public static void myProfile() throws InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("bhc.bishophebercollege-zhkb@force.com");
		driver.findElement(By.id("password")).sendKeys("Harsen@1009");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("tryLexDialogX")).click();
		Thread.sleep(3000);
		WebElement usermenu = driver.findElement(By.id("userNavButton"));
		usermenu.click();
		WebElement myprofile = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[1]"));
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
      System.out.println("file uploaded");
		driver.close();
		
	}
	@Test
	public static void addPhoto() throws InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("bhc.bishophebercollege-zhkb@force.com");
		driver.findElement(By.id("password")).sendKeys("Harsen@1009");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("tryLexDialogX")).click();
		Thread.sleep(3000);
		WebElement usermenu = driver.findElement(By.id("userNavButton"));
		usermenu.click();
		WebElement myprofile = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[1]"));
		myprofile.click();
		Thread.sleep(3000);
		driver.findElement(By.id("displayBadge")).click();
		Thread.sleep(2000);
		WebElement frame2 = driver.findElement(By.id("uploadPhotoContentId"));
		driver.switchTo().frame(frame2);
		Thread.sleep(3000);
		WebElement photo = driver.findElement(By.id("j_id0:uploadFileForm:uploadInputFile"));
		photo.sendKeys("C:\\Users\\kanch\\OneDrive\\Pictures\\Saved Pictures\\ppp.jpg");
		System.out.println("pic opened");
		Thread.sleep(3000);
		WebElement saveBtnId = driver.findElement(By.id("j_id0:j_id7:save"));
		saveBtnId.click();
     
		driver.close();
	}

	
	
	
	
	
	
	
	
}


