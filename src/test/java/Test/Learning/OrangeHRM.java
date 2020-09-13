package Test.Learning;

import org.openqa.selenium.By;

public class OrangeHRM extends CommonMethods{
	String s = "abcd";
	
	public static void main(String[] args) throws Exception {
		
		OrangeHRM sss = new OrangeHRM(); //sss is Object reference
		
		System.out.println(sss.s);
		CommonMethods comMethods = new CommonMethods();
		
		comMethods.browserSetup();
		comMethods.loginMethod("Admin", "admin123");
		comMethods.logoutMethod();
		
		driver. close();
		//loginMethod("Admin", "admin123");
		//loginMethod("Admin", "admin"); //Method overloading = method name is same but passing different arguments
		
		
	}

}
