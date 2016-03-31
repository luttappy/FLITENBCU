package com.mop.qa.pageobject;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.testbase.PageBase_Appium;
import com.mop.qa.testbase.ReusableComponents;

public class CanvasRegisterUserPage extends PageBase_Appium {
	
	public CanvasRegisterUserPage() {
		super();
	}
	
	//element I'm a student
	@FindBy(id = "signup_student")
	protected WebElement studentbtn;
	
	@FindBy(id = "student_join_code")
	protected WebElement joinCode;
	
	@FindBy(id = "student_name")
	protected WebElement firstName;
	
	@FindBy(id = "student_username")
	protected WebElement userName;
	
	@FindBy(id = "student_password")
	protected WebElement password;
	
	@FindBy(id = "student_password_confirmation")
	protected WebElement passwordConfirm;
	
	@FindBy(name = "user[terms_of_use]")
	protected WebElement checkBox;
	
	@FindBy(xpath = "html/body/div[4]/div[3]/div/button")
	protected WebElement StartLearning;
	
	@FindBy(id="signup_teacher")
	protected WebElement signupbtn;
	
	@FindBy(xpath=".//form[@id='try_canvas']//*[@id='org_type__c']")
	protected WebElement organizationType;
	
	@FindBy(xpath=".//form[@id='try_canvas']//*[@id='title']")
	protected WebElement title;
	
	@FindBy(id="firstname-fft")
	protected WebElement instructor_firstname;
	
	@FindBy(id="lastname-fft")
	protected WebElement instructor_lastname;
	
	@FindBy(id="phone")
	protected WebElement phone;
	
	@FindBy(id="email")
	protected WebElement email;
	
	@FindBy(id="location")
	protected WebElement location;
	
	@FindBy(id="user_terms_of_use")
	protected WebElement user_terms_of_use;
	
	@FindBy(id = "company")
	protected WebElement company;
	
	@FindBy(id="FFT-Canvas-submit")
	protected WebElement submit;
	
	@FindBy(id="teacher_signup")
	protected WebElement teacher_signup;
	
	//student username
	String studUserName; 
	
	//launch the URL
	public void launchCanvasUserRegister(String url) throws Exception {
		enterUrl(url);
		
	}

	public String studentRegistration(String fName,int i, String pword, String studjoincode) throws Exception {
		clickStudentBtn();
		enterStudentJoinCode(studjoincode);
		enterStudentName(fName,i);
		studUserName = getFormattedDate("yyyyMMdd_HHmmss")+"@sharklasers.com";
		enterStudentUserName(studUserName);
		enterPassword(pword);
		enterPasswordConfirm(pword);
		checkTermsofUse();
		clickStartLearningBtn();
		return studUserName;
		
	}
	
	//click on student button
	public void clickStudentBtn() throws Exception {
		click(studentbtn, "Click on I'm student button");
	}
	
	public void enterStudentJoinCode(String jcode) throws Exception {
		enterText(joinCode, jcode, "Entering join code ");
	}
	
	public void enterStudentName(String fName, int i) throws Exception {
		enterText(firstName, fName+i, "Entering Name ");
	}
	
	public void enterStudentUserName(String uName) throws Exception {
		enterText(userName, uName, "Entering User Name " +uName);
	}
	
	public void enterPassword(String pword) throws Exception {
		enterText(password, pword, "Entering Password ");
	}
	
	public void enterPasswordConfirm(String pword) throws Exception {
		enterText(passwordConfirm, pword, "Entering Passeord confirm ");
	}
	
	//TODO: Test Confirmation for InStructor
	//add for checkbox  
	public void checkTermsofUse() throws Exception {
		checkBox(checkBox, "Check checkbox for Terms of use ");
	}
	
	public void clickStartLearningBtn() throws Exception {
		click(StartLearning, "Click Start Learning ");
	}
	
	public void clickTeacherBtn () throws Exception {
		click(signupbtn, "Sign Up As Teacher");
	}
	
	public String completeInstructorLead() throws Exception {
		
		return studUserName;
	}

	public void teacherSignup(String organization, String title, String school, String firstname, String lastname, String phoneNumber, String email, String location) throws Exception{
		
		//Switch to frame.
		//this.switchToframe(teacher_signup);
	//TODO: REmove Method
		//selectJSLockedId("org_type__c", organization);
		//selectText(this.organizationType, organization);
		selectText(this.title, title);
		this.sendKeys(this.company,school);
		
		this.sendKeys(instructor_firstname, firstname);
		this.sendKeys(instructor_lastname, lastname);
		this.sendKeys(this.phone, phoneNumber); 
		this.sendKeys(this.email, email);
		selectValue(this.location, location);
		checkTermsofUse();
		this.click(submit, "Submit");
	}
	
	private static final String _long_time_format = "yyyyMMddhhmmssz";
	private static final String _short_format = "ddhhmmss";
	
	public void teacherSignup(String firstname, String lastname, String email) throws Exception{
		String 	organization ="Higher Ed", title = "Teacher/Instructor", school ="Test_" + ReusableComponents.getFormattedDate(_long_time_format), 
				location = "United States and Canada", phone = "50" + ReusableComponents.getFormattedDate(_short_format);
		
		teacherSignup(organization, title, school, firstname, lastname, phone, email, location);
		
	}
	
	
}