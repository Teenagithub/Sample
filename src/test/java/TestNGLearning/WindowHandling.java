package TestNGLearning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {
	
	 public static WebDriver driver; 
		@BeforeClass
		public void browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		@Test
		public void Window1(){

			String parentHandle1 = driver.getWindowHandle(); //get the current window handle
			driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();  // click some link that opens a new window	
			for (String winHandle1 : driver.getWindowHandles()) {
			 driver.switchTo().window(winHandle1);  // switch focus of WebDriver to the next found window handle 
			}
			System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
			driver.close();	
		}	
		@Test
		public void Window2() {	
			String parentHandle2= driver.getWindowHandle();
			driver.findElement(By.xpath("(//button[@class='mt-4 btn btn-primary'])")).click();
			for (String winHandle2 : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle2);
			}
			System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText()); 
			driver.close();
			}
		
		@Test
		
		public void Window3() {
			String parentHandle3 = driver.getWindowHandle();
			driver.switchTo().window(parentHandle3);
			driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();;
		}
		
}

