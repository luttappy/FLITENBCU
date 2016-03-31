package com.mop.qa.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import com.mop.qa.testbase.PageBase_Appium;

public class EvolveHomePage extends PageBase_Appium {
	
	protected String parentWindow;
	protected String passcode="testing1";
	protected String studentName;
	@FindBy(xpath = "/html/body/header/div/nav/form/ul[1]/li[2]/input")
	protected WebElement loginUserId;
	
	@FindBy(xpath = "/html/body/header/div/nav/form/ul[1]/li[3]/input")
	protected WebElement loginPassword;
	
	@FindBy(className = "login")
	protected WebElement loginBtn;
	
	public String launchurl(String url) throws Exception {
		try {
			enterUrl(url);
			parentWindow = getParentWindow();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return parentWindow;
	}
	
	public void login(String userName, String password) throws Exception {
		try {
			enterText(loginUserId,userName,"Enter User Name");
			enterText(loginPassword,password,"Enter Password");
			click(loginBtn, "Click Login Button");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
