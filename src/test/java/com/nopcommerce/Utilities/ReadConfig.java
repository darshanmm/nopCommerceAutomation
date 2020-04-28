package com.nopcommerce.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig() {
		
		File src = new File("./configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}
	
	public String getApplicationURL() {
		String geturl = pro.getProperty("baseURL");
		return geturl;
	}
	
	public String getUserEmail() {
		String username = pro.getProperty("useremail");
		return username;
	}
	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
	}
	public String getChromePath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}
	public String getIEPath() {
		String IEpath = pro.getProperty("iepath");
		return IEpath;
		
	}
	public String getFirefoxPath() {
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
		
	}
}
