package com.qc.pom.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qc.pom.pages.DashBoardPage;
import com.qc.pom.pages.LoginPage;
import com.qc.pom.pages.RegisterPage;

public class POMtest extends BaseIntegration {
	
	@Test(dataProvider = "loginData", priority = 1)
	public void doLogin(String testName, String uName, String uPass)
	{
		LoginPage login = new LoginPage(driver);
		if(testName.endsWith("Both are valid")) {
		DashBoardPage dash = login.loginWithValid(uName, uPass);
		Assert.assertTrue(dash.VerifyDashBoardPageTitle());
		dash.doLogout();
		
		}
		else
		{
			login.loginWithIValid(uName, uPass);
			Assert.assertTrue(login.verifyLoginPageTitle());
		}
	}
	
		@Test(dataProvider = "registerData", priority = 2)
		public void doRegister(String testName, String uName, String uMobile, String uEmail, String uPass){
			LoginPage loogin = new LoginPage(driver);
			if(driver.getTitle().equals("Queue Codes | Log in"))
			{
				loogin.clickOnRegisterBtn();
			}
			
			RegisterPage register = new RegisterPage(driver);
			register.doRegisterWithValid(uName,uMobile,uEmail,uPass);
			if(testName.equals("All are valid"))
			{
				Assert.assertTrue(register.verifyAlertMsg());
			}
			
			else
				Assert.assertTrue(register.verifyRegisterTitle());
		}
		
		
		
	}


