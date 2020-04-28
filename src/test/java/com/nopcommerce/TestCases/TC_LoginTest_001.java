package com.nopcommerce.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.model.ScreenCapture;
import com.nopcommerce.pageObjects.BaseClass;
import com.nopcommerce.pageObjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass{

	@Test
	public void loginTest() throws InterruptedException, IOException {
		driver.get(baseURL);
		logger.info("URL is opened");
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username is entered");
		lp.setPassword(password);
		logger.info("Password is entered");
		lp.clickLogin();
		logger.info("Login button is clicked");
		Thread.sleep(5000);
		if(driver.getTitle().equals("Dashboard / nopCommerce administration")) {
				Assert.assertTrue(true);
				lp.clickLogout();
				logger.info("Login test is passed");
		}
		else
		{
			captureScreenshot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			Assert.assertTrue(false);
			logger.info("Login test is failed");
		}
	}

}
