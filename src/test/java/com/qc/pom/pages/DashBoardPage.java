package com.qc.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {
	
	WebDriver driver;
	
	public DashBoardPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "hlogout")
	 WebElement logoutBtn;
	
    public boolean VerifyDashBoardPageTitle()
    {
    	String actResult = driver.getTitle();
    	String exResult = "Queue Codes | Dashboard";
    	return actResult.equals(exResult);
    }
    public void doLogout()
    {
    	logoutBtn.click();
    }
	
	
}
