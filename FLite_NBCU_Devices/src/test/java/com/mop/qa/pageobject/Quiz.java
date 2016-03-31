package com.mop.qa.pageobject;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mop.qa.Utilities.Answer;
import com.mop.qa.Utilities.AnswerYamlBuilder;
import com.mop.qa.testbase.PageBase_Appium;

public class Quiz extends PageBase_Appium {
	public Quiz() {
		super();
	}
	
	@FindBy(id = "next")
	private WebElement next;
	@FindBy(xpath = ".//*[@id='question-container']//h2")
	private WebElement question;
	@FindBy(id="questionNumber")
	private WebElement questionNumber;
	@FindBy(id="submit-quiz-answer-low")
	private WebElement just_a_guess;
	@FindBy(id="submit-quiz-answer-medium")
	private WebElement pretty_sure;
	@FindBy(id = "submit-quiz-answer-high")
	private WebElement no_doubt;
	@FindBy(id="submit-quiz-answer")
	private WebElement submit;
	//@FindBy(xpath = ".//*[@id='sortable']/div[1]/li")
	@FindBy(css = "h2.quiz_question.ng-binging")
	private WebElement sortable_top;
	
	private static final String ANSWER_KEY_PATH = ".//label[contains(.,'%s')]";
	private static final String ANSWER_SINGLE_CHOICE_STR = "answerChoice%d";
	private static final String ANSWER_MULTI_CHOICE_STR = "answerChoice[%d]";
	
	/*****
	 * Selects an answer by the name of the answer
	 * @param answer
	 * @throws Exception
	 */
	public void selectAnswer(String answer) throws Exception{
		String path = String.format(ANSWER_KEY_PATH,answer);
		String answer_id = this.getAttributesFromXpath(path, "for");
		
		this.clickById(answer_id, answer);
	}
	
	public String getQuestion() throws Exception{
		return this.getText(question, "Question");
	}
	/*****
	 * Selects multiple choice questions
	 * @param answers
	 * @throws Exception
	 */
	public void selectMultipleChoiceAnswers(String[] answers) throws Exception{
		for( String answer : answers){
			selectAnswer(answer);
		}
	}
	
	private AnswerYamlBuilder ayb;
	
	public void buildYamlAnswers(){
		ayb = new AnswerYamlBuilder();
		String yaml_file = "Alterations in Oxygenation and Perfusion";
		ayb.setYamlFile(yaml_file);
		
		ayb.buildAnswerSheet();
		
	}
	
	public void buildYamlAnswers(String yaml_file){
		ayb = new AnswerYamlBuilder();
		ayb.setYamlFile(yaml_file);
		
		ayb.buildAnswerSheet();
	}
	
	@FindBy(xpath=".//*[@id='question-container']/div/div/div")
	WebElement drag_targets;
	
	private static final String drag_target_path = ".//*[@id='drag-container']/div[contains(.,'%s')]";
	private static final String answer_path =  ".//*[@id='question-container']/fieldset/div/ul/li/label[contains(., '%s')]";
			//".//*[@id='question-container']//li[label[contains(.,'%s')]]/input";
	
	//Used to get the count for the ID
	private static final String for_attribute = "for";
	private static final String for_id = "id";

	//private static final String SORT_TOP_PATH =   ".//*[@id='sortable']/div[1]/li";
	private static final String SORT_ANSWER_SELECTION_PATH = ".//*[@id='sortable']/div[contains(.,'%s')]/li";
	private static final String SORT_ELEMENTS_PATH = ".//*[@id='sortable']/div";
	
	
	private static final String END_CONTAINER_PATH  = ".//*[@class='container-drag-target ng-scope' and span[contains(.,'%s')]]/div";
	private static final String DRAG_ANSWER_PATH = ".//div[@class='draggable-answer-wrapper']/div[span[contains(.,'%s')]]";
	
	@SuppressWarnings("unchecked")
	public boolean selectAnswerFromYaml() throws Exception{
		//Retrieve Question
		String question = getQuestion(); //get Question for Label
		String path = new String();
		String answer_id = new String();
		Answer ans = ayb.getAnswer(question);
		
		boolean answerFound = false;
		
		switch(ans.getType()){
		case SINGLE:
			//Generate a path for the answer
			path = String.format(answer_path, ans.getAnswers());
			//answer_id = this.getAttributesFromXpath(path, for_id);
			this.click(path, (String)ans.getAnswers());
			//this.clickbyid(answer_id, answer_id);
			answerFound = true;
			break;
		case MULTIPLE:
			//Handle Clicking multiple answers.
			for (String answer : (List<String>)ans.getAnswers()){
				path = String.format(answer_path, answer);
				answer_id = this.getAttributesFromXpath(path, for_attribute);
				this.clickById(answer_id, answer_id);
				answerFound = true;
			}
			break;
		case SOUND:
			//YAML File Only contains the ID
			answer_id = (String) ans.getAnswers();
			this.clickById(answer_id, answer_id);
			answerFound = true;
			break;
		case LABEL:	
			Map<String, String>answer_hash = (Map<String,String>) ans.getAnswers();
			for (String key_id : answer_hash.keySet()){
				String ans_text = answer_hash.get(key_id);
				path = String.format(drag_target_path, ans_text);
				String id = this.getAttributesFromXpath(path, for_id);
				
				WebElement answer_element = this.getElementById(id);
				WebElement dropElement = this.getElementById(key_id);
				
				this.dragAndDropLabels(answer_element, dropElement);
				answerFound = true;

				System.out.println("Answer: " + answer_hash.get(key_id) + " : " + key_id);

			}
			break;
		case DRAG: //TODO: Evalate usage
			
			Map<String, String>answer_split = (Map<String,String>) ans.getAnswers();
			for (String endpoint_id : answer_split.keySet()){
				String drag_path = String.format(DRAG_ANSWER_PATH, answer_split.get(endpoint_id));
				
				String item_id = this.getAttributesFromXpath(drag_path, for_id);
				WebElement answer_element = this.getElementById(item_id);

				String end_location_path = String.format(END_CONTAINER_PATH, endpoint_id);
				
				WebElement dropElement = this.getElement(end_location_path);
				
				this.dragAndDropALT(answer_element, dropElement);
			}
			System.out.println("");
			break;			
		case REORDER:
			Map<String, String> reorder_answers = (Map<String,String>) ans.getAnswers();
			String reorder_answer = new String();
			
			int total = this.getNumberOfElementsByXpath( SORT_ELEMENTS_PATH );	
			WebElement top_element = this.getElement(".//*[@class='quiz-question ng-binding']");
			
			for ( int i = total;i > 0; i-- ){
				reorder_answer = reorder_answers.get(i);
				System.out.println("\tANSWER: " + reorder_answer);
				
				String re_path = String.format(SORT_ANSWER_SELECTION_PATH, reorder_answer);
				WebElement drag = this.getElement(re_path);
				//String xpath = ".//*[@id='sortable']/div[1]";
				WebElement top = this.getElement(".//*[@id='sortable']/div[1]/li");
				this.dragAndDropALT(drag, top, false);// sortable_top);
				//TODO: REMOVE System.out.println();
			}
			System.out.println();	
		default:
			break;
		}
		
		return answerFound;
		
				
	}
	
	

	/*****
	 * Select answer by index
	 * @param index
	 * @throws Exception
	 */
	public void selectAnswer(int index, boolean single) throws Exception{		
		String answer_id = String.format(
				(single ? ANSWER_SINGLE_CHOICE_STR : ANSWER_MULTI_CHOICE_STR ), 
				index);
		clickById(answer_id, String.format("Answer #%d", index));
	}
	
	/*********
	 * Clicks the Next Button
	 * @throws Exception
	 */
	public void clickNext() throws Exception{
		click(next, "Next");
	}
	
	public void clickSubmit() throws Exception{
		click(submit, "Submit");
	}
	
	public void selectAnswerFromYaml(String yaml){
		
	}
	
	public void selectAnswerFromQuestion(){
		//TODO: Get answer from question use flat file and potential DB Connection.
	}

	/**
	 * Complete Quiz From Yamal with no Doubt
	 * @throws Exception
	 */
	public void completeQuizFromYaml() throws Exception {
		completeQuizFromYaml(Confidence.NO_DOUBT);
	}
	
	public void completeQuizFromYaml(Confidence level) throws Exception {
		completeQuestions(true, level);
	}
	
	public void completeLessonAssessmentFromYaml() throws Exception {
		completeQuestions(false, null);
	}
	
	public void completeLessonAssessment() throws Exception{
		completeQuestions(false, null);		
	}
	
	private void completeQuestions(boolean quiz, Confidence level) throws Exception{
		/* TODO: REMOVE THIS Block Comment
		 * if(!quiz){
			System.out.println();
		}*/
		this.waitForPageLoad();
		int numberOfQuestions = this.getNumberOfQuestions();
		if ( numberOfQuestions < 1 ){
			System.out.println("");
			throw new Exception("Number of questions could not be determined.");
		}
		int num = this.getQuestionNumber();
		String text = null; 
		for(int i = num; i <= numberOfQuestions; i++){
			Thread.sleep(250);
			
			this.waitForPageLoad();
			if (text == this.getQuestion()){
				//this.waitForTextNotOnPage
				this.waitUntilTextChanges(question, text);
				
			}
			text = this.getQuestion();
			
			selectAnswerFromYaml();
			
			if( quiz ) {
				clickLevelOfConfidence(level);
				clickNext();
			}else{ //Lesson Answer Submit
				if (!isSubmitEnabled()){
					this.logErrorToReporter("Submit button not enabled", new Exception());
				}
				clickSubmit();
				if (i != numberOfQuestions)
					this.waitUntilTextChanges(question, text);
			}
			System.out.println();
		}
	}

	public boolean isSubmitEnabled() throws Exception {
		boolean enabled = this.elementIsEnabled(submit);
		
		return enabled;
	}

	public void clickLevelOfConfidence(Confidence level ) throws Exception{
		switch(level){
		case GUESS:
			click(just_a_guess, "Just a Guess");
		case SURE:
			click(pretty_sure, "Pretty Sure");
		case NO_DOUBT:
			click(no_doubt, "No Doubt");
			default:
				
		}
	}
	public enum Confidence{
		GUESS, SURE, NO_DOUBT;
		
	}
	
	public int getQuestionNumber() throws Exception{
		return getQuestionStepDetail(true);
	}
	
	public int getNumberOfQuestions() throws Exception{
		return getQuestionStepDetail(false);
	}
	
	private static final String QUESTION_REGEX = "(\\d+) (?:[o|O][f|F]) (\\d+)";
	private int getQuestionStepDetail(boolean question_number) throws Exception{
		this.waitForPageLoad();
		String text = new String();
		String key = new String();
		int over = 0;
		do{
			text = this.getText(questionNumber);
		
			int index = (question_number? 1 : 2);
			key = getValueFromPattern(text, QUESTION_REGEX, index);
			if(over > 2){
				throw new Exception("Could not locate number of questions.");
			}
			over++;
		}while(key == null);
		return Integer.valueOf(key);
	}
}
