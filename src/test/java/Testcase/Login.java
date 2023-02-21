package Testcase;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
















































public class Login {
	
	public static void enterText(WebElement element,String text,String name) {
		if(element.isDisplayed()) {
			element.clear();
			element.sendKeys(text);
		}
		else {
			System.out.println(name+"Web element not displayed");
		}
		
	}
	/*
public void loginSuccess2() throws InterruptedException, IOException {
		
		logger.info(" inside Testcase");
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
		getScreenshotOfThePage();
	}
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void loginSuccess2() {
		String expected = "Salesforce - Essentials Edition";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		WebElement username = driver.findElement(By.id("username"));
		enterText(username,"bhc.bishophebercollege-zhkb@force.com","UserName");
		WebElement password = driver.findElement(By.id("password"));
		enterText( password,"Harsen@1009","PassWord");
		
		driver.findElement(By.id("Login")).click();
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected );
		System.out.println(actual);
		
		
		driver.close();
	}
	
	public static void calender() throws InterruptedException {
		
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
		driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input")).click();
		Thread.sleep(1000);
		WebElement date = driver.findElement(By.id("opp9"));
		String dateval ="03/19/2023";
		datepicker(driver,date,dateval);
		Thread.sleep(1000);
		
	}
	public static void datepicker(WebDriver driver,WebElement element,String dateval) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value','"+dateval+"');",element);
		System.out.println("date selected");
	}
	
	@Test
	public static void table() throws InterruptedException {
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
		driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div/span[2]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"p:f:j_id25:j_id61:28:j_id64\"]/a")).click();
	    driver.findElement(By.id("evt5")).sendKeys("Other");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]")).click();
	    Thread.sleep(3000);
	    driver.close();
   }
	          
	
}
