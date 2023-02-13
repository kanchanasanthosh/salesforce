package Testcase;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Opportunities {
	
	public static void opportunity15() throws InterruptedException {
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
		driver.findElement(By.id("fcf")).click();
		Thread.sleep(3000);
		System.out.println("Opportunities drop down displayed");
		driver.close();	
	}
	public static void datepicker(WebDriver driver,WebElement element,String dateval) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value','"+dateval+"');",element);
		System.out.println("date selected");
	}
	
	public static void opportunity16() throws InterruptedException {
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
		System.out.println("testcase completed");
	}
	
	public static void opportunity17() throws InterruptedException {
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
		
		driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[1]/a")).click();
		Thread.sleep(3000);
		System.out.println("opportunities displayed");
		driver.close();
	}
	
	public static void opportunity18() throws InterruptedException {
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
		driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[2]/a")).click();
		Thread.sleep(3000);
		System.out.println("stuck oppprtunities displayed");
	}
	@Test
	public static void opportunity19() throws InterruptedException {
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
		driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a")).click();
		Thread.sleep(1000);
		Select interval = new Select(driver.findElement(By.id("quarter_q")));
		interval.selectByValue("curfy");
		Thread.sleep(1000);
		Select opt = new Select(driver.findElement(By.id("open")));
		opt.selectByValue("open");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"lead_summary\"]/table/tbody/tr[3]/td/input")).click();
		System.out.println("Report page displayed");
		driver.close();
	}
}
