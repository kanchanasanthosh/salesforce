package Testcase;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DevelopersConsole {
	
	public static void developerconsole8() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window();
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
		List<WebElement> menu= driver.findElements(By.xpath("//*[@id=\"userNav-menuItems\"]/a[2]"));
		List<String> expecteditems  =Arrays.asList("My Profile","My Settings", "Developer Console","Switch to Lighting Experience"," Logout" );
		for(WebElement w : menu) {
			System.out.println(w.getText());
			Assert.assertTrue(expecteditems.contains((w.getText())));
		}
		Thread.sleep(3000);
		String originalWindow = driver.getWindowHandle();
		assert driver.getWindowHandles().size() == 1;
		driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[3]")).click();
		Thread.sleep(1000);
		for(String Winhandle :driver.getWindowHandles()) {
			if(!originalWindow.contentEquals( Winhandle));
			driver.switchTo().window(Winhandle);
			Thread.sleep(2000);
			driver.close();
		}
	}
	
	public static void developerconsole9() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window();
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
		List<WebElement> menu= driver.findElements(By.xpath("//*[@id=\"userNav-menuItems\"]/a[2]"));
		List<String> expecteditems  =Arrays.asList("My Profile","My Settings", "Developer Console","Switch to Lighting Experience"," Logout" );
		for(WebElement w : menu) {
			System.out.println(w.getText());
			Assert.assertTrue(expecteditems.contains((w.getText())));
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]")).click();
		System.out.println("logout successfully");
		driver.close();
	}
	
	
	
	
	
	

}
