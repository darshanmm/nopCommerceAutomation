package com.nopcommerce.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce.Utilities.XLUtils;
import com.nopcommerce.pageObjects.BaseClass;
import com.nopcommerce.pageObjects.LoginPage;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginTest(String user, String pwd) throws IOException, InterruptedException {
		
		driver.get(baseURL);
		logger.info("URL is opened");
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(user);
		logger.info("Username is entered");
		lp.setPassword(pwd);
		logger.info("Password is entered");
		lp.clickLogin();
		logger.info("Login button is clicked");
		Thread.sleep(3000);
		if(driver.getTitle().equals("Dashboard / nopCommerce administration")) {
				Assert.assertTrue(true);
				lp.clickLogout();
				logger.info("Login test is passed");
		}
		else
		{
			captureScreenshot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.info("Login test is failed");
			Assert.assertTrue(false);
		}

	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/nopcommerce/testData/LoginData.xlsx";

		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);
			}
		}
		return logindata;
	}
}
