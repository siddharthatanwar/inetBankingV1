package com.inetBanking.utilities;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class MyXLUtil {
	static String projectpath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public MyXLUtil(String excelPath, String sheetName)
	{
		try 
		{
			 workbook = new XSSFWorkbook(excelPath);
			 sheet = workbook.getSheet(sheetName);	
			 System.out.println(sheet);
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
	}

	public static int getRowCount() 
	{
		int rowCount =0;
		try 
			{
				 rowCount = sheet.getPhysicalNumberOfRows();
				 System.out.println("No of Rows: "+rowCount);
			}
					catch (Exception exp)
					{
						System.out.println(exp.getMessage());
						System.out.println(exp.getCause());
						exp.printStackTrace();
					}
		return rowCount;
	}
	
	public static int getColCount() 
	{
		 int colCount =0;
		try 
			{
				 colCount = sheet.getRow(0).getPhysicalNumberOfCells();
				 //System.out.println("No of Columns: "+colCount);
			}
					catch (Exception exp)
					{
						System.out.println(exp.getMessage());
						System.out.println(exp.getCause());
						exp.printStackTrace();
					}
		return colCount;
	}
	
	public static String  getCellDataString(int rowNum, int colNum)
	{
		String cellStringData = "A";
		try 
			{
				 cellStringData  = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
				 //System.out.println(cellStringData);
			}
					catch (Exception exp)
					{
						System.out.println(exp.getMessage());
						System.out.println(exp.getCause());
						exp.printStackTrace();
					}
		
		return cellStringData;
	}
	
	public static double getCellDataNumber(int rowNum, int colNum)
	{
		double cellNumericData =0;
		try 
			{			 
				 cellNumericData  = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
				 //System.out.println(cellNumericData);
			}
					catch (Exception exp)
					{
						System.out.println(exp.getMessage());
						System.out.println(exp.getCause());
						exp.printStackTrace();
					}
		return cellNumericData; 
	}
}