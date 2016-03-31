package com.mop.qa.test.bvt;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.HomeView;
import org.junit.Assert;

import com.mop.qa.pageobject.LessonOverview;
import com.mop.qa.pageobject.Quiz;
import com.mop.qa.pageobject.TakeAssesment;


public class Test_LabelQuestions extends TestBase {

	@Test(enabled = false)
	public void testLabelQuestion() throws Exception {
		try {
			TakeAssesment ta = new TakeAssesment();

			String url=rds.getValue("DATA", this.getClass().getSimpleName(), "URL");
			String uName = rds.getValue("DATA", this.getClass().getSimpleName() , "UserName");
			String pword = rds.getValue("DATA", this.getClass().getSimpleName(), "Password"); 
			
			//Login
			ta.enterUrl(url);
			ta.login(url,uName,pword);
		
			//navigate to share path
			ta.navigateToSherPath("SEP-3720 Label Quiz 20160209", "SEP-3720 Labeling Questions");
			
			
			String assignment = "Alterations in Oxygenation and Perfusion";
			assignment = "Overview of Oxygenation and Perfusion";
			HomeView home = new HomeView();
			
			Assert.assertTrue( 
					"Lesson '" + assignment + "' is not Present", 
					home.isAssigmentPresent(assignment) );
			home.goToAssignment(assignment);
			System.out.println("Go to Lesson");
			LessonOverview lesson = new LessonOverview();
			//check if lesson new
			lesson.resetLessonAndProcessToQuiz();
			lesson.continueToQuiz();
			lesson.continueIfReadyForMicroQuiz();
			Quiz quiz = new Quiz();
			quiz.buildYamlAnswers(assignment);
			
			System.out.println("Quiz1 ");
			quiz.completeQuizFromYaml();
			
			lesson.continueToQuiz();
			lesson.continueIfReadyForMicroQuiz();
			
			System.out.println("Complete Quiz");
			quiz.completeQuizFromYaml();
			
			lesson.continueToQuiz();
			Assert.assertTrue("We are not on the Lesson Assessment page", lesson.isReadyForLessonAssessment());
			System.out.println("Start Lesson Assessment");
			lesson.clickYesIveGotThis();
			
			quiz.completeLessonAssessmentFromYaml();
			
			//TODO: add performance review
			/***********************************/
			//Out of scope
			lesson.clickExitLesson();
							
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	@Test
	public void testAssessmentQuestion() throws Exception {
		try {
			TakeAssesment ta = new TakeAssesment();

			String url	 = rds.getValue("DATA", this.getClass().getSimpleName(), "URL");
			String uName = rds.getValue("DATA", this.getClass().getSimpleName(), "UserName");
			String pword = rds.getValue("DATA", this.getClass().getSimpleName(), "Password"); 
			
			//Login
			//ta.enterUrl(url);
			ta.login(url,uName,pword);
		
			//navigate to share path
			ta.navigateToSherPath("SEP-3720 Label Quiz 20160209", "SEP-3720 Labeling Questions");
			
			
			String assignment = "Alterations in Oxygenation and Perfusion";
			assignment = "Overview of Oxygenation and Perfusion";
			HomeView home = new HomeView();
			
			//Verify that the assignment is present on the page
			Assert.assertTrue( 
					"Lesson '" + assignment + "' is not Present", 
					home.isAssigmentPresent(assignment) );
			home.goToAssignment(assignment);
			System.out.println("Go to Lesson");
			LessonOverview lesson = new LessonOverview();
			
			//check if lesson new
			lesson.resetLessonAndProcessToQuiz();
			
			Quiz quiz = new Quiz();
			quiz.buildYamlAnswers(assignment);
			
			//****************************
			do{
				lesson.continueToQuiz();
				lesson.continueIfReadyForMicroQuiz();
				
				System.out.println("Quiz1 ");
				quiz.completeQuizFromYaml();
				
				lesson.continueToQuiz();
				
			}while( !lesson.isReadyForLessonAssessment() );
							
			Assert.assertTrue("We are not on the Lesson Assessment page", lesson.isReadyForLessonAssessment());
			System.out.println("Start Lesson Assessment");
			lesson.clickYesIveGotThis();
			
			quiz.completeLessonAssessmentFromYaml();
			
			//TODO: add performance review
			/***********************************/
			//Out of scope
			//Thread.sleep(3000);
			//lesson.clickExitLesson();
			
			//ta.logout();
			
							
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

	

