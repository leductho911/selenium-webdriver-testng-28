package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_13_Selenium_Locator {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Open Register webpage
		driver.get("https://demo.nopcommerce.com/register");
		
	}

	@Test
	public void TC_01_ID() {
		// Thao tac len element phai tim duoc no : findElement
		// find theo cai gi : id / class / name / css / xpath...
		// find tim thay roi thi action len element do : click / sendKeys ...
		
		driver.findElement(By.id("FirstName")).sendKeys("Le Duc");
		driver.findElement(By.id("Company")).sendKeys("BAP software");
	}

	@Test
	public void TC_02_Class() {
		// Open search webpage
		driver.get("https://demo.nopcommerce.com/search");
		// Nhap text vao search textbox
		driver.findElement(By.className("search-text")).sendKeys("iPhone");
	}
	
	@Test
	public void TC_03_Name() {
		
		// clink vao Advanced search
		// click vao Automatically search sub categories
		driver.findElement(By.name("advs")).click();
		driver.findElement(By.name("isc")).click();		
	}
	
	@Test
	public void TC_04_tagName() {
		// kiem tra co bao nhieu the input tren man hinh
		System.out.println(driver.findElements(By.tagName("input")).size());
	}
	
	@Test
	public void TC_05_LinkText() {
		// click vao duong link, link tuyet doi
		driver.findElement(By.linkText("Shipping & returns")).click();
	}
	
	@Test
	public void TC_06_PartialLinkText() {
		// click vao duong link, link tuong doi
		driver.findElement(By.partialLinkText("vendor account")).click();
	}
	
	@Test
	public void TC_07_Css() {
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2Fsearch");
		
		// 1
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Le Duc");

		// 2
		driver.findElement(By.cssSelector("input[id='LastName'")).sendKeys("Tho");
				
		// 3
		driver.findElement(By.cssSelector("input[name='Email'")).sendKeys("leductho911@gmail.com");
	}
	
	@Test
	public void TC_08_XPath() {
		driver.get("https://demo.nopcommerce.com/register");
		
		// 1
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Le Duc");

		// 2
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Tho");
				
		// 3
		driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("leductho911@gmail.com");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}