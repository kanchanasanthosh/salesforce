package Testcase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Contacts {
	
	
	public static void createcontact25() throws InterruptedException {
		
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
		driver.findElement(By.id("Contact_Tab")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("name_lastcon2")).sendKeys("EFGH");
		driver.findElement(By.id("con4")).sendKeys("Santhosh");
		driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]")).click();
		Thread.sleep(3000);
		driver.quit();
		
	}
	
	public static void createviewpage() throws InterruptedException {
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
		driver.quit();
		
	}
	
	public static void checkrecentContact27() throws InterruptedException {
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
		driver.findElement(By.id("Contact_Tab")).click();
		Thread.sleep(1000);
		Select recent = new Select(driver.findElement(By.id("hotlist_mode")));
		recent.selectByValue("2");
		System.out.println("recently created contact diaplayed");
		Thread.sleep(3000);
		driver.close();
	}
	
	public static void myContacts28() throws InterruptedException {
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
		driver.findElement(By.id("Contact_Tab")).click();
		Thread.sleep(1000);
		Select select = new Select(driver.findElement(By.id("fcf")));
		select.selectByValue("00BDn00000LpUKw");
		Thread.sleep(1000);
		System.out.println("My Contacts view page displayed");
		driver.close();
		
	}
	@Test
	public static void viewContact29() throws InterruptedException {
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

		    System.out.println(cell.getText());
		    }

		}	
		
	}
	
	public static void checkErrormessage30() throws InterruptedException {
		
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
		driver.findElement(By.id("Contact_Tab")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[2]")).click();
		driver.findElement(By.id("devname")).sendKeys("EFGH");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='btn primary']")).click();
		Thread.sleep(1000);
		System.out.println("Error message displayed");
		driver.close();
	}
	
	public static void checkCancelbutton31() throws InterruptedException {
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
		System.out.println("Contacts home page displayed and ABCD not created");
		driver.close();
	}
	
	public static void saveandNew32() throws InterruptedException {
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
		System.out.println("New contact page displayed");
		driver.close();
	}
	
	
	
	
}
