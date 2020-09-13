package TestNGLearning;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Button {
	 public static WebDriver driver; 
		@BeforeClass
		public void browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.get("https://demoqa.com/buttons");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		@Test
		public void dblclk() {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Buttons')]"));
			executor.executeScript("arguments[0].click();", element);
			String btn = driver.findElement(By.className("main-header")).getText();
			System.out.println(btn);
			Assert.assertEquals("Buttons", btn);
			List<WebElement> btns = driver.findElements(By.xpath("//*[@id='userForm']/div"));
			System.out.println(btns.size());
			for(int a=1; a<=btns.size(); a++) {
				if(a==1) {
					Actions actions = new Actions(driver);
					WebElement Element = driver.findElement(By.xpath("//div[@class='col-12 mt-4 col-md-6']/div[1]/div["+a+"]/Button"));
					actions.doubleClick(Element);
					String dblclk = driver.findElement(By.xpath("//p[@id='doubleClickMessage']")).getText();
					System.out.println(dblclk);
					Assert.assertEquals("Double Click Me", dblclk);
				}if(a==2) {
					Actions actions = new Actions(driver);
					WebElement Elements = driver.findElement(By.xpath("//div[@class='col-12 mt-4 col-md-6']/div[1]/div["+a+"]/Button"));
					actions.contextClick(Elements);
					String rgtclk = driver.findElement(By.xpath("//p[@id='rightClickMessage']")).getText();
					System.out.println(rgtclk);
					Assert.assertEquals("Right Click Me", rgtclk);
				}if(a==3) {
					driver.findElement(By.xpath("//div[@class='col-12 mt-4 col-md-6']/div[1]/div["+a+"]/Button")).click();
					String clk = driver.findElement(By.xpath("//p[@id='dynamicClickMessage']")).getText();
					System.out.println(clk);
					Assert.assertEquals("You have done a dynamic click", clk);
				}
			}
			driver.close();
		}
}
