package com.mop.qa.test.bvt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.mop.qa.pageobject.CanvasDashboardPage;
import com.mop.qa.pageobject.CanvasCoursesPage;
import com.mop.qa.pageobject.LoginPage;
import com.mop.qa.pageobject.SherpathStudentHomePage;
import com.mop.qa.pageobject.SherpathSchedulePage;
import com.mop.qa.pageobject.SherpathSyllabusPage;
import com.mop.qa.pageobject.TakeAssesment;
import com.mop.qa.testbase.ReusableComponents;
import com.mop.qa.pageobject.CanvasRegisterUserPage;


 

public class StageTest extends TestBase{
	
	 @Test
		public void testSherpath() throws Exception  {
		try {		
			

			LoginPage loginPage = new LoginPage();
			CanvasDashboardPage canvasDashboardPage =  new CanvasDashboardPage() ;
			CanvasCoursesPage canvasCoursesPage = new CanvasCoursesPage();
			SherpathSchedulePage sherpathSchedulePage = new SherpathSchedulePage();
			SherpathSyllabusPage sherpathSyllabusPage = new SherpathSyllabusPage();
			CanvasRegisterUserPage canvasRegisterUserPage = new CanvasRegisterUserPage();
			SherpathStudentHomePage sherpathHomePage = new SherpathStudentHomePage();
			ReusableComponents reusableComponents = new ReusableComponents();
			TakeAssesment takeAssesment = new TakeAssesment();
		
//			String url=rds.getValue("DATA", this.getClass().getSimpleName(), "url");
			String url="http://qa.portal.eols.io/#/login/307?courseId=378&token=eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyMDE2MDIxMl8xMDE0MDFAc2hhcmtsYXNlcnMuY29tIiwidXNlciI6eyJ1c2VySWQiOjMwNywiZXh0ZXJuYWxJZCI6IjA3YWRiM2U2MDYzN2ZmMDJkOWVhMTFjN2M3NGYxY2E5MjE2OTliZDcuY2FudmFzLmluc3RydWN0dXJlLmNvbS0wMzMwYmE4MzRhMGMxMGVjY2E3ODFjNDc5ZDQ5OWQ5ZTBiZDQ5Y2IyIiwidXNlcm5hbWUiOiIyMDE2MDIxMl8xMDE0MDFAc2hhcmtsYXNlcnMuY29tIiwiZmlyc3ROYW1lIjoic3R1ZCIsImxhc3ROYW1lIjoidGVzdDEiLCJyb2xlIjoiU3R1IiwiZXhwaXJlRGF0ZSI6MTQ1NTM5NzgzMDg2M30sImlzcyI6ImVvbHMiLCJqdGkiOiI4N2FiYTA1YS0yYWE5LTQyMWEtODIyNi02YmE1YjZkZjNhYjAiLCJpYXQiOjE0NTUzOTY2MzAsIm5iZiI6MTQ1NTM5NjYzMCwiZXhwIjoxNDU1Mzk3ODMwfQ.Dt8W1s1EcXPIDzgdzt1AdBIjQaHN2Tw6X92qYYHPEUzI6bW3EZwsTmt_2t6oRWZBpqq-g7vFaOD9-SwSMrT3cQ";
//			String instUserName = rds.getValue("DATA",this.getClass().getSimpleName(), "UserName");
//			String pword = rds.getValue("DATA",this.getClass().getSimpleName(), "Password");
//			String userRegistrationURL = rds.getValue("DATA",this.getClass().getSimpleName(), "userRegistrationURL");
//			//String studUserName = reusableComponents.getFormattedDate("yyyyMMdd_HHmmss")+"@sharklasers.com"; //timestamp for userID creation
//			String studjoincode = rds.getValue("Data",  this.getClass().getSimpleName(), "JoinCode");
//			String parentWindow;
//			List<String> studUserName = new ArrayList<String>();
//			String studType = "good";
			

		
			
//			//Create new student user
//			for(int i=0;i<numberofStudents;i++) {
//				canvasRegisterUserPage.launchCanvasUserRegister(userRegistrationURL);
//				studUserName.add(canvasRegisterUserPage.studentRegistration("stud test1",pword,studjoincode));
//				canvasDashboardPage.studentCanvasLogout();
//			}
//			
//			System.out.println("student user names  are "+studUserName);
//			
//							
//					
//			//Login as instructor to create course
			System.out.println("starting test");
//			loginPage.login(url, instUserName, pword);
////			//String moduleUrl = "https://canvas.instructure.com/courses/1005192/modules/items/8936515"
//			parentWindow = loginPage.login(url,instUserName,pword);
////			String courseName = canvasDashboardPage.startNewCourse();
////			
//			for(String studentList : studUserName) {
//				
//				System.out.println("student user names  are "+studentList);				
//				canvasCoursesPage.addStudent(studentList); //add student to the course
//			}
//			
//			
//			canvasCoursesPage.createAppModule(); //create app and module in canvas
			canvasCoursesPage.launchSherpath();//launch Sherpath
//			System.out.println("sherpath lanched");
//			Thread.sleep(3000);
//			sherpathSchedulePage.setCourseSchedule();
			Thread.sleep(3000);
			System.out.println("page launched");
			sherpathHomePage.clickSyllabusMenu();
			System.out.println("Syllabus page loaded");
			
			Thread.sleep(2000);
			sherpathSyllabusPage.assignLesson("Nursing Diagnosis","Overview of Nursing Diagnosis" );
			
//			sherpathSyllabusPage.assignBeliefsLessonforTomorrow();
//			sherpathSyllabusPage.logout(); //sherpath Logout
//			canvasDashboardPage.logoutCanvas(parentWindow); //canvas logout
//			
//			
//			//Login as student to complete the course
//			for(String studentList : studUserName) {
//				loginPage.login(url,studentList, pword);
//				System.out.println("student logged in");
//				canvasDashboardPage.studAcceptCourse();
//				canvasDashboardPage.navigateToAllCoursesPage();
//				System.out.println("navigated to all courses page");
////				canvasCoursesPage.navigateToCoursePage(courseName);
//				System.out.println("navigated to selected course page");
//				canvasCoursesPage.navigateToSherpath();
//				sherpathHomePage.studentOpenLesson("Overview of Nursing Diagnosis");
//				
//				
//				takeAssesment.takeQuiz();
//				takeAssesment.lesson(studType);
//				takeAssesment.checkResult();
//				
//				sherpathSyllabusPage.logout(); //sherpath Logout
////				canvasDashboardPage.logoutCanvas(parentWindow); //canvas logout
//				studType = "bad";
//			}
			
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
			
		
		}

}
