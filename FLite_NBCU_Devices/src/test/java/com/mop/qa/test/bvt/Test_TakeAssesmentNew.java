package com.mop.qa.test.bvt;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.CanvasCoursesPage;
import com.mop.qa.pageobject.CanvasDashboardPage;
//import com.mop.qa.pageobject.SherpathLaunchPage;
import com.mop.qa.pageobject.SherpathSchedulePage;
import com.mop.qa.pageobject.TakeAssesment;


	public class Test_TakeAssesmentNew extends TestBase {

		@Test
		public void testNBC() throws Exception {
			try {
				TakeAssesment ta = new TakeAssesment();
				CanvasDashboardPage cDP =  new CanvasDashboardPage() ;
				CanvasCoursesPage crsPg = new CanvasCoursesPage();
				SherpathSchedulePage sherPg = new SherpathSchedulePage();

				String url=rds.getValue("DATA", this.getClass().getSimpleName(), "URL");
				String uName = rds.getValue("DATA", this.getClass().getSimpleName() , "UserName");
				String pword = rds.getValue("DATA", this.getClass().getSimpleName(), "Password"); 
				
				//Login
				ta.enterUrl(url);
				ta.login(url,uName,pword);
				cDP.startNewCourse();
				crsPg.createAppModule();
				sherPg.setCourseSchedule();		
				ta.clickNursingDiagnosis();
				//take quiz
				ta.takeQuiz();
				ta.lesson();
				ta.checkResult();
				//logout
				ta.logout();
				
								
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		
	}
}

	

