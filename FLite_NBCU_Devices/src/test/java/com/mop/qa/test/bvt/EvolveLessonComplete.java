package com.mop.qa.test.bvt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.testng.annotations.Test;
import com.mop.qa.pageobject.SherpathSyllabusPage;

import com.mop.qa.pageobject.EvolveHomePage;
import com.mop.qa.pageobject.EvolveLessonPage;
import com.mop.qa.pageobject.EvolveMyEvolvePage;

public class  EvolveLessonComplete extends TestBase {
	
	@Test
	public void testSherpath() throws Exception  {
	try {		
		

		EvolveHomePage evolveHomePage =  new EvolveHomePage();
		EvolveMyEvolvePage evolvemyEvolvePage = new EvolveMyEvolvePage();
		SherpathSyllabusPage sherpathSyllabusPage = new SherpathSyllabusPage();
		EvolveLessonPage evolveLessonPage = new EvolveLessonPage();
	
		String url = rds.getValue("EvolveDemo",this.getClass().getSimpleName(), "url");
		String userName = rds.getValue("EvolveDemo",this.getClass().getSimpleName(), "UserName");
		//list of courses
		String courseName = rds.getValue("EvolveDemo", this.getClass().getSimpleName(), "CourseID");
		List<String> courselist = new ArrayList<String>();
		String[] courseNameArr = courseName.split(",");
		courselist = Arrays.asList(courseNameArr);
		//list of Lessons
		String lesson = rds.getValue("EvolveDemo", this.getClass().getSimpleName(), "LessonName");
		List<String> lessonList = new ArrayList<String>();
		String[] lessonArr = lesson.split(",");
		lessonList = Arrays.asList(lessonArr);
		
		//list for student type - Best to Bad students
		String studType = rds.getValue("EvolveDemo", this.getClass().getSimpleName(), "StudentType");
		List<String> studTypeList = new ArrayList<String>();
		String[] studTypeArr = studType.split(",");
		studTypeList = Arrays.asList(studTypeArr);
		
		//list of student login
		String studentList = rds.getValue("EvolveDemo", this.getClass().getSimpleName(), "UserName");
		List<String> student = new ArrayList<String>();
		String[] studentArr = studentList.split(",");
		student = Arrays.asList(studentArr);
		System.out.println(student);
		String password = rds.getValue("EvolveDemo", this.getClass().getSimpleName(), "Password");
		String lessonFlag = rds.getValue("EvolveDemo", this.getClass().getSimpleName(), "LessonCompletionFlag");
		System.out.println(lessonFlag);
//		String assessmentFlag = rds.getValue("EvolveDemo", this.getClass().getSimpleName(), "LessonAssessmentFlag");
		
		String contentName=rds.getValue("EvolveDemo", this.getClass().getSimpleName(), "ContentName");
		String parentWindow;

		
		for(String courseID : courselist){
			for(String studId : student) {
				parentWindow = evolveHomePage.launchurl(url);
				evolveHomePage.login(studId,password);
				evolvemyEvolvePage.launchSherpath(courseID,contentName);
				for(String lessonName : lessonList) {
					if("Y".equalsIgnoreCase(lessonFlag)) {
						evolveLessonPage.completeLesson(lessonName);
						
					} else {
						evolveLessonPage.navigateLessonAssessment(lessonName);
					}
					evolveLessonPage.selectLessonAssessment(lessonName, studType);
					evolveLessonPage.selectSklillAssessment(lessonName, studType);
				}
				sherpathSyllabusPage.logout();
				evolvemyEvolvePage.evolvelogout(parentWindow);
								
//			}
									
			}
		}
	
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	
		
	
	}

}
