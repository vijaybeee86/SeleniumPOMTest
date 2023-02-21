package com.qa.ecomm.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	public Properties prop;
	FileInputStream fis;
	public static String highlight;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	/**
	 * This method is used to initialze the driver
	 * @author samkrithik
	 * @param prop
	 * @return This method will return the driver
	 */
	
	public WebDriver init_driver(Properties prop)
	{
	String browserName = prop.getProperty("browser").trim();
	
	highlight = prop.getProperty("highlight");
	
		System.out.println("Browser Name is: " + browserName);
		
		if (browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			tlDriver.set(new ChromeDriver());
			
		}
		
		if (browserName.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();
			tlDriver.set(new FirefoxDriver());
		}
		
		if (browserName.equals("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			//driver = new EdgeDriver();
			tlDriver.set(new EdgeDriver());
		}
		
		else
		{
			System.out.println("Please pass the correct browser: " + browserName);
		}
		
		getThreadLocalDriver().manage().window().fullscreen();
		getThreadLocalDriver().manage().deleteAllCookies();
		getThreadLocalDriver().get(prop.getProperty("url"));
		
		System.out.println("Thread Local Driver Copy:" + getThreadLocalDriver());
		return getThreadLocalDriver();
	}
	
	
	/**
	 * getThreadLocalDriver: it will return a thread local copy of WebDriver
	 * @return
	 */
	public WebDriver getThreadLocalDriver()
	{
		return tlDriver.get();
	}
	
	
	/**
	 * This method is used to initialize the properties
	 * @return Properties prop reference
	 */
	public Properties init_prop()
	{
		prop = new Properties();
		
		String envName = System.getProperty("env");
		if(envName==null)
		{
			System.out.println("Running tets scripts in PROD");
			try {
				fis = new FileInputStream("./src/test/resources/config/config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		
		}
		
		else
		{
			System.out.println("Running tets scripts in Non-PROD:" + envName);
			
			try {
			switch(envName.toLowerCase())
			{
			case "qa":
					fis = new FileInputStream("./src/test/resources/config/qa.config.properties");
				break;
				
			default:
				System.out.println("Please Pass the Correct Environment");
				break;				
			}
		}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
		}	
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}	
		
		
		/**
		 * @return 
		 * 
		 */
		
		public String getScreenshot()
		{
			File src = ((TakesScreenshot)getThreadLocalDriver()).getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
			File destination = new File(path);
			try {
				FileUtils.copyFile(src, destination);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return path;
		}
	

}
