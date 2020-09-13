package Test.Learning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonMethods {

	public static WebDriver driver;
	String keyword1 = "Selenium";
	String keyword2 = "Java";
	String keyword3 = "Eclipse";
	String keyword4 = "Eclipse";
	
	public void browserSetup(){

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public void loginMethod(String username, String password) throws Exception {

		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(username);

		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(password);

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		boolean abc = driver.findElement(By.id("welcome")).isDisplayed();

		System.out.println("statement is displayed: " + abc);
		
		Thread.sleep(2000);
	}

	public void logoutMethod() throws InterruptedException {
		 
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();

		boolean xyz = driver.findElement(By.id("logInPanelHeading")).isDisplayed();
		
		System.out.println("Is the element enabled: " + xyz);
		
		boolean qwe = driver.findElement(By.xpath("//a[contains(text(),'Forgot your password?')]")).isEnabled();
		
		System.out.println("Is the element enabled: " + qwe);
		
		Thread.sleep(2000);
}
}//	click on human button
//click logout button
//make sure forget password is enabled.