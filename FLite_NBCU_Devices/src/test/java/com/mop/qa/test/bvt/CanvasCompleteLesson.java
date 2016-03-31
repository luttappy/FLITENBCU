package com.mop.qa.test.bvt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.testng.annotations.Test;
import com.mop.qa.pageobject.CanvasDashboardPage;
import com.mop.qa.pageobject.CanvasCoursesPage;
import com.mop.qa.pageobject.LoginPage;
import com.mop.qa.pageobject.SherpathSchedulePage;
import com.mop.qa.pageobject.SherpathSyllabusPage;
import com.mop.qa.pageobject.CanvasRegisterUserPage;
import com.mop.qa.pageobject.EvolveLessonPage;


 
public class CanvasCompleteLesson extends TestBase{
	
    @Test
	public void testSherpath() throws Exception  {
	try {		
		

		LoginPage loginPage = new LoginPage();
		CanvasDashboardPage canvasDashboardPage =  new CanvasDashboardPage() ;
		CanvasCoursesPage canvasCoursesPage = new CanvasCoursesPage();
		SherpathSchedulePage sherpathSchedulePage = new SherpathSchedulePage();
		SherpathSyllabusPage sherpathSyllabusPage = new SherpathSyllabusPage();
		CanvasRegisterUserPage canvasRegisterUserPage = new CanvasRegisterUserPage();
		EvolveLessonPage evolveLessonPage = new EvolveLessonPage();
	
		String url=rds.getValue("DATA", this.getClass().getSimpleName(), "url");
		String instUserName = rds.getValue("DATA",this.getClass().getSimpleName(), "UserName");
		String pword = rds.getValue("DATA",this.getClass().getSimpleName(), "Password");
		String userRegistrationURL = rds.getValue("DATA",this.getClass().getSimpleName(), "userRegistrationURL");
		String studjoincode = rds.getValue("Data",  this.getClass().getSimpleName(), "JoinCode");
		int numberofStudents =2;//Integer.parseInt(rds.getValue("Data",  this.getClass().getSimpleName(), "NumberofStudents"));
		String studType = rds.getValue("Data",  this.getClass().getSimpleName(), "StudentType");
		String courseName = rds.getValue("Data", this.getClass().getSimpleName(), "CourseName");
		String newStudFlag = rds.getValue("Data", this.getClass().getSimpleName(), "NewStudentFlag");
		String lessonFlag = rds.getValue("Data", this.getClass().getSimpleName(), "LessonCompletionFlag");
		String parentWindow;
		
		//list of Lessons that need to be completed
		String lessons = rds.getValue("DATA", this.getClass().getSimpleName(), "LessonName");
		List<String> lessonList = new ArrayList<String>();
		String[] lessonArr = lessons.split(",");
		lessonList = Arrays.asList(lessonArr);
		
		//get existing stud user names from data sheet
		String existingStudNames = rds.getValue("DATA", this.getClass().getSimpleName(),"StudentLogin");
		List<String> studUserName = new ArrayList<String>();
		String[] existingStudNameArr = existingStudNames.split(",");
		studUserName = Arrays.asList(existingStudNameArr);

		

	
		//Create student users
		if("Y".equalsIgnoreCase(newStudFlag)) {
			studUserName = new ArrayList<String>();
			for(int i=0;i<numberofStudents;i++) {
				canvasRegisterUserPage.launchCanvasUserRegister(userRegistrationURL);
				studUserName.add(canvasRegisterUserPage.studentRegistration("stud test",i,pword,studjoincode));
				canvasDashboardPage.studentCanvasLogout();
				loginPage.clickLogin();
			}
		//login as inst to add students to course
		parentWindow = loginPage.login(url,instUserName,pword);
		canvasDashboardPage.navigateToAllCoursesPage();
		canvasCoursesPage.navigateToCoursePage(courseName);
//		String courseName = canvasDashboardPage.startNewCourse();
		canvasCoursesPage.navigateToAddPeople();
		canvasCoursesPage.addStudent(studUserName); 
		
		//create new course
//		canvasCoursesPage.createAppModule(); //create app and module in canvas
//		canvasCoursesPage.launchSherpath();//launch Sherpath
//		System.out.println("sherpath lanched");
//		Thread.sleep(3000);
//		sherpathSchedulePage.setCourseSchedule();
//		sherpathHomePage.clickSyllabusMenu();
//		System.out.println("Syllabus page loaded");
//		
		canvasDashboardPage.studentCanvasLogout(); //canvas logout
	}
		System.out.println("student user names  are "+studUserName);
		//Login as student to complete the course
		for(String studentList : studUserName) {
			parentWindow = loginPage.login(url,studentList, pword);
			if("Y".equalsIgnoreCase(newStudFlag)) {
				canvasDashboardPage.studAcceptCourse();
			} else {
				canvasDashboardPage.navigateToAllCoursesPage();
				canvasCoursesPage.navigateToCoursePage(courseName);
			}
			canvasCoursesPage.navigateToSherpath();
			for(String lessonName : lessonList) {
				if("Y".equalsIgnoreCase(lessonFlag)) {
					evolveLessonPage.completeLesson(lessonName);
					
				} else {
					evolveLessonPage.navigateLessonAssessment(lessonName);
				}
				evolveLessonPage.selectLessonAssessment(lessonName, studType);
				
			}
			sherpathSyllabusPage.logout(); //sherpath Logout
			canvasDashboardPage.logoutCanvas(parentWindow); //canvas logout
		}
			


	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
	
		
	
	}

