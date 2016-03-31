package com.mop.qa.test.bvt;

import java.util.ArrayList;
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


public class SherpathStudentCompleteLesson extends TestBase {

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
		
		
		
		sherpathHomePage.studentOpenLesson("Overview of Nursing Diagnosis");
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	
		
	
	}

}