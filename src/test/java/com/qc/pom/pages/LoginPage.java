package com.qc.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}
   
	@FindBy(id = "email")
	WebElement  email;
	
	@FindBy(id ="password")
	WebElement pass;
	
	@FindBy(id = "submit")
	WebElement signin;
	
	@FindBy(linkText = "Register a new membership")
	WebElement rePageLink;
	
	public void enterEmail(String uName)
	{
		email.clear();
		email.sendKeys(uName);
	}
	public void enterPass(String uPass)
	{
		pass.clear();
		pass.sendKeys(uPass);
	}
	public void  clickOnLoginBtn()
	{
		signin.click();
	}
	
	public void clickOnRegisterBtn()
	{
		rePageLink.click();
	}
	
	
	public boolean verifyLoginPageTitle()
	{
		String actResult = driver.getTitle();
		String exResult = "Queue Codes | Log in";
		return actResult.equals(exResult);
	}
	
	
	public DashBoardPage loginWithValid(String uName, String uPass)
	{
		enterEmail(uName);
		enterPass(uPass);
		clickOnLoginBtn();
		return new DashBoardPage(driver);
	}
	
	public void loginWithIValid(String uName, String uPass)
	{
		enterEmail(uName);
		enterPass(uPass);
		clickOnLoginBtn();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
