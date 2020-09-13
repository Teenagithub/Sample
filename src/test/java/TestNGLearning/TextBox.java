package TestNGLearning;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextBox {
	 public static WebDriver driver; 
		@BeforeClass
		public void browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.get("https://demoqa.com/text-box");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		@Test
		public void Textbox() {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Text Box')]"));
			executor.executeScript("arguments[0].click();", element);
			String textBox = driver.findElement(By.xpath("//div[@class='main-header']")).getText();
			System.out.println(textBox);
			Assert.assertEquals("Text Box", textBox);
			List<WebElement> Textboxlist = driver.findElements(By.xpath("//*[@id='userForm']/div"));
			System.out.println(Textboxlist.size());
			for(int a= 1; a<=Textboxlist.size();a++) {
			 if (a==1) {
				 driver.findElement(By.xpath("//*[@id='userForm']/div["+a+"]/div[2]/input")).sendKeys("Alen Sloan");
			} if (a==2) {
				 driver.findElement(By.xpath("//*[@id='userForm']/div["+a+"]/div[2]/input")).sendKeys("Alensloan@example.com");
			} if (a==3) {
				 driver.findElement(By.xpath("//*[@id='userForm']/div["+a+"]/div[2]/textarea")).sendKeys("Hyderabad");
				 driver.findElement(By.xpath("//*[@id='userForm']/div["+a+"]/div[2]/textarea")).sendKeys(Keys.ENTER);
				 driver.findElement(By.xpath("//*[@id='userForm']/div["+a+"]/div[2]/textarea")).sendKeys("India");
			} if (a==4) {
				 driver.findElement(By.xpath("//*[@id='userForm']/div["+a+"]/div[2]/textarea")).sendKeys("Hyderabad");
				 driver.findElement(By.xpath("//*[@id='userForm']/div["+a+"]/div[2]/textarea")).sendKeys(Keys.ENTER);
				 driver.findElement(By.xpath("//*[@id='userForm']/div["+a+"]/div[2]/textarea")).sendKeys("India");
			} if (a==5) {
				 driver.findElement(By.xpath("//*[@id='userForm']/div["+a+"]/div[1]")).submit();
			}
			}
			driver.close();
		}
}
