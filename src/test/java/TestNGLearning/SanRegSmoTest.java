package TestNGLearning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SanRegSmoTest {

	public WebDriver driver;
	public String username= "Admin" , password = "admin123";
	@BeforeClass(alwaysRun=true)
	public void launchBrowser () {
		WebDriverManager.chromedriver().setup();;
		
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("OrangeHRM", title);
	}
	
	@Test(priority=0,groups= {"sanity","smoke","regression"})
	@Parameters({"username","password"})
	public void login(@Optional("Admin")String U,@Optional("admin123")String P ) {
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(U);
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(P);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println("Login ");
		String Welcome = driver.findElement(By.xpath("//a[@id='welcome']")).getText();
		Assert.assertEquals("Welcome Linda", Welcome);
}
	@Test(priority=1,groups= "sanity")
	public void admin() {
		driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
		System.out.println("Admin");
}
	@Test(priority=2,groups= "smoke")
	public void pim() {
		driver.findElement(By.xpath("//b[contains(text(),'PIM')]")).click();
		System.out.println("PIM");
}

	@Test(priority=3,groups= {"sanity,regression"})
	public void Leave() {
		driver.findElement(By.xpath("//b[contains(text(),'Leave')]")).click();
		driver.findElement(By.id("btnSearch")).click();
		System.out.println("Leave");
}
	@Test(priority=4,groups="smoke")
	public void time() {
		driver.findElement(By.xpath("//b[contains(text(),'Time')]")).click();
		System.out.println("Time");		
}
	@Test(priority=5,groups= {"sanity,regression"})
	public void recruitment() {
		driver.findElement(By.xpath("//b[contains(text(),'Recruitment')]")).click();
		System.out.println("Recruitment");		
}
	@Test(priority=6,groups= "smoke")
	public void myInfo() {
		driver.findElement(By.xpath("//b[contains(text(),'My Info')]")).click();
		System.out.println("MyInfo");		
}
	@Test(priority=7,groups= {"sanity,regression"})
	public void performance() {
		driver.findElement(By.xpath("//b[contains(text(),'Performance')]")).click();
		System.out.println("Performance");		
}
	@Test(priority=8,groups= "smoke")
	public void dashBoard() {
		driver.findElement(By.xpath("//b[contains(text(),'Dashboard')]")).click();
		System.out.println("DashBoard");		
}
	@Test(priority=9,groups={"sanity,regression"})
	public void directory() {
		driver.findElement(By.xpath("//b[contains(text(),'Directory')]")).click();
		System.out.println("Directory");		
}
	@Test(priority=10,groups= "smoke")
	public void maintenance() {
		driver.findElement(By.xpath("//b[contains(text(),'Maintenance')]")).click();
		System.out.println("Maintenance");		
}
	@Test(priority=11,groups= "regression")
	public void buzz() {
		driver.findElement(By.xpath("//b[contains(text(),'Buzz')]")).click();
		System.out.println("Buzz");		
}
	@AfterClass(alwaysRun=true)
	public void closeBrowser() {
		System.out.println("i'm closing browser ");
		driver.close();

}
}
