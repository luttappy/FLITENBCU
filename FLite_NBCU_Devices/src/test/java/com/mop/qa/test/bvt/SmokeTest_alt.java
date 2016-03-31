package com.mop.qa.test.bvt;

import org.testng.annotations.Test;

import com.mop.qa.Utilities.MPException;
import com.mop.qa.pageobject.CanvasCoursesPage;
import com.mop.qa.pageobject.CanvasDashboardPage;
import com.mop.qa.pageobject.CanvasLoginPage;
import com.mop.qa.pageobject.SerpathCourseSetupPage;
import com.mop.qa.pageobject.SherpathSyllabusPage;
import com.mop.qa.testbase.ReusableComponents;
import org.testng.annotations.BeforeTest;

import java.util.Calendar;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SmokeTest_alt  extends TestBase {
	private CanvasLoginPage canvasLoginPage;
	
	private String COURSE_NAME;
	@Test
	public void testInstructorSetup() throws Exception {
		SerpathCourseSetupPage serpathCourseSetupPage = new SerpathCourseSetupPage();
		SherpathSyllabusPage sherpathSyllabusPage = new SherpathSyllabusPage();
		
		//Wait For Page to Fully load before testing.
		serpathCourseSetupPage.waitForPageLoad();
		
		//VERIFY: Sherpath Course Setup Loaded Successfully
		Assert.assertTrue(serpathCourseSetupPage.isElsevierSherpathCourseSetup(), "Course was not loaded");
		
		serpathCourseSetupPage.clickIntroContinueButton();
		serpathCourseSetupPage.setCourseStartDateToToday();
		
		
		String date = ReusableComponents.getFormattedDate(ReusableComponents.US_DATE_FORMAT, Calendar.MONTH, 7);
		serpathCourseSetupPage.setCourseEndDate(date);
		
		serpathCourseSetupPage.clickContinueFromCourseSetup();
		//In Sherpath Main page as Instructor
		//Should launch in to the Syllabus page
		
		sherpathSyllabusPage.waitForPageLoad();
		//VERIFY: We are on the Syllabus page
		Assert.assertTrue(sherpathSyllabusPage.isSyllabusPage(), "This is not the Syllabus page");
			
		String syllabusCoursNameText = sherpathSyllabusPage.getSyllabusCourseName();
		
		//VERIFY: Sherpath Course Name was Loaded Successfully
		Assert.assertEquals(syllabusCoursNameText.toUpperCase().trim(), COURSE_NAME.toUpperCase().trim(), "Course name is Different than expected");
		Thread.sleep(10000);
	}

	@Test
	public void testHomePageStudent() {
	}
	
	@Test
	public void testCreateCanvas() {
		
	}
	
	@BeforeTest
	public void beforeTest() {
		//Create Instructor in Canvas
		try {
			canvasLoginPage = new CanvasLoginPage();
			String url = rds.getValue("DATA",this.getClass().getSimpleName(), "url");
			String uname = rds.getValue("DATA",this.getClass().getSimpleName(), "UserName");
			String pword = rds.getValue("DATA",this.getClass().getSimpleName(), "Password");
			
			canvasLoginPage.login(url);
			
			canvasLoginPage.enterUserName(uname);
			canvasLoginPage.enterPassword(pword);
			canvasLoginPage.clickLogin();
			
			CanvasDashboardPage canvasDashboardPage =  new CanvasDashboardPage() ;
			
			canvasDashboardPage.clickStartNewCourse();
			COURSE_NAME =  ReusableComponents.getCourseName();
			canvasDashboardPage.enterCourseName(COURSE_NAME);
			canvasDashboardPage.clickCourseLicense();
			
			canvasDashboardPage.publishCourse();
			
			CanvasCoursesPage canvasCoursesPage = new CanvasCoursesPage();
			
			canvasCoursesPage.createApp(COURSE_NAME,"http://qa.oauthapi.eols.io/oauth/launch", "" );
			canvasCoursesPage.createModule(COURSE_NAME, COURSE_NAME);
			canvasCoursesPage.launchSherpath();
			
			//TODO: Below line is not needed
			//canvasCoursesPage.navigateToSherpath();
			System.out.println();
		} catch (MPException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}
	
	@AfterTest
	public void afterTest() {
	}

}
