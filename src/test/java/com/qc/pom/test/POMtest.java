package com.qc.pom.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qc.pom.pages.DashBoardPage;
import com.qc.pom.pages.LoginPage;

public class POMtest extends BaseIntegration {
	
	@Test(dataProvider = "loginData")
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

}
