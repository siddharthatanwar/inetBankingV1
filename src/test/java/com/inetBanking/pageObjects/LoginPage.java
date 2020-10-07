package com.inetBanking.pageObjects;

import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.inetBanking.testCases.BaseClass;

public class LoginPage {
	
	//WebDriver ldriver;
	BaseClass bc = new BaseClass();
	
	public LoginPage(WebDriver rdriver)
	{
		//ldriver =rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="txtUsername")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(id="txtPassword")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(id="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="//a[@id=\"welcome\"]")
	@CacheLookup
	WebElement btnWelcome;
	
	@FindBy(linkText="Logout")
	@CacheLookup
	WebElement btnLogout;
	
	@FindBy(xpath="/html/body/div[1]/div/div[3]/div[2]/div[2]/form/div[5]/span")
	@CacheLookup
	WebElement txtInvalidLogin;
	
	public void setUserName(String uname)
	{
		txtUserName.sendKeys(uname);
		//System.out.println("uname entered");
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
		//System.out.println("password entered");
	}
	
	public void clickSubmit()
	{
		btnLogin.click();
		//System.out.println("login btn clicked");
	}
	
	public void clickWelcomeIcon()
	{
		btnWelcome.click();
		//System.out.println("login btn clicked");
	}
	
	public void clickLogout()
	{
		btnLogout.click();
	}
	
	public void printInvalidLogin()
	{
		String InvalidMsg = txtInvalidLogin.getText();
		System.out.println(InvalidMsg);
	}
	
	public boolean isInvalidLoginTextPresent()
	{
		
		
		try {
			if (txtInvalidLogin.isDisplayed())
			return true;	
		}
		catch(Exception exp)
		{
			exp.getMessage();
			
			//System.out.println(exp.getCause());
			//exp.printStackTrace();
		}
		
		return false;
		
	}
}
