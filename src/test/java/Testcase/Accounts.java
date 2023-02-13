package Testcase;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Accounts {
	
	public static void createAcount10() throws InterruptedException {
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
		System.out.println("Account created");
		Thread.sleep(3000);
		driver.close();
	}
	
	public static void createnewview11() throws InterruptedException {
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
		System.out.println("new view created");
		driver.close();
	}
	
	public static void editview12() throws InterruptedException {
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
		System.out.println("view name updated");
		driver.close();
	}
	
public static void mergeAccounts13() throws InterruptedException {
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
    System.out.println("Acccount merged");
    driver.close();
	
}

public static void createReport14() throws InterruptedException {
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
}
	
	
}
