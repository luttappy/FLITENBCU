package com.mop.qa.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.testbase.PageBase_Appium;

public class SherpathHomePage  extends PageBase_Appium {

		@FindBy(xpath= ("//div[@class='menu-portal-item ng-scope active']"))
		protected WebElement homeTab;
		
		@FindBy(xpath = ("//img[@class='ui-datepicker-trigger']"))
		protected WebElement dateWidget;
		
		
	
		public void clickHome() throws Exception{
			click(homeTab,"Click on Home Page tab");
		}
		
		public void clickCalendar() throws Exception{
			click(dateWidget, "Click calendar widget");
		}
		
		
		
		
		
}
