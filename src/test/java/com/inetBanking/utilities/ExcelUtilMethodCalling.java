package com.inetBanking.utilities;

public class ExcelUtilMethodCalling {

	public static void main(String[] args) {
		
		
		String projectpath = System.getProperty("user.dir");
		//System.out.println(projectpath);
		MyXLUtil excel = new MyXLUtil(projectpath+"/src/test/java/com/inetBanking/testData/LoginData.xlsx", "Sheet1");

		excel.getRowCount();
		excel.getColCount();
		excel.getCellDataString(0,0);
		excel.getCellDataNumber(1,2);
	}

}

