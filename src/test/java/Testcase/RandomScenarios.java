package Testcase;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Transferable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RandomScenarios {
	
	public static void verifyName33() throws InterruptedException {
		
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
		Thread.sleep(1000);
		String expected = "kanchana santhosh ";
		Thread.sleep(2000);
		driver.findElement(By.id("userNavLabel")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("tailBreadcrumbNode")).getText().equalsIgnoreCase(expected);
		Thread.sleep(3000);
		System.out.println("first and lastname verified");
		driver.close();
	}
	@Test
	public static void editLastname34() throws InterruptedException {
		
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
		Thread.sleep(1000);
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
			 System.out.println("updated");
		     driver.close();
	}
	
	
	public static void relogin(WebDriver drivers) throws InterruptedException {
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
		Thread.sleep(1000);
	}
	
	
	
	
	public static void customizeTab35() throws InterruptedException {
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
		Thread.sleep(1000);
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
		System.out.println("removed tab not present in the tab menu");
		Thread.sleep(3000);
		driver.quit();
	}
	
	public static void Timepicker(WebDriver driver,WebElement element,String timeval) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value','"+timeval+"');",element);
		System.out.println("time selected");
	}
	
	
	public static void  blockingEvent36() throws InterruptedException {
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
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div/span[2]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"p:f:j_id25:j_id61:28:j_id64\"]/a")).click();
	    driver.findElement(By.id("evt5")).sendKeys("Other");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]")).click();
	    Thread.sleep(3000);
	    driver.close();
		System.out.println("other event scheduled");
		Thread.sleep(3000);
		
	}
	

	public static void blockEvent() throws InterruptedException {
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
		Thread.sleep(1000);
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
		Thread.sleep(3000);
		
		
		
		
	}
	
	

}
