package com.mop.qa.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mop.qa.testbase.PageBase_Appium;
import com.mop.qa.testbase.ReusableComponents;

import android.text.TextUtils;



public class CanvasCoursesPage extends PageBase_Appium {
	/*
	@FindBy(xpath= ("//li[@class='section section-tab-hidden']//a[@class='modules']"))
	protected WebElement modTab;
	*/
	
	@FindBy(className= ("modules"))
	protected WebElement modTab;
	
	@FindBy(xpath = ("//button[@class='btn btn-primary add_module_link']"))
	protected WebElement addModBtn;
	
	@FindBy(id = "context_module_name")
	protected WebElement modNmTxtBx;
	
	@FindBy(xpath = ("//button[contains(text(),'Add Module')]"))
	protected WebElement addModSubmitBtn;
	
	@FindBy(className = "icon-unpublish")
	protected WebElement publishIcon;
	
	@FindBy(xpath = ("//div[@id='context_modules']/div[1]/div[1]/div[3]/button[1]"))
	protected WebElement plusIcon;
	
	@FindBy(id = "add_module_item_select")
	protected WebElement addDD;
	
	@FindBy(xpath = ("//a[contains(text(),'SherpathApp')]"))
	protected WebElement externalAppLink;	

	@FindBy(xpath = ("//div[@id='context_external_tools_select']//table[1]//tbody[1]//tr[4]//td[1]//input"))
	protected WebElement newTabChkBtn;
	
	@FindBy(xpath = ("//button[@class='add_item_button btn btn-primary ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']//span[contains(text(),'Add Item')]"))
	protected WebElement addItemBtn;
	
	@FindBy(xpath = ("//div[@class='ig-admin']//span[@title='Publish']"))
	protected WebElement modPublishIcon;
	
	@FindBy(xpath = ("//div[@class='ig-row   ig-published']//div[@class='ig-title module-item-title ellipsis']//span[@class='item_name']//a"))
	protected WebElement instModuleItem;
	
	@FindBy(xpath = ("//div[@class='ig-row  ig-published student-view']//div[@class='ig-title module-item-title ellipsis']//span[@class='item_name']//a"))
	protected WebElement studModuleItem;
	/*
	@FindBy(xpath = (".//*[@id='header']/div[1]/div/div[1]/div"))
	//*[@id="context_module_item_8716138"]/div/div[1]/span[2]/a
	protected WebElement moduleItem;
	*/
	
	@FindBy(xpath = ("//button[@class='btn']"))
	protected WebElement loadAppNewWindwBtn;
	
	@FindBy(className = "settings")
	protected WebElement settngTab;
	
	@FindBy(id = "tab-tools-link")
	protected WebElement appsLink;
	
	@FindBy(xpath = ("//a[contains(text(),'View App Configurations')]" ))
	protected WebElement appConfigBtn;
	
	@FindBy(xpath = ("//a[contains(text(),'Add App')]"))
	protected WebElement addAppBtn;
	
	@FindBy(xpath = ("//input[@placeholder='Name']"))
			//("/html/body/div[5]/div/div/div/form/div[1]/div[2]/div/div[1]/label/input"))
	protected WebElement nameTxtBx;
	
	@FindBy(xpath = ("//input[@data-reactid='.3.0.0.1.0.1.0.1.0.0.0.1']"))
	protected WebElement consumerKeyTxtBx;
	
	@FindBy(xpath = ("//input[@placeholder='Shared Secret']"))
	protected WebElement secretTxtBx;
	
	@FindBy(xpath = ("//input[@placeholder='Launch URL']"))
	protected WebElement launchUrlTxtBx;
		
	@FindBy(xpath = ("//select[@class='form-control input-block-level']"))
	protected WebElement privacyDD;
	
	@FindBy(xpath = ("//button[contains(text(),'Submit')]"))
	protected WebElement submitBtn;
	
	@FindBy(className = "btn")
	protected WebElement loadSherPath;
	
	@FindBy(xpath = ".//*[@id='section-tabs']/li[6]/a")
	protected WebElement peopleTab;
	
	@FindBy(id = "addUsers")
	protected WebElement addPeopleBtn;
	
	@FindBy(id = "user_list_textarea")
	protected WebElement userListTxtBx;
	
	@FindBy(id = "next-step")
	protected WebElement nxtBtn;
	
	@FindBy(id= "createUsersAddButton")
	protected WebElement addUsersBtn;
	
	@FindBy(xpath = ("//div[@class='form-controls']//button[2]"))
	protected WebElement doneBtn;	
	
	@FindBy(id = "global_nav_profile_link")
	protected WebElement accounTab;
	
	@FindBy(xpath = "//*[@class='ReactTray__link-list']/li[6]/form/a/span")
	protected WebElement canvasLogout;
	
	@FindBy(id="customFields")
	protected WebElement customFields;
	
	String EXTERNAL_APP_XPATH_FORMAT = ("//a[contains(text(),'%s')]");
	
	public ReusableComponents rc;
	
	public void createAppModule() throws Exception {
		createApp();
		createModule();
	}
	
	
	public void createModule(String moduleName, String externalLinkName) throws Exception{
		click(modTab, "Click on Modules ");
		System.out.println("module tab clicked");
		//Thread.sleep(2000);
		this.clickUntilAnotherElementIsVisible(addModBtn, modNmTxtBx, "Click on Add Modules");
		
		System.out.println("plus button clicked");
		sendKeys(modNmTxtBx, moduleName);
		click(addModSubmitBtn, "Click on Submit button");
		click(publishIcon, "Click on Publish icon");
		click(plusIcon,"Click on plus icon");
		selectValue(addDD,"External Tool");
		
		String externalAppLink = String.format(EXTERNAL_APP_XPATH_FORMAT, externalLinkName);
		click(externalAppLink, String.format("Click on %s Link", externalLinkName));
		
		click(newTabChkBtn, "Click on Load in a new Tab");
		click(addItemBtn,"Click on Add Item");
		click(modPublishIcon,"Publish Module" );
		click(instModuleItem, "Click on the app created");
		//click(loadAppNewWindwBtn, "Click Load App in a new window button");
		//launchSherpath();
		//Thread.sleep(3000);
		
	}


	public void createModule() throws Exception{
		click(modTab, "Click on Modules ");
		System.out.println("module tab clicked");
		//Thread.sleep(2000);
		clickUntilAnotherElementIsVisible(addModBtn, modNmTxtBx, "Click on Add Modules");
		System.out.println("plus button clicked");
		sendKeys(modNmTxtBx, "SherpathMod");
		click(addModSubmitBtn, "Click on Submit button");
		click(publishIcon, "Click on Publish icon");
		click(plusIcon,"Click on plus icon");
		selectValue(addDD,"External Tool");
		click(externalAppLink, "Click on SherpathApp Link");
		click(newTabChkBtn, "Click on Load in a new Tab");
		click(addItemBtn,"Click on Add Item");
		click(modPublishIcon,"Publish Module" );
		click(instModuleItem, "Click on the app created");
		//click(loadAppNewWindwBtn, "Click Load App in a new window button");
		//launchSherpath();
		Thread.sleep(3000);
//		switchToWindowTitle();
		
						
	}
	
	
	public void createApp() throws Exception {
		click(settngTab, "Click on Settings ");
		click(appsLink, "Click on Apps ");
		click(appConfigBtn, "Click on View Apps Configurations ");
		click(addAppBtn, "Click on Add App ");
		sendKeys(nameTxtBx, "SherpathApp");
		sendKeys(consumerKeyTxtBx, "keycanvas");
		sendKeys(secretTxtBx, "secret");
		sendKeys(launchUrlTxtBx, "http://qa.oauthapi.eols.io/oauth/launch");
		selectValue(privacyDD,"Public");
		click(submitBtn,"Click on Submit");
		
	}
	
	public void createApp(String app_name, String launch_URL, String custom_fields ) throws Exception {
		click(settngTab, "Click on Settings ");
		click(appsLink, "Click on Apps ");
		click(appConfigBtn, "Click on View Apps Configurations ");
		click(addAppBtn, "Click on Add App ");
		sendKeys(nameTxtBx, app_name);
		sendKeys(consumerKeyTxtBx, "keycanvas");
		sendKeys(secretTxtBx, "secret");
		sendKeys(launchUrlTxtBx, launch_URL);
		sendKeys(customFields, custom_fields);
		selectValue(privacyDD,"Public");
		click(submitBtn,"Click on Submit");		
	}
	
	public void navigateToCoursePage(String courseName) throws Exception{
    	
    	String courseXpath = "//span[@class='name'][contains(text(),'"+courseName+"')]";
    	click(courseXpath, courseName);
    	
	}
	
	//student navigate and launch Sherpath
	public void navigateToSherpath() throws Exception{
		click(modTab, "Click on Modules ");
		click(studModuleItem, "Click on the module Item");
		launchSherpath();
		Thread.sleep(5000);
//		switchToWindowTitle();
		
	}

	
	
	public void launchSherpath() throws Exception {
	
		String browser  = getAppProperties("webBrowser");
		clickNewWindow(loadSherPath, "Click on Load SherPath");
		if(browser.equalsIgnoreCase("firefox"))
		{
			clickAlert();
		}
		switchToWindowTitle(); 
	}
	
	public void navigateToAddPeople() throws Exception {
		elementIsDisplayed(peopleTab,"Add people link exist");
		Thread.sleep(2000);
		click(peopleTab, "Click on peoples tab");
	}

	public void addStudent(List<String> studUserName) throws Exception{
		elementIsDisplayed(addPeopleBtn,"add people button exist");
		click(addPeopleBtn, "Click on add people button");
		String studNameList = studUserName.toString().replace("[", "").replace("]", "").replace(", ", ",");
		enterText(userListTxtBx,studNameList,"Enter Student name");
		click(nxtBtn, "Click on peoples tab");
		Thread.sleep(2000);
		click(addUsersBtn, "Click on peoples tab");
		Thread.sleep(2000);
		click(doneBtn, "Click on peoples tab");
		Thread.sleep(1000);
		
	}
	
	//what is this for??
public String getStudentEmail(){
	    String cname = rc.getCourseName();
		String studentEmail = "S_" + cname + "@yopmail.com";
		return studentEmail;
	}
	
public void Canvaslogout() throws Exception {
	clickNewWindow(accounTab,"Click on Account");
	Thread.sleep(2000);
	click(canvasLogout, "Logout Parent window");
	
}
	
	public void clickLoadApp() throws Exception {
		click(loadAppNewWindwBtn, "Load App in New Window");
	}
	
	
	

}
