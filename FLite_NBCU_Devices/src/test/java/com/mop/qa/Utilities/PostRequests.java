/**
 * 
 */
package com.mop.qa.Utilities;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;

import com.mop.qa.testbase.ReusableComponents;
/**
 * @author bookere
 *
 */
public class PostRequests {
	private String url;
	private Map<String,String> parameters;
	private Map<String,String> header;
	
	public PostRequests(){
		url = new String();
		parameters= null;
		header = null;
	}
	
	public PostRequests(String url, String parameters){
		this(url, PostRequests.seperateFormData(parameters));
		
	}
	public PostRequests(String url, Map<String,String> parameters){
		this();
		this.setUrl(url);
		this.setParameters(parameters);
	}
	
	public PostRequests(String url, String parameters, String header){
		this(url, parameters);
		this.setHeader(header);
	}
	
	public PostRequests(String url, Map<String,String> parameters, String header){
		this(url, parameters);
		this.setHeader(header);
	}
	
	public PostRequests(String url, Map<String,String> parameters, Map<String,String> header){
		this(url, parameters);
		this.setHeader(header);
	}
	public void PostMessageRequests(){
		PostMessageRequests(url, parameters, header);
	}
	
	public static void PostMessageRequests(String url, Map<String,String> parameters) {
		PostMessageRequests(url, parameters, null);
	}
	
	/**
	 * 
	 */
	public static void PostMessageRequests(String url, Map<String,String> parameters, Map<String,String> header) {
		HttpClient httpClient = new HttpClient();
	    PostMethod postMethod = new PostMethod(url);
	    
	    if ( header != null){
	    	for(String key : header.keySet()){
	    		postMethod.addRequestHeader(key, header.get(key));	    		
	    	}	    	
	    }
	    
	    for(String key : parameters.keySet()){
	    	postMethod.addParameter(key, parameters.get(key));
	    }
	    
	    try {
	        httpClient.executeMethod(postMethod);
	        String resp = new String();
	        int code = postMethod.getStatusCode();
	        if (postMethod.getStatusCode() == HttpStatus.SC_MOVED_TEMPORARILY) {
		        resp = postMethod.getResponseBodyAsString();
		    } else {
		        System.out.println(postMethod.getStatusLine());
		    }
	        
	        System.out.println(resp);
	    } catch (HttpException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public static Map<String,String> buildHeader(String h_string){
		Map<String,String> map = new HashMap<String,String>();
		
		for(String param : h_string.split("&")){
			String[] value = param.split(":");
			map.put(value[0], (value.length != 2 ? "" : value[1]));			
		}
		return map;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String FORMAT_STRING = "yyyyMMddHHmmss";
		String incstring = ReusableComponents.getFormattedDate(FORMAT_STRING);
		
		long start = System.currentTimeMillis();
		//983953887.1457966729
		//470498731.1457110787
		//000000000.1457968740 015
		String email = "test"+ incstring +"%40mailinator.com";
		System.out.println(email.replaceAll("%40", "@"));
		String url = "https://www.canvaslms.com/forms/processing.php";
		
		String data = "form_type=fft-canvas-form"
				+ "&lead_source_description__c=canvas.instructure.com_fft_canvas_+FFT_Canvas"
				+ "&lead_source=Free_For_Teacher_Request"
				+ "&disable_integrations=1"
				+ "&Campaign_ID=701A0000000u5Xc"
				+ "&member_status=Responded"
				+ "&City_Address__c=Miamisburg"
				+ "&State_Address__c=Ohio"
				+ "&Country_Address__c=United+States"
				+ "&MARUID__c=" + start//470498731.1457110787"
				+ "&demo_site_name=Professor+QA"
				+ "&user[terms_of_use]=1"
				+ "&locale=en"
				+ "&alt_contact="
				+ "&org_type__c=Higher+Ed"
				+ "&title=Teacher/Instructor"
				+ "&company=Super+University"
				+ "&firstname=Professor"
				+ "&lastname=QA"
				+ "&phone=2154123142"
				+ "&email=" + email.replaceAll("%40", "@")
				+ "&location=United+States+and+Canada"
				+ "&user[terms_of_use]=1";
		
		Map<String,String> hash = seperateFormData(data);//new HashMap<String, String>();
		PostRequests postRequests = new PostRequests(url, hash);
		
		postRequests.PostMessageRequests();
		
		String head_string =new String();
		head_string = 
				"Accept:text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8"+
				"&Accept-Encoding:gzip, deflate"+
				"&Accept-Language:en-US,en;q=0.8"+
				"&Cache-Control:max-age=0"+
				"&Connection:keep-alive"+
				"Upgrade-Insecure-Requests: 1" +
				//"&Content-Length:593"+
				"&Origin: https://www.canvaslms.com" +
				"&Content-Type:application/x-www-form-urlencoded" //+
				//"&Referer: https://www.canvaslms.com/try-canvas?lead_source_description=canvas.instructure.com_fft_canvas_&__hstc=199188080.60d192bc43ff412ddd43d97c30a95905.1457966751300.1457966751300.1457966751300.1&__hssc=199188080.1.1457966751301&__hsfp=797238374"
				;
		
				email = "test"+ ReusableComponents.getFormattedDate(FORMAT_STRING) +"%40mailinator.com";
		String[] second_form ={"form_type:fft-canvas-form",
				"lead_source_description__c:canvas.instructure.com_fft_canvas_+FFT_Canvas",
				"lead_source:Free_For_Teacher_Request",
				"disable_integrations:1",
				"Campaign_ID:701A0000000u5Xc",
				"member_status:Responded",
				"City_Address__c:Miamisburg",
				"State_Address__c:Ohio",
				"Country_Address__c:United+States",
				"MARUID__c:" + start,//470498731.1457110787",
				"demo_site_name:UNI+Prof",
				"user[terms_of_use]:1",
				"locale:en",
				"alt_contact:",
				"org_type__c:Higher+Ed",
				"title:Teacher Instructor",
				"company:Some+School",
				"firstname:UNI",
				"lastname:Prof",
				"phone:3023211234",
				"email:" + email.replaceAll("%40", "@"),
				"location:United+States+and+Canada",
				"user[terms_of_use]:1"
		};
		Map<String,String> header_hash = seperateFormData(second_form);
		postRequests = new PostRequests(url, header_hash, head_string);
		System.out.println(email);
		postRequests.PostMessageRequests();

		
	}
	
	public static Map<String, String> seperateFormData(String data){
		Map<String,String> map = new HashMap<String,String>();
		String[] test = data.split("&");
		for(String param : data.split("&")){
			String[] value = param.split(":");
			map.put(value[0], (value.length != 2 ? "" : value[1]));			
		}
		return map;
	}
	
	public static Map<String, String> seperateFormData(String[] data){
		Map<String,String> map = new HashMap<String,String>();
		for(String param : data){
			String[] value = param.split(":");
			map.put(value[0], (value.length != 2 ? "" : value[1]));			
		}
		return map;
	}
	
	/**
	 * @return the parameters
	 */
	public Map<String,String> getParameters() {
		return parameters;
	}

	/**
	 * @param parameters the parameters to set
	 */
	public void setParameters(Map<String,String> parameters) {
		this.parameters = parameters;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the header
	 */
	public Map<String,String> getHeader() {
		return header;
	}

	/**
	 * @param header the header to set
	 */
	public void setHeader(String header) {
		Map<String,String> map = new HashMap<String,String>();
		
		for(String param : header.split("&")){
			String[] value = param.split(":");
			map.put(value[0], (value.length != 2 ? "" : value[1]));			
		}
		this.header = map;
	}
	
	public void setHeader(Map<String,String> header){
		this.header = header;
	}

}
