package com.inetBanking.testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.inetBanking.pageObjects.AddUserPage;
import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.MyXLUtil;

public class TC_AddUserTest_003 extends BaseClass

{
	@Test
	public void AddUserTest() throws InterruptedException, IOException
	
	/*@Test(dataProvider="testDataX")
	public void AddUserTest(String username,String password,String newempname,
			String newusername, String adduserpassword, String adduserconfrimpwd) 
					throws InterruptedException, IOException*/
	{
		LoginPage lp=new LoginPage(driver);
		AddUserPage addusr = new AddUserPage(driver);
		
		lp.setUserName(username);
		Logger.info("user name entered");
		
		lp.setPassword(password);
		Logger.info("password entered");
		
		lp.clickSubmit();
		Logger.info("Submit button clicked");
		Thread.sleep(4000);
		addusr.LnkAdmin();
		Logger.info("Tester is on Admin page");
		Thread.sleep(4000);
		addusr.btnAdd();
		Logger.info("Adding a new user");
		Thread.sleep(4000);
		addusr.setEmpName(newempname);;
		Logger.info("Employee name provided");
		Thread.sleep(4000);
		addusr.setUsrName(newusername);
		Logger.info("User Name name provided");
		Thread.sleep(4000);
		addusr.setPassword(adduserpassword);
		Logger.info("Password name provided");
		
		if (addusr.MsgUsrNameShort()==true)
		{
			captureScreen(driver,"AddUserTest");
			Assert.assertTrue(false);
			Logger.info("test case is failed");
		}
		else 
		{	
		addusr.setConfrimPassword(adduserconfrimpwd);
		Logger.info("Confrim password name provided");
		Thread.sleep(4000);
		addusr.btnSave();
		Logger.info("A new user is addedd");
		Thread.sleep(4000);
		lp.clickWelcomeIcon();
		lp.clickLogout();
		Logger.info("Tester is logged out from the application");
		}
	}
	
	@DataProvider(name="testDataX")
	public Object[][] getData()
	{
		//String projectPath = System.getProperty("user.dir");
		String excelPath = "D:\\JarWS\\LatestTahseen\\inetbankingV1\\src\\test\\java\\com\\inetBanking\\testData\\TestData.xlsx";
		String sheetName = "AddUser";
		Object data[][] = testData(excelPath, sheetName);
		return data;
	}

	public Object[][] testData(String excelPath, String sheetName)
	{
		MyXLUtil excel= new MyXLUtil(excelPath, sheetName);
		
		int rowCount = excel.getRowCount();
		//System.out.println(rowCount);
		int colCount = excel.getColCount();
		//System.out.println(colCount);
		
		
		Object data[][] = new Object[rowCount-1][colCount];
		
		for (int i=1; i<rowCount; i++)
		{
			for (int j=0; j<colCount; j++)
			{
				String cellData = excel.getCellDataString(i,j);
			   // System.out.print(cellData+ "|");
			    data[i-1][j] = cellData;
			}
			//System.out.println();
		}
		return data; 
	}
	
}
