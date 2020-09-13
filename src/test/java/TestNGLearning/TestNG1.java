package TestNGLearning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG1 {
	
	public static WebDriver driver;
	public String username= "Admin" , password = "admin123";
	@BeforeClass
	public void launchBrowser () {
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("OrangeHRM", title);
	}
	
	@Test(priority=0)
	@Parameters({"username","password"})
	public void login(@Optional("Admin")String U,@Optional("admin123")String P ) throws Exception {
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(U);
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(P);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println("Login ");
		//String Welcome = driver.findElement(By.xpath("//a[@id='welcome']")).getText();
		//Assert.assertEquals("Welcome Linda", Welcome);
		driver.findElement(By.cssSelector("[id*='mainMenuFirstLevelUnorderedList']>li:nth-child(3)>a")).click();
		Thread.sleep(2000);
	}
	@Test(priority=2,dependsOnMethods="login")
	public void logout () {
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		System.out.println("Logout");
		String ForgotPwd = driver.findElement(By.xpath("//a[contains(text(),'Forgot your password?')]")).getText();
		System.out.println(ForgotPwd);
		Assert.assertEquals("Forgot your password?", ForgotPwd);
	}
//	@Test(priority=3,dependsOnMethods="logout",	enabled=true)
//	public void afterLogout() {
//		System.out.println("Logout");
//	}
	@AfterClass
	public void closeBrowser() {
		System.out.println("i'm closing browser ");
		driver.close();
	}
}