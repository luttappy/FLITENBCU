package com.mop.qa.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.testbase.PageBase_Appium;

public class SherpathStudentHomePage  extends PageBase_Appium {

		@FindBy(xpath= ("//div[@class='menu-portal-item ng-scope active']"))
		protected WebElement homeMenu;
		
		@FindBy(xpath = ("//img[@class='ui-datepicker-trigger']"))
		protected WebElement dateWidget;
		
		@FindBy(className = ("icon-syllabus"))
		protected WebElement syllabusMenu;
		
		@FindBy(xpath = "/html/body/ui-view/snap-content/div/main/article/div[1]/div[2]/content-tile/div/div/div[1]/div[2]/span[5]")
		protected WebElement overviewofNursingDiagnosis;

		
		
		
		
		
	
		public void clickHomeMenu() throws Exception{
			click(homeMenu,"Click on Home Page tab");
		}
		
		public void clickSyllabusMenu() throws Exception{
			String syllabuspath = "//span[@class='menu-label ng-binding'][contains(text(),'Syllabus')]";
	    	//System.out.println("courseXpath is " +syllabuspath);
	    	click(syllabuspath, syllabuspath);
//			click(syllabusMenu,"Click on Syllabus menu tab");
		}
		
		public void clickCalendar() throws Exception{
			click(dateWidget, "Click calendar widget");
		}
		
		public void studentOpenLesson(String courseName) throws Exception {
			click(overviewofNursingDiagnosis, "Click on Overview of Nursing Diagnosis lesson");
			
		}
		
		
		
		
}
