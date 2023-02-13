package Testcase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeadTestcases {
	
	
	public static  void leadsTab20() throws InterruptedException {
		
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
		driver.findElement(By.xpath("//*[@id=\"Lead_Tab\"]")).click();
		Thread.sleep(1000);
		System.out.println("leads page displayed");
		driver.findElement(By.id("userNav")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]")).click();
		Thread.sleep(1000);
		driver.quit();
	}
	
	public static void selectview21() throws InterruptedException {
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
	    driver.close();
	}
	public static void log(WebDriver driver2) throws InterruptedException {
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
	

	public static void defaultView22() throws InterruptedException {
		
		
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
		driver.close();
	}
	
	public static void leadview23() throws InterruptedException {
		
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
		driver.findElement(By.id("Lead_Tab")).click();
		Select select =new Select(driver.findElement(By.id("fcf")));
		select.selectByValue("00BDn00000LpUKz");
		driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[1]/input")).click();
		Thread.sleep(2000);
		System.out.println("Today's lead page displayed");
		Thread.sleep(2000);
		 driver.findElement(By.id("userNav")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]")).click();
		driver.close();
		
		
	}
	
	public static void createleadview24() throws InterruptedException {
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
		driver.findElement(By.id("Lead_Tab")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("name_lastlea2")).sendKeys("ABCD");
		driver.findElement(By.id("lea3")).sendKeys("ABCD");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]")).click();
		Thread.sleep(3000);
		driver.close();
	}

	
	
	
	
	

}
