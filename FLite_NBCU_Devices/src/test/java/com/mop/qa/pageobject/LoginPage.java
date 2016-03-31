package com.mop.qa.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.testbase.PageBase_Appium;

public class LoginPage extends PageBase_Appium {
	@FindBy(id = "pseudonym_session_unique_id")
	protected WebElement userName;

	@FindBy(id = "pseudonym_session_password")
	protected WebElement passWord;

	@FindBy(xpath = ".//*[@id='login_form']/div[4]/div[2]/button")
	protected WebElement Login;
	
	protected String parentWindow;
	
	public void clickLogin() throws Exception {
		click(Login, "Click Login");
	} 
	
	public String login(String url, String uName, String pword) throws Exception {
		enterUrl(url);
		enterUserName(uName);
		enterPassword(pword);
		clickLogin();
		
		parentWindow = getParentWindow();
		return parentWindow;
	}
	
	
	public void enterUserName(String uname) throws Exception {

		enterText(userName, uname, "Entering UserName");

	}

	public void enterPassword(String pword) throws Exception {

		enterText(passWord, pword, "Entering password");

	}
	

}
