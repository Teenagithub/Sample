package Test.Learning;

import org.openqa.selenium.By;

public class Test2 extends CommonMethods{
	
	public static void main(String[] args) throws Exception {
		
		CommonMethods sel = new CommonMethods();
		
		sel.browserSetup();
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(sel.keyword2);
		
		Thread.sleep(2000);
		
		driver.close();
}

}