package com.qa.ecomm.tests;

import org.testng.annotations.*;

import com.qa.ecomm.listeners.TestAllureListener;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("JIRA 200: Ecomm Automation Store")
@Story("JIRA 210: Forgot Password feature")
@Listeners(TestAllureListener.class)
public class ForgotPasswordTest extends BaseTest{

	
	@BeforeClass
	public void forgotPwdSetup()
	{
		fp = lp.clickForgotPwdLink();
	}
	
	
	@Description("This test case is to verify the Login Page Title")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void forgotPwdPageHeaderTest()
	{
		String pageHeader = fp.getForgotPwdPageHeader();
		System.out.println("Forgot Password Page Haeder is: " + pageHeader );
	
	}
	
	

}
