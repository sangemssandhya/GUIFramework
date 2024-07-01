package com.comcast.crm.generic.basetest;


import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutlity.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class BaseClass {
	/* Create Object */
	public DataBaseUtility dbLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	 public WebDriverUtility wdu=new WebDriverUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public  WebDriver driver = null;
	public  static WebDriver sdriver = null;
	public ExtentSparkReporter spark;
	public ExtentReports report;


	
		@BeforeSuite(groups = {"smokeTest", "regressionTest"})
		public void configBS() throws Throwable {
			System.out.println("===Connect to DB , Report Config===");
			dbLib.getDbconnection();
			ExtentSparkReporter spark=new ExtentSparkReporter("./AdavnceReport/reports1.html");
			spark.config().setDocumentTitle("Crm test suite results");
			spark.config().setReportName("crm report");
			spark.config().setTheme(Theme.DARK);
			
			//add env information and create test
			 report=new ExtentReports();
			report.attachReporter(spark);
			report.setSystemInfo("OS", "Window-10");
			report.setSystemInfo("BROWSER","CHROME-100");
		}
		
		
       //  @Parameters ("BROWSER")
	    @BeforeClass(groups = {"smokeTest", "regressionTest"})
	    public void configBC() throws Throwable {
	    	
	    System.out.println("==Launch the BROWSER==");
	    
		
		
	    
	   // String BROWSER	= fLib.getDataFromPropertiesFile("browser");
	    String BROWSER = System.getProperty("browser" , fLib.getDataFromPropertiesFile("browser"));
		if(BROWSER.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			driver = new ChromeDriver(chromeOptions);
		}else if(BROWSER.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOption = new FirefoxOptions();
			driver = new FirefoxDriver(firefoxOption);
		}else if(BROWSER.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions edgeOption = new EdgeOptions();
			driver = new EdgeDriver(edgeOption);
		}else {
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			driver = new ChromeDriver(chromeOptions);
		}
		sdriver = driver;
		UtilityClassObject.setDriver(driver);
	    }
	    
	    @BeforeMethod(groups = {"smokeTest", "regressionTest"})
		public void configBM() throws Throwable {
			System.out.println("=login=");
			String URL = System.getProperty("url" ,fLib.getDataFromPropertiesFile("url") );
			String USERNAME = System.getProperty("username" , fLib.getDataFromPropertiesFile("username"));
			String PASSWORD = System.getProperty("password" , fLib.getDataFromPropertiesFile("password"));
			LoginPage lp = new LoginPage(driver);
			lp.loginToapp(URL, USERNAME, PASSWORD);
		}
	    
	    
		@AfterMethod(groups = {"smokeTest", "regressionTest"})
		public void configAM() {
		
			LoginPage Lp=new LoginPage(driver);
			Lp.getLogoutLk();
			System.out.println("=logout=");
			
		}
		
	    
	    @AfterClass(groups = {"smokeTest", "regressionTest"})
	    public void configAC() {
	    	System.out.println("==Close the BROWSER==");
	        driver.quit();
	    }
	    
	   @AfterSuite(groups = {"smokeTest", "regressionTest"})
		public void configAS() throws SQLException {
			System.out.println("===close Db , Report backUP====");
			dbLib.closeDbconnection();
			report.flush();
			
		}
	  
	
	   
	    


}
