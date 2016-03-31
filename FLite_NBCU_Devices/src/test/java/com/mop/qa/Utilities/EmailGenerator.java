package com.mop.qa.Utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.json.JSONException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class EmailGenerator {
	public EmailGenerator(){
		setEmailMap(new HashMap<Integer, UserEmail>());
		setEmailPattern(new String());
		setNumberOfUsers(0);
		this.setRequestLocation(false);
	}
	private boolean local;
	
	public EmailGenerator(String pattern, int number_of_users){
		this();
		//email_pattern = pattern;
		setNumberOfUsers(number_of_users);
		
	}
	public int getNumberOfUsers() {
		return number_of_users;
	}

	public void setNumberOfUsers(int number_of_users) {
		this.number_of_users = number_of_users;
	}
	public Map<Integer, UserEmail> getEmailMap() {
		return emailMap;
	}

	public void setEmailMap(Map<Integer, UserEmail> emailMap) {
		this.emailMap = emailMap;
	}
	public String getEmailPattern() {
		return email_pattern;
	}

	public void setEmailPattern(String email_pattern) {
		this.email_pattern = email_pattern;
	}
	private Map<Integer, UserEmail > emailMap;
	private String email_pattern;
	private int number_of_users;
	
	private String generateEmailAddress(){
		return generateEmailAddress(this.getEmailPattern());
	}
	
	private static final String DEFAULT_EMAIL_FORMAT = "yyMMddhhmmssSSS";
	private static String generateEmailAddress(String email_pattern){
		return	generateEmailAddress(email_pattern, DEFAULT_EMAIL_FORMAT);	
	}
	
	private static String generateEmailAddress(String email_pattern, String emailFormat ){
		if ( email_pattern == null){
			email_pattern = "test@mailinator.com";
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(emailFormat);
		
		String strDate = dateFormat.format(new Date());
		
		return new String(email_pattern.replaceFirst("@",strDate + "@"));
	}
	
	private static String[]firstnames = { "Joe", "Jack", "Mark", "Devi","Sue", "Jose", "Aarav", "Pranav","Veer","Myra","George", "Steven", "Aditya", "Arjun", "Sai", "Arnav", 
			"Krishna", "Yui", "Rio", "Hina", "Saki", "Trang", "Linh", "Tha", "Garrett", "Saito"};
	
	private static String[]lastnames = {"Patel", "Smith", "Cruz", "Johnson", "Taylor", "Harris", "Young" , "Hernandez", "King", "Wright", "Lopez", "Rocha"};
	
	public static String generateEmailUser(boolean local){
		if ( local ){
			return generateName();
		}else{
			return generateNameFromRandomUser();			
		}
	}
			
	private static String generateNameFromRandomUser(){
		String name = new String();
		String json;
		try {
			json = sendGet(null);
			name = getNameFromJson(json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return name;
	}
	
	private static String generateName(){
		Random rand = new Random();
		int randomFirst = rand.nextInt(firstnames.length);
		int randomLast = rand.nextInt(lastnames.length);
		String first = firstnames[randomFirst];
		String last = firstnames[randomLast];
		
		String names = String.format("%s %s" , first, last);
		
		return names;
	}
	
	private final static String USER_AGENT = "Mozilla/5.0";
	private static String sendGet(String url) throws Exception {

		if (url== null)
			url = "https://randomuser.me/api/";
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		//int responseCode = con.getResponseCode();
		//System.out.println("\nSending 'GET' request to URL : " + url);
		//System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//System.out.println(response.toString());
		
		return response.toString();
		
		
	}
	
	private static String getNameFromJson(final String json) throws JSONException{
		JsonObject name = new JsonParser().parse(json).getAsJsonObject()
									.get("results").getAsJsonArray().get(0)
											.getAsJsonObject().get("user")
											.getAsJsonObject().get("name")
											.getAsJsonObject();
		
		String first = name.get("first").toString().replaceAll("\"", "");
		String last =  name.get("last").toString().replaceAll("\"", "");
		
		String str_name = String.format("%s %s", 
				(first.substring(0, 1).toUpperCase() + first.substring(1).toLowerCase()),
				(last.substring(0, 1).toUpperCase() + last.substring(1).toLowerCase()));
		
		return str_name;
		
	}
	
	
	public static void main(String[] args){
		EmailGenerator eg = new EmailGenerator();
		try {
			String json = EmailGenerator.sendGet(null);
			String name = EmailGenerator.getNameFromJson(json);
			System.out.println(name);
			String generatedName = EmailGenerator.generateName();
			System.out.println(generatedName);
			String email = EmailGenerator.generateEmailAddress("t@mailinator.com");
			System.out.println(email);
			int number_of_users = 5; 
			eg.setNumberOfUsers(number_of_users);
			eg.setEmailPattern("t@mailinator.com");
			eg.buildUsers();
			
			System.out.println(eg.getCanvasFormatedUsers());
			eg.printAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.exit(0);
	}
	
	public void printAll(){
		if (this.emailMap.isEmpty()){
			return;
		}
		
		for (Map.Entry<Integer, UserEmail> entry : emailMap.entrySet()) {
		    System.out.println("|"+ entry.getKey() + "|" +  ": " + entry.getValue().getCanvasFormat());
		}
	}
	
	public String getCanvasFormatedUsers(){
		List<String> list = new ArrayList<String>();
		if (this.emailMap.isEmpty()){
			return "";
		}
		
		for (Map.Entry<Integer, UserEmail> entry : emailMap.entrySet()) {
			list.add(entry.getValue().getCanvasFormat());
		}
		
		String value =  list.toString().replaceAll("[\\[\\]]","");
		return value;
	}
	
	public void buildUsers(String emailPattern) {
		this.setEmailPattern(emailPattern);
		buildUsers();
	}
	
	public void buildUsers() {
		if (number_of_users < 1 || getEmailPattern() == "")
			return;
		for (int i = 0; i < this.getNumberOfUsers(); i++){
			this.getEmailPattern();
			String email = this.generateEmailAddress();
			///System.out.println(email);
			String name = EmailGenerator.generateEmailUser(isLocal());
			emailMap.put(i, new UserEmail( name, email));
		}
	}
	
	private boolean isLocal() {
		return local;
	}
	public void setRequestLocation(boolean local) {
		this.local = local;
	}
}


