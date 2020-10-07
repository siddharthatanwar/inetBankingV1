package com.inetBanking.testCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;
import com.inetBanking.utilities.MyXLUtil;
import com.inetBanking.utilities.Xls_Reader;

public class TC_LoginDDT_002 extends BaseClass
{

	@Test(dataProvider="testData")
	public void loginDDT(String username, String password) throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);

			lp.setUserName(username);
			Logger.info("user name entered");
			lp.setPassword(password);
			Logger.info("password entered");
			lp.clickSubmit();
			Logger.info("Submit button clicked");
			Thread.sleep(3000);
			
			if(lp.isInvalidLoginTextPresent()==false)
			{
				Logger.info("User is successfully logged in and looking into title.");
				String title = driver.getTitle();
				System.out.println(title);
				lp.clickWelcomeIcon();
				Thread.sleep(3000);
				lp.clickLogout();
			}
			else 
			{
				lp.printInvalidLogin();
			}
	}
	//----- the data provider has been added to base class as its common method
	/*@DataProvider(name="testData")
	public Object[][] getData()
	{
		String projectPath = system.getproperty("user.dir");
		String excelPath = "D:\\JarWS\\LatestTahseen\\inetbankingV1\\src\\test\\java\\com\\inetBanking\\testData\\LoginData.xlsx";
		String sheetName = "Test Cases";
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
	}*/
}
