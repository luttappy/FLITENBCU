
package com.mop.qa.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.mop.qa.testbase.PageBase_Appium;


public class EvolveLessonPage extends PageBase_Appium {
	
	
	@FindBy(xpath = ("//*[@id='slide-panel']/navigation-list/div[1]/div[1]/a"))
	protected WebElement home;
	
	@FindBy(xpath = ("//span[@class='breadcrumb__label'][contains(text(),'Exit')]"))
	protected WebElement exit;
	
	@FindBy(className = "heading__resource-title")
	protected WebElement perfPageHeader;
	
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
    
    String sfirstOption = "answerChoice0";
    
	@FindBy(xpath = "//label[@for='answerChoice1']")
	protected WebElement secondOption;
	
	@FindBy(id = "answerChoice1")
	protected WebElement secondOptionNew;
    
    @FindBy(xpath = "//label[@for='answerChoice2']")
	protected WebElement thirdOption;

	@FindBy(xpath = "//label[@for='answerChoice3']")
	protected WebElement fourthOption;
	 
	@FindBy(xpath = "//label[@for='answerChoice4']")
	protected WebElement fifthOption;
	
	@FindBy(xpath = "//label[@for='answerChoice[0]']")
	protected WebElement firstAnswer;
	
	String sfirstAnswer = "answerChoice[0]";
	
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
	
	String sAreYouReady = "areYouReadyQuestion";
	String sNextBtn = "next";
	String sConfusedBtn = "button-confused";
	String sDisplayKeyPoints = "kpViewButton";
	
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
	
	@FindBy(xpath = ("//div[@class='dropdown']"))
	protected WebElement innerLessonNav;
	
	
	@FindBy(xpath = ("//span[@class='icon-arrow-down dropdown__arrow']"))
	protected WebElement lessonNav;
	
	@FindBy(xpath = ("//div[@class='dropdown__element ng-binding']"))
	protected List <WebElement> listofTopics;
	
	@FindBy(xpath = ("//div[@class='dropdown__element ng-binding'][contains(text(),'introduction')]"))
	protected WebElement  topic1;
	
	@FindBy(xpath = ("//div[@class='dropdown__element ng-binding'][contains(text(),'Concept of Pain')]"))
	protected WebElement  topic2;
	
	@FindBy(xpath = ("//div[@class='dropdown__element ng-binding'][contains(text(),'Physiology of Pain')]"))
	protected WebElement  topic3;
	
	@FindBy(xpath = ("//div[@class='dropdown__element ng-binding'][contains(text(),'Pain Theories')]"))
	protected WebElement  topic4;
	
	@FindBy(xpath = ("//div[@class='dropdown__element ng-binding'][contains(text(),'summary')]"))
	protected WebElement  topic5;
	
	@FindBy (xpath = ("//article[id='additional-content-alt']"))
	protected WebElement confusedArticle;
	
	@FindBy(xpath = ("//aside[@class='content-img-fluff']//img"))
	protected WebElement image;
	
	
	@FindBy(xpath = ("//span[@class='ng-scope']//img[@src='images/icons-svg/in-progress.svg']"))
	protected WebElement topicStatusInProgress;
	
	@FindBy(xpath = ("//span[@class='ng-scope']//img[@src='images/icons-svg/icon-bullet.svg']"))
	protected WebElement topicStatusCompleted;
	
	@FindBy(id = "questionNumber")
	protected WebElement questionNumber;
	
	
	
	
		
	int submitCounter = 0;
	
	
	public void completeMiniQuiz() throws Exception {
		try {
			while(!elementExist(sConfusedBtn,2)) {
				while(!elementExist(sNextBtn,1)) {
					if(elementExist(sfirstOption,2)) {
						click(firstOption, "Click on firstoption");
					} else if(elementExist(sfirstAnswer,2)) {
						click(firstAnswer, "click on first option");
					} else if(isElementPresent(drag1,1)) {	
							dragAndDrop(drag2, target2);
							dragAndDrop(drag3, target3);
							
							dragAndDrop(drag4, target4);
							if(isElementPresent(drag5,1)){
							dragAndDrop(drag5, target5);
//							dragAndDrop(drag3, target1);
							dragAndDrop(drag1, target1);
							}else
							dragAndDrop(drag1, target1);
					}
					if(isElementPresent(prettySureBtn,2)) {
						//caoture and write to output file
						click(prettySureBtn, "Click on pretty sure button");
						if(elementExist(tryAgainBtn,3)) {
							clickById(tryAgainBtn, "Click on try again");
						}
					} else if(elementExist(submitMiniQuiz,2)) {
						submitCounter++;
						clickById(submitMiniQuiz,"click submit mini quiz button");
						if(elementExist(tryAgainBtn,5)) {
							clickById(tryAgainBtn, "Click on try again");
//							System.out.println("try again clicked");
						}
						if(submitCounter==2) {
//							System.out.println("submit counter value set "+submitCounter);
							Thread.sleep(1000);
							//System.out.println(questionTxt.getText());
							clickById(submitMiniQuiz,"click submit mini quiz button");
							submitCounter = 0;
						}
					}
				}
				click(next,"click on next button");
				Thread.sleep(1000);
				if(isElementPresent(lessonPageHeading,2)) {
					if(lessonPageHeading.getText().equalsIgnoreCase("Summary")) {
						System.out.println("Lesson Summary Page reached");
						click(next,"click on next button");
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void completeLesson(String lessonName) throws Exception {
		
		try {
//			Thread.sleep(2000);
			String lessonXpath = "//span[@class='tile__resource-title ng-binding' and normalize-space(.)= '"+lessonName+"']";
//			System.out.println("Lesson element is "+lessonXpath);
			elementIsDisplayed(lessonXpath);
//			Thread.sleep(2000);
			click(lessonXpath, lessonName);
			System.out.println("Entered lesson");
//			Thread.sleep(2000);
			int confused = 1;
			
			while(!elementExist(sAreYouReady,2)) {
//			while(!isElementPresent(areYouReady, 2)) {
//				System.out.println("inside first loop - lesson navigation");
				do {
//					System.out.println("inside do while");
					if(elementExist(sNextBtn, 2)){ //changed
						if(elementExist(sDisplayKeyPoints, 2)) {
//							click(next,"Click next button inside if");
							break;
						}
						if(confused % 3 ==0){
							if(elementExist(sConfusedBtn, 2)) {
								click(confusedBtn, "Click on confused button");
								//capture Topic name and student login and write to a output file
							}
						}
						//Capture topic name and add it to reporter function
						click(next,"Lesson Navigation Next button clicked");
						}
				} while(!elementExist(sDisplayKeyPoints,2));
//				System.out.println("completed while loop");
//				Thread.sleep(2000);
				if(areYouReady.getText().equalsIgnoreCase("Almost finished!")) {
					break;
				}
				//Capture topic name and add it to reporter function
				click(next,"Click next Topic summary");
				completeMiniQuiz();
				confused++;
			}
			System.out.println("in Lesson assessment page");
			Thread.sleep(1000);
			click(next,"Click next button");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void selectLessonAssessment(String lessonName, String studType) throws Exception {
		try {
			
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
			if(isElementPresent(perfPageHeader,5)) {
				click(exit,"click on Exit Lesson");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
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
		String questionText = questionNumber.getText();	
		String[] questionTextArr = questionText.split(" ");
		int totalNumofQuestions = Integer.parseInt(questionTextArr[2]);
		int questionCounter=1;
				
		
		
		try {
			//#1
			switch (studType) {
			case "Better":
				click(firstOption, "Click on first option");
				break;
			case "Good":
				click(thirdOption, "Click on third option");
				break;
			case "Average":
				click(fourthOption, "Click on first option");
				break;
			case "Bad":
				click(thirdOption, "Click on third option");
				break;
			default:
				click(secondOption, "Click on secondoption");
					
			}
//			System.out.println("qn1 "+questionTxt.getText());
			clickById(submit, "Click on submit answer");
			
			//#2
			questionCounter++;
			waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
//			System.out.println(questionTxt.getText());
			switch (studType) {
			case "Better":
				click(secondOption, "Click on first option");
				break;
			case "Good":
				click(thirdOption, "Click on third option");
				break;
			case "Average":
				click(fourthOption, "Click on first option");
				break;
			case "Bad":
				click(thirdOption, "Click on third option");
				break;
			default:
				click(firstOption, "Click on secondoption");
			}
//			System.out.println("qn2 "+questionTxt.getText());
			clickById(submit, "Click on submit answer");
			questionCounter++;
			//#3
			waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
			switch (studType) {
			case "Good":
				click(firstAnswer, "Click on third option");
				break;
			case "Average":
				click(fifthanswer, "Click on first option");
				break;
			case "Bad":
				click(firstAnswer, "Click on third option");
				break;
			default:
				click(firstAnswer, "Click on firstoption");
				click(fifthanswer, "Click on firstoption");
			}
//			System.out.println("qn3 "+questionTxt.getText());
			clickById(submit, "Click on submit answer");
			questionCounter++;
			
			//#4
			waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
			switch (studType) {
			case "Good":
				click(firstOption, "Click on third option");
				break;
			case "Average":
				click(secondOption, "Click on first option");
				break;
			case "Bad":
				click(firstOption, "Click on third option");
				break;
			default:
				click(thirdOption, "Click on firstoption");
			}
//			System.out.println("qn4 "+questionTxt.getText());
			clickById(submit, "Click on submit answer");
			questionCounter++;
			
			//#5
			waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
//			System.out.println(questionTxt.getText());
			switch (studType) {
			case "Good":
				click(firstOption, "Click on third option");
				break;
			case "Average":
				click(secondOption, "Click on first option");
				break;
			case "Bad":
				click(firstOption, "Click on third option");
				break;
			default:
				click(fourthOption, "Click on firstoption");
			}
//			System.out.println("qn5 "+questionTxt.getText());
			clickById(submit, "Click on submit answer");
			questionCounter++;
			//#6
			waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
			switch (studType) {
			case "Average":
				click(secondOption, "Click on first option");
				break;
			case "Bad":
				click(thirdOption, "Click on third option");
				break;
			default:
				click(firstOption, "Click on firstoption");
				break;
			}
//			System.out.println("qn6 "+questionTxt.getText());
			clickById(submit, "Click on submit answer");
			questionCounter++;
			//#7
			waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
			switch (studType) {
			case "Average":
				click(firstOption, "Click on first option");
				break;
			case "Bad":
				click(thirdOption, "Click on third option");
				break;
			default:
				click(secondOption, "Click on firstoption");
				break;
			}
//			System.out.println("qn7 "+questionTxt.getText());
			clickById(submit, "Click on submit answer");
			questionCounter++;
			//#8
			waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
			switch (studType) {
			case "Average":
				click(secondOption, "Click on first option");
				break;
			case "Bad":
				click(thirdOption, "Click on third option");
				break;
			default:
				click(firstOption, "Click on firstoption");
			}
//			System.out.println("qn8 "+questionTxt.getText());
			clickById(submit, "Click on submit answer");
			questionCounter++;
			//#9
			waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
			switch (studType) {
			case "Bad":
				click(thirdOption, "Click on third option");
				break;
			default:
				click(secondOption, "Click on firstoption");
			}
//			System.out.println("qn9 "+questionTxt.getText());
			clickById(submit, "Click on submit answer");
			questionCounter++;
			waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);

			
			//#10
//			System.out.println("qn10 "+questionTxt.getText());
			clickById(submit, "Click on submit answer");
			questionCounter++;
			waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);

			//#11
			switch (studType) {
			case "Bad":
				click(thirdOption, "Click on third option");
				break;
			default:
				click(thirdOption, "Click on firstoption");
			}
			//System.out.println(questionTxt.getText());
			clickById(submit, "Click on submit answer");
			questionCounter++;
			waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);

			//#12
			switch (studType) {
			case "Bad":
				click(secondOption, "Click on third option");
				break;
			default:
				click(thirdOption, "Click on firstoption");
			}
			//System.out.println(questionTxt.getText());
			clickById(submit, "Click on submit answer");
			questionCounter++;
			waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);

			//#13
			switch (studType) {
			case "Bad":
				click(thirdOption, "Click on third option");
				break;
			default:
				click(secondOption, "Click on firstoption");
			}
			//System.out.println(questionTxt.getText());
			clickById(submit, "Click on submit answer");
			questionCounter++;
			waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);

			//#14
			click(secondanswer, "Click on secondoption");
			click(thirdanswer, "Click on secondoption");
			click(fifthanswer,"Click on fifth option");
			//System.out.println(questionTxt.getText());
			clickById(submit, "Click on submit answer");
			questionCounter++;
			waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);

			//#15
			click(secondOption, "Click on firstoption");
			//System.out.println(questionTxt.getText());
			clickById(submit, "Click on submit answer");
		} catch (Exception e) {
			System.out.println("in the catch block");
			e.printStackTrace();
		}
		System.out.println("Lesson Completed");
	}
	public void lessonAssessTypesOfPain(String studType) throws Exception {
		
		System.out.println("inside lesson assessment - Types of Pain");
		String questionText = questionNumber.getText();	
		String[] questionTextArr = questionText.split(" ");
		int totalNumofQuestions = Integer.parseInt(questionTextArr[2]);
		int questionCounter=1;
		
		try {
			//#1
			switch (studType) {
			case "Better":
				click(firstOption, "Click on first option");
				break;
			case "Good":
				click(thirdOption, "Click on third option");
				break;
			case "Average":
				click(fourthOption, "Click on first option");
				break;
			case "Bad":
				click(thirdOption, "Click on third option");
				break;
			default:
				click(secondOption, "Click on secondoption");
					
			}
			//System.out.println(questionTxt.getText());
			clickById(submit, "Click on submit answer");
			questionCounter++;
			waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
			
			//#2
			switch (studType) {
			case "Better":
				click(secondOption, "Click on first option");
				break;
			case "Good":
				click(thirdOption, "Click on third option");
				break;
			case "Average":
				click(fourthOption, "Click on first option");
				break;
			case "Bad":
				click(thirdOption, "Click on third option");
				break;
			default:
				click(firstOption, "Click on secondoption");
					
			}
			//System.out.println(questionTxt.getText());
			clickById(submit, "Click on submit answer");
			questionCounter++;
			waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
			
			//#3
			switch (studType) {
			case "Good":
				click(firstAnswer, "Click on third option");
				break;
			case "Average":
				click(fifthanswer, "Click on first option");
				break;
			case "Bad":
				click(firstAnswer, "Click on third option");
				break;
			default:
				click(firstAnswer, "Click on firstoption");
				click(thirdanswer, "Click on firstoption");
				click(fifthanswer, "Click on firstoption");
			}
			//System.out.println(questionTxt.getText());
			clickById(submit, "Click on submit answer");
			questionCounter++;
			waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
			
			//#4
			switch (studType) {
			case "Good":
				click(thirdOption, "Click on third option");
				break;
			case "Average":
				click(firstOption, "Click on first option");
				break;
			case "Bad":
				click(thirdOption, "Click on third option");
				break;
			default:
				click(fourthOption, "Click on secondoption");
					
			}
			//System.out.println(questionTxt.getText());
			clickById(submit, "Click on submit answer");
			questionCounter++;
			waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
			
			//#5
			switch (studType) {
			case "Good":
				click(thirdOption, "Click on third option");
				break;
			case "Average":
				click(firstOption, "Click on first option");
				break;
			case "Bad":
				click(fourthOption, "Click on third option");
				break;
			default:
				click(secondOption, "Click on secondoption");
					
			}
			//System.out.println(questionTxt.getText());
			clickById(submit, "Click on submit answer");
			questionCounter++;
			waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
			
			//#6
			switch (studType) {
			case "Good":
				click(secondOption, "Click on third option");
				break;
			case "Average":
				click(firstOption, "Click on first option");
				break;
			case "Bad":
				click(fourthOption, "Click on third option");
				break;
			default:
				click(thirdOption, "Click on secondoption");
					
			}
			//System.out.println(questionTxt.getText());
			clickById(submit, "Click on submit answer");
			questionCounter++;
			waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
			
			//#7
			switch (studType) {
			case "Average":
				click(firstOption, "Click on first option");
				break;
			case "Bad":
				click(fourthOption, "Click on third option");
				break;
			default:
				click(secondOption, "Click on secondoption");
					
			}
			//System.out.println(questionTxt.getText());
			clickById(submit, "Click on submit answer");
			questionCounter++;
			waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
			
			//#8
			switch (studType) {
			case "Average":
				click(secondOption, "Click on first option");
				break;
			case "Bad":
				click(firstOption, "Click on third option");
				break;
			default:
				click(fourthOption, "Click on secondoption");
					
			}
			//System.out.println(questionTxt.getText());
			clickById(submit, "Click on submit answer");
			questionCounter++;
			waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
			
			//#9
			switch (studType) {
			case "Average":
				click(secondOption, "Click on first option");
				break;
			case "Bad":
				click(thirdOption, "Click on third option");
				break;
			default:
				click(firstOption, "Click on secondoption");
					
			}
			//System.out.println(questionTxt.getText());
			clickById(submit, "Click on submit answer");
			questionCounter++;
			waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
			
			//#10
			switch (studType) {
			case "Bad":
				click(thirdOption, "Click on third option");
				break;
			default:
				click(fourthOption, "Click on secondoption");
					
			}
			//System.out.println(questionTxt.getText());
			clickById(submit, "Click on submit answer");
			questionCounter++;
			waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
			
			//#11
			switch (studType) {
			case "Bad":
				click(thirdOption, "Click on third option");
				break;
			default:
				click(secondOption, "Click on secondoption");
					
			}
			//System.out.println(questionTxt.getText());
			clickById(submit, "Click on submit answer");
			questionCounter++;
			waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
			
			//#12
			switch (studType) {
			case "Bad":
				click(thirdOption, "Click on third option");
				break;
			default:
				click(firstOption, "Click on secondoption");
					
			}
			//System.out.println(questionTxt.getText());
			clickById(submit, "Click on submit answer");
			questionCounter++;
			waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
			
			//#13
			switch (studType) {
			case "Bad":
				click(thirdOption, "Click on third option");
				break;
			default:
				click(firstOption, "Click on secondoption");
					
			}
			//System.out.println(questionTxt.getText());
			clickById(submit, "Click on submit answer");
			questionCounter++;
			waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
			
			//#14
			click(thirdOption, "Click on secondoption");
			//System.out.println(questionTxt.getText());
			clickById(submit, "Click on submit answer");
			questionCounter++;
			waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
			
			//#15
			click(secondanswer, "Click on firstoption");
			click(fifthanswer, "Click on firstoption");
			//System.out.println(questionTxt.getText());
			clickById(submit, "Click on submit answer");
 		} catch (Exception e) {
			e.printStackTrace();
 		}
	}
	public void lessonAssessOVerviewOfPain(String studType) throws Exception {
		System.out.println("inside lesson assessment");
		switch (studType) {
		case "Better":
		}
		System.out.println("lesson completed");

	}
	public void lessonAssessAssessmentrelToPain(String studType) throws Exception {
		System.out.println("inside lesson assessment - Assessment related To Pain");
		String questionText = questionNumber.getText();	
		String[] questionTextArr = questionText.split(" ");
		int totalNumofQuestions = Integer.parseInt(questionTextArr[2]);
		int questionCounter=1;
		
		try {
		       //#1
	           switch (studType) {
	           case "Better":
	                           click(firstOption, "Click on first option");
	                           break;
	           case "Good":
	                           click(secondOption, "Click on third option");
	                           break;
	           case "Average":
	                           click(fourthOption, "Click on fourth option");
	                           break;
	           case "Bad":
	                           click(fourthOption, "Click on third option");
	                           break;
	           default:
	                                  click(thirdOption, "Click on third option");
	                                  break;
	                                           
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           questionCounter++;
				waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
	           
	           //#2
	           switch (studType) {
	           case "Better":
	                           click(firstOption, "Click on second option");
	                           break;
	           case "Good":
	                           click(thirdOption, "Click on third option");
	                           break;
	           case "Average":
	                           click(fourthOption, "Click on first option");
	                           break;
	           case "Bad":
	                           click(thirdOption, "Click on third option");
	                           break;
	           default:
	                                  click(secondOption, "Click on second option");
	                                  break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           questionCounter++;
	           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
	           
	           //#3
	           switch (studType) {
	           case "Good":
	                           click(firstOption, "Click on third option");
	                           break;
	           case "Average":
	                           click(firstOption, "Click on first option");
	                           break;
	           case "Bad":
	                           click(secondOption, "Click on third option");
	                           break;
	           default:
	                                  click(fourthOption, "Click on first option");
	                                  break;
	                          
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           questionCounter++;
	           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
	           
	           //#4
	           switch (studType) {
	           case "Good":
	                           click(firstOption, "Click on third option");
	                           break;
	           case "Average":
	                           click(secondOption, "Click on first option");
	                           break;
	           case "Bad":
	                           click(firstOption, "Click on third option");
	                           break;
	           default:
	                           click(fourthOption, "Click on firstoption");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           questionCounter++;
	           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
	           
	           //#5
	           switch (studType) {
	           case "Good":
	                           click(firstOption, "Click on third option");
	                           break;
	           case "Average":
	                           click(thirdOption, "Click on first option");
	                           break;
	           case "Bad":
	                           click(firstOption, "Click on third option");
	                           break;
	           default: 
	                           click(secondOption, "Click on firstoption");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           questionCounter++;
	           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
	           
	       //#6
	           switch (studType) {
	           case "Average":
	                                      click(secondanswer, "Click on firstoption");
	                                   click(thirdanswer, "Click on thirdoption");
	                           break;
	           case "Bad":
	                                  click(firstAnswer, "Click on firstoption");
	                                 click(thirdanswer, "Click on thirdoption");
	                           break;
	           default:
	                           click(firstAnswer, "Click on firstoption");
	                           click(thirdanswer, "Click on thirdoption");
	                           click(fourthanswer, "Click on fourthoption");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           questionCounter++;
	           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
	           
	       //#7
	           switch (studType) {
	           case "Average":
	                           click(secondOption, "Click on first option");
	                           break;
	           case "Bad":
	                           click(thirdOption, "Click on third option");
	                           break;
	           default:
	                           click(firstOption, "Click on firstoption");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           questionCounter++;
	           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
	           
	       //#8 
	           switch (studType) {
	           case "Average":
	                           click(firstOption, "Click on first option");
	                           break;
	           case "Bad":
	                           click(thirdOption, "Click on third option");
	                           break;
	           default:
	                           click(secondOption, "Click on firstoption");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           questionCounter++;
	           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
	           
	       //#9 
	           switch (studType) {
	           case "Bad":
	                           click(secondOption, "Click on third option");
	                           break;
	           default:
	                           click(thirdOption, "Click on firstoption");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           questionCounter++;
	           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
	           
	           //#10
	           switch (studType) {
	           case "Bad":
	                           click(thirdOption, "Click on third option");
	                           break;
	           default:
	                           click(secondOption, "Click on firstoption");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           questionCounter++;
	           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
	         
	           
	       //#11
	           switch (studType) {
	           case "Bad":
	                                  click(firstAnswer, "Click on firstoption");
	                                 click(thirdanswer, "Click on thirdoption");
	                                 click(fourthanswer, "Click on fourthoption");
	                                  break;
	           default:
	                                   click(firstAnswer, "Click on firstoption");
	                                   click(secondanswer, "Click on firstoption");
	                                  click(thirdanswer, "Click on thirdoption");
	                                  click(fifthanswer, "Click on fourthoption");
	                                  break;
	                               }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           questionCounter++;
	           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
	           
	       //#12
	           switch (studType) {
	           case "Bad":
	                           click(secondOption, "Click on third option");
	                           break;
	           default:
	                           click(fourthOption, "Click on firstoption");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           questionCounter++;
	           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
	           
	       //#13
	           switch (studType) {
	           case "Bad":
	                           click(thirdOption, "Click on third option");
	                           break;
	           default:
	                           click(fourthOption, "Click on firstoption");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           questionCounter++;
	           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
	       
	           //#14
	           click(fourthOption, "Click on firstoption");
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           questionCounter++;
	           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
	       
	           //#15
	           click(fourthOption, "Click on firstoption");
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           
	           System.out.println("Completed Lesson");
		} catch (Exception e) {
			e.printStackTrace();
		}
        


		
	}
	public void lessonAssessNursingDiagPlanningRelToPainMgmt(String studType) throws Exception {
			System.out.println("inside asessment Nursing Diagnosis and Planning Related to Pain Management");
			String questionText = questionNumber.getText();	
			String[] questionTextArr = questionText.split(" ");
			int totalNumofQuestions = Integer.parseInt(questionTextArr[2]);
			int questionCounter=1;
			
			try {
			       //#1
		           switch (studType) {
		           case "Better":
		                           click(firstOption, "Click on first option");
		                           break;
		           case "Good":
		                           click(thirdOption, "Click on third option");
		                           break;
		           case "Average":
		                           click(fourthOption, "Click on fourth option");
		                           break;
		           case "Bad":
		                           click(fourthOption, "Click on third option");
		                           break;
		           default:
		                                  click(secondOption, "Click on third option");
		                                  break;
		                                           
		           }
		           //System.out.println(questionTxt.getText());
		           clickById(submit, "Click on submit answer");
		           questionCounter++;
		           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
		           
		           //#2 
		           switch (studType) {
		           case "Better":
		                           click(firstOption, "Click on second option");
		                           break;
		           case "Good":
		                           click(thirdOption, "Click on third option");
		                           break;
		           case "Average":
		                           click(secondOption, "Click on first option");
		                           break;
		           case "Bad":
		                           click(thirdOption, "Click on third option");
		                           break;
		           default:
		                                  click(fourthOption, "Click on second option");
		                                  break;
		           }
		           //System.out.println(questionTxt.getText());
		           clickById(submit, "Click on submit answer");
		           questionCounter++;
		           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
		           
		           //#3
		           switch (studType) {
		           case "Good":
		                           click(firstOption, "Click on third option");
		                           break;
		           case "Average":
		                           click(firstOption, "Click on first option");
		                           break;
		           case "Bad":
		                           click(secondOption, "Click on third option");
		                           break;
		           default:
		                                  click(fourthOption, "Click on first option");
		                                  break;
		                          
		           }
		           //System.out.println(questionTxt.getText());
		           clickById(submit, "Click on submit answer");
		           questionCounter++;
		           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
		           
		           //#4
		           switch (studType) {
		           case "Good":
		                           click(firstOption, "Click on third option");
		                           break;
		           case "Average":
		                           click(secondOption, "Click on first option");
		                           break;
		           case "Bad":
		                           click(firstOption, "Click on third option");
		                           break;
		           default:
		                           click(fourthOption, "Click on firstoption");
		                           break;
		           }
		           //System.out.println(questionTxt.getText());
		           clickById(submit, "Click on submit answer");
		           questionCounter++;
		           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
		           
		           //#5 
		           switch (studType) {
		           case "Good":
		                           click(firstOption, "Click on third option");
		                           break;
		           case "Average":
		                           click(thirdOption, "Click on first option");
		                           break;
		           case "Bad":
		                           click(firstOption, "Click on third option");
		                           break;
		           default: 
		                           click(fourthOption, "Click on firstoption");
		                           break;
		           }
		           //System.out.println(questionTxt.getText());
		           clickById(submit, "Click on submit answer");
		           questionCounter++;
		           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
		           
		       //#6 
		           switch (studType) {
		           case "Average":
		                                  click(firstOption, "Click on third option");
		                           break;
		           case "Bad":
		                                  click(firstOption, "Click on third option");
		                           break;
		           default:
		                          click(secondOption, "Click on third option");
		                           break;
		           }
		           //System.out.println(questionTxt.getText());
		           clickById(submit, "Click on submit answer");
		           questionCounter++;
		           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
		           
		       //#7
		           switch (studType) {
		           case "Average":
		                           click(secondOption, "Click on first option");
		                           break;
		           case "Bad":
		                           click(firstOption, "Click on third option");
		                           break;
		           default:
		                           click(thirdOption, "Click on firstoption");
		                           break;
		           }
		           //System.out.println(questionTxt.getText());
		           clickById(submit, "Click on submit answer");
		           questionCounter++;
		           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
		           
		       //#8 
		           switch (studType) {
		           case "Average":
		                                  click(firstAnswer, "Click on firstoption");
		                                 click(secondanswer, "Click on firstoption");
		                                 click(thirdanswer, "Click on thirdoption");
		                           break;
		           case "Bad":
		                                  click(firstAnswer, "Click on firstoption");
		                                 click(secondanswer, "Click on firstoption");
		                                 click(fourthanswer, "Click on thirdoption");
		                           break;
		           default:
		                          click(firstAnswer, "Click on firstoption");
		                          click(secondanswer, "Click on firstoption");
		                        click(thirdanswer, "Click on thirdoption");
		                        click(fourthanswer, "Click on fourthoption");
		                        break;
		           }
		           //System.out.println(questionTxt.getText());
		           clickById(submit, "Click on submit answer");
		           questionCounter++;
		           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
		           
		       //#9 
		           switch (studType) {
		           case "Bad":
		                           click(secondOption, "Click on third option");
		                           break;
		           default:
		                           click(firstOption, "Click on firstoption");
		                           break;
		           }
		           //System.out.println(questionTxt.getText());
		           clickById(submit, "Click on submit answer");
		           questionCounter++;
		           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
		           
		           //#10
		           switch (studType) {
		           case "Bad":
		                           click(thirdOption, "Click on third option");
		                           break;
		           default:
		                           click(secondOption, "Click on firstoption");
		                           break;
		           }
		           //System.out.println(questionTxt.getText());
		           clickById(submit, "Click on submit answer");
		           questionCounter++;
		           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
		         
		           
		       //#11 
		           switch (studType) {
		           case "Bad":
		                                  click(secondOption, "Click on firstoption");
		                                  break;
		           default:
		                                  click(thirdOption, "Click on third option");
		                                  break;
		                               }
		           //System.out.println(questionTxt.getText());
		           clickById(submit, "Click on submit answer");
		           questionCounter++;
		           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
		           
		       //#12
		           switch (studType) {
		           case "Bad":
		                           click(firstOption, "Click on third option");
		                           break;
		           default:
		                           click(fourthOption, "Click on firstoption");
		                           break;
		           }
		           //System.out.println(questionTxt.getText());
		           clickById(submit, "Click on submit answer");
		           questionCounter++;
		           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
		           
		       //#13
		           switch (studType) {
		           case "Bad":
		                                  click(firstAnswer, "Click on firstoption");
		                                  click(secondanswer, "Click on firstoption");
		                                 click(thirdanswer, "Click on thirdoption");
		                           break;
		           default:
		                                  click(firstAnswer, "Click on firstoption");
		                                  click(secondanswer, "Click on firstoption");
		                                 click(thirdanswer, "Click on thirdoption");
		                                 click(fifthanswer, "Click on fourthoption");
		                                 break;
		           }
		           //System.out.println(questionTxt.getText());
		           clickById(submit, "Click on submit answer");
		           questionCounter++;
		           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
		       
		           //#14 
		           click(secondOption, "Click on firstoption");
		           //System.out.println(questionTxt.getText());
		           clickById(submit, "Click on submit answer");
		           questionCounter++;
		           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
		       
		           //#15 
		           click(firstOption, "Click on firstoption");
		           //System.out.println(questionTxt.getText());
		           clickById(submit, "Click on submit answer");
		           questionCounter++;
		           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
		           
		           //#16
		           click(thirdOption, "Click on firstoption");
		           //System.out.println(questionTxt.getText());
		           clickById(submit, "Click on submit answer");
		           questionCounter++;
		           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
		           
		           System.out.println("Completed Lesson");
			} catch (Exception e) {
				e.printStackTrace();
			}
        

		
	}
	public void lessonAssessImpleNdEvalOfInterRelToPainMgmt(String studType) throws Exception {
		System.out.println("inside Implementation and Evaluation of Interventions Related to Pain Management");
		String questionText = questionNumber.getText();	
		String[] questionTextArr = questionText.split(" ");
		int totalNumofQuestions = Integer.parseInt(questionTextArr[2]);
		int questionCounter=1;
		
		try {
		       //#1
	           switch (studType) {
	           case "Better":
	                           click(firstOption, "Click on first option");
	                           break;
	           case "Good":
	                           click(thirdOption, "Click on third option");
	                           break;
	           case "Average":
	                           click(fourthOption, "Click on fourth option");
	                           break;
	           case "Bad":
	                           click(fourthOption, "Click on third option");
	                           break;
	           default:
	                                  click(secondOption, "Click on third option");
	                                  break;
	                                           
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           questionCounter++;
	           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
	           
	           //#2 
	           switch (studType) {
	           case "Better":
	                                   click(firstAnswer, "Click on firstoption");
	                                  click(thirdanswer, "Click on thirdoption");
	                                  click(fourthanswer, "Click on fourthoption");
	                           break;
	           case "Good":
	                                   click(firstAnswer, "Click on firstoption");
	                                  click(thirdanswer, "Click on thirdoption");
	                                  click(fourthanswer, "Click on fourthoption");
	                           break;
	           case "Average":
	                                   click(firstAnswer, "Click on firstoption");
	                                  click(thirdanswer, "Click on thirdoption");
	                                  click(fourthanswer, "Click on fourthoption");
	                           break;
	           case "Bad":
	                                   click(firstAnswer, "Click on firstoption");
	                                  click(thirdanswer, "Click on thirdoption");
	                                  click(fourthanswer, "Click on fourthoption");
	                           break;
	           default:
	                                  click(firstAnswer, "Click on firstoption");
	                                  click(thirdanswer, "Click on thirdoption");
	                                  click(fourthanswer, "Click on fourthoption");
	                                  click(fifthanswer, "Click on firstoption");
	                                  break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           questionCounter++;
	           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
	           
	           //#3
	           switch (studType) {
	           case "Good":
	                           click(firstOption, "Click on third option");
	                           break;
	           case "Average":
	                           click(firstOption, "Click on first option");
	                           break;
	           case "Bad":
	                           click(secondOption, "Click on third option");
	                           break;
	           default:
	                                  click(thirdOption, "Click on first option");
	                                  break;
	                          
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           questionCounter++;
	           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
	           
	           //#4
	           switch (studType) {
	           case "Good":
	                           click(firstOption, "Click on third option");
	                           break;
	           case "Average":
	                           click(thirdOption, "Click on first option");
	                           break;
	           case "Bad":
	                           click(firstOption, "Click on third option");
	                           break;
	           default:
	                           click(secondOption, "Click on firstoption");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           questionCounter++;
	           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
	           
	           //#5 
	           switch (studType) {
	           case "Good":
	                           click(firstOption, "Click on third option");
	                           break;
	           case "Average":
	                           click(secondOption, "Click on first option");
	                           break;
	           case "Bad":
	                           click(firstOption, "Click on third option");
	                           break;
	           default: 
	                           click(thirdOption, "Click on firstoption");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           questionCounter++;
	           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
	           
	       //#6 
	           switch (studType) {
	           case "Average":
	                                  click(firstOption, "Click on third option");
	                           break;
	           case "Bad":
	                                  click(firstOption, "Click on third option");
	                           break;
	           default:
	                          click(thirdOption, "Click on third option");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           questionCounter++;
	           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
	           
	       //#7
	           switch (studType) {
	           case "Average":
	                                  click(firstAnswer, "Click on firstoption");
	                                 click(thirdanswer, "Click on thirdoption");
	                                 click(fourthanswer, "Click on fourthoption");
	                           break;
	           case "Bad":
	                                  click(firstAnswer, "Click on firstoption");
	                                 click(thirdanswer, "Click on thirdoption");
	                                 click(fourthanswer, "Click on fourthoption");
	                           break;
	           default:
	                                  click(firstAnswer, "Click on firstoption");
	                                 click(thirdanswer, "Click on thirdoption");
	                                 click(fifthanswer, "Click on firstoption");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           questionCounter++;
	           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
	           
	       //#8 
	           switch (studType) {
	           case "Average":
	                                  click(firstAnswer, "Click on firstoption");
	                                 click(secondanswer, "Click on firstoption");
	                                 click(thirdanswer, "Click on thirdoption");
	                           break;
	           case "Bad":
	                                  click(firstAnswer, "Click on firstoption");
	                                 click(secondanswer, "Click on firstoption");
	                                 click(thirdanswer, "Click on thirdoption");
	                           break;
	           default:
	                          click(firstAnswer, "Click on firstoption");
	                          click(secondanswer, "Click on firstoption");
	                        click(fourthanswer, "Click on fourthoption");
	                        break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           questionCounter++;
	           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
	           
	       //#9 
	           switch (studType) {
	           case "Bad":
	                           click(secondOption, "Click on third option");
	                           break;
	           default:
	                           click(firstOption, "Click on firstoption");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           questionCounter++;
	           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
	           
	           //#10
	           switch (studType) {
	           case "Bad":
	                                  click(thirdanswer, "Click on thirdoption");
	                                   click(fourthanswer, "Click on fourthoption");
	                                   click(fifthanswer, "Click on firstoption");
	                           break;
	           default:
	                                  click(firstAnswer, "Click on firstoption");
	                                 click(thirdanswer, "Click on thirdoption");
	                                 click(fourthanswer, "Click on fourthoption");
	                                
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           questionCounter++;
	           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
	         
	           
	       //#11 
	           switch (studType) {
	           case "Bad":
	                                  click(firstAnswer, "Click on firstoption");
	                                 click(thirdanswer, "Click on thirdoption");
	                                 click(fourthanswer, "Click on fourthoption");
	                                  break;
	           default:
	                                  click(firstAnswer, "Click on firstoption");
	                                 click(fifthanswer, "Click on firstoption");
	                                  break;
	                               }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           questionCounter++;
	           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
	           
	       //#12
	           switch (studType) {
	           case "Bad":
	                           click(firstOption, "Click on third option");
	                           break;
	           default:
	                           click(secondOption, "Click on firstoption");
	                           break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           questionCounter++;
	           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
	           
	       //#13
	           switch (studType) {
	           case "Bad":
	                                  click(secondOption, "Click on firstoption");       
	                           break;
	           default:
	                                  click(fourthOption, "Click on firstoption");
	                                 break;
	           }
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           questionCounter++;
	           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
	       
	           //#14 
	           click(secondOption, "Click on firstoption");
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           questionCounter++;
	           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
	       
	           //#15 
	           click(thirdOption, "Click on firstoption");
	           //System.out.println(questionTxt.getText());
	           clickById(submit, "Click on submit answer");
	           questionCounter++;
	           waitforAssessmentPageLoad(questionNumber,questionCounter,totalNumofQuestions);
	           
	           
	           System.out.println("Completed Lesson");
		} catch (Exception e) {
			e.printStackTrace();
		}
        

		
	}
	public void skillAssessingPain(String studType) throws Exception {
		try {
			click(next, "Click on next button");
	        click(next, "Click on next button");
	        click(next, "Click on next button");
	        click(next, "Click on next button");
	        click(next, "Click on next button");
	        click(next, "Click on next button");
	        //#1
	        switch (studType) {
	        case "Better":
	                        click(secondOption, "Click on first option");
	                        break;
	        case "Good":
	                        click(thirdOption, "Click on third option");
	                        break;
	        case "Average":
	                        click(secondOption, "Click on fourth option");
	                        break;
	        case "Bad":
	                        click(secondOption, "Click on third option");
	                        break;
	        default:
	                               click(firstOption, "Click on third option");
	                               break;
	                                        
	        }
	        clickById(submit, "Click on submit answer");
	        
	        //#2
	        switch (studType) {
	          case "Good":
	                        click(thirdOption, "Click on third option");
	                        break;
	        case "Average":
	                        click(secondOption, "Click on fourth option");
	                        break;
	        case "Bad":
	                        click(secondOption, "Click on third option");
	                        break;
	        default:
	                               click(firstOption, "Click on third option");
	                               break;
	                                        
	        }
	        clickById(submit, "Click on submit answer");
	        //#3
	        switch (studType) {
	         case "Average":
	                        click(firstOption, "Click on fourth option");
	                        break;
	        case "Bad":
	                        click(firstOption, "Click on third option");
	                        break;
	        default:
	                               click(secondOption, "Click on third option");
	                               break;
	                                        
	        }
	        clickById(submit, "Click on submit answer");
	        //#4
	        switch (studType) {
	        case "Bad":
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
//	        click(exitSkil,"Click on exit skill");
		} catch (Exception e) {
			e.printStackTrace();
		}


		
	}
	public void dragAndDropQuestions() throws Exception{
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

		
		
	}
	public void navigateLessonAssessment(String lessonName) throws Exception {
		
			Thread.sleep(2000);
			String lessonXpath = "//span[@class='tile__resource-title ng-binding' and normalize-space(.)= '"+lessonName+"']";
//			System.out.println("Lesson element is "+lessonXpath);
			elementIsDisplayed(lessonXpath);
			Thread.sleep(2000);
			click(lessonXpath, lessonName);
//			System.out.println("Opened lesson");
			elementIsDisplayed(next,"until next button is displayed");
			
			String lessonAssessXpath = "//div[@class='link-text' and normalize-space(.)='Lesson Assessment']";
			elementIsDisplayed(lessonAssessXpath);
			click(lessonAssessXpath, "Lesson Assessment");
			Thread.sleep(3000);
//			System.out.println("in lesson assessment");
		} 
	public void verifyDueDate(String dueDate2) throws Exception{
		Thread.sleep(2000);
		String lessonXpath = "//span[@class='tile__resource-title ng-binding' and normalize-space(.)= 'Overview of Pain']";
		System.out.println("Lesson element is "+lessonXpath);
		elementIsDisplayed(lessonXpath);
		click(lessonXpath, "Overview of Pain");
		System.out.println("Entered lesson");
		Thread.sleep(2000);
		String dueDate1 = getText(dueDate, "Get due date displayed on lesson home page");
		//String dueDate2 = rds.getValue("EvolveDemo",this.getClass().getSimpleName(), "LessonName");
	    System.out.println("from app" +"  "+dueDate1);
		System.out.println("from excel" + dueDate2);
		Assert.assertEquals(dueDate1, dueDate2);
		System.out.println("Due date on lesson assignment page is as expected");
	}
	public void verifyInnerLessonNav(String topicName) throws Exception{
		
		Thread.sleep(2000);
		String lessonXpath = "//span[@class='tile__resource-title ng-binding' and normalize-space(.)= 'Overview of Pain']";
		System.out.println("Lesson element is "+lessonXpath);
		elementIsDisplayed(lessonXpath);
		click(lessonXpath, "Overview of Pain" );
		System.out.println("Entered lesson");
		Thread.sleep(2000);
		
			
		    click(next,"click on next button");
		    Thread.sleep(1000);
		    click(lessonNav, "Click on lesson navigation");
		    
		    List<WebElement> allOptions = remoteDriver.findElements(By.cssSelector(".dropdown-menu dropdown__menu dropdown__wedge--right li"));
		    int iListSize = allOptions.size(); 			
			for(int i =0; i < iListSize ; i++){				
			String sValue = allOptions.get(i).getText();				
			System.out.println(sValue);
		    Assert.assertEquals(sValue ,topicName );
			Thread.sleep(1000);
			
			System.out.println("Lesson navigation is as expected");
			}			      
	}	
	public void verifyConfusedContent(String confusedContent) throws Exception{
		
		Thread.sleep(2000);
		String lessonXpath = "//span[@class='tile__resource-title ng-binding' and normalize-space(.)= 'Overview of Pain']";
		System.out.println("Lesson element is "+lessonXpath);
		elementIsDisplayed(lessonXpath);
		click(lessonXpath, "Overview of Pain");
		System.out.println("Entered lesson");
		Thread.sleep(2000);		
			
		    click(next,"click on next button");
		    click(next,"click on next button");
		    
		    String confusedText = getText(confusedArticle, "Get content when clicked on confused");
		    
		    Assert.assertEquals(confusedText, confusedContent );
		    System.out.println("The confused content is as expected");
		
	}
	public void verifyImageDisplayed() throws Exception{
		Thread.sleep(2000);
		String lessonXpath = "//span[@class='tile__resource-title ng-binding' and normalize-space(.)= 'Overview of Pain']";
		System.out.println("Lesson element is "+lessonXpath);
		elementIsDisplayed(lessonXpath);
		click(lessonXpath, "Overview of Pain");
		System.out.println("Entered lesson");
		Thread.sleep(2000);		
			
		    click(next,"click on next button");
		    //click(next,"click on next button");
		    
		    Thread.sleep(2000);
		    String ImageID = remoteDriver.findElement(By.xpath("//aside[@class='content-img-fluff']//img")).getAttribute("id");
		    
		   System.out.println("The image id is" + ' ' + ImageID);
		    
		    WebElement ImageFile = remoteDriver.findElementById(ImageID);
		    
		    if(ImageFile.isDisplayed())
		    {
		    	System.out.println("Image is Displayed");
		    }else{
		    	System.out.println("Image is not displayed");
		    }
		    
		    
		
	}
		

}

	

	
		
	
	
	
	
	
	



