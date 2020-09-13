package TestNGLearning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButton {
	 public static WebDriver driver; 
		@BeforeClass
		public void browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.get("https://demoqa.com/radio-button");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		@Test
		public void Rbtn() {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Radio Button')]"));
			executor.executeScript("arguments[0].click();", element);
			String RadioBtn = driver.findElement(By.className("main-header")).getText();
			System.out.println(RadioBtn);
			Assert.assertEquals("Radio Button", RadioBtn);
			driver.findElement(By.xpath("//label[contains(text(),'Yes')]")).click();
			String atrclkmsg = driver.findElement(By.xpath("//span[@class='text-success']")).getText();
			System.out.println(atrclkmsg);
			driver.close();
		}

}
