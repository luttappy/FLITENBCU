package com.mop.qa.pageobject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.mop.qa.testbase.PageBase_Appium;

public class EvolveRegisterStudent extends PageBase_Appium {
	
	@FindBy(id = "ui-resourceId")
	protected WebElement instCourseID;
	
	@FindBy(xpath = ("//input[@value='Continue']"))
	protected WebElement continueBtn;
	
	@FindBy(xpath = ("//div[@class='proceed']/button"))
	protected WebElement proceedtoCart;
	
	@FindBy(xpath = "/html/body/div[3]/form/div[1]/div/input")
	protected WebElement loginID;
	
	@FindBy(id = "checkoutButton")
	protected WebElement checkoutBtn;
	
	@FindBy(id = "field-firstName")
	protected WebElement studFirstName;

	@FindBy(id = "field-lastName")
	protected WebElement studLastName;	

	@FindBy(id = "field-email")
	protected WebElement studEmail;	
		
	@FindBy(id = "field-emailConfirm")
	protected WebElement studEmailConfirm;	
	
	@FindBy(id = "field-password")
	protected WebElement password;
	
	@FindBy(id = "field-passwordConfirm")
	protected WebElement passwordConfirm;

	@FindBy(id = "institution-country")
	protected WebElement country;
	
	@FindBy(id = "institution-state")
	protected WebElement state;
	
	@FindBy(id = "institution-city")
	protected WebElement city;
	
	@FindBy(id = "institution-name")
	protected WebElement instName;
	
	@FindBy(id = "address0-address1")
	protected WebElement stAddress;
	
	@FindBy(id = "address0-zipCode")
	protected WebElement zip;
	
	@FindBy(id = "field-phone")
	protected WebElement phone;
	
	@FindBy(id = "select-program-type")
	protected WebElement pgmType;

	@FindBy(id = "domestic-true")
	protected WebElement resideCheckBox;
	
	@FindBy(id = "profile-submit")
	protected WebElement continueBtn1;
	
	@FindBy(id = "checkbox-registered")
	protected WebElement registerCheckBox;
	
	@FindBy(id = "submitButton")
	protected WebElement submitBtn;
	
	@FindBy(xpath = ("//img[@alt='Account']"))
	protected WebElement logoutIcon;
	
	@FindBy(xpath = "//li[@class='logout']/a")
	protected WebElement logout;
	
	@FindBy(xpath = "//ul[@class='account-dropdown-content']/li/a")
	protected WebElement accountSettings;

	@FindBy(className = "span6")
	protected WebElement userName;
	
	@FindBy(id = ("no-institution"))
	protected WebElement checkBoxNotAffiliated;
	
	@FindBy(id = ("//a[@href='/?']"))
	protected WebElement myEvolveLink;
	
	@FindBy(className = "current")
	protected WebElement orderConfirmation;
	
	protected String parentWindow;
	protected String passcode="testing1";
	protected String studentName;

	//create file

	

	
	public String launchurl(String url) throws Exception {
		try {
			enterUrl(url);
			parentWindow = getParentWindow();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return parentWindow;
	}
	
	public String evolveUserRegister(String courseID, String firstName, String studeemailID) throws Exception {
		try {
//			System.out.println("enter url");
			entercourseID(courseID);
			clickButton(continueBtn);
//			System.out.println("switch to iframe");
			Thread.sleep(2000);
			switchToiframe();
			clickProceedtoCart();
			clickButton(checkoutBtn);
			
//			String firstName = String.valueOf(fName);
			enterFirstName(firstName);
			enterLastName("Student");
			
			//get user email
			
			enterEmail(studeemailID);
			confirmEmail(studeemailID);
			enterPassword();
			confirmPassword();
			checkBoxNotAffiliated.click();
			clickButton(continueBtn1);
			Thread.sleep(2000);
			registerCheckBox.click();
			clickButton(submitBtn);
			
			if(isElementPresent(orderConfirmation,5)) {
				Thread.sleep(2000);
				click(logoutIcon,"clicked on logout icon");
				click(accountSettings,"Clickon Account Settings");
				if(isElementPresent(userName,5)) {
					studentName= userName.getAttribute("value");
					System.out.println("username is "+studentName);
	 
				} else {
					System.out.println("user name element");
					studentName= "null";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentName; 
	}

	public String evolveUserRegister(String courseID, String firstName) throws Exception {
		String studeemailID = getFormattedDate("yyyyMMdd_HHmmss")+"@sharepathdemo.com";
		System.out.println("Student email id is "+studeemailID);
		
		return evolveUserRegister(courseID, firstName, studeemailID);
	}

	
	public void launchSherpath(String courseID, String contentName) throws Exception {
		try {
			Thread.sleep(2000);
			enterUrl("https://evolve.elsevier.com/Courses/"+courseID+"#/contents");
			Thread.sleep(2000);
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
	
	public void enterFirstName(String firstName) throws Exception {

		enterText(studFirstName, firstName, "Entering first name");

	}
	
	public void enterLastName(String lName) throws Exception {

		enterText(studLastName, lName, "Entering last name");

	}
	
	public void enterEmail(String studeemailID) throws Exception {

		enterText(studEmail, studeemailID, "Entering email id");

	}
	
	public void confirmEmail(String studeemailID) throws Exception {

		enterText(studEmailConfirm, studeemailID, "Entering email id confirm");

	}
	
	public void enterPassword() throws Exception {

		enterText(password, passcode, "Entering password");

	}
	
	public void confirmPassword() throws Exception {

		enterText(passwordConfirm, passcode, "Entering confirm password");

	}
	
	public void enterCity(String cityName) throws Exception {

		enterText(city, cityName, "Entering confirm password");

	}
	
	public void enterInstName(String name) throws Exception {

		enterText(instName, name, "Entering confirm password");

	}
	
	public void enterZip(String zipcode) throws Exception {

		enterText(zip, zipcode, "Entering confirm password");

	}
	
	public void enterStAddress(String address) throws Exception {

		enterText(stAddress, address, "Entering address");

	}
	
	public void enterPhoneNum(String phnum) throws Exception {

		enterText(phone, phnum, "Entering phone number");

	}
	
	public void resideinCheckBox() throws Exception {

		click(resideCheckBox,"click checkout button");

	}
	
	
	public void entercourseID(String courseID) throws Exception {

		enterText(instCourseID, courseID, "Entering courseID");

	}
	
	public void clickButton(WebElement element) throws Exception {
		click(element, "Click continue");
	}
	
	public void clickProceedtoCart() throws Exception {
		click(proceedtoCart, "Click proceedtoCart");
	} 

}
