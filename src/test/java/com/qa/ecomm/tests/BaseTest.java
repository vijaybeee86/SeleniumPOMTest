package com.qa.ecomm.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.qa.ecomm.factory.DriverFactory;
import com.qa.ecomm.pages.ForgotPassword;
import com.qa.ecomm.pages.LoginPage;

public class BaseTest {
	DriverFactory df;
	Properties prop;
	WebDriver driver;
	LoginPage lp;
	ForgotPassword fp;
	
	
	
	@BeforeTest
	public void setup()
	{
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
		lp = new LoginPage(driver);
		
	}
	
	
	@AfterTest
	public void teardown()
	{
		
		driver.close();
		
	}

}
