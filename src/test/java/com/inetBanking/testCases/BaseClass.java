package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

//import com.inetBanking.pageObjects.Random;
import com.inetBanking.utilities.MyXLUtil;
import com.inetBanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();

	public String baseURL = readconfig.getAppplicatinoURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public String newempname = readconfig.getEmpName();
	public String newusername = randomString();
	public String adduserpassword = readconfig.getNewUsrPwd();
	public String adduserconfrimpwd = readconfig.getNewUsrConfrmPwd();
	
	public static Logger Logger;
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	public String randomString()
	{
		String randomString = RandomStringUtils.randomAlphanumeric(6);
		return randomString;	
	}
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		Logger = Logger.getLogger("InetBanking");
		PropertyConfigurator.configure("Log4j.Properties");
		
		if (br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		driver = new ChromeDriver();
		}
		
		else if (br.equals("firefox"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		
		else if (br.equals("ie"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getIEPath());
			driver = new InternetExplorerDriver();
		}
		driver.get(baseURL);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver,8);
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".jpeg");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot captured");
	}
	

	
	@DataProvider(name="testData")
	public Object[][] getData()
	{
		String excelPath = "D:\\JarWS\\LatestTahseen\\inetbankingV1\\src\\test\\java\\com\\inetBanking\\testData\\TestData.xlsx";
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
	}
	
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
		
}
