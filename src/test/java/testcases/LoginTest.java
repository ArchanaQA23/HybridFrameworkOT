package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProvider.CustomDataProvider;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseClass 
{

	@Test(dataProvider = "loginDetails",dataProviderClass = CustomDataProvider.class)
	public void loginToApplication(String uname,String pass)
	{
	
	System.out.println("changes made on remote");
		LoginPage login=new LoginPage(driver);
		
		login.loginToApplication(uname,pass);
			
		HomePage home=new HomePage(driver);
		
		Assert.assertTrue(home.getWelcomeMsg().contains("Welcome"));
		
		home.clickOnSignOut();
		
		Assert.assertTrue(login.isSignInPresent());
		
	}
	
}
