
package com.mop.qa.pageobject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.testbase.PageBase_Appium;


public class EvolveLessonCompletion extends PageBase_Appium {
	
	
	@FindBy(xpath = ("//*[@id='slide-panel']/navigation-list/div[1]/div[1]/a"))
	protected WebElement home;
	
	@FindBy(xpath = ("//span[@class='ng-binding'][contains(text(),'Overview of Pain')]"))
	protected WebElement overviewofPainTile;
	

	@FindBy(xpath = "/html/body/ui-view/snap-content/div/div[4]/div/div/ul/li[3]/week-drag-panel/div[2]/ul/li[4]/module-drag-panel/div[1]/div[1]/span")
	protected WebElement painManagementModule;
	
	@FindBy(xpath = ("//input[@value='Just a guess']"))
	protected WebElement justAGuessBtn;
	
	@FindBy(xpath = ("//input[@value='Pretty sure']"))
	protected WebElement prettySureBtn;
	
	@FindBy(xpath = ("//input[@value='No doubt!']"))
	protected WebElement noDoubtBtn;
	
    @FindBy(xpath = "//label[@for='answerChoice0']")
    protected WebElement firstOption;
    
	@FindBy(xpath = "//label[@for='answerChoice1']")
   protected WebElement secondOption;
    
    @FindBy(xpath = "//label[@for='answerChoice2']")
	protected WebElement thirdOption;

	@FindBy(xpath = "//label[@for='answerChoice3']")
	protected WebElement fourthOption;
	 
	@FindBy(xpath = "//label[@for='answerChoice4']")
	protected WebElement fifthOption;
	
	@FindBy(xpath = "//label[@for='answerChoice[0]']")
	protected WebElement firstanswer;
	
	@FindBy(xpath = "//label[@for='answerChoice[1]']")
	protected WebElement secondanswer;
	
	@FindBy(xpath = "//label[@for='answerChoice[2]']")
	protected WebElement thirdanswer;

	@FindBy(xpath = "//label[@for='answerChoice[3]']")
	protected WebElement fourthanswer;
	
	@FindBy(xpath = "//label[@for='answerChoice[4]']")
	protected WebElement fifthanswer;
 
	
	
	@FindBy(xpath = ("//button[@class='button button--tertiary button--outlined'][contains(text(),'Reset')]"))
	protected WebElement resetBtn;
	
	@FindBy(xpath = ("//button[@class='button button--primary button--x-large']"))
	protected WebElement resetBtn2;
	
	@FindBy(id = "readyButton" )
	protected WebElement ready;
	
	@FindBy(id = "areYouReadyQuestion" )
	protected WebElement areYouReady;
	
	@FindBy(id = "correctTab" )
	protected WebElement correctTab;
	
	@FindBy(id = "incorrectTab" )
	protected WebElement incorrectTab;
	
//	protected String ready = "readyButton";



	protected String submit = "submit-quiz-answer";

	protected String submitMiniQuiz = "submit-quiz-answer";
	
	protected String tryAgainBtn = "question-return";

	@FindBy(id = "next")
	protected WebElement next;
	
	@FindBy(id = "button-confused")
	protected WebElement confusedBtn;
	
	@FindBy(xpath = ("//article[@id='question-container']//h2"))
	protected WebElement questionTxt;
	
	@FindBy(xpath = ("//li[@class='resource-row clearfix']//div[2]//span[2]//a[@tooltip='Types of Pain']"))
	protected WebElement lesson2;
	
	@FindBy(xpath = ("//li[@class='resource-row clearfix']//div[2]//span[2]//a[@tooltip='Assessment Related to Pain']"))
	protected WebElement lesson3;
	
	@FindBy(xpath = ("//li[@class='resource-row clearfix']//div[2]//span[2]//a[@tooltip='Nursing Diagnosis and Planning Related to Pain Management']"))
	protected WebElement lesson4;
	
	@FindBy(xpath = ("//li[@class='resource-row clearfix']//div[2]//span[2]//a[@tooltip='Implementation and Evaluation of Interventions Related to Pain Management']"))
	protected WebElement lesson5;
	
	@FindBy(xpath = ("//li[@class='resource-row clearfix']//div[2]//span[3]//a[@tooltip='Assessing Pain]"))
	protected WebElement skill;
	
	@FindBy(xpath = ("//li[@class='resource-row clearfix']//div[2]//span[4]//a[@tooltip='Pain Management']"))
	protected WebElement simulation;
	
	@FindBy(id = "kpViewButton" )
	protected WebElement displayKeyPoints;
	
	@FindBy(id = "h1-0010" )
	protected WebElement lessonPageHeading;
	
	@FindBy(xpath = ("//li[@class='assessment-label]/div"))
	protected WebElement lessonAssesLink;
	
	//drag and drop
	
	//Drag fields
	@FindBy(xpath = ("//div[@id='drag1']//span[2]"))
	protected WebElement drag1;
	
	@FindBy(id = "drag2")
	protected WebElement drag2;
	
	@FindBy(id = "drag3")
	protected WebElement drag3;
	
	@FindBy(xpath = ("//div[@id='drag4']//span[2]"))
	protected WebElement drag4;
	
	@FindBy(xpath = ("//div[@id='drag5']//span[2]"))
	protected WebElement drag5;
	
	
	//Drop target fields
	
	@FindBy(xpath = ("//div[@class='text-text-matching']//div[1]//div[@ng-model='selectedTargetResponseChoices' and contains(@jqyoui-droppable, 'index: 0')]"))
	protected WebElement target1;
	
	@FindBy(xpath = ("//div[@class='text-text-matching']//div[2]//div[@ng-model='selectedTargetResponseChoices']"))
	protected WebElement target2;
	
	@FindBy(xpath = ("//div[@class='text-text-matching']//div[3]//div[@ng-model='selectedTargetResponseChoices']"))
	protected WebElement target3;
	
	@FindBy(xpath = ("//div[@class='text-text-matching']//div[4]//div[@ng-model='selectedTargetResponseChoices']"))
	protected WebElement target4;
	
	@FindBy(xpath = ("//div[@class='text-text-matching']//div[5]//div[@ng-model='selectedTargetResponseChoices']"))
	protected WebElement target5;
	
	//Validations
	
	@FindBy(xpath = ("//div[@class='due-date ng-binding ng-scope']"))
	protected WebElement dueDate;
	
	@FindBy(xpath = ("//span[@class='ng-scope']//img[@src='images/icons-svg/check-orange-bg.svg']"))
	protected WebElement topicStatusBullet;
	
	@FindBy(xpath = ("//span[@class='ng-scope']//img[@src='images/icons-svg/in-progress.svg']"))
	protected WebElement topicStatusInProgress;
	
	@FindBy(xpath = ("//span[@class='ng-scope']//img[@src='images/icons-svg/icon-bullet.svg']"))
	protected WebElement topicStatusCompleted;
	
	
	
	
	
		
	
	int submitCounter = 0;
	

	

	public void completeMiniQuiz() throws Exception {
		boolean tryagin = false;
//		System.out.println("Entered miniquiz");
//		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		Date date = new Date();
//		System.out.println("before first first while - mini quiz "+dateFormat.format(date));
		
		while(!isElementPresent(confusedBtn,1)) {
//			System.out.println("inside mini quiz first while loop");
			while(!isElementPresent(next,1)) {
//				System.out.println("inside mini quiz second while loop");
				
			if(isElementPresent(firstOption,1)) {
					click(firstOption, "Click on firstoption");
//					System.out.println("first answer clicked");
				} else if(isElementPresent(firstanswer,1)) {
					click(firstanswer, "click on first option");
//					System.out.println("option type first option clicked");
				} else if(isElementPresent(drag1,1)) {	
						//dragAndDrop(drag1, target1);
						dragAndDrop(drag2, target2);
						dragAndDrop(drag3, target3);
						
						dragAndDrop(drag4, target4);
						if(isElementPresent(drag5,1)){
						dragAndDrop(drag5, target5);
//						dragAndDrop(drag3, target1);
						dragAndDrop(drag1, target1);
						}else
						dragAndDrop(drag1, target1);
				}
//					System.out.println("Drag and drop options chosen");
				if(isElementPresent(prettySureBtn,1)) {
					//System.out.println(questionTxt.getText());
					click(prettySureBtn, "Click on pretty sure button");
//					System.out.println("pretty sure answer type selected");
//					Thread.sleep(1000);
					if(isElementPresentById(tryAgainBtn,5)) {
						tryagin = true;
						clickById(tryAgainBtn, "Click on try again");
//						System.out.println("try again clicked");
					}
				} else if(isElementPresentById(submitMiniQuiz,1)) {
					submitCounter++;
//					System.out.println("Submit button - "+questionTxt.getText());
					clickById(submitMiniQuiz,"click submit mini quiz button");
//					System.out.println("submit mini quiz answer clicked");
					Thread.sleep(1000);
					if(isElementPresentById(tryAgainBtn,5)) {
						clickById(tryAgainBtn, "Click on try again");
//						System.out.println("try again clicked");
					}
					if(submitCounter==1) {
//						System.out.println("submit counter value set "+submitCounter);
						Thread.sleep(1000);
						//System.out.println(questionTxt.getText());
						clickById(submitMiniQuiz,"click submit mini quiz button");
						submitCounter = 0;
					}
				}
			}
			click(next,"click on next button");
			Thread.sleep(1000);
			if(isElementPresent(lessonPageHeading,1)) {
				if(lessonPageHeading.getText().equalsIgnoreCase("Summary")) {
					System.out.println("Lesson Summary Page reached");
					click(next,"click on next button");
					break;
				}
			}
		}
	}


	public void completeLessonOne(String lessonName) throws Exception {
//		click(home,"click on home icon");
		Thread.sleep(2000);
		String lessonXpath = "//span[@class='tile__resource-title ng-binding' and normalize-space(.)= '"+lessonName+"']";
//		System.out.println("Lesson element is "+lessonXpath);
		elementIsDisplayed(lessonXpath);
		Thread.sleep(2000);
		click(lessonXpath, lessonName);
		System.out.println("Entered lesson");
		Thread.sleep(2000);
		int confused = 1;
		
		
		while(!isElementPresent(areYouReady, 2)) {
//			System.out.println("inside first loop - lesson navigation");
			do {
//				System.out.println("inside do while");
				if(isElementPresent(next, 2 )){ //changed
					if(isElementPresent(displayKeyPoints, 2)) {
						click(next,"Click next button inside if");
//						System.out.println("break from loop");
						break;
					}
					if(confused % 3 ==0){
						if(isElementPresent(confusedBtn, 2)) {
							click(confusedBtn, "Click on confused button");
						}
					}
						
					click(next,"Click next button outside if");
//					System.out.println("clicked on next button outside if");
					}
							
			} while(!isElementPresent(displayKeyPoints,2));
			
//			System.out.println("completed while loop");
			Thread.sleep(2000);
			
			if(areYouReady.getText().equalsIgnoreCase("Almost finished!")) {
				break;
			}
			click(next,"Click next button outside if");
//			System.out.println("Ready for quiz");

			completeMiniQuiz();
			confused++;
//			System.out.println("miniquiz completed");
			
		}
		System.out.println("in Lesson assessment page");
		Thread.sleep(1000);
		click(next,"Click next button");
		Thread.sleep(1000);
		

	}
	
	public void selectLessonAssessment(String lessonName, String studType) throws Exception {
//		Thread.sleep(3000);
//		String lessonXpath = "//span[@class='ng-binding' and normalize-space(.)= '"+lessonName+"']";
//		System.out.println("Lesson element is new "+lessonXpath);
//		clickElement(By.xpath(lessonXpath));
//		Thread.sleep(10000);
//		System.out.println("now in lesson assessment page");
		
			switch (lessonName) {
			case "Overview of Pain":
				Thread.sleep(1000);
				lessonAssessOverviewOfPain(studType);
				break;
			case "Types of Pain":
				Thread.sleep(2000);
				lessonAssessTypesOfPain(studType);
				break;
			case "Assessment Related to Pain":
				Thread.sleep(2000);
				lessonAssessAssessmentrelToPain(studType);
				break;
			case "Nursing Diagnosis and Planning Related to Pain Management":
				Thread.sleep(2000);
				lessonAssessNursingDiagPlanningRelToPainMgmt(studType);
				break;
			case "Implementation and Evaluation of Interventions Related to Pain Management":
				Thread.sleep(2000);
				lessonAssessImpleNdEvalOfInterRelToPainMgmt(studType);
				break;

			}
			//go to home page
			//enterUrl("https://demo.eols.io/#/studentView/learn");
			click(home,"click on home icon");

		
		
		
	}
	
	public void selectSklillAssessment(String skillName, String studType) throws Exception {
		switch (skillName) {
		case "Assessing Pain":
			Thread.sleep(2000);
			skillAssessingPain(studType);
			break;
		}
	}
	public void lessonAssessOverviewOfPain(String studType) throws Exception {
		
		System.out.println("inside lesson assessment - Overview of Pain");
		//#1
		switch (studType) {
		case "W":
			click(firstOption, "Click on first option");
			break;
		case "X":
			click(thirdOption, "Click on third option");
			break;
		case "Y":
			click(fourthOption, "Click on first option");
			break;
		case "Z":
			click(thirdOption, "Click on third option");
			break;
		default:
			click(secondOption, "Click on secondoption");
				
		}
		//System.out.println(questionTxt.getText());
		clickById(submit, "Click on submit answer");
		
		//#2
		switch (studType) {
		case "W":
			click(secondOption, "Click on first option");
			break;
		case "X":
			click(thirdOption, "Click on third option");
			break;
		case "Y":
			click(fourthOption, "Click on first option");
			break;
		case "Z":
			click(thirdOption, "Click on third option");
			break;
		default:
			click(firstOption, "Click on secondoption");
		}
		//System.out.println(questionTxt.getText());
		clickById(submit, "Click on submit answer");
		
		//#3
		switch (studType) {
		case "X":
			click(firstanswer, "Click on third option");
			break;
		case "Y":
			click(fifthanswer, "Click on first option");
			break;
		case "Z":
			click(firstanswer, "Click on third option");
			break;
		default:
			click(firstanswer, "Click on firstoption");
			click(fifthanswer, "Click on firstoption");
		}
		//System.out.println(questionTxt.getText());
		clickById(submit, "Click on submit answer");
		
		//#4
		switch (studType) {
		case "X":
			click(firstOption, "Click on third option");
			break;
		case "Y":
			click(secondOption, "Click on first option");
			break;
		case "Z":
			click(firstOption, "Click on third option");
			break;
		default:
			click(thirdOption, "Click on firstoption");
		}
		//System.out.println(questionTxt.getText());
		clickById(submit, "Click on submit answer");
		
		//#5
		switch (studType) {
		case "X":
			click(firstOption, "Click on third option");
			break;
		case "Y":
			click(secondOption, "Click on first option");
			break;
		case "Z":
			click(firstOption, "Click on third option");
			break;
		default:
			click(fourthOption, "Click on firstoption");
		}
		//System.out.println(questionTxt.getText());
		clickById(submit, "Click on submit answer");
		//#6
		switch (studType) {
		case "Y":
			click(secondOption, "Click on first option");
			break;
		case "Z":
			click(thirdOption, "Click on third option");
			break;
		default:
			click(firstOption, "Click on firstoption");
			break;
		}
		//System.out.println(questionTxt.getText());
		clickById(submit, "Click on submit answer");
		//#7
		switch (studType) {
		case "Y":
			click(firstOption, "Click on first option");
			break;
		case "Z":
			click(thirdOption, "Click on third option");
			break;
		default:
			click(secondOption, "Click on firstoption");
			break;
		}
		//System.out.println(questionTxt.getText());
		clickById(submit, "Click on submit answer");
		//#8
		switch (studType) {
		case "Y":
			click(secondOption, "Click on first option");
			break;
		case "Z":
			click(thirdOption, "Click on third option");
			break;
		default:
			click(firstOption, "Click on firstoption");
		}
		//System.out.println(questionTxt.getText());
		clickById(submit, "Click on submit answer");
		//#9
		switch (studType) {
		case "Z":
			click(thirdOption, "Click on third option");
			break;
		default:
			click(secondOption, "Click on firstoption");
		}
		//System.out.println(questionTxt.getText());
		clickById(submit, "Click on submit answer");
		
		//#10
		//System.out.println(questionTxt.getText());
		clickById(submit, "Click on submit answer");
		//#11
		switch (studType) {
		case "Z":
			click(thirdOption, "Click on third option");
			break;
		default:
			click(thirdOption, "Click on firstoption");
		}
		//System.out.println(questionTxt.getText());
		clickById(submit, "Click on submit answer");
		//#12
		switch (studType) {
		case "Z":
			click(secondOption, "Click on third option");
			break;
		default:
			click(thirdOption, "Click on firstoption");
		}
		//System.out.println(questionTxt.getText());
		clickById(submit, "Click on submit answer");
		//#13
		switch (studType) {
		case "Z":
			click(thirdOption, "Click on third option");
			break;
		default:
			click(secondOption, "Click on firstoption");
		}
		//System.out.println(questionTxt.getText());
		clickById(submit, "Click on submit answer");
		//#14

		click(secondanswer, "Click on secondoption");
		click(thirdanswer, "Click on secondoption");
		click(fifthanswer,"Click on fifth option");
		//System.out.println(questionTxt.getText());
		clickById(submit, "Click on submit answer");
		//#15
		
		click(secondOption, "Click on firstoption");
		//System.out.println(questionTxt.getText());
		clickById(submit, "Click on submit answer");
		
		System.out.println("Completed Lesson");
		
	}


	public void lessonAssessTypesOfPain(String studType) throws Exception {
		
		System.out.println("inside lesson assessment - Types of Pain");
		//#1
		switch (studType) {
		case "W":
			click(firstOption, "Click on first option");
			break;
		case "X":
			click(thirdOption, "Click on third option");
			break;
		case "Y":
			click(fourthOption, "Click on first option");
			break;
		case "Z":
			click(thirdOption, "Click on third option");
			break;
		default:
			click(secondOption, "Click on secondoption");
				
		}
		//System.out.println(questionTxt.getText());
		clickById(submit, "Click on submit answer");
		
		//#2
		switch (studType) {
		case "W":
			click(secondOption, "Click on first option");
			break;
		case "X":
			click(thirdOption, "Click on third option");
			break;
		case "Y":
			click(fourthOption, "Click on first option");
			break;
		case "Z":
			click(thirdOption, "Click on third option");
			break;
		default:
			click(firstOption, "Click on secondoption");
				
		}
		//System.out.println(questionTxt.getText());
		clickById(submit, "Click on submit answer");
		
		//#3
		switch (studType) {
		case "X":
			click(firstanswer, "Click on third option");
			break;
		case "Y":
			click(fifthanswer, "Click on first option");
			break;
		case "Z":
			click(firstanswer, "Click on third option");
			break;
		default:
			click(firstanswer, "Click on firstoption");
			click(thirdanswer, "Click on firstoption");
			click(fifthanswer, "Click on firstoption");
		}
		//System.out.println(questionTxt.getText());
		clickById(submit, "Click on submit answer");
		
		//#4
		switch (studType) {
		case "X":
			click(thirdOption, "Click on third option");
			break;
		case "Y":
			click(firstOption, "Click on first option");
			break;
		case "Z":
			click(thirdOption, "Click on third option");
			break;
		default:
			click(fourthOption, "Click on secondoption");
				
		}
		//System.out.println(questionTxt.getText());
		clickById(submit, "Click on submit answer");
		
		//#5
		switch (studType) {
		case "X":
			click(thirdOption, "Click on third option");
			break;
		case "Y":
			click(firstOption, "Click on first option");
			break;
		case "Z":
			click(fourthOption, "Click on third option");
			break;
		default:
			click(secondOption, "Click on secondoption");
				
		}
		//System.out.println(questionTxt.getText());
		clickById(submit, "Click on submit answer");
		
		//#6
		switch (studType) {
		case "X":
			click(secondOption, "Click on third option");
			break;
		case "Y":
			click(firstOption, "Click on first option");
			break;
		case "Z":
			click(fourthOption, "Click on third option");
			break;
		default:
			click(thirdOption, "Click on secondoption");
				
		}
		//System.out.println(questionTxt.getText());
		clickById(submit, "Click on submit answer");
		
		//#7
		switch (studType) {
		case "Y":
			click(firstOption, "Click on first option");
			break;
		case "Z":
			click(fourthOption, "Click on third option");
			break;
		default:
			click(secondOption, "Click on secondoption");
				
		}
		//System.out.println(questionTxt.getText());
		clickById(submit, "Click on submit answer");
		
		//#8
		switch (studType) {
		case "Y":
			click(secondOption, "Click on first option");
			break;
		case "Z":
			click(firstOption, "Click on third option");
			break;
		default:
			click(fourthOption, "Click on secondoption");
				
		}
		//System.out.println(questionTxt.getText());
		clickById(submit, "Click on submit answer");
		
		//#9
		switch (studType) {
		case "Y":
			click(secondOption, "Click on first option");
			break;
		case "Z":
			click(thirdOption, "Click on third option");
			break;
		default:
			click(firstOption, "Click on secondoption");
				
		}
		//System.out.println(questionTxt.getText());
		clickById(submit, "Click on submit answer");
		
		//#10
		switch (studType) {
		case "Z":
			click(thirdOption, "Click on third option");
			break;
		default:
			click(fourthOption, "Click on secondoption");
				
		}
		//System.out.println(questionTxt.getText());
		clickById(submit, "Click on submit answer");
		
		//#11
		switch (studType) {
		case "Z":
			click(thirdOption, "Click on third option");
			break;
		default:
			click(secondOption, "Click on secondoption");
				
		}
		//System.out.println(questionTxt.getText());
		clickById(submit, "Click on submit answer");
		
		//#12
		switch (studType) {
		case "Z":
			click(thirdOption, "Click on third option");
			break;
		default:
			click(firstOption, "Click on secondoption");
				
		}
		//System.out.println(questionTxt.getText());
		clickById(submit, "Click on submit answer");
		
		//#13
		switch (studType) {
		case "Z":
			click(thirdOption, "Click on third option");
			break;
		default:
			click(firstOption, "Click on secondoption");
				
		}
		//System.out.println(questionTxt.getText());
		clickById(submit, "Click on submit answer");
		
		//#14
		click(thirdOption, "Click on secondoption");
		//System.out.println(questionTxt.getText());
		clickById(submit, "Click on submit answer");
		
		//#15
		click(secondanswer, "Click on firstoption");
		click(fifthanswer, "Click on firstoption");
		//System.out.println(questionTxt.getText());
		clickById(submit, "Click on submit answer");
	}

	public void lessonAssessAssessmentrelToPain(String studType) throws Exception {
		System.out.println("inside lesson assessment - Assessment related To Pain");
        
	       //#1
	           switch (studType) {
	           case "W":
	                           click(firstOption, "Click on first option");
	                           break;
	           case "X":
	                           click(secondOption, "Click on third option");
	                           break;
	           case "Y":
	                           click(fourthOption, "Click on fourth option");
	                           break;
	           case "Z":
	                           click(fourthOption, "Click on third option");
	                           break;
	           default:
	                                  click(thirdOption, "Click on third option");
	                                  break;
	                                           
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	           //#2
	           switch (studType) {
	           case "W":
	                           click(firstOption, "Click on second option");
	                           break;
	           case "X":
	                           click(thirdOption, "Click on third option");
	                           break;
	           case "Y":
	                           click(fourthOption, "Click on first option");
	                           break;
	           case "Z":
	                           click(thirdOption, "Click on third option");
	                           break;
	           default:
	                                  click(secondOption, "Click on second option");
	                                  break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	           //#3
	           switch (studType) {
	           case "X":
	                           click(firstOption, "Click on third option");
	                           break;
	           case "Y":
	                           click(firstOption, "Click on first option");
	                           break;
	           case "Z":
	                           click(secondOption, "Click on third option");
	                           break;
	           default:
	                                  click(fourthOption, "Click on first option");
	                                  break;
	                          
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	           //#4
	           switch (studType) {
	           case "X":
	                           click(firstOption, "Click on third option");
	                           break;
	           case "Y":
	                           click(secondOption, "Click on first option");
	                           break;
	           case "Z":
	                           click(firstOption, "Click on third option");
	                           break;
	           default:
	                           click(fourthOption, "Click on firstoption");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	           //#5
	           switch (studType) {
	           case "X":
	                           click(firstOption, "Click on third option");
	                           break;
	           case "Y":
	                           click(thirdOption, "Click on first option");
	                           break;
	           case "Z":
	                           click(firstOption, "Click on third option");
	                           break;
	           default: 
	                           click(secondOption, "Click on firstoption");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	       //#6
	           switch (studType) {
	           case "Y":
	                                      click(secondanswer, "Click on firstoption");
	                                   click(thirdanswer, "Click on thirdoption");
	                           break;
	           case "Z":
	                                  click(firstanswer, "Click on firstoption");
	                                 click(thirdanswer, "Click on thirdoption");
	                           break;
	           default:
	                           click(firstanswer, "Click on firstoption");
	                           click(thirdanswer, "Click on thirdoption");
	                           click(fourthanswer, "Click on fourthoption");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	       //#7
	           switch (studType) {
	           case "Y":
	                           click(secondOption, "Click on first option");
	                           break;
	           case "Z":
	                           click(thirdOption, "Click on third option");
	                           break;
	           default:
	                           click(firstOption, "Click on firstoption");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	       //#8 
	           switch (studType) {
	           case "Y":
	                           click(firstOption, "Click on first option");
	                           break;
	           case "Z":
	                           click(thirdOption, "Click on third option");
	                           break;
	           default:
	                           click(secondOption, "Click on firstoption");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	       //#9 
	           switch (studType) {
	           case "Z":
	                           click(secondOption, "Click on third option");
	                           break;
	           default:
	                           click(thirdOption, "Click on firstoption");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	           //#10
	           switch (studType) {
	           case "Z":
	                           click(thirdOption, "Click on third option");
	                           break;
	           default:
	                           click(secondOption, "Click on firstoption");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	         
	           
	       //#11
	           switch (studType) {
	           case "Z":
	                                  click(firstanswer, "Click on firstoption");
	                                 click(thirdanswer, "Click on thirdoption");
	                                 click(fourthanswer, "Click on fourthoption");
	                                  break;
	           default:
	                                   click(firstanswer, "Click on firstoption");
	                                   click(secondanswer, "Click on firstoption");
	                                  click(thirdanswer, "Click on thirdoption");
	                                  click(fifthanswer, "Click on fourthoption");
	                                  break;
	                               }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	       //#12
	           switch (studType) {
	           case "Z":
	                           click(secondOption, "Click on third option");
	                           break;
	           default:
	                           click(fourthOption, "Click on firstoption");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	       //#13
	           switch (studType) {
	           case "Z":
	                           click(thirdOption, "Click on third option");
	                           break;
	           default:
	                           click(fourthOption, "Click on firstoption");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	       
	           //#14
	           click(fourthOption, "Click on firstoption");
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	       
	           //#15
	           click(fourthOption, "Click on firstoption");
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	           System.out.println("Completed Lesson");

		
	}
	public void lessonAssessNursingDiagPlanningRelToPainMgmt(String studType) throws Exception {
			System.out.println("inside asessment Nursing Diagnosis and Planning Related to Pain Management");
        
	       //#1
	           switch (studType) {
	           case "W":
	                           click(firstOption, "Click on first option");
	                           break;
	           case "X":
	                           click(thirdOption, "Click on third option");
	                           break;
	           case "Y":
	                           click(fourthOption, "Click on fourth option");
	                           break;
	           case "Z":
	                           click(fourthOption, "Click on third option");
	                           break;
	           default:
	                                  click(secondOption, "Click on third option");
	                                  break;
	                                           
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	           //#2 
	           switch (studType) {
	           case "W":
	                           click(firstOption, "Click on second option");
	                           break;
	           case "X":
	                           click(thirdOption, "Click on third option");
	                           break;
	           case "Y":
	                           click(secondOption, "Click on first option");
	                           break;
	           case "Z":
	                           click(thirdOption, "Click on third option");
	                           break;
	           default:
	                                  click(fourthOption, "Click on second option");
	                                  break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	           //#3
	           switch (studType) {
	           case "X":
	                           click(firstOption, "Click on third option");
	                           break;
	           case "Y":
	                           click(firstOption, "Click on first option");
	                           break;
	           case "Z":
	                           click(secondOption, "Click on third option");
	                           break;
	           default:
	                                  click(fourthOption, "Click on first option");
	                                  break;
	                          
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	           //#4
	           switch (studType) {
	           case "X":
	                           click(firstOption, "Click on third option");
	                           break;
	           case "Y":
	                           click(secondOption, "Click on first option");
	                           break;
	           case "Z":
	                           click(firstOption, "Click on third option");
	                           break;
	           default:
	                           click(fourthOption, "Click on firstoption");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	           //#5 
	           switch (studType) {
	           case "X":
	                           click(firstOption, "Click on third option");
	                           break;
	           case "Y":
	                           click(thirdOption, "Click on first option");
	                           break;
	           case "Z":
	                           click(firstOption, "Click on third option");
	                           break;
	           default: 
	                           click(fourthOption, "Click on firstoption");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	       //#6 
	           switch (studType) {
	           case "Y":
	                                  click(firstOption, "Click on third option");
	                           break;
	           case "Z":
	                                  click(firstOption, "Click on third option");
	                           break;
	           default:
	                          click(secondOption, "Click on third option");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	       //#7
	           switch (studType) {
	           case "Y":
	                           click(secondOption, "Click on first option");
	                           break;
	           case "Z":
	                           click(firstOption, "Click on third option");
	                           break;
	           default:
	                           click(thirdOption, "Click on firstoption");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	       //#8 
	           switch (studType) {
	           case "Y":
	                                  click(firstanswer, "Click on firstoption");
	                                 click(secondanswer, "Click on firstoption");
	                                 click(thirdanswer, "Click on thirdoption");
	                           break;
	           case "Z":
	                                  click(firstanswer, "Click on firstoption");
	                                 click(secondanswer, "Click on firstoption");
	                                 click(fourthanswer, "Click on thirdoption");
	                           break;
	           default:
	                          click(firstanswer, "Click on firstoption");
	                          click(secondanswer, "Click on firstoption");
	                        click(thirdanswer, "Click on thirdoption");
	                        click(fourthanswer, "Click on fourthoption");
	                        break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	       //#9 
	           switch (studType) {
	           case "Z":
	                           click(secondOption, "Click on third option");
	                           break;
	           default:
	                           click(firstOption, "Click on firstoption");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	           //#10
	           switch (studType) {
	           case "Z":
	                           click(thirdOption, "Click on third option");
	                           break;
	           default:
	                           click(secondOption, "Click on firstoption");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	         
	           
	       //#11 
	           switch (studType) {
	           case "Z":
	                                  click(secondOption, "Click on firstoption");
	                                  break;
	           default:
	                                  click(thirdOption, "Click on third option");
	                                  break;
	                               }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	       //#12
	           switch (studType) {
	           case "Z":
	                           click(firstOption, "Click on third option");
	                           break;
	           default:
	                           click(fourthOption, "Click on firstoption");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	       //#13
	           switch (studType) {
	           case "Z":
	                                  click(firstanswer, "Click on firstoption");
	                                  click(secondanswer, "Click on firstoption");
	                                 click(thirdanswer, "Click on thirdoption");
	                           break;
	           default:
	                                  click(firstanswer, "Click on firstoption");
	                                  click(secondanswer, "Click on firstoption");
	                                 click(thirdanswer, "Click on thirdoption");
	                                 click(fifthanswer, "Click on fourthoption");
	                                 break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	       
	           //#14 
	           click(secondOption, "Click on firstoption");
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	       
	           //#15 
	           click(firstOption, "Click on firstoption");
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	           //#16
	           click(thirdOption, "Click on firstoption");
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	           System.out.println("Completed Lesson");
		
	}
	public void lessonAssessImpleNdEvalOfInterRelToPainMgmt(String studType) throws Exception {
		System.out.println("inside Implementation and Evaluation of Interventions Related to Pain Management");
        
	       //#1
	           switch (studType) {
	           case "W":
	                           click(firstOption, "Click on first option");
	                           break;
	           case "X":
	                           click(thirdOption, "Click on third option");
	                           break;
	           case "Y":
	                           click(fourthOption, "Click on fourth option");
	                           break;
	           case "Z":
	                           click(fourthOption, "Click on third option");
	                           break;
	           default:
	                                  click(secondOption, "Click on third option");
	                                  break;
	                                           
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	           //#2 
	           switch (studType) {
	           case "W":
	                                   click(firstanswer, "Click on firstoption");
	                                  click(thirdanswer, "Click on thirdoption");
	                                  click(fourthanswer, "Click on fourthoption");
	                           break;
	           case "X":
	                                   click(firstanswer, "Click on firstoption");
	                                  click(thirdanswer, "Click on thirdoption");
	                                  click(fourthanswer, "Click on fourthoption");
	                           break;
	           case "Y":
	                                   click(firstanswer, "Click on firstoption");
	                                  click(thirdanswer, "Click on thirdoption");
	                                  click(fourthanswer, "Click on fourthoption");
	                           break;
	           case "Z":
	                                   click(firstanswer, "Click on firstoption");
	                                  click(thirdanswer, "Click on thirdoption");
	                                  click(fourthanswer, "Click on fourthoption");
	                           break;
	           default:
	                                  click(firstanswer, "Click on firstoption");
	                                  click(thirdanswer, "Click on thirdoption");
	                                  click(fourthanswer, "Click on fourthoption");
	                                  click(fifthanswer, "Click on firstoption");
	                                  break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	           //#3
	           switch (studType) {
	           case "X":
	                           click(firstOption, "Click on third option");
	                           break;
	           case "Y":
	                           click(firstOption, "Click on first option");
	                           break;
	           case "Z":
	                           click(secondOption, "Click on third option");
	                           break;
	           default:
	                                  click(thirdOption, "Click on first option");
	                                  break;
	                          
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	           //#4
	           switch (studType) {
	           case "X":
	                           click(firstOption, "Click on third option");
	                           break;
	           case "Y":
	                           click(thirdOption, "Click on first option");
	                           break;
	           case "Z":
	                           click(firstOption, "Click on third option");
	                           break;
	           default:
	                           click(secondOption, "Click on firstoption");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	           //#5 
	           switch (studType) {
	           case "X":
	                           click(firstOption, "Click on third option");
	                           break;
	           case "Y":
	                           click(secondOption, "Click on first option");
	                           break;
	           case "Z":
	                           click(firstOption, "Click on third option");
	                           break;
	           default: 
	                           click(thirdOption, "Click on firstoption");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	       //#6 
	           switch (studType) {
	           case "Y":
	                                  click(firstOption, "Click on third option");
	                           break;
	           case "Z":
	                                  click(firstOption, "Click on third option");
	                           break;
	           default:
	                          click(thirdOption, "Click on third option");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	       //#7
	           switch (studType) {
	           case "Y":
	                                  click(firstanswer, "Click on firstoption");
	                                 click(thirdanswer, "Click on thirdoption");
	                                 click(fourthanswer, "Click on fourthoption");
	                           break;
	           case "Z":
	                                  click(firstanswer, "Click on firstoption");
	                                 click(thirdanswer, "Click on thirdoption");
	                                 click(fourthanswer, "Click on fourthoption");
	                           break;
	           default:
	                                  click(firstanswer, "Click on firstoption");
	                                 click(thirdanswer, "Click on thirdoption");
	                                 click(fifthanswer, "Click on firstoption");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	       //#8 
	           switch (studType) {
	           case "Y":
	                                  click(firstanswer, "Click on firstoption");
	                                 click(secondanswer, "Click on firstoption");
	                                 click(thirdanswer, "Click on thirdoption");
	                           break;
	           case "Z":
	                                  click(firstanswer, "Click on firstoption");
	                                 click(secondanswer, "Click on firstoption");
	                                 click(thirdanswer, "Click on thirdoption");
	                           break;
	           default:
	                          click(firstanswer, "Click on firstoption");
	                          click(secondanswer, "Click on firstoption");
	                        click(fourthanswer, "Click on fourthoption");
	                        break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	       //#9 
	           switch (studType) {
	           case "Z":
	                           click(secondOption, "Click on third option");
	                           break;
	           default:
	                           click(firstOption, "Click on firstoption");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	           //#10
	           switch (studType) {
	           case "Z":
	                                  click(thirdanswer, "Click on thirdoption");
	                                   click(fourthanswer, "Click on fourthoption");
	                                   click(fifthanswer, "Click on firstoption");
	                           break;
	           default:
	                                  click(firstanswer, "Click on firstoption");
	                                 click(thirdanswer, "Click on thirdoption");
	                                 click(fourthanswer, "Click on fourthoption");
	                                
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	         
	           
	       //#11 
	           switch (studType) {
	           case "Z":
	                                  click(firstanswer, "Click on firstoption");
	                                 click(thirdanswer, "Click on thirdoption");
	                                 click(fourthanswer, "Click on fourthoption");
	                                  break;
	           default:
	                                  click(firstanswer, "Click on firstoption");
	                                 click(fifthanswer, "Click on firstoption");
	                                  break;
	                               }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	       //#12
	           switch (studType) {
	           case "Z":
	                           click(firstOption, "Click on third option");
	                           break;
	           default:
	                           click(secondOption, "Click on firstoption");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	       //#13
	           switch (studType) {
	           case "Z":
	                                  click(secondOption, "Click on firstoption");       
	                           break;
	           default:
	                                  click(fourthOption, "Click on firstoption");
	                                 break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	       
	           //#14 
	           click(secondOption, "Click on firstoption");
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	       
	           //#15 
	           click(thirdOption, "Click on firstoption");
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	           
	           System.out.println("Completed Lesson");
		
	}
	public void skillAssessingPain(String studType) throws Exception {
		click(next, "Click on next button");
        click(next, "Click on next button");
        click(next, "Click on next button");
        click(next, "Click on next button");
        click(next, "Click on next button");
        click(next, "Click on next button");
        //#1
        switch (studType) {
        case "W":
                        click(secondOption, "Click on first option");
                        break;
        case "X":
                        click(thirdOption, "Click on third option");
                        break;
        case "Y":
                        click(secondOption, "Click on fourth option");
                        break;
        case "Z":
                        click(secondOption, "Click on third option");
                        break;
        default:
                               click(firstOption, "Click on third option");
                               break;
                                        
        }
        clickById(submit, "Click on submit answer");
        
        //#2
        switch (studType) {
          case "X":
                        click(thirdOption, "Click on third option");
                        break;
        case "Y":
                        click(secondOption, "Click on fourth option");
                        break;
        case "Z":
                        click(secondOption, "Click on third option");
                        break;
        default:
                               click(firstOption, "Click on third option");
                               break;
                                        
        }
        clickById(submit, "Click on submit answer");
        //#3
        switch (studType) {
         case "Y":
                        click(firstOption, "Click on fourth option");
                        break;
        case "Z":
                        click(firstOption, "Click on third option");
                        break;
        default:
                               click(secondOption, "Click on third option");
                               break;
                                        
        }
        clickById(submit, "Click on submit answer");
        //#4
        switch (studType) {
        case "Z":
                        click(secondOption, "Click on third option");
                        break;
        default:
                               click(thirdOption, "Click on third option");
                               break;
                                        
        }
        clickById(submit, "Click on submit answer");
        //#5
        click(thirdOption, "Click on third option");
        clickById(submit, "Click on submit answer");

        click(correctTab,"click on Correct answer tab");
        click(incorrectTab,"click on incorrect answer tab");
        click(next, "Click on next button");
//        click(exitSkil,"Click on exit skill");

		
	}


	
	
	public void dragAndDropQuestions() throws Exception{
		
		
		if(elementIsDisplayed(drag1,"If drag and drop type question")){
		dragAndDrop(drag1, target1);
		dragAndDrop(drag2, target2);
		dragAndDrop(drag3, target3);
		dragAndDrop(drag4, target4);
		click(prettySureBtn, "Click on pretty sure button");
		System.out.println("pretty sure answer type selected");
		Thread.sleep(2000);
		if(elementIsEnabledById(tryAgainBtn, "if try again is displayed")) {
			
			clickById(tryAgainBtn, "Click on try again");
			System.out.println("try again clicked");
			dragAndDrop(drag1, target2);
			dragAndDrop(drag2, target3);
			dragAndDrop(drag3, target4);
			dragAndDrop(drag4, target1);
			click(submit, "Click on submit button");
			if(elementIsDisplayed(next, "if next is displayed")){
					click(next, "Click next");
			}else if(elementIsEnabledById(tryAgainBtn, "if try again is displayed")){
				
				clickById(tryAgainBtn, "Click on try again");
				System.out.println("try again clicked");
				dragAndDrop(drag1, target3);
				dragAndDrop(drag2, target4);
				dragAndDrop(drag3, target1);
				dragAndDrop(drag4, target2);
				click(submit, "Click on submit button");
				if(elementIsDisplayed(next, "if next is displayed")){
					click(next, "Click next");
				}else if(elementIsEnabledById(tryAgainBtn, "if try again is displayed")){
					
					clickById(tryAgainBtn, "Click on try again");
					System.out.println("try again clicked");
					dragAndDrop(drag1, target3);
					dragAndDrop(drag2, target4);
					dragAndDrop(drag3, target1);
					dragAndDrop(drag4, target2);
					click(submit, "Click on submit button");
					if(elementIsDisplayed(next, "if next is displayed")){
						click(next, "Click next");
					}else if(elementIsEnabledById(submit, "if submit is enabled")){
						click(submit, "Click on submit button");
					}
						
					}
					
		
				}

		}		
		}
		else if(elementIsDisplayed(next, "if next is displayed")){
			click(next, "Click next");
		}
		
		
	}
	
	
	public void navigateLessonAssessment(String lessonName) throws Exception {
		Thread.sleep(2000);
		String lessonXpath = "//span[@class='tile__resource-title ng-binding' and normalize-space(.)= '"+lessonName+"']";
//		System.out.println("Lesson element is "+lessonXpath);
		elementIsDisplayed(lessonXpath);
		Thread.sleep(2000);
		click(lessonXpath, lessonName);
//		System.out.println("Opened lesson");
		elementIsDisplayed(next,"until next button is displayed");
		
		String lessonAssessXpath = "//div[@class='link-text' and normalize-space(.)='Lesson Assessment']";
		elementIsDisplayed(lessonAssessXpath);
		click(lessonAssessXpath, lessonName);
		Thread.sleep(3000);
//		System.out.println("in lesson assessment");
	}

	
	
	
	
}

	

	
		
	
	
	
	
	
	



