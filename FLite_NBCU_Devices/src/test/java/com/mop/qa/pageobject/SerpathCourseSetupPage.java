package com.mop.qa.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.testbase.PageBase_Appium;
import com.mop.qa.testbase.ReusableComponents;

public class SerpathCourseSetupPage extends PageBase_Appium {
	
	@FindBy(xpath=".//*[@id='main']/main/div[2]/div[1]/div/button")
	protected WebElement continueBtn;
	
	@FindBy(xpath=".//*[@id='main']/main/div[2]/div[2]/form/div[3]/button[2]")
	protected WebElement courseDateContinueBtn;
	
	@FindBy(id="fromDatePicker")
	protected WebElement courseStartDate;
	
	@FindBy(id="toDatePicker")
	protected WebElement courseEndDate;
	
	@FindBy(xpath=".//div[@id='main']/main/div/h1")
	protected WebElement titleHeader;
	
	private static final String US_DATE_FORMAT = "MM/dd/yyyy";
	private static final String ElsevierSherpathTitleString = "Elsevier Sherpath";
	
	public SerpathCourseSetupPage() {
		super();
	}
	
	public void clickContinue() throws Exception{
		if(this.verifyPageText("Cancel")){
			clickIntroContinueButton();
		}else{
			clickContinueFromCourseSetup();
		}
	}
	
	public void clickIntroContinueButton() throws Exception{
		this.waitUntilElementVisible(continueBtn);
		this.click(continueBtn, "Continue Button");
	}
	public void clickContinueFromCourseSetup() throws Exception{
		this.waitUntilElementVisible(courseDateContinueBtn);
		this.click(courseDateContinueBtn, "Continue Button");
	}
	
	public void setCourseStartDate(String date) throws Exception{
		this.sendKeys(courseStartDate, date);
	}
	
	public void setCourseStartDateToToday() throws Exception{
		String date = ReusableComponents.getFormattedDate(US_DATE_FORMAT);
		setCourseStartDate(date);
	}
	
	public void setCourseEndDate(String date) throws Exception{
		this.sendKeys(courseEndDate, date);
	}
	
	public String getTitleHeader() throws Exception{
		return this.getText(titleHeader);
	}
	public boolean isElsevierSherpathCourseSetup() throws Exception{
		String text = this.getText(titleHeader);
		boolean check = text.toUpperCase().contains(ElsevierSherpathTitleString.toUpperCase());
		return check;
	}
}
