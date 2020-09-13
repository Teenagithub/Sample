package TestNGLearning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GTest3 {
	public static WebDriver driver;
	public String username= "Admin" , password = "admin123";
	@BeforeClass
	public void launchBrowser () {
		WebDriverManager.edgedriver().setup();;
		
		driver = new EdgeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("OrangeHRM", title);
	}
	
	@Test(priority=0)
	@Parameters({"username","password"})
	public void login(@Optional("Admin")String U,@Optional("admin123")String P ) {
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(U);
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(P);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println("Login ");
		String Welcome = driver.findElement(By.xpath("//a[@id='welcome']")).getText();
		Assert.assertEquals("Welcome Linda", Welcome);
}
	
	@Test
	
	public void performance(){
		
		
		
		
	}
	
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("i'm closing browser ");
		driver.close();

}
}
