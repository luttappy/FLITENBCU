package com.mop.qa.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.testbase.PageBase_Appium;

public class SherpathSyllabusPage  extends PageBase_Appium {
	
	@FindBy(xpath = (".//*[@id='slide-panel']/navigation-list/div[1]/div[2]/a"))
	protected WebElement syllabus;
	
	@FindBy(xpath = ("//html/body/ui-view/snap-content/div/div[4]/div/div/ul/li[2]/week-drag-panel/div[2]/ul/li[2]/module-drag-panel/div/div[1]/span"))
	protected WebElement module;
	
	@FindBy(linkText = "Week1")
	protected WebElement week1Expand;
	@FindBy(linkText = "Communication and Collaboration PowerPoint")
	
	protected WebElement commLesson;
	
	@FindBy(xpath = ("//div[@class='expand-collapse']//a[1]"))
	protected WebElement expandAllWksTab;
	
	@FindBy(xpath = ("//div[@class='expand-collapse']/a[1][contains(text(),'Expand all weeks')]"))
	protected WebElement expandAllWksTabNew;
	
	@FindBy(xpath = "/html/body/ui-view/snap-content/div/div[4]/div/div/ul/li[1]/week-drag-panel/div[2]/ul/li[5]/module-drag-panel/div/div[1]")
	protected WebElement nursingDiagnosisModule;
	
	@FindBy(xpath = "/html/body/ui-view/snap-content/div/div[4]/div/div/ul/li[1]/week-drag-panel/div[2]/ul/li[5]/module-drag-panel/div[3]/div[2]/ul/li[1]/lesson-drag-panel/ul/li/div[5]/span")
    protected WebElement assignOverviewofNursingDiagnosis;


	
	@FindBy(xpath = "/html/body/ui-view/snap-content/div/div[4]/div/div/ul/li[1]/week-drag-panel/div[2]/ul/li[1]/module-drag-panel/div[1]/div[1]")
	protected WebElement beliefModule;
	
	@FindBy(xpath = "/html/body/ui-view/snap-content/div/div[4]/div/div/ul/li[1]/week-drag-panel/div[2]/ul/li[1]/module-drag-panel/div[3]/div[2]/ul/li[1]/lesson-drag-panel/ul/li/div[5]/span")
    protected WebElement beliefLesson;
	
	@FindBy(xpath = "/html/body/ui-view/snap-content/div/div[4]/div/div/ul/li[1]/week-drag-panel/div[2]/ul/li[1]/module-drag-panel/div[3]/div[2]/ul/li[1]/lesson-drag-panel/ul/li/div[5]/span")
	protected WebElement beliefLesson2;
	
	
	@FindBy(xpath = ".//*[@id='contentSchedule.id']/div[1]/div[1]")
	protected WebElement cognitionModule;
	
	@FindBy(xpath = ".//*[@id='contentSchedule.id']/div[3]/div[2]/ul/li[1]/lesson-drag-panel/ul/li/div[5]/span")
	protected WebElement assignCogniLesson;
	
	
	@FindBy(xpath = ("//div[@id='assignLessonScreen']//main[1]//section[2]//div[1]//div[1]//button"))
	protected WebElement strtDateTxtBx;
	
	@FindBy(xpath = ("//input[@id='visibletimepicker']"))
	protected WebElement strtTimePickerBx;
		
	@FindBy(xpath = ("/html/body/ui-view/snap-drawers/snap-drawer/assign-lesson/div/main/section[5]/div/div/button"))
	protected WebElement dueDateTxtBx;
	
	@FindBy(xpath = ("//input[@id='duetimepicker2']"))
	protected WebElement dueTimePickerBx;
	
	@FindBy(xpath = "/html/body/ui-view/snap-content/div/div[4]/div/div/ul/li[2]/week-drag-panel/div[2]/ul/li[6]/module-drag-panel/div[1]/div[1]")
	protected WebElement oxygenationModule;
	                  
	@FindBy(xpath = "/html/body/ui-view/snap-content/div/div[4]/div/div/ul/li[2]/week-drag-panel/div[2]/ul/li[6]/module-drag-panel/div[3]/div[2]/ul/li[1]/lesson-drag-panel/ul/li/div[5]/span")
	protected WebElement assignOverviewOxyPerfLesson;
	
	            
	@FindBy(xpath= ("//table[@class='ui-datepicker-calendar']//td"))
	protected List<WebElement> listofDates;
	
	@FindBy(xpath = ("//assign-lesson[@course-info='courseInfo']//div[1]//main[1]//div[1]//button[@class='button button--primary button--large']"))
	protected WebElement assignBtn;
	
	@FindBy(xpath = ("/html/body/ui-view/snap-drawers/snap-drawer/assign-lesson/div/main/div/button[1]"))
    protected WebElement assignLessonBtn;
	
	//move to Sherpath Home page
	@FindBy(xpath = "//*[@id='slide-panel']/div[2]/a")
	protected WebElement moretab;
	

	//move to Sherpath Home page
	@FindBy(xpath = "//*[@id='slide-panel']/div[2]/a")
	protected WebElement mMoretab;
	
	//move to Sherpath Home page
	@FindBy(xpath = "//*[@id='slide-panel']/navigation-list/div[2]/div[3]/a")
	protected WebElement logout;
	
	@FindBy(xpath = ("/html/body/ui-view/snap-content/div/div[4]/div/div/ul//li"))
	protected List<WebElement>  weeks;
	
	@FindBy(xpath = "html/body/ui-view/snap-content/header/div[1]/div[1]/p")
	protected WebElement syllabusHeader;
	
	@FindBy(xpath= "html/body/ui-view/snap-content/header/div[2]/div[1]/div[1]/h1")
	protected WebElement courseName;
	
	public void assignLessonTwoDaysLater() throws Exception{
		//click(syllabus, "Click on Syllabus tab");
		click(expandAllWksTab, "Click on Expand all weeks");
		click(oxygenationModule, "Click on Oxygenation Module");
		click(assignOverviewOxyPerfLesson, "Click on Assign");
		click(strtDateTxtBx, "Click Start Date");
		selectDate(listofDates,getTwoDaysLaterDate(),"Select assignment start date");
		clearKeys(strtTimePickerBx);
		click(strtTimePickerBx,"Click on start time");
		sendKeys(strtTimePickerBx, "4:30 AM");
		click(dueDateTxtBx, "Click Start Date");
		selectDate(listofDates,"30","Select assignment due date");	
		clearKeys(dueTimePickerBx);
		click(dueTimePickerBx, "Click on due time picker box");
		sendKeys(dueTimePickerBx, "8:00 PM");
		click(assignBtn,"Click on assign button");
		
		}
	
	public void assignBeliefsLessonforToday() throws Exception{
		click(expandAllWksTab, "Click on Expand all weeks");
		click(beliefModule, "Click on Beliefs,Values and Caring Module");
		click(beliefLesson, "Click on Beliefs and Values in Nursing Lesson ");
		click(strtDateTxtBx, "Click Start Date");
		selectDate(listofDates,getCurrentDate(),"Select assignment start date");
		clearKeys(strtTimePickerBx);
		click(strtTimePickerBx,"Click on start time");
		sendKeys(strtTimePickerBx, "4:30 AM");
		click(dueDateTxtBx, "Click Start Date");
		selectDate(listofDates,"30","Select assignment due date");	
		clearKeys(dueTimePickerBx);
		click(dueTimePickerBx, "Click on due time picker box");
		sendKeys(dueTimePickerBx, "8:00 PM");
		click(assignBtn,"Click on assign button");
	}
	
	public void clickModule(String moduleName, String lessonName) {
		// case moduleName = nursingDiagnostics
		//assignNursingdiagnostics(lessonName);
		
	}
	
	public void assignBeliefsLessonforTomorrow() throws Exception{
		click(expandAllWksTab, "Click on Expand all weeks");
		click(beliefModule, "Click on Beliefs,Values and Caring Module");
		click(beliefLesson2, "Click on Beliefs and Values in Nursing Lesson ");
		click(strtDateTxtBx, "Click Start Date");
		//selectDate(listofDates,getOneDayLaterDate(),"Select assignment start date");
		selectDate(listofDates,getCurrentDate()+1,"Select assignment start date");
		clearKeys(strtTimePickerBx);
		click(strtTimePickerBx,"Click on start time");
		sendKeys(strtTimePickerBx, "4:30 AM");
		click(dueDateTxtBx, "Click Start Date");
		selectDate(listofDates,"30","Select assignment due date");	
		clearKeys(dueTimePickerBx);
		click(dueTimePickerBx, "Click on due time picker box");
		sendKeys(dueTimePickerBx, "8:00 PM");
		click(assignBtn,"Click on assign button");
	}
	
	public void assignLesson(String moduleName, String lessonName) throws Exception{
		//check if expand all is enabled before clicking on it
		clickExpandAllWeeks();
		System.out.println("all weeks expanded");
		selectModule(moduleName);
		clickAssignLesson(lessonName);
		System.out.println("Assign lesson clicked");
		clickVisibleCalendar();
		selectVisibleDate();
//		clickVisibleTime()
		selectVisibleTime();
		clickAssignDueCalendar();
		System.out.println("calendar selected ");
		selectAssignDate();
		System.out.println("due date selected ");
//		clickAssignDueDate();
		selectAssignDueTime();
		clickAssignButton();
		
	}
	
	
	public void clickExpandAllWeeks() throws Exception {
		if(expandAllWksTabNew.isEnabled()) {
			System.out.println("Expand week enabled");
			click(expandAllWksTabNew, "Click on Expand all weeks");
		}
		
	}
	
	public void selectModule(String moduleName) throws Exception {
		
    	String courseXpath = "//div[contains(@class,'title-module') and normalize-space(.) ='"+moduleName+"']";
    	System.out.println("courseXpath is " +courseXpath);
    	click(courseXpath, courseXpath);
		
   	
		
//		click(nursingDiagnosisModule, "Click on Nursing diagnosis");
		
	}
	
	public void clickAssignLesson(String lessonName) throws Exception {
		
//		String lessonXpath = "//a[@class='ng-binding' and normalize-space(.) ='"+lessonName+"']/../../following-sibling::div[@class='resource-cell date']/span";
		String lessonXpath = "//a[@class='ng-binding' and normalize-space(.) ='"+lessonName+"']/../../following-sibling::div[@class='resource-cell date']/span";
		
//		String lessonAssign = "'+lessonXpath+'/../../following-sibling::div[@class='resource-cell type']/span [contains(text(),'lesson']/../../following-sibling::div[@class='resource-cell date']/span";
    	System.out.println("courseXpath is " +lessonXpath);
    	click(lessonXpath, lessonXpath);
    	
		
		
//    	String lessonXpath = "//a[contains(@class,'ng-binding') and normalize-space(.) ='"+lessonName+"']/../../following-sibling::div[@class='resource-cell date']/span";
//    	System.out.println("courseXpath is " +lessonXpath);
//    	clickElement(By.xpath(lessonXpath));
    	
//		click(assignOverviewofNursingDiagnosis, "Click on assign lesson");
		
	}
	
	public void clickVisibleCalendar() throws Exception {
		
	}
	
	public void selectVisibleDate() throws Exception {
		//selectDate(listofDates,getCurrentDate(),"Select today's date as course visible date");
		
	}
	
	public void selectVisibleTime() throws Exception {
		
	}
	
	public void clickAssignDueCalendar() throws Exception {
		click(dueDateTxtBx, "Click assign due date calendar");
		
	}
	
	public void selectAssignDate() throws Exception {
		selectDate(listofDates,getCurrentDate(), "Select today's date as course start date");
		
	}
	
	
	public void clickAssignDueDate() throws Exception {
		
	}
	
	public void selectAssignDueTime() throws Exception {
		
	}
	
	public void clickAssignButton() throws Exception {
		click(assignLessonBtn, "click on Assign button");
		
	}
	
	
		
		
//		click(expandAllWksTab, "Click on Expand all weeks");
//		//check if module is already expanded before clicking
//		click(nursingDiagnosisModule, "Click on Nursing Diagnosis Module");
//		click(assignOverviewofNursingDiagnosis, "Click on assign Overview of Nursing Diagnosis lesson ");
//		click(strtDateTxtBx, "Click Start Date");
//		//selectDate(listofDates,getOneDayLaterDate(),"Select assignment start date");
//		selectDate(listofDates,getCurrentDate()+1,"Select assignment start date");
//		clearKeys(strtTimePickerBx);
//		click(strtTimePickerBx,"Click on start time");
//		sendKeys(strtTimePickerBx, "4:30 AM");
//		click(dueDateTxtBx, "Click Start Date");
//		selectDate(listofDates,"30","Select assignment due date");	
//		clearKeys(dueTimePickerBx);
//		click(dueTimePickerBx, "Click on due time picker box");
//		sendKeys(dueTimePickerBx, "8:00 PM");
//		click(assignBtn,"Click on assign button");
//	}
	
	public void logout() throws Exception {
		clickmoretab();
		clicklogout();
		System.out.println("Sherpath Logout Successful");
	}
	
	public void clickmoretab() throws Exception {
		String toolName  = getAppProperties("tool");
		if (toolName.equalsIgnoreCase("Selenium")) {
			click(moretab, "Click on more tab");
		}
		else{
			click(mMoretab, "Click on more tab");
		}
	}
	
	public void clicklogout() throws Exception {
		click(logout, "Click on logout button");
	}
	
	
	
	
	
	public boolean isSyllabusPage() throws Exception{
		String text = this.getText(syllabusHeader);
		
		return text.toUpperCase().trim().contains("Syllabus".toUpperCase().trim());
	}
	
	public String getSyllabusCourseName() throws Exception{
		this.waitForPageLoad();
		this.waitUntilTextChanges(courseName, "");
		return this.getText(courseName, "Get Course Name");
	}
	
	
	
	
	
	
}
