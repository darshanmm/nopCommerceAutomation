package com.nopcommerce.pageObjects;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nopcommerce.Utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUserEmail();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;

	@BeforeClass
	@Parameters("browser")
	public void setup(String br) {
		// System.setProperty("webdriver.chrome.driver",
		// System.getProperty("user.dir")+"//drivers/chromedriver.exe");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();

		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();

		} else if (br.equals("IE")) {
			System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
			driver = new InternetExplorerDriver();

		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		logger = Logger.getLogger("nopCommerce");
		PropertyConfigurator.configure("log4j.properties");

	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver, String tname) throws IOException{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot is taken");
	}
}