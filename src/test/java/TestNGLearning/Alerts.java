package TestNGLearning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {
	 public static WebDriver driver; 
		@BeforeClass
		public void browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		}
		
		@Test
		public void alert() throws Exception {
		driver.findElement(By.id("alertButton")).click();
		Thread.sleep(7000);
		Alert clickAlert = driver.switchTo().alert();
		String Alert1 = clickAlert.getText();
		System.out.println("Clicked on alert btn- " + Alert1);
		clickAlert.accept();
		
		driver.findElement(By.id("timerAlertButton")).click();
		Thread.sleep(7000);
		Alert simpleAlert = driver.switchTo().alert();
		String alert2 = simpleAlert.getText();
		System.out.println("Alert text is- " + alert2);
		simpleAlert.accept();
		
		driver.findElement(By.id("confirmButton")).click();
		Thread.sleep(2000);
		Alert clickConfirm = driver.switchTo().alert();
		String Alert3 = clickConfirm.getText();
		System.out.println("Clicked on alert btn-  " + Alert3);
		clickConfirm.accept();
		
		
		 driver.findElement(By.id("promtButton")).click();
		 Alert Alertpromptbox  = driver.switchTo().alert();
		 String alert4 =  Alertpromptbox.getText();
		 System.out.println("Alert text is- " + alert4); 
		 Alertpromptbox.sendKeys("selenium");
		 Thread.sleep(3000); 
		 Alertpromptbox .accept();
		 String Popup = driver.findElement(By.xpath("//*[@id='promptResult']")).getText();
		 System.out.println(Popup);
		 if(Popup.equals("selenium")) {
			 System.out.println("Printing selenium");
			 System.out.println("its Same");
		 }
		 else {
			 System.out.println("its not same");
		 }
}

}
