package com.nopcommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver ldriver;
	public LoginPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Email text element
	@FindBy(id="Email")
	@CacheLookup
	WebElement txtEmail;
	// password text element
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtPassword;
	
	//login button element
	@FindBy(xpath="//input[@value='Log in']")
	@CacheLookup
	WebElement btnLogin;

	//logout link element
	@FindBy(linkText="Logout")
	@CacheLookup
	WebElement lnkLogout;

	public void setUserName(String uname) {
		txtEmail.clear();
		txtEmail.sendKeys(uname);
	}
	public void setPassword(String pwd) {
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}
	public void clickLogin() {
		btnLogin.click();
	}
	public void clickLogout() {
		lnkLogout.click();
	}
}
