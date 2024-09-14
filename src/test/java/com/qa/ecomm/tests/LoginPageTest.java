package com.qa.ecomm.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.ecomm.listeners.TestAllureListener;
import com.qa.ecomm.utils.Constants;
import com.qa.ecomm.utils.Errors;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("JIRA 200: Ecomm Automation Store")
@Story("JIRA 209: Login feature")
@Listeners(TestAllureListener.class)
public class LoginPageTest extends BaseTest{

	
	@Description("This test case is to verify the Login Page Title")
	@Severity(SeverityLevel.MINOR)
	@Test(priority = 0)
	public void loginPageTitleTest()
	{
		
		String actualTitle = lp.getLoginPageTitle();
		System.out.println("Page Title is: " + actualTitle);
		Assert.assertEquals(actualTitle, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Description("This test case is to verify the Login Page URL")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)
	public void loginPageUrlTest()
	{
		String actualUrl= lp.getLoginPageUrl();
		System.out.println("Page URL is: " + actualUrl);
		Assert.assertTrue(actualUrl.contains(Constants.LOGIN_PAGE_URL));
	}
	@Description("This test case is to verify the Forgot Password link is present or not")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 2)
	public void loginPage_ForgotPwdLinkExistTest()
	{
        Boolean forgotPwdLinkPresent = lp.isForgotPwdLinkExist();
		System.out.println("Forgot Password link is present in Login page: " + forgotPwdLinkPresent);
		Assert.assertTrue(forgotPwdLinkPresent);
		
	}
	
	@Description("This test case is to verify the Forgot Password link is clickable or not")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 3)
	public void loginPage_ForgotPwdLinkTest()
	{
        fp = lp.clickForgotPwdLink();
		String pageTitle = fp.getForgotPwdPageTitle();
		System.out.println("Forgot Password Page Title is: " + pageTitle );
		Assert.assertEquals(pageTitle, "hhhhk", Errors.TITLE_ERROR_MESSG);
		
		//Constants.FORGOTPWD_PAGE_TITLE)
	
	}
	
	@Test(priority = 4, enabled=false)
	public void loginTest()
	{
		lp.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		System.out.println("Successfully Logged in to the application");
	}
	
}
