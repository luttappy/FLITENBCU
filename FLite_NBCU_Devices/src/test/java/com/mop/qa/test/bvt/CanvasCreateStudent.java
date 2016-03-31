	package com.mop.qa.test.bvt;
	import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
	import org.testng.annotations.Test;
	import com.mop.qa.pageobject.CanvasDashboardPage;
	import com.mop.qa.pageobject.CanvasCoursesPage;
	import com.mop.qa.pageobject.LoginPage;
	import com.mop.qa.pageobject.CanvasRegisterUserPage;


public class CanvasCreateStudent extends TestBase {

	    @Test
		public void testSherpath() throws Exception  {
		try {		
			

			LoginPage loginPage = new LoginPage();
			CanvasDashboardPage canvasDashboardPage =  new CanvasDashboardPage() ;
			CanvasCoursesPage canvasCoursesPage = new CanvasCoursesPage();
			CanvasRegisterUserPage canvasRegisterUserPage = new CanvasRegisterUserPage();

					
			String url=rds.getValue("DATA", this.getClass().getSimpleName(), "url");
			String instUserName = rds.getValue("DATA",this.getClass().getSimpleName(), "UserName");
			String pword = rds.getValue("DATA",this.getClass().getSimpleName(), "Password");
			String userRegistrationURL = rds.getValue("DATA",this.getClass().getSimpleName(), "userRegistrationURL");
			//String studUserName = reusableComponents.getFormattedDate("yyyyMMdd_HHmmss")+"@sharklasers.com"; //timestamp for userID creation
			String studjoincode = rds.getValue("Data",  this.getClass().getSimpleName(), "JoinCode");
//			int numberofStudents = 7;//
			String studentCount = rds.getValue("Data", this.getClass().getSimpleName(), "NumberofStudents"); 
			int numberofStudents = 2;//Integer.parseInt(studentCount);
			//Store student login names
			List<String> studUserName = new ArrayList<String>();
			//Create File  
			String TestFile = "C:\\RETS\\AutomationOutput\\canvasstudentid.txt"; 
			File FC = new File(TestFile);
			FC.createNewFile(); 
			FileWriter FW = new FileWriter(TestFile); 
			BufferedWriter BW = new BufferedWriter(FW); 

		
//			
//			Create new student user
			for(int i=0;i<numberofStudents;i++) {
				canvasRegisterUserPage.launchCanvasUserRegister(userRegistrationURL);
				studUserName.add(canvasRegisterUserPage.studentRegistration("stud test",i,pword,studjoincode));
				canvasDashboardPage.studentCanvasLogout();
			}
//			
			System.out.println("student user names  are "+studUserName);
			
			for(String userName : studUserName) {
				BW.write(userName); 
				BW.write(",");
			}
			BW.close(); 

			
			
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	    }
}
