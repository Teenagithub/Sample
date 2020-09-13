package TestNGLearning;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeForm {
	  public static WebDriver driver; 
		@BeforeClass
		public void browserSetup() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().setSize(new Dimension(1200, 900));
			driver.get("https://demoqa.com/automation-practice-form");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		}
		@Test
		public void PracticeForm1() throws Exception{
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			WebElement Form = driver.findElement(By.xpath("//div[contains(text(),'Forms')]"));
			executor.executeScript("arguments[0].click();", Form);
			Thread.sleep(2000);
			WebElement Forms1 = driver.findElement(By.xpath("//span[contains(text(),'Practice Form')]"));
			executor.executeScript("arguments[0].click();", Forms1);
			Thread.sleep(2000);
			List<WebElement> formRegistration = driver.findElements(By.xpath("//form[@id='userForm']/div"));
			System.out.println(formRegistration.size());
			for(int a = 1;a<=formRegistration.size(); a++ ) {
			     if(a==1) {
			        driver.findElement(By.xpath("//form[@id='userForm']/div["+a+"]/div[2]/input")).sendKeys("FirstName");
			        driver.findElement(By.xpath("//form[@id='userForm']/div["+a+"]/div[4]/input")).sendKeys("LastName");
			    }if(a==2) {
				    driver.findElement(By.xpath("//form[@id='userForm']/div["+a+"]/div[2]/input")).sendKeys("FirstLast@example.com");
				}
				 if(a==3) {
					driver.findElement(By.xpath("//*[@id='userForm']/div[3]/div[2]/div[2]")).click();
				}
				 if(a==4) {
					driver.findElement(By.xpath("//form[@id='userForm']/div["+a+"]//div[2]/input")).sendKeys("+98989898989");
				}if(a==5) {
					driver.findElement(By.xpath("//form[@id='userForm']/div["+a+"]//input")).clear();
					driver.findElement(By.xpath("//form[@id='userForm']/div["+a+"]//input")).sendKeys("30 May 2001");
				}			
				 if(a==7) {
//				    driver.findElement(By.xpath("//*[@id='userForm']/div["+a+"]/div[2]/div[2]")).click();
					driver.findElement(By.xpath("//*[text()='Reading']")).click(); 
				}
				 if(a==8) {
					driver.findElement(By.xpath("//form[@id='userForm']/div["+a+"]//input")).sendKeys("C:\\Users\\isana\\Desktop\\New Text Document.txt");
//					driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\isana\\Desktop\\New Text Document.txt");
				}if(a==9) {
					driver.findElement(By.xpath("//form[@id='userForm']/div["+a+"]/div[2]/textarea")).sendKeys("Hyderabad");
					driver.findElement(By.xpath("//form[@id='userForm']/div["+a+"]/div[2]/textarea")).sendKeys(Keys.ENTER);
					driver.findElement(By.xpath("//form[@id='userForm']/div["+a+"]/div[2]/textarea")).sendKeys("India");
				}if(a==10) {
					driver.findElement(By.xpath("//form[@id='userForm']/div["+a+"]/div[2]/div[1]/div[1]/div[1]/div[@class=' css-1wa3eu0-placeholder']")).sendKeys("NCR");
				}
}
}	
		
		@AfterClass
		public void CloseBrowser() {
		driver.close();
		}
		
}

		
