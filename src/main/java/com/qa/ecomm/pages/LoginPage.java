package com.qa.ecomm.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import com.qa.ecomm.listeners.TestAllureListener;

import io.qameta.allure.Step;


@Listeners(TestAllureListener.class)
public class LoginPage {

	//privare driver initialize
    private WebDriver driver;
    
	
    //page constructor
	public LoginPage(WebDriver driver) {
	
		this.driver = driver;
	}

	//By locator
	private By emailId = By.id("input-email");
	private By loginPwd = By.id("input-password");
	private By loginBtn = By.xpath("//*[@id='form-login']/button");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	//private By registerBtn = 
	
	//Page Actions
	
	@Step("Getting the Login Page Title")
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	@Step("Getting the Login Page URL")
	public String getLoginPageUrl()
	{
		return driver.getCurrentUrl();
	}
	
	@Step("Checking the Forgot link existance")
	public boolean isForgotPwdLinkExist()
	{
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	@Step("do Check the Forgot link is clickable")
	public ForgotPassword clickForgotPwdLink()
	{
	  driver.findElement(forgotPwdLink).click();
	  try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return new ForgotPassword(driver);
	}
	
	@Step("do Login with username: {0} + password: {1}")
	public void doLogin(String uname, String pwd)
	{
		System.out.println("User name passed to Login is: " + uname);
		System.out.println("Password passed to Login is: " + pwd);
		driver.findElement(emailId).sendKeys(uname);
		driver.findElement(loginPwd).sendKeys(pwd);
		driver.findElement(loginBtn).click();
	
	}
	
	

}
