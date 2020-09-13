package TestNGLearning;


import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
//import Java.lang.NullPointerException;
public class WebTables {
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
	public void webTables() throws Exception{
		
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//div[contains(text(),'Elements')]"));
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);
		WebElement element1 = driver.findElement(By.xpath("//span[text()='Web Tables']"));
		executor.executeScript("arguments[0].click();", element1);
		String addBtnTxt = driver.findElement(By.xpath("//button[@id='addNewRecordButton']")).getText();
		System.out.println(addBtnTxt);
		Assert.assertEquals("Add", addBtnTxt);
		boolean clickable = driver.findElement(By.xpath("//button[@id='addNewRecordButton']")).isEnabled();
		System.out.println(clickable);
		if (clickable==true) {
			System.out.println("Is clickable");
			driver.findElement(By.xpath("//button[@id='addNewRecordButton']")).click();
			String regForm = driver.findElement(By.xpath("//div[text()='Registration Form']")).getText();
			Assert.assertEquals("Registration Form", regForm);
			List<WebElement> regFromList = driver.findElements(By.xpath("//*[@id='userForm']/div"));
			System.out.println(regFromList.size());
			for(int a=1; a<regFromList.size(); a++) {
				if (a==1) {
					driver.findElement(By.xpath("//*[@id='userForm']/div["+a+"]/div[2]/input")).sendKeys("First name");
				}if (a==2) {
					driver.findElement(By.xpath("//*[@id='userForm']/div["+a+"]/div[2]/input")).sendKeys("Last name");
				}if (a==3) {
					driver.findElement(By.xpath("//*[@id='userForm']/div["+a+"]/div[2]/input")).sendKeys("Email@emaple.com");
				}if (a==4) {
					driver.findElement(By.xpath("//*[@id='userForm']/div["+a+"]/div[2]/input")).sendKeys("27");
				}if (a==5) {
					driver.findElement(By.xpath("//*[@id='userForm']/div["+a+"]/div[2]/input")).sendKeys("25000");
				}if (a==6) {
					driver.findElement(By.xpath("//*[@id='userForm']/div["+a+"]/div[2]/input")).sendKeys("Depatment");
				}
			}
			String submit = driver.findElement(By.xpath("//button[@id='submit']")).getText();
			Assert.assertEquals("Submit", submit);
			driver.findElement(By.xpath("//span[contains(text(),'×')]")).click();
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("searchBox")));
			driver.findElement(By.id("searchBox")).sendKeys("Kierra");
			List<WebElement> confirmingEntry = driver.findElements(By.xpath("//*[@class='rt-tr -odd']/div"));
			System.out.println(confirmingEntry.size());
			for(int b=1; b<=confirmingEntry.size();b++) {
				if(b==1) {
					Assert.assertEquals("Kierra", driver.findElement(By.xpath("//*[@class='rt-tr -odd']/div["+b+"]")).getText());
				}if(b==2) {
					Assert.assertEquals("Gentry", driver.findElement(By.xpath("//*[@class='rt-tr -odd']/div["+b+"]")).getText());
				}if(b==3) {
					Assert.assertEquals("29", driver.findElement(By.xpath("//*[@class='rt-tr -odd']/div["+b+"]")).getText());
				}if(b==4) {
					Assert.assertEquals("kierra@example.com", driver.findElement(By.xpath("//*[@class='rt-tr -odd']/div["+b+"]")).getText());
				}if(b==5) {
					Assert.assertEquals("2000", driver.findElement(By.xpath("//*[@class='rt-tr -odd']/div["+b+"]")).getText());
				}if(b==6) {
					Assert.assertEquals("Legal", driver.findElement(By.xpath("//*[@class='rt-tr -odd']/div["+b+"]")).getText());
				}if(b==7) {
					Assert.assertEquals("Edit", driver.findElement(By.xpath("//*[@class='rt-tr -odd']/div["+b+"]//span[1]")).getAttribute("title"));
					Assert.assertEquals("Delete", driver.findElement(By.xpath("//*[@class='rt-tr -odd']/div["+b+"]//span[2]")).getAttribute("title"));
				}
			}
			
		} else if(clickable=false) {
			System.out.println("Not clickable");
		}
		
	}
	@AfterClass
	public void CloseBrowser(){
		driver.close();
	}
}

