package TestNGLearning;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GTest1 {
	public static WebDriver driver;
	public String username= "Admin" , password = "admin123";
	@BeforeClass
	public void launchBrowser () {
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("OrangeHRM", title);
	}
	
	@Test(priority=0)
	@Parameters({"username","password"})
	public void login(@Optional("Admin")String U,@Optional("admin123")String P ) throws Exception {
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(U);
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(P);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println("Login ");
		//String Welcome = driver.findElement(By.xpath("//a[@id='welcome']")).getText();
		//Assert.assertEquals("Welcome Linda", Welcome);
		
	}
    @Test(priority=1)
    public void leave() throws Exception {
    	driver.findElement(By.cssSelector("[id*='mainMenuFirstLevelUnorderedList']>li:nth-child(3)>a")).click();
    	driver.findElement(By.id("menu_leave_applyLeave")).click();
    	//driver.findElement(By.xpath("//select[@id='applyleave_txtLeaveType']")).sendKeys("Vacation US");
    	Select leaveOptions = new Select(driver.findElement(By.xpath("//select[@id='applyleave_txtLeaveType']")));
//    	leaveOptions.selectByVisibleText("FMLA US");
//		leaveOptions.selectByIndex(2);
    	leaveOptions.selectByVisibleText("Vacation US");
		

		driver.findElement(By.id("applyleave_txtFromDate")).clear();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		   LocalDateTime now = LocalDateTime.now();  
		   System.out.println(dtf.format(now));
		   String input = dtf.format(now);
		driver.findElement(By.id("applyleave_txtFromDate")).sendKeys(input);
		Thread.sleep(2000);
		driver.findElement(By.name("applyleave[txtToDate]")).clear();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, 30); // Adding 5 days
		String output = sdf.format(c.getTime());
		System.out.println(output);
		driver.findElement(By.name("applyleave[txtToDate]")).sendKeys(output);
		Thread.sleep(2000);
		driver.findElement(By.name("applyleave[txtToDate]")).sendKeys(Keys.TAB);
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("leaveBalance_details_link")));
		String leavebalmessage = driver.findElement(By.id("leaveBalance_details_link")).getText();
		System.out.println(leavebalmessage);
		if (leavebalmessage.contains("Balance not sufficient")) {
			String myleaveBal = driver.findElement(By.id("applyleave_leaveBalance")).getText();
			System.out.println("My Leave Bal- " + myleaveBal);
			String S = "7 Leave Balance";
			int value = Integer.parseInt(S.replaceAll("\\..*", "$1"));
			System.out.println(value);
//			String firstNumber = myleaveBal.replaceFirst(".*?(\\d+).*", "$1");
//			System.out.println("For my knowledge " + myleaveBal);
			if (myleaveBal.contains("2")) {
				Calendar c1 = Calendar.getInstance();
				c1.setTime(new Date());
				c1.add(Calendar.DATE, 1); 
				String output1 = sdf.format(c1.getTime());
				
				System.out.println(output1);
				driver.findElement(By.name("applyleave[txtToDate]")).clear();
				driver.findElement(By.name("applyleave[txtToDate]")).sendKeys(output1);
				Thread.sleep(5000);
				driver.findElement(By.name("applyleave[txtToDate]")).sendKeys(Keys.TAB);
				String leavebalmessage1 = driver.findElement(By.id("leaveBalance_details_link")).getText();
				System.out.println(leavebalmessage1);
			}
		}
		driver.findElement(By.id("applyleave_txtComment")).sendKeys("Personal Request");
		//driver.findElement(By.id("applyBtn")).click();
		Thread.sleep(2000);
    }
    @AfterClass
    public void logout() {
    	driver.close();
    }
}
