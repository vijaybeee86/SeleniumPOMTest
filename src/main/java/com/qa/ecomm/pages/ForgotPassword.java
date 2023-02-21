package com.qa.ecomm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import com.qa.ecomm.listeners.TestAllureListener;
import com.qa.ecomm.utils.Constants;
import com.qa.ecomm.utils.ElementUtil;

import io.qameta.allure.Step;


@Listeners(TestAllureListener.class)
public class ForgotPassword {
	private WebDriver driver;
	ElementUtil eleUtil;
	
	private By FP_Header = By.xpath("//*[@id='content']/h1");
	
	
	public ForgotPassword(WebDriver driver)
	{
		this.driver=driver;
		eleUtil = new ElementUtil(driver);
	}
	
	@Step("Getting the Forgot Password Page Title")
	public String getForgotPwdPageTitle()
	{
		return eleUtil.waitForTitleContains(Constants.FORGOTPWD_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
	}

	@Step("Getting the Forgot Password Page Header")
	public String getForgotPwdPageHeader()
	{
		return eleUtil.doGetText(FP_Header);
	}
	
	
	
}
