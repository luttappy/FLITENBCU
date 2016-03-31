package com.mop.qa.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StudentLessonPerformancePage {
	
	@FindBy(xpath = ("//div[@class='row']//div[@class='ng-scope']//div[1]//div[1]//div[2]//span[@class='tile__resource-title ng-binding'][contains(text(),'Overview of Nursing Diagnosis')]"))
	protected WebElement lessonUpNext;
	
	@FindBy(xpath = ("//div[@class='metric__stats-bubble--chart']//div/*[name()='svg']/*[name()='g']/*[name()='text'][1]"))
	protected WebElement correctAnsPerc;
	
	
	
	
	
			
	

}
