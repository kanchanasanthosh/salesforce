package Testcase;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class mySettings {
	@Test
	public static void usermenudropdown() throws InterruptedException {
	
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
	List<WebElement> menu= driver.findElements(By.xpath("//*[@id=\"userNav-menuItems\"]/a[2]"));
	List<String> expecteditems  =Arrays.asList("My Profile","My Settings", "Developer Console","Switch to Lighting Experience"," Logout" );
	for(WebElement w : menu) {
		System.out.println(w.getText());
		Assert.assertTrue(expecteditems.contains((w.getText())));
	}
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[2]")).click();
	driver.findElement(By.id("PersonalInfo_font")).click();
	driver.findElement(By.xpath("//*[@id=\"LoginHistory_font\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"DisplayAndLayout_font\"]")).click();
	driver.findElement(By.id("CustomizeTabs_font")).click();
	Thread.sleep(3000);
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
				driver.quit();
			}
			System.out.println("completed");
			driver.quit();
	}
	
	

	

	

	
	
	
	

}
