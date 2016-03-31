package com.mop.qa.testbase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class ReusableComponents {
		
	public static Calendar calendarContent = Calendar.getInstance();
	
	public static final String US_DATE_FORMAT = "MM/dd/yyyy";
	
	public static String getCourseName() {

		String cname = "C_" + getFormattedDate("yyyyMMdd_HHmmss");
		return cname;
		
	}
	 
    public static String getFormattedDate(String format){
		//TODO: in testing.
		//DateFormat dateFormat = new SimpleDateFormat(format);
		//return dateFormat.format(new Date());
		return getFormattedDate(format, null);
		
	}
    
    /**
     * Allows you to add x number of (Month, Day, Year) to the current date
     * and print it as a formated string
     * 
     * NOTE: only one instance of Month, Day, and Year can be in the calendarUpdate
     * key set. Key refers to "Calendar.DAY_OF_MONTH", "Calendar.MONTH" 
     * from Calendar Class
     * 
     * @param format
     * @param calendarUpdate
     * @return
     */
    public static String getFormattedDate(String format, Map<Integer,Integer> calendarUpdate  ){
    	DateFormat dateFormat = new SimpleDateFormat(format);
    	Calendar calendar = Calendar.getInstance();
    	
    	calendar.setTime(new Date());
    	
    	if ( calendarUpdate != null){
	    	for(int key : calendarUpdate.keySet()){
	    		calendar.add(key, calendarUpdate.get(key));
	    	}
    	}
    	return dateFormat.format(calendar.getTime());
    }
    
    public static String getFormattedDate(String format, int key, int number){
    	DateFormat dateFormat = new SimpleDateFormat(format);
    	//Calendar calendar = Calendar.getInstance();
    	
    	//calendar.setTime(new Date());
    	calendarContent.setTime(new Date());
    	
    	//Key refers to "Calendar.DAY_OF_MONTH" or "Calendar.MONTH"
    	//Part of Calendar Class
    	calendarContent.add(key, number);
    	return dateFormat.format(calendarContent.getTime());
    }
    
    
    
}
