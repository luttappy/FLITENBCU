package com.mop.qa.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.testbase.PageBase_Appium;

public class HomeView extends PageBase_Appium {
	
	public HomeView(){
		super();
	}
	
	private static final String ASSIGNMENT_DATE_LESSON_FORMAT = //"//div[h3[@id='%s']]/div//content-tile//div[@class='tile__content']/span[contains(.,'%s')]";
																  "//div[h3[@id='%s']]/div//content-tile//span[contains(.,'%s')]";
	private static final String ASSIGNMENT_LESSON_FORMAT = ".//div/div/div[3]/content-tile/div/div/div[@class='tile-new ng-scope']/div[@class='tile__content']/span[@class='tile__module-name ng-binding' and contains(.,'')]";
	
	public void goToAssignment(DayOfTheWeek day, String assignment ) throws Exception{
		String path = String.format(ASSIGNMENT_DATE_LESSON_FORMAT, day.toString(), assignment);
		WebElement e = this.getElement(path);
		click(e, assignment);
	}
	
	public void goToAssignment(String assignment ) throws Exception{
		String path = String.format(ASSIGNMENT_LESSON_FORMAT, assignment);
		WebElement e = this.getElement(path);
		click(e, assignment);
	}
	
	//ENUM for Day of the Week
	public enum DayOfTheWeek{

		SUNDAY ( "lesson-0"), 
		MONDAY ("lesson-1"),
		TUESDAY ("lesson-2"),
		WEDNESDAY ( "lesson-3"),
		THURSDAY ( "lesson-4" ),
		FRIDAY ("lesson-5"),
		SATURDAY ("lesson-6");
		
		private final String id; 
		//private static final String
		DayOfTheWeek( String id ){
			this.id = id;
		}
		public boolean equalsName(String otherName) {
	        return (otherName == null) ? false : id.equals(otherName);
	    }

	    public String toString() {
	       return this.id;
	    }
	}

	@FindBy(id = "opener")
	WebElement opener;
	
	public void clickOpener() throws Exception {
		click(opener, "Opener");
	}

	public boolean isAssigmentPresent(String assignment) {
		String xpath = String.format(ASSIGNMENT_LESSON_FORMAT, assignment);
		try {
			return this.elementIsDisplayed(xpath);
		} catch (Exception e) {
			
		}
		return false;
	}

	
}
