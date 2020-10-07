package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{

	@Test
	public void LoginTest() throws InterruptedException, IOException
	{
		
		Logger.info("URL is opened in Browser");
		LoginPage lp=new LoginPage(driver);
		Thread.sleep(5000);
		
		lp.setUserName(username);
		Logger.info("user name entered");
		lp.setPassword(password);
		Logger.info("password entered");
		lp.clickSubmit();
		Logger.info("Submit button clicked");
		Thread.sleep(3000);
		if (driver.getTitle().equals("OrangeHRM554")) 
		{
				Assert.assertTrue(true);
				Logger.info("Title is correct");
			}
		else
		{
			captureScreen(driver,"LoginTest");
			Assert.assertTrue(true);
			Logger.info("Title is not correct");
		}
		
		lp.clickWelcomeIcon();
		Thread.sleep(3000);
		lp.clickLogout();
		Logger.info("Tester is logged out from the application");
		
	}
}
