package Test.Learning;

import org.openqa.selenium.By;

public class Test1 extends CommonMethods{

	public static void main(String[] args) throws Exception {
		
		CommonMethods sel = new CommonMethods();
		
		sel.browserSetup();
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(sel.keyword1);
		
		Thread.sleep(2000);
		
		driver.close();
		

	}

}