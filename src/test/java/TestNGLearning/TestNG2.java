package TestNGLearning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
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

public class TestNG2 {
	
	public static WebDriver driver;
	public String username= "Admin" , password = "admin123";
	@BeforeClass(alwaysRun=true)
	public void launchBrowser () {
		WebDriverManager.firefoxdriver().setup();;
		
		driver = new FirefoxDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("OrangeHRM", title);
	}
	
	@Test(priority=0,groups= {"must","should"})
	@Parameters({"username","password"})
	public void login(@Optional("Admin")String U,@Optional("admin123")String P ) {
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(U);
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(P);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println("Login ");
		String Welcome = driver.findElement(By.xpath("//a[@id='welcome']")).getText();
		Assert.assertEquals("Welcome Linda", Welcome);
}
	@Test(priority=2,groups= "notmust")
	public void Leave() {
		driver.findElement(By.xpath("//b[contains(text(),'Leave')]")).click();
		driver.findElement(By.id("btnSearch")).click();
	}
	@Test(priority=3,groups= {"must","should"})
	public void logout () {
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Logout')]")).click();
		System.out.println("Logout");
		String ForgotPwd = driver.findElement(By.xpath("//*[contains(text(),'Forgot your password?')]")).getText();
		Assert.assertEquals("Forgot your password?", ForgotPwd);
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("i'm closing browser ");
		driver.close();

}
}