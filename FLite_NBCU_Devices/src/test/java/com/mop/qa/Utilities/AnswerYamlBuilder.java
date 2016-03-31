package com.mop.qa.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class AnswerYamlBuilder {

	private Map<String, Map<String, Object>> answers;
	//private Map<String, Map<String, String>> answers_map;
	public AnswerYamlBuilder() {
		setAnswers(new HashMap<String, Map<String, Object>>());
	}
	
	private String yaml_file = "Alterations in Oxygenation and Perfusion";
	public AnswerYamlBuilder(String yaml_file){
		this.setYamlFile(yaml_file);
	}
	
	public void setYamlFile(String yaml_file) {
		this.yaml_file = yaml_file;
	}

	public void buildAnswerSheet(){
		this.setAnswers_map(buildAnswerSheet(this.getYamlFile()+ ".yaml"));
	}
	
	
	
	@SuppressWarnings("unchecked")
	public static Map<String, Map<String, Object>> buildAnswerSheet(String yaml_file) {
		Map<String, Map<String, Object>> values = new HashMap<String, Map<String,Object>>();
		Yaml yaml = new Yaml();
		try {
			//Map< String, Object> result = (Map< String, Object>) yaml.load(new FileInputStream(new File(yaml_file)));
			//String k = "Which clinical situations indicate that a patient is at high risk for atelectasis?";
			//System.out.println(result);
			//String l = "When assessing a cardiac patient, an irregular, slow heart rate is noted. The nurse understands this symptom may result from which possible etiologies (causes)?";
			//System.out.println(l + "\n" + result.get(l));

			values = (Map<String, Map<String, Object>>) yaml
					.load(new FileInputStream(new File(yaml_file)));
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return values;
	}
	
	private static final String TYPE_ = "type";
	private static final String ANSWERS_ = "answers";
	private static final String ANSWER_ = "answer";
	
	@SuppressWarnings("unchecked")
	public Answer getAnswer(String question) throws Exception{
		if (this.answers.isEmpty()){
			return null;
		}
		
		
		System.out.println("QUESTION: " + question);
		Map<String,String> answers_map = null;
		String answer = new String();
		Map<String, Object> subValues = this.getAnswerMap().get(question);

		if (subValues == null){
			throw new Exception("Answers for QUESTION \"" + question + "\" does not exist. in file."); 
		}
		String type = (String)subValues.get(TYPE_);
		
		switch ( AnswerType.valueOf(type)){
		case SINGLE:
			answer = (String) subValues.get(ANSWER_);
			return new Answer(AnswerType.valueOf(type),  answer);
		case MULTIPLE:
			@SuppressWarnings("unchecked")
			List<String> answers_list = (List<String>) subValues.get(ANSWERS_);
			return new Answer(AnswerType.valueOf(type),  answers_list);//new Answer(AnswerType.valueOf(type), answers_list);
		case SOUND:
			answer = (String) subValues.get(ANSWER_);
			return new Answer(AnswerType.valueOf(type),  answer);//new AnswerSheet( AnswerType.valueOf(type), answer);
		case REORDER:
		case LABEL:
		case DRAG:
			answers_map = (Map<String,String>) subValues.get(ANSWERS_);
			Answer a = new Answer(AnswerType.valueOf(type), answers_map);
			return a;
		default:
				
		}
		
		AnswerType k = AnswerType.LABEL;
		//System.out.println(k.valueOf());
		
		
		return new Answer();
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnswerYamlBuilder test = new AnswerYamlBuilder();
		test.buildAnswerSheet();
		Map<String, Map<String, Object>> values = test.getAnswers();
		//String question = "In addition to chest pain, a patient with a blocked coronary artery may experience which symptoms?";
		
		//Object a = test.getAnswer(question);
		//System.out.println( a.getClass().getSimpleName() + " " + a.toString() );
		//question = "To initiate a normal beat, an organized electrical impulse is generated from which heart chamber?";
		//a = test.getAnswer(question);
		//System.out.println( a.getClass().getSimpleName() + " " + a.toString() );
		
		for (String key : values.keySet()) {
			Map<String, Object> subValues = values.get(key);
			System.out.println(key);

			for (String subValueKey : subValues.keySet()) {
				System.out.println(subValues.get(subValueKey).getClass().getSimpleName());
				if (subValues.get(subValueKey).getClass().isInstance(new ArrayList<String>())){
					System.out.println(String.format(subValueKey));
					System.out.println( subValues.get(subValueKey));
										
				}else{
					System.out.println(String.format("\t%s = %s",
						subValueKey, subValues.get(subValueKey)));
				}
			}
		}

	}
	/**
	 * @return yamlFile
	 */
	public String getYamlFile() {
		return yaml_file;
	}

	/**
	 * @return the answers
	 */
	public Map<String, Map<String, Object>> getAnswers() {
		return answers;
	}

	/**
	 * @param hashMap the answers to set
	 */
	public void setAnswers(HashMap<String, Map<String,Object>> hashMap) {
		this.answers = hashMap;
	}

	/**
	 * @return the answers_map
	 */
	public Map<String, Map<String, Object>> getAnswerMap() {
		return answers;
	}

	/**
	 * @param map the answers_map to set
	 */
	private void setAnswers_map(Map<String, Map<String, Object>> map) {
		this.answers = map;
	}

}
