package com.mop.qa.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.testbase.PageBase_Appium;

public class LessonOverview extends PageBase_Appium {

	public LessonOverview() {
		super();
	}
	
	@FindBy(xpath = ".//*[@id='main-learning-content']//button[@data-button='continue-from-last-button']")
	WebElement continueFromWhereILeftOff;
	
	@FindBy(xpath = ".//*[@id='main-learning-content']//button[contains(.,'Reset Lesson')]")
	WebElement  resetLesson;
	
	@FindBy(id = "next")
	WebElement next;
	
	@FindBy(xpath = ".//*[@id='next']")
	WebElement next_path;
	
	@FindBy(id = "readyButton")
	WebElement readyButton;
	
	@FindBy(xpath = ".//*[@id='confirmLessonReset']/div/button[1]")
	WebElement confirmLessonReset;
	
	@FindBy(xpath = ".//*[@id='confirmLessonReset']/div/button[2]")
	WebElement cancelLessonReset;
	
	@FindBy(xpath = ".//a[contains(.,'EXIT')]") //.//*[@id='main']/header/div[1]/back-button/div/a]")
	WebElement exitLesson;
	
	public void clickContinueFromWhereILeftOff() throws Exception{
		click(continueFromWhereILeftOff, "Continue Where I left Off");
	}
	
	public void clickResetLesson() throws Exception{
		click(resetLesson, "Reset Lesson");
	}
	
	public void clickConfirmReset() throws Exception{
		click(confirmLessonReset, "Confirm Lesson Reset");
	}
	public void clickNext() throws Exception{
		click(next, "Next");
	}
	
	public void clickReadyForQuiz() throws Exception{
		click(readyButton, "Yes! I've Got this");
	}
	
	/**
	 * Added this method just for Button Naming an layout consistency.
	 * @throws Exception
	 */
	public void clickYesIveGotThis() throws Exception{
		clickReadyForQuiz();
	}
	
	private static final String MICRO_QUIZ_TEXT = "Ready to try a micro-quiz?";
	private static final String QUIZ_SECTION_ID = "submit-quiz-answer-low";
	private static final String LESSON_ASSESSMENT = "Lesson Assessment";
	private static final String ALMOST_FINISHED = "Almost finished!";
	private static final String TABLE_OF_CONTENTS = "Table of Contents";
	
	public void continueToQuiz() throws Exception{
		waitForPageLoad();
		while( !(verifyPageText(MICRO_QUIZ_TEXT)  || 
				 verifyPageText(QUIZ_SECTION_ID))){
			if (this.verifyPageText("questionNumber")){
				//you are in a quiz
				return;
			}
			if (verifyPageText(LESSON_ASSESSMENT) && !verifyPageText(TABLE_OF_CONTENTS) ){
				return;
			}
			clickNext();
		}
	}
	
	
	public boolean isLessonSummary(){
		boolean found = verifyPageText("SUMMARY");
		return found;
	}
	//TODO: Change name to isReadyForLessonAssessment()
	public boolean isReadyForLessonAssessment(){
		boolean found = ( verifyPageText(LESSON_ASSESSMENT) && verifyPageText(ALMOST_FINISHED) );
		return found;
	}

	public void clickConfirmLessonReset() throws Exception{
		click(confirmLessonReset, "Reset Lesson");
	}
	
	public void clickCancelLessonReset() throws Exception{
		click(cancelLessonReset, "Cancel Reset Lesson");
	}

	public void resetLessonAndProcessToQuiz() throws Exception {
		if( resetLesson.isEnabled() ){
			clickResetLesson();
			clickConfirmReset();
		}else if(continueFromWhereILeftOff.isEnabled()){
			this.clickContinueFromWhereILeftOff();
		}else{
			continueToQuiz();			
		}
		
	}
	
	public void continueIfReadyForMicroQuiz() throws Exception{
		if (this.verifyPageText("questionNumber")){
			//you are in a quiz
			return;
		}
		if (this.verifyPageText(MICRO_QUIZ_TEXT)){
			clickReadyForQuiz();			
		}
		
	}

	public void clickExitLesson() throws Exception {
		this.click(exitLesson, "Exit Lesson");
	}
}
