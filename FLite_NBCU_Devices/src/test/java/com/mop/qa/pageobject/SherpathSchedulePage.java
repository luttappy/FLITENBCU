package com.mop.qa.pageobject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.testbase.PageBase_Appium;

public class SherpathSchedulePage extends PageBase_Appium {

	@FindBy(xpath= ("/html/body/ui-view/div/main/div[2]/div[1]/div/button"))
	protected WebElement continueBtn;
	
	@FindBy(xpath= ("//table[@class='ui-datepicker-calendar']//td"))
	protected List<WebElement> listofDates;
	
	@FindBy(xpath = ("//div[@class='container-buttons-splash']//button[2]"))
	protected WebElement continue2Btn;
	
	@FindBy(xpath = (".//*[@id='fromDatePicker']"))
	protected WebElement dateStrtTxtBx;
	
	@FindBy(xpath = (".//*[@id='toDatePicker']"))
	protected WebElement dateEndTxtBx;

	
	public void setCourseSchedule() throws Exception{
		click(continueBtn, "Click continue button");
		System.out.println("onto schedule dates");
		click(dateStrtTxtBx,"Click on start date text box");
		//selectCurrentDate();
		selectDate(listofDates,getCurrentDate(), "Select today's date as course start date");
		click(dateEndTxtBx,"Click on end date text box");
		selectDate(listofDates,"29", "Select course end date");
		click(continue2Btn, "Click continue button");
		Thread.sleep(5000);
		
	}
	
	
	//obsolete
	public void selectCurrentDate() throws Exception {
		selectDate(listofDates,getCurrentDate(),"Select Current date");
   
    }

	
	
}
    