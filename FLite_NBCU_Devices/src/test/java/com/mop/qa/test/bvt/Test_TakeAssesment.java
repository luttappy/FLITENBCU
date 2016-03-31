package com.mop.qa.test.bvt;

import org.testng.annotations.Test;

import com.mop.qa.pageobject.TakeAssesment;


	public class Test_TakeAssesment extends TestBase {

		@Test
		public void testNBC() throws Exception {
			try {
				TakeAssesment ta = new TakeAssesment();

				String url=rds.getValue("DATA", this.getClass().getSimpleName(), "URL");
				String uName = rds.getValue("DATA", this.getClass().getSimpleName() , "UserName");
				String pword = rds.getValue("DATA", this.getClass().getSimpleName(), "Password"); 
				
				//Login
				ta.enterUrl("http://dev.portal.new.eols.io/#/login/894?courseId=312&token=eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkZWM3X3N0dWQxQHNoYXJrbGFzZXJzLmNvbSIsInVzZXIiOnsidXNlcklkIjo4OTQsImV4dGVybmFsSWQiOiIwN2FkYjNlNjA2MzdmZjAyZDllYTExYzdjNzRmMWNhOTIxNjk5YmQ3LmNhbnZhcy5pbnN0cnVjdHVyZS5jb20tOGU4YmNiN2M1NjkxOGI0NmNhNTAzMTMyZTI0NmFmZjYzYTc5YzEyMCIsInVzZXJuYW1lIjoiZGVjN19zdHVkMUBzaGFya2xhc2Vycy5jb20iLCJmaXJzdE5hbWUiOiJzdHVkMSIsImxhc3ROYW1lIjoiZGVjIiwicm9sZSI6IklucyIsImV4cGlyZURhdGUiOjE0NTQ2MTM3OTAzNzJ9LCJpc3MiOiJlb2xzIiwianRpIjoiMDIzZjQ0MTgtNzAwMi00ZDNiLTgxNTMtZDU0NGZiZmM2NjkwIiwiaWF0IjoxNDU0NjEyNTkwLCJuYmYiOjE0NTQ2MTI1OTAsImV4cCI6MTQ1NDYxMzc5MH0.tiB1f1wbNLhVkaznAyaciMl7jkKf6wVjAFTfRs9wJsfVTNXFlBZbUPMc1RoYMq6Bs0EjUvdRkDZohoyQRCxjmw");
				//ta.login(url,uName,pword);
			
				//navigate to share path
				//ta.navigateSherPath();
				for(int i=1; i<25; i++) {
					
					//Select Course in sher path
					ta.selectCourse();
			       
					//take quiz
					ta.takeQuiz();
					
					ta.lesson();
					ta.checkResult();
					
				}
				
			
				//logout
				ta.logout();
				
								
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		
	}
}

	

