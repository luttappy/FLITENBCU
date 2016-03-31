package com.mop.qa.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import com.mop.qa.testbase.PageBase_Appium;

public class EvolveMyEvolvePage extends PageBase_Appium {
	
	@FindBy(xpath = ("//img[@alt='Account']"))
	protected WebElement logoutIcon;
	
	@FindBy(xpath = "//li[@class='logout']/a")
	protected WebElement logout;
	
	@FindBy(className = "refresh")
	protected WebElement refreshLink;
	
	public void launchSherpath(String courseID, String contentName) throws Exception {
		try {
			isElementPresent(refreshLink,5);
			enterUrl("https://evolve.elsevier.com/Courses/"+courseID+"#/contents");
			String lessonXpath = "//span[@class='ng-binding' and normalize-space(.)= '"+contentName+"']";
			click(lessonXpath, contentName);
			switchToWindowTitle();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void evolvelogout(String parentWindow) throws Exception {
		Thread.sleep(2000);
		switchToParentWindow(parentWindow);
		click(logoutIcon,"clicked on logout icon");
		click(logout,"Clicked on Logout");
		Thread.sleep(5000);

	}
	
	

}

