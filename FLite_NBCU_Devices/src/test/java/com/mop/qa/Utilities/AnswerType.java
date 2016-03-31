package com.mop.qa.Utilities;

public enum AnswerType {
	SINGLE ("single"), MULTIPLE ("multiple"), SOUND("sound"), REORDER ( "reorder" ), LABEL ("lable"), DRAG ("drag");
	
	private final String name;
	
	AnswerType(String name){
		this.name = name;
	}
	
	public String valueOf(){
		
		return name;
	}
}
