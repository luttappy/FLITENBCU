package com.mop.qa.test.bvt;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Iterator;
import java.util.List;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import com.mop.qa.pageobject.SherpathSyllabusPage;

import com.mop.qa.pageobject.EvolveRegisterStudent;
import com.mop.qa.pageobject.EvolveLessonPage;
import com.mop.qa.pageobject.EvolveMyEvolvePage;
	

public class EvolveCreateUser extends TestBase {
	
	 @Test
		public void testSherpath() throws Exception  {
		try {		
			

			EvolveRegisterStudent evolveRegisterStudent =  new EvolveRegisterStudent() ;
			SherpathSyllabusPage sherpathSyllabusPage = new SherpathSyllabusPage();
			EvolveLessonPage evolveLessonCompletion = new EvolveLessonPage();
			EvolveMyEvolvePage evolveMyEvolvePage = new EvolveMyEvolvePage();
		
			String url = "";
			String userRegistrationURL = rds.getValue("EvolveDemo",this.getClass().getSimpleName(), "userRegistrationURL");
			//Course ID where students need to be added to
			String courseName = rds.getValue("EvolveDemo", this.getClass().getSimpleName(), "CourseID");
			List<String> courseIdList = new ArrayList<String>();
			String[] courseNameArr = courseName.split(",");
			courseIdList = Arrays.asList(courseNameArr);
			//list for student type - Best to Bad students
			String studType = rds.getValue("EvolveDemo", this.getClass().getSimpleName(), "StudentType");
			List<String> studTypeList = new ArrayList<String>();
			String[] studTypeArr = studType.split(",");
			studTypeList = Arrays.asList(studTypeArr);
			//list of Lessons that need to be completed
			String lessons = rds.getValue("EvolveDemo", this.getClass().getSimpleName(), "LessonName");
			List<String> lessonList = new ArrayList<String>();
			String[] lessonArr = lessons.split(",");
			lessonList = Arrays.asList(lessonArr);
			//Evolve content name
			String topicList = rds.getValue("EvolveDemo", this.getClass().getSimpleName(), "TopicName");
			List<String> topic = new ArrayList<String>();
			String[] topicArr = topicList.split(",");
			topic = Arrays.asList(topicArr);
			String contentName=rds.getValue("EvolveDemo", this.getClass().getSimpleName(), "ContentName");
			String confusedContent = rds.getValue("EvolveDemo",this.getClass().getSimpleName(), "ConfusedContent");
			
			String parentWindow;
			int i =65;
			//Create a file
			String TestFile = "C:\\RETS\\AutomationOutput\\evolverStudentList.txt"; 
			File FC = new File(TestFile);
			FC.createNewFile();
			FileWriter FW = new FileWriter(TestFile,true); 
			BufferedWriter BW = new BufferedWriter(FW); 
			PrintWriter out = new PrintWriter(BW);
			String studentName;
			
			
			
			for(String courseID : courseIdList){
				System.out.println("Currently in Lesson "+courseID);
				out.println(courseID);
				for(String studTypeID : studTypeList) {
					out.println(studTypeID);
					parentWindow = evolveRegisterStudent.launchurl(userRegistrationURL);
					//register student
					System.out.println("Student type is "+studTypeID);
					studentName=evolveRegisterStudent.evolveUserRegister(courseID,String.valueOf((char)i));
					out.println(studentName);
					out.close(); 
					i=i+1;
					//navigate to sherpath
					evolveMyEvolvePage.launchSherpath(courseID,contentName);
					for(String lessonName : lessonList) {
						evolveLessonCompletion.verifyImageDisplayed();
						evolveLessonCompletion.verifyConfusedContent(confusedContent);
						String dueDate2 = rds.getValue("EvolveDemo",this.getClass().getSimpleName(), "DueDate");
						evolveLessonCompletion.verifyDueDate(dueDate2);
						for(String topicName : topic){
                   		evolveLessonCompletion.verifyInnerLessonNav(topicName);
						evolveLessonCompletion.completeLesson(lessonName);
						evolveLessonCompletion.selectLessonAssessment(lessonName, studTypeID);
											
										
						evolveLessonCompletion.navigateLessonAssessment(lessonName);
//						evolveLessonCompletion.completeLessonOne(lessonName);
						evolveLessonCompletion.selectLessonAssessment(lessonName, studTypeID);
						evolveLessonCompletion.selectSklillAssessment(lessonName, studTypeID);
				    }
					}
					sherpathSyllabusPage.logout();
					evolveMyEvolvePage.evolvelogout(parentWindow);
		
					
										
				}
				
			}
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
			
		
		}

}