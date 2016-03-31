package com.mop.qa.Utilities;

public class Answer {

	public Answer() {
		setType(null);
		setAnswers(null);
	}
	
	public Answer(AnswerType type, Object answer){
		this();
		this.setType(type);
		this.setAnswers(answer);
	}
	
	/**
	 * @return the type
	 */
	public AnswerType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(AnswerType type) {
		this.type = type;
	}

	/**
	 * @return the answers
	 */
	public Object getAnswers() {
		return answers;
	}

	/**
	 * @param answers the answers to set
	 */
	public void setAnswers(Object answers) {
		this.answers = answers;
	}

	private AnswerType type;
	private Object answers;
}
