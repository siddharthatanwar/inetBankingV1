package com.inetBanking.utilities;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
	
	@Test(dataProvider = "testdata")
	public void test1(String username, String password)
	
	{
			System.out.println(username + " | " + password);
	}
	
	@DataProvider(name="testdata")
	public Object[][] getData()
	{
		String excelPath = "D:\\JarWS\\LatestTahseen\\inetbankingV1\\src\\test\\java\\com\\inetBanking\\testData\\LoginData.xlsx";
		String sheetName = "Sheet1";
		Object data[][] = testData(excelPath, sheetName);
		return data;
	}

	public Object[][] testData(String excelPath, String sheetName)
	{
		MyXLUtil excel= new MyXLUtil(excelPath, sheetName);
		
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		Object data[][] = new Object[rowCount-1][colCount];
		
		for (int i=1; i<=rowCount; i++)
		{
			for (int j=0; j<colCount; j++)
			{
				String cellData = excel.getCellDataString(i, j);
			    //System.out.print(cellData+ " | ");
			    data[i-1][j] = cellData;
			}
			//System.out.println();
		}
		return data; 
	}
}
