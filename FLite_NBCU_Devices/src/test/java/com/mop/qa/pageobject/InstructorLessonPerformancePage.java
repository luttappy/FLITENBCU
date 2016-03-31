package com.mop.qa.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.testbase.PageBase_Appium;

public class InstructorLessonPerformancePage extends PageBase_Appium {
	
	@FindBy(xpath= ("//div[@class='metric__stats-bubble--message']//span//span"))
	protected WebElement clsAvgSc;
	
	@FindBy(xpath = ("//div[@class='metric__spotlight']//div[1]//div[1]//div[4]//div[1]"))
	protected WebElement perfSc;
	
	@FindBy(xpath = ("//div[@class='metric__spotlight']//div[1]//div[2]//div[4]//div[1]"))
	protected WebElement confSc;
	
	@FindBy(xpath = ("//div[@class='metric__spotlight']//div[1]//div[3]//div[4]//div[1]"))
	protected WebElement timeSpent;
	
	@FindBy(xpath = ("//div[@id='metric_2']//div[2]//div[1]//div[1]//div[2]//div[2]//div[1]//div[1]//div[2]//div[1]"))
	protected WebElement topOnePerfSc;
	
	@FindBy(xpath = ("//div[@id='metric_2']//div[2]//div[1]//div[1]//div[2]//div[3]//div[1]//div[1]//div[2]//div[1]"))
	protected WebElement topOneStudConf;
	
	@FindBy(xpath = ("//div[@id='metric_2']//div[2]//div[1]//div[1]//div[2]//div[4]//div[1]//div[1]//div[2]//div[1]"))
	protected WebElement topOneStudTmSp;	
	
	
	@FindBy(xpath = ("//div[@id='metric_2']//div[2]//div[1]//div[1]//div[3]//div[2]//div[1]//div[1]//div[2]//div[1]"))
	protected WebElement topTwoPerfSc;
	
	@FindBy(xpath = ("//div[@id='metric_2']//div[2]//div[1]//div[1]//div[3]//div[3]//div[1]//div[1]//div[2]//div[1]"))
	protected WebElement topTwoStudConf;
	
	@FindBy(xpath = ("//div[@id='metric_2']//div[2]//div[1]//div[1]//div[3]//div[4]//div[1]//div[1]//div[2]//div[1]"))
	protected WebElement topTwoStudTmSp;
	
	@FindBy(xpath = ("//div[@id='metric_2']//div[2]//div[1]//div[1]//div[4]//div[2]//div[1]//div[1]//div[2]//div[1]"))
	protected WebElement topThreePerfSc;
	
	@FindBy(xpath = ("//div[@id='metric_2']//div[2]//div[1]//div[1]//div[4]//div[3]//div[1]//div[1]//div[2]//div[1]"))
	protected WebElement topThreeStudConf;
	
	@FindBy(xpath = ("//div[@id='metric_2']//div[2]//div[1]//div[1]//div[4]//div[4]//div[1]//div[1]//div[2]//div[1]"))
	protected WebElement topThreeStudTmSp;
	
	@FindBy(xpath = ("//div[@id='metric_3']//div[2]//div[1]//div[2]//div[2]//div[1]//div[1]//div[1]//div[2]//div[1]"))
	protected WebElement firstStudSc;
	
	
    public String getClassAvgScore() throws Exception{
		
		String classAvgSc = getText(clsAvgSc,"Total class average score");
		return classAvgSc;			
		}
    
    public String getLowestPerfScore() throws Exception{
		
		String lowestPerfSc = getText(perfSc,"Lowest Performance scored");
		return lowestPerfSc;			
		}
 
     public String getHighestConf() throws Exception {
    	 String highestConfStuds = getText(confSc, "Highest confused students");
		return highestConfStuds;
    	 	 
     }
     
     public String getLongestTimeSp() throws Exception {
    	 String longestTimeSp = getText(confSc, "Longest time spent on the topic");
		return longestTimeSp;
    	 	 
     }
     
     //Topics
     
    /* Performance Scores*/
     
     public String getPerfSconTopOne() throws Exception{
 		String PerfScTopOne = getText(topOnePerfSc, "Time spent on first topic");
 		return PerfScTopOne;
 	}

 	 public String getPerfSconTopTwo() throws Exception{
 		String PerfScTopTwo = getText(topTwoPerfSc, "Time spent on first topic");
 		return PerfScTopTwo;
 	}
 	
 	 public String getPerfSconTopThree() throws Exception{
 		String PerfScTopThree = getText(topThreePerfSc, "Time spent on first topic");
 		return PerfScTopThree;
 	}
     
 	 /* Confusion */
 	 
 	 
     public String getStudConfonTopOne() throws Exception{
 		String studConfTopOne = getText(topOneStudConf, "Time spent on first topic");
 		return studConfTopOne;
 	}

 	 public String getStudConfonTopTwo() throws Exception{
 		String studConfTopTwo = getText(topTwoStudConf, "Time spent on first topic");
 		return studConfTopTwo;
 	}
 	
 	 public String getStudConfonTopThree() throws Exception{
 		String studConfTopThree = getText(topThreeStudConf, "Time spent on first topic");
 		return studConfTopThree;
 	}
 	 
 	
 	  /*Time Spent*/
 	 
 	 public String getTimeSponTopOne() throws Exception{
  		String TimeSponTopOne = getText(topOneStudTmSp, "Time spent on first topic");
  		return TimeSponTopOne;
  	}
 	 
 	public String getTimeSponTopTwo() throws Exception{
  		String TimeSponTopTwo = getText(topTwoStudTmSp, "Time spent on first topic");
  		return TimeSponTopTwo;
  	}
 	
 	public String getTimeSponTopThree() throws Exception{
  		String TimeSponTopThree = getText(topThreeStudTmSp, "Time spent on first topic");
  		return TimeSponTopThree;
  	}
 	 
     
 	//Student Scores
 	
 	
 	public String getStudOneCorrectAnsPerc() throws Exception {
 		String studOneAnsPerc = getText(firstStudSc, "First Student correct ans percentage");
 		return studOneAnsPerc;
 		
 	}
     
 

}

