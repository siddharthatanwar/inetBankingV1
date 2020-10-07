package com.inetBanking.pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.inetBanking.testCases.BaseClass;
//import com.inetBanking.testCases.Random;

public class AddUserPage {

	//WebDriver ldriver;
	BaseClass bc = new BaseClass();
	
	public AddUserPage(WebDriver rdriver) {
		
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.LINK_TEXT, using ="Admin")
	@CacheLookup
	WebElement lnkAdmin;

	@FindBy(how = How.NAME, using = "btnAdd")
	@CacheLookup
	WebElement lnkAdd;

	/*@FindBy(how = How.ID, using = "")
	@CacheLookup
	WebElement txtUsrRole;*/

	@CacheLookup
	@FindBy(how = How.ID_OR_NAME, using ="systemUser_employeeName_empName")
	WebElement txtEmpName;
	
	@CacheLookup
	@FindBy(how = How.ID_OR_NAME, using ="systemUser_employeeName_empName")
	WebElement selectEmp;

	@CacheLookup
	@FindBy(how = How.ID, using ="systemUser_userName")
	WebElement txtUsrName;

	@CacheLookup
	@FindBy(how = How.ID, using ="systemUser_password")
	WebElement txtPwd;

	@CacheLookup
	@FindBy(how = How.ID, using ="systemUser_confirmPassword")
	WebElement txtConfrimPwd;

	@CacheLookup
	@FindBy(how = How.ID_OR_NAME, using ="btnSave" )
	WebElement btnSave;

	@CacheLookup
	@FindBy(how = How.XPATH, using ="//span[@for='systemUser_employeeName_empName']" )
	WebElement lnkmsgEmpNameRequired;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//span[@for='systemUser_userName']")
	WebElement lnkMsgUsrNameRequired;
	
	@CacheLookup
	@FindBy(how=How.XPATH, using ="/html/body/div[1]/div[3]/div/div[2]/form/fieldset/ol/li[3]/span")
	WebElement usrNameshortMsg;

	public void LnkAdmin()
	{
		lnkAdmin.click();
	}
	
	public void btnAdd()
	{
		lnkAdd.click();
	}
	
	public void setEmpName(String empName)
	{
		txtEmpName.sendKeys(empName);
	}
	
	public void setUsrName(String randomString)
	{
		txtUsrName.sendKeys(randomString);
	}
	
	public void setPassword(String pwd)
	{
		txtPwd.sendKeys(pwd);
	}
	
	public void setConfrimPassword(String ConfrimPwd)
	{
		txtConfrimPwd.sendKeys(ConfrimPwd);
	}
	
	public void btnSave()
	{
		btnSave.click();
	}
	
	public boolean MsgUsrNameShort()
	{
		try
		{
			String usrNameValidation = usrNameshortMsg.getText();
			System.out.println(usrNameValidation);
			if (usrNameValidation.equals(true))
			{
				return true;
			}
		}
			catch(Exception exp)
			{
				exp.getMessage();
				System.out.println(exp.getCause());
				exp.printStackTrace();
			}
			return false;
	}
		
}
