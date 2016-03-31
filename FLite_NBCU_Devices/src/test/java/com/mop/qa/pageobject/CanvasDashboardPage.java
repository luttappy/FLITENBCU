package com.mop.qa.pageobject;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.mop.qa.testbase.PageBase_Appium;
import com.mop.qa.testbase.ReusableComponents;

public class CanvasDashboardPage extends PageBase_Appium {	
	
	@FindBy(id = "start_new_course")
	protected WebElement newCourseBtn;
	
	@FindBy(id = "course_name")
	protected WebElement courseNameTxtBx;
	
	@FindBy(id = "course_license")
	protected WebElement courseLicenseDd;
	
	@FindBy(id = "course_is_public")
	protected WebElement publicChkBtn;
	
	@FindBy(xpath = ("//div[@class='ui-dialog-buttonset']//button[2]"))
	protected WebElement createCrsBtn;
	
	@FindBy(xpath = ("//button[@class='ui-button btn-publish']//i"))
	protected WebElement publishBtn;
	
	@FindBy(id = "global_nav_profile_link")
	protected WebElement accounTab;
	
	@FindBy(xpath = "//*[@class='ReactTray__link-list']/li[6]/form/a/span")
	protected WebElement parentLogout;
	//canvas window handle
	
	@FindBy(name = "accept")
	protected WebElement studAcceptbtn;
	
	@FindBy(id = "global_nav_courses_link")
	protected WebElement coursesTab;

	@FindBy(linkText = "All Courses")
	protected WebElement allCourses;
	/*
	@FindBy(xpath = "//span[@title='C_20160201_162718']")
	protected WebElement courseName;	
	*/
	
	public String courseName;
	
		
	public String startNewCourse() throws Exception{
		clickStartNewCourse();
		//ReusableComponents rc = new ReusableComponents();
		 
		 courseName = getCourseName();
		 System.out.println(courseName);
		 enterCourseName(courseName);
		 clickCourseLicense();
		 publishCourse();
		 return courseName;
		
	}

	public void clickStartNewCourse() throws Exception {
		click(newCourseBtn, "Click Start New Course ");
	}
	
    public void enterCourseName(String cname) throws Exception{
       enterText(courseNameTxtBx, cname, "Enter Course Name");
    }
	
    public void clickCourseLicense() throws Exception {
    	
    	//click(courseLicenseDd,"Click on Content License");
		selectValue(courseLicenseDd, "Public Domain");
		click(publicChkBtn, "Click on set to public");
		click(createCrsBtn, "Click on create course button");
	}
      

	public void publishCourse() throws Exception{
    	click(publishBtn, "Click on the publish course button");
    }
	
	
	public void logoutCanvas(String parentWindow) throws Exception {
		switchToParentWindow(parentWindow);
		System.out.println("switched to parent window");
		Thread.sleep(3000);
		clickNewWindow(accounTab,"Click on Account");
		System.out.println("Account tab clicked");
		Thread.sleep(2000);
		click(parentLogout, "Logout Parent window");
		
	}
	
	public void studentCanvasLogout() throws Exception {
		clickNewWindow(accounTab,"Click on Account");
		click(parentLogout, "Logout Parent window");
		
	}
	
	//student accept course
	public void studAcceptCourse() throws Exception {
		click(studAcceptbtn, "Click Start New Courseaccept button ");
	}
	
	public void navigateToAllCoursesPage() throws Exception{
		click(coursesTab, "Click on Courses Tab ");
		click(allCourses, "Click on All Courses");
		//click(courseName, "Click on All Courses");
		
		
	}
	
    
    
	
}
