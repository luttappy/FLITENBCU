package com.mop.qa.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.testbase.PageBase_Appium;

public class CanvasLoginPage extends PageBase_Appium {
	@FindBy(id = "pseudonym_session_unique_id")
	protected WebElement userName;

	@FindBy(id = "pseudonym_session_password")
	protected WebElement passWord;

	@FindBy(xpath = ".//*[@id='login_form']/div[4]/div[2]/button")
	protected WebElement Login;
	
	@FindBy(id = "register_link")
	protected WebElement register;
	
	protected String parentWindow;
	
	//create new student ID
	public void clickregister() throws Exception {
		click(register, "Click Register for Canvas account");
	}
	
	public void clickLogin() throws Exception {
		click(Login, "Click Login");
	} 
	
	public void login(String url, String uName, String pword) throws Exception {
		enterUrl(url);
		enterUserName(uName);
		enterPassword(pword);
		clickLogin();
		
		parentWindow = getParentWindow();
		System.out.println("Login Successful");
	}
	
	public void login(String url) throws Exception {
		enterUrl(url);
	}
	
	public void enterUserName(String uname) throws Exception {

		enterText(userName, uname, "Entering UserName");

	}

	public void enterPassword(String pword) throws Exception {

		enterText(passWord, pword, "Entering password");

	}
	

}
