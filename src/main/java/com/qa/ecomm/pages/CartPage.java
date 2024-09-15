package com.qa.ecomm.pages;

import com.qa.ecomm.listeners.TestAllureListener;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;


@Listeners(TestAllureListener.class)
public class CartPage {

	//privare driver initialize
    private WebDriver driver;


    //page constructor
	public CartPage(WebDriver driver) {
	
		this.driver = driver;
	}

	//By locator
	private By cartQty = By.id("input-email");
	private By cartATCBtn = By.id("input-password");
	private By cartPrice = By.xpath("//*[@id='form-login']/button");
	private By cartTotal = By.linkText("Forgotten Password");
	
	//Page Actions
	
	@Step("Getting the Cart Page Title")
	public String getCartPageTitle()
	{
		return driver.getTitle();
	}

	@Step("Getting the Cart Total")
	public String getCartTotal()
	{
		return driver.findElement(cartTotal).getText();
	}

	@Step("Getting the Cart Price")
	public String getCartPrice()
	{
		return driver.findElement(cartPrice).getText();
	}

	
	

}
