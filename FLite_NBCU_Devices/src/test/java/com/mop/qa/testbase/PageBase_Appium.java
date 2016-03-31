package com.mop.qa.testbase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.NetworkConnectionSetting;
import io.appium.java_client.ScrollsTo;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.jboss.netty.util.Timeout;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.Assert;

import android.app.Activity;
import android.provider.Browser;
import android.view.WindowManager.LayoutParams;

import com.experitest.client.Client;
import com.mop.qa.Utilities.ReportGenerator;
//import com.mop.qa.pageobject.IWebElement;
import com.mop.qa.test.bvt.TestBase;
import com.mop.qa.test.bvt.TestSuite;

public class PageBase_Appium {

	protected static RemoteWebDriver remoteDriver;
	private static AppiumDriver appiumDriver;
	// private static WebDriver driver;
	private static HtmlUnitDriver htmlUnitDriver;
	protected static Client client = null;
	private static String toolName;

	public PageBase_Appium(AppiumDriver driver) {
		this.appiumDriver = driver;
		PageFactory.initElements(appiumDriver, this);
		toolName = "Appium";
	}

	public PageBase_Appium(RemoteWebDriver driver) {
		this.remoteDriver = driver;
		PageFactory.initElements(remoteDriver, this);
		toolName = "Selenium";
	}

	public PageBase_Appium(HtmlUnitDriver htmlDriver) {
		this.htmlUnitDriver = htmlDriver;
		PageFactory.initElements(htmlUnitDriver, this);
		toolName = "htmlUnitDriver";
	}

	public PageBase_Appium() {
		try {
			if (getAppProperties("tool").equalsIgnoreCase("selenium")) {
				this.remoteDriver = TestBase.remoteDriver;
				PageFactory.initElements(remoteDriver, this);
				toolName = "Selenium";

			} else if (getAppProperties("tool").equalsIgnoreCase("appium")) {
				this.appiumDriver = TestBase.appiumDriver;
				PageFactory.initElements(appiumDriver, this);
				toolName = "Appium";
			} else if (getAppProperties("tool").equalsIgnoreCase("htmlunit")) {
				this.htmlUnitDriver = TestBase.htmlUnitDriver;
				PageFactory.initElements(htmlUnitDriver, this);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Storing time as a constant over the application
	 * We can overload accordingly
	 */
	private static final long default_timeoutInSeconds = 60, default_pollingInMillis = 500;

	protected int count3 = 1;
	protected static int n = 0;
	protected String text1 = null;
	ReportGenerator rg = new ReportGenerator();
	protected Screen screen = new Screen();
	protected String tool = null, appType = null, webBrowser = null, chromeDriverPath = null, fireFoxDriverPath = null,
			deviceName = null, appName = null, appiumPort = null, deviceVersion = null, appPackage = null,
			appActivity = null, Android_Appium_Server_Path = null, appiumPort_Ios = null, devicePlatformName_Ios = null,
			deviceVersion_Ios = null, device_UDID = null, platformName = null, applicationPath = null, appiumURL = null;

	public AppiumDriver launchApp() throws IOException, InterruptedException {
		tool = getAppProperties("tool");
		appType = getAppProperties("appType");
		platformName = getAppProperties("platformName");

		if (tool.equalsIgnoreCase("Appium")) {
			if ((platformName.equalsIgnoreCase("iOS")) && (appType.equalsIgnoreCase("Native"))) {

				appiumPort_Ios = getAppProperties("appiumPort_Ios");
				deviceVersion_Ios = getAppProperties("deviceVersion_Ios");
				device_UDID = getAppProperties("device_UDID");
				applicationPath = getAppProperties("applicationPath");
				appiumURL = "http://127.0.0.1:" + appiumPort_Ios + "/wd/hub";

				DesiredCapabilities capabilities = new DesiredCapabilities();

				capabilities.setCapability("appium-version", "1.0");
				capabilities.setCapability("platformName", platformName);
				capabilities.setCapability("platformVersion", deviceVersion_Ios);
				capabilities.setCapability("deviceName", device_UDID);
				capabilities.setCapability("app", applicationPath);
				if (appiumDriver == null)
					appiumDriver = null;

				appiumDriver = new IOSDriver(new URL(appiumURL), capabilities);

			} else if ((platformName.equalsIgnoreCase("Android")) && (appType.equalsIgnoreCase("Native"))) {

				System.out.println("Android Native");

				appName = getAppProperties("appName");
				deviceVersion = getAppProperties("deviceVersion");
				deviceName = getAppProperties("deviceName");
				appPackage = getAppProperties("appPackage");
				appActivity = getAppProperties("appActivity");
				appiumPort = getAppProperties("appiumPort");
				appiumURL = "http://127.0.0.1:" + appiumPort + "/wd/hub";

				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("appium-version", "1.0");
				capabilities.setCapability("app", appName);
				capabilities.setCapability("platformName", platformName);
				capabilities.setCapability("platformVersion", deviceVersion);
				capabilities.setCapability("deviceName", deviceName);
				capabilities.setCapability("appPackage", appPackage);
				capabilities.setCapability("appActivity", appActivity);

				appiumDriver = new AndroidDriver(new URL(appiumURL), capabilities);
				// }
				appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}

			else if ((platformName.equalsIgnoreCase("Android")) && (appType.equalsIgnoreCase("Web"))) {
				System.out.println("Android Browser");

				deviceVersion = getAppProperties("deviceVersion");
				deviceName = getAppProperties("deviceName");
				appiumPort = getAppProperties("appiumPort");
				appiumURL = "http://127.0.0.1:" + appiumPort + "/wd/hub";

				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
				capabilities.setCapability("newCommandTimeout", "300");
				capabilities.setCapability("appium-version", "1.0");
				capabilities.setCapability("platformName", platformName);
				capabilities.setCapability("deviceName", deviceName);
				capabilities.setCapability("platformVersion", deviceVersion);

				if (appiumDriver == null) {
					appiumDriver = new AndroidDriver(new URL(appiumURL), capabilities);
				}
				appiumDriver.manage().timeouts().implicitlyWait(default_timeoutInSeconds, TimeUnit.SECONDS);
			} else if ((platformName.equalsIgnoreCase("iOS")) && (appType.equalsIgnoreCase("Web"))) {
				System.out.println("iOS Browser");

				deviceVersion = getAppProperties("deviceVersion_Ios");
				deviceName = getAppProperties("device_UDID");
				appiumPort = getAppProperties("appiumPort");
				appiumURL = "http://127.0.0.1:" + appiumPort + "/wd/hub";

				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability("deviceName", "iPhone");
				cap.setCapability("browserName", "Safari");
				cap.setCapability("platformVersion", deviceVersion);
				cap.setCapability("platformName", platformName);
				cap.setCapability("udid", deviceName);

				if (appiumDriver == null) {
					System.out.println("before initializing mobile web");
					System.out.println("before appiumURL ---" + appiumURL);
					appiumDriver = new IOSDriver(new URL(appiumURL), cap);
					System.out.println("after initializing mobile web");
					appiumDriver.get("www.facebook.com");
					System.out.println("after initializing mobile web++");

				}
				System.out.println("after again");
				appiumDriver.manage().timeouts().implicitlyWait(default_timeoutInSeconds, TimeUnit.SECONDS);
			}
		}

		return appiumDriver;
	}

	public WebDriver launchSite() throws Exception {
		webBrowser = getAppProperties("webBrowser");
		if (webBrowser.equalsIgnoreCase("chrome")) {
			chromeDriverPath = getAppProperties("chromeDriverPath");
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--test-type");
			options.addArguments("start-maximized");
			remoteDriver = new ChromeDriver(options);

		} else if (webBrowser.equalsIgnoreCase("firefox")) {
			fireFoxDriverPath = getAppProperties("fireFoxDriverPath");
			File pathToFirefoxBinary = new File(fireFoxDriverPath);
			FirefoxBinary firefoxbin = new FirefoxBinary(pathToFirefoxBinary);
			remoteDriver = new FirefoxDriver(firefoxbin, null);
			remoteDriver.manage().window().maximize();

		} else if (webBrowser.equalsIgnoreCase("htmlunit")) {
			return htmlUnitDriver = new HtmlUnitDriver();
		}
		// remoteDriver.manage().window().maximize();
		remoteDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return remoteDriver;

	}

	protected String getAppProperties(String key) throws IOException {
		String value = "";
		try {

			FileInputStream fileInputStream = new FileInputStream("data.properties");
			Properties property = new Properties();
			property.load(fileInputStream);

			value = property.getProperty(key);

			fileInputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;

	}

	/**
	 * enterUrl is a method used
	 * 
	 * @param url
	 * @throws Exception
	 */
	public void enterUrl(String url) throws Exception {
		try {
			WebDriver driver = getSysDriver(toolName);
			driver.get(url);
		} catch (Exception exc) {
			exc.printStackTrace();

		}
	}

	protected void getTitle() throws Exception {
		System.out.println("--------" + appiumDriver.getTitle());
	}

	protected void clickPoint(WebElement e, String elementName) throws Exception {
		// Point point=e.getLocation();
		int xx = e.getLocation().x;
		int yy = e.getLocation().y;
		// e.getLocation().x;

		System.out.println("X Position : " + xx);
		System.out.println("Y Position : " + yy);
		clickCoordinates(xx, yy);
	}

	/**
	 * Method used to interact with the Sherpath Date Selection
	 * 
	 * @param dates
	 * @param selectDate
	 * @param elementName
	 * @throws Exception
	 */
	protected void selectDate(List<WebElement> dates, String selectDate, String elementName) throws Exception {
		try {

			int total_node = dates.size();
			for (int i = 0; i < total_node; i++) {

				String date = dates.get(i).getText();

				if (date.equals(selectDate)) {

					dates.get(i).click();
					break;
				}
			}

			rg.passTestCase("click on element" + elementName + "" + "successfull");

		} catch (Exception exc) {
			exc.printStackTrace();
			rg.logException("Exception on clicking webelement" + elementName, exc);
		}
	}

	/**
	 * Click method used to
	 * 
	 * @param e
	 * @param elementName
	 * @throws Exception
	 */
	protected void click(WebElement e, String elementName) throws Exception {
		try {
			WebDriver driver = getSysDriver(toolName);
			WebDriverWait wait = new WebDriverWait(driver, default_timeoutInSeconds, 500);
			wait.until(ExpectedConditions.visibilityOf(e));
			wait.until(ExpectedConditions.elementToBeClickable(e));

			e.click();

			rg.passTestCase("click on element " + elementName + "" + " successful");

		} catch (Exception exc) {
			exc.printStackTrace();
			rg.logException("Exception on clicking webelement" + elementName, exc);

		}
	}
	
	protected void clickUntilAnotherElementIsVisible(WebElement e, WebElement e2, String elementName) throws Exception {
		try {
			WebDriver driver = getSysDriver(toolName);
			WebDriverWait wait = new WebDriverWait(driver, default_timeoutInSeconds, 250);
			wait.until(ExpectedConditions.visibilityOf(e));
			
			wait.until(clickUntilNewElementVisible(e, e2, default_timeoutInSeconds, 250 ));
			

			rg.passTestCase("click on element " + elementName + "" + " successful");

		} catch (Exception exc) {
			exc.printStackTrace();
			rg.logException("Exception on clicking webelement" + elementName, exc);

		}
		
		
	}

	protected void clickByCSS(String e, String text) throws Exception {
		try {
			WebDriver driver = this.getSysDriver(toolName);
			switch (toolName) {
			case "Appium":
				// appiumDriver.findElementByCssSelector(e).click();

				List<WebElement> li = driver.findElements(By.cssSelector(e));
				for (WebElement we : li) {
					we.click();
				}

				break;
			case "Selenium":
				driver.findElement(By.cssSelector(e)).click();
				break;
			}
			rg.passTestCase("click on element " + e + "" + " successful");

		} catch (Exception exc) {
			exc.printStackTrace();
			rg.logException("Exception on clicking webelement" + e, exc);

		}

	}

	protected void clickNewWindow(WebElement e, String elementName) throws Exception {
		try {
			WebDriver driver = this.getSysDriver(toolName);
			WebDriverWait wait = new WebDriverWait(driver, default_timeoutInSeconds, 250);
			wait.until(ExpectedConditions.visibilityOf(e));
			
			e.click();
		} catch (Exception exc) {
			exc.printStackTrace();
			rg.logException("Exception on clicking webelement" + elementName, exc);
		}

	}

	/**
	 * Click on Xpath targets.
	 * Note: This method will wait for presense of target before clicking.
	 * @param xpath
	 * @param elementName
	 * @throws Exception
	 */
	protected void click(String xpath, String elementName) throws Exception {
		try {
			WebDriver driver = this.getSysDriver(toolName);
			
			WebDriverWait wait = new WebDriverWait(driver, default_timeoutInSeconds, 250);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			driver.findElement(By.xpath(xpath)).click();
			
			rg.passTestCase("Click on Element " + elementName + " successful");

		} catch (Exception exc) {
			rg.logException("Exception in clicking " + elementName, exc);
		}
	}

	/**
	 * Get Page Title
	 * @return String title
	 * @throws Exception
	 */
	protected String getPageTitle() throws Exception {
		try {
			WebDriver driver = this.getSysDriver(toolName);
			String title = driver.getTitle();
			
			rg.passTestCase("Get Page Title");
			return title;

		} catch (Exception exc) {
			rg.logException("Get Page Title", exc);
		}
		return null;
	}

	protected void clickById(String id, String elementName) throws Exception {
		try {
			
			WebDriver driver = this.getSysDriver(toolName);
			//Below line was never executed. Retained for later data
			//WebDriverWait waitSelenium = new WebDriverWait(driver, default_timeoutInSeconds, 500);
			
			driver.findElement(By.id(id)).click();
			
			rg.passTestCase("Click on Element " + elementName + " successful");

		} catch (Exception exc) {

			exc.printStackTrace();
			rg.logException("Exception in clicking " + elementName, exc);

		}
	}

	protected void clickbyClassName(String className, String elementName) throws Exception {
		try {
			switch (toolName) {
			case "Appium":
				WebDriverWait wait = new WebDriverWait(appiumDriver, default_timeoutInSeconds, 500);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
				appiumDriver.findElementByClassName(className).click();

				break;
			case "Selenium":
				WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, default_timeoutInSeconds, 1000);
				remoteDriver.findElementByClassName(className).click();
				break;
			}
			rg.passTestCase("Click on Element " + elementName + " successful");

		} catch (Exception exc) {

			exc.printStackTrace();
			rg.logException("Exception in clicking " + elementName, exc);

		}
	}

	protected void clickByElementName(String name, String elementName) throws Exception {

		try {
			switch (toolName) {
			case "Appium":
				WebDriverWait wait = new WebDriverWait(appiumDriver, default_timeoutInSeconds, 500);
				wait.until(ExpectedConditions.elementToBeClickable(By.name(name)));
				appiumDriver.findElementByName(name).click();
				break;
			case "Selenium":
				WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, default_timeoutInSeconds, 500);
				waitSelenium.until(ExpectedConditions.elementToBeClickable(By.name(name)));
				remoteDriver.findElementByName(name).click();
				break;
			}

			rg.passTestCase("Click on Element " + elementName + " successful");

		} catch (Exception exc) {

			rg.logException("Exception in clicking " + elementName, exc);

		}
	}

	protected void clickAlert() throws Exception {
		//WebDriver waitDriver;
		try {
			//waitDriver = getSysDriver(toolName);
			//WebDriverWait wait = new WebDriverWait(waitDriver, default_timeoutInSeconds, 500);
			Alert a2 = remoteDriver.switchTo().alert();
			a2.accept();
			
			// rg.passTestCase("Click on Alert Successful");

		} catch (Exception exc) {
			exc.printStackTrace();

			rg.logException("Exception in clicking ", exc);

		}
	}

	protected void waitUntilTextChanges(WebElement e, String text) throws Exception {
		waitUntilTextChanges(e, text, default_timeoutInSeconds, 250);
	}

	protected void waitUntilTextChanges(WebElement e, String text, long timeInSeconds, long pollInMilliseconds)
			throws Exception {
		
		WebDriver wait_Driver = null;
		try {

			wait_Driver = getSysDriver(toolName);
			WebDriverWait wait = new WebDriverWait(wait_Driver, timeInSeconds, pollInMilliseconds);

			wait.until(PageBase_Appium.textToNotBePresentInElement(e, text, timeInSeconds, pollInMilliseconds));
			// rg.passTestCase("Click on Alert Successful");

		} catch (Exception exc) {
			exc.printStackTrace();

			rg.logException("Exception in clicking ", exc);

		}

	}

	private static ExpectedCondition<Boolean> textToNotBePresentInElement(final WebElement element, final String text,
			final long timeoutInSeconds, final long pollingInMillis) {

		return new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					String elementText = element.getText().trim();
					
					if (text == null ){
						if ( elementText.length() > 0){
							return true;
						}
						return false;
						
					}else{
						if (!text.equals(elementText)){
							return true;
						}else if (!driver.getPageSource().contains(text)) {
							waitForPageLoad(driver, timeoutInSeconds, pollingInMillis);
							return true;
						}else {
							return false;
						}
					}
					
				} catch (StaleElementReferenceException sere) {
					return false;
				} catch (Exception e) {
					System.out.println("Test for Except " + e.getMessage());
					return true;
				}
			}

			@Override
			public String toString() {
				return String.format("text ('%s') to not be present in element %s", text, element);
			}
		};
	}

	private static ExpectedCondition<Boolean> clickUntilNewElementVisible(final WebElement element, final  WebElement newElement,
			final long timeoutInSeconds, final long pollingInMillis) {

		return new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					element.click();
					boolean state = newElement.isDisplayed();
					return state;
					
				} catch (StaleElementReferenceException sere) {
					return false;
				} catch (Exception e) {
					System.out.println("Test for Except " + e.getMessage());
					return true;
				}
			}

			@Override
			public String toString() {
				return String.format("%s is no longer visble after click.", element);
			}
		};
	}
	// code added by srujana

	protected void selectJSLockedId(String id, String text) {
		WebDriver driver = getSysDriver(toolName);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("document.getElementById('" + id + "').style.display='block';");
		Select select = new Select(driver.findElement(By.id(id)));
		List<WebElement> le = driver.findElements(By.id(id));
		if (le.size() > 1) {
			System.out.println("Fail Club");
		}
		int i = 0;
		for (WebElement l : select.getOptions()) {
			String check = l.getAttribute("value");
			if (check.contains(text)) {
				select.selectByIndex(i);
			}
			i++;
		}
		// select.selectByVisibleText(text);
		// Thread.sleep(6000);
	}

	protected void selectText(WebElement e, String label) throws Exception {
		e.submit();
		// String text = getText(e);
		Select DD = new Select(e);
		int size = DD.getOptions().size();
		String web_text = new String();
		int i = 0;
		for (WebElement we : DD.getOptions()) {
			web_text = we.getAttribute("value");
			if (web_text.contains(label)) {
				// e.click();
				boolean test = e.isDisplayed();
				e.isEnabled(); // #teacher_signup > div:nth-child(16) >
								// span:nth-child(2) > select:nth-child(2)
				WebDriver driver = this.getSysDriver(toolName);
				driver.findElement(By
						.cssSelector("#teacher_signup > div:nth-child(16) > span:nth-child(2) > select:nth-child(2)"));
				waitUntilElementVisible(e);
				// driver.findElement(By.xpath(".//form[@id='try_canvas']//*[@id='title']")).get;
				e.sendKeys(web_text);
				DD.selectByIndex(i);
				// e.click();
				// we.click();
				return;
			}
			i++;

		}
		for (int j = 0; i < size; i++) {
			web_text = DD.getOptions().get(j).getAttribute("value");
			if (web_text.contains(label)) {
				DD.deselectByIndex(j);
				return;
			}
		}
		throw new Exception("Element text not found " + label);

	}

	protected void selectValue(WebElement e, String label) {

		Select DD = new Select(e);
		DD.selectByVisibleText(label);

	}

	protected void dragAndDropALT(WebElement e1, WebElement e2) throws Exception {
		dragAndDropALT(e1, e2, false);
	}

	protected void dragAndDropALT(WebElement e1, WebElement e2, boolean normal) throws Exception {
		//WebDriver driver = getSysDriver(toolName);
		//TODO: Re-factor This method for getSYSDriver functionality.
		try {
			switch (toolName) {
			case "Appium":
				Actions action = new Actions(appiumDriver);
				action.dragAndDrop(e1, e2).perform();

				break;
			case "Selenium":

				Actions builder = new Actions(remoteDriver);
				
				if (normal) {
					builder.clickAndHold(e1).moveToElement(e2).
							build().perform();
				} else {
					builder.clickAndHold(e1).moveToElement(e2, e1.getSize().getWidth() / 2, 0).build().perform();
				}

				

				Thread.sleep(200);
				builder.// moveToElement(e3).
						build().perform();
				
				Thread.sleep(200);
				builder.release().build().perform();
				
				break;
			}

			// rg.passTestCase("Click on Alert Successful");

		} catch (Exception exc) {
			exc.printStackTrace();

			rg.logException("Exception in clicking ", exc);

		}

	}

	protected void dragAndDropLabels(WebElement e1, WebElement e2) throws Exception {

		try {
			switch (toolName) {
			case "Appium":
				Actions action = new Actions(appiumDriver);
				action.dragAndDrop(e1, e2).perform();

				break;
			case "Selenium":

				Actions builder = new Actions(remoteDriver);
				builder.clickAndHold(e1).moveToElement(e2).build().perform();

				Thread.sleep(100);
				builder.moveByOffset(0, 1).build().perform();

				Thread.sleep(100);
				builder.release().build().perform();

				break;
			}

			// rg.passTestCase("Click on Alert Successful");

		} catch (Exception exc) {
			exc.printStackTrace();

			rg.logException("Exception in clicking ", exc);

		}

	}

	protected void dragAndDrop(WebElement e1, WebElement e2) throws Exception {
		WebDriver driver = getSysDriver(toolName);
		try {
			Actions action = new Actions(driver);
			action.dragAndDrop(e1, e2).perform();
			
			// rg.passTestCase("Click on Alert Successful");

		} catch (Exception exc) {
			exc.printStackTrace();

			rg.logException("Exception in clicking ", exc);

		}
	}

	protected void MicroQuiz() throws Exception {
		//TODO: METHOD PERFORMS NO ACTION
		try {
			switch (toolName) {
			case "Appium":
				System.out.println("Navigated to the page micro-quiz!");

				break;
			case "Selenium":
				System.out.println("Navigated to the page micro-quiz!");
				break;
			}

			// rg.passTestCase("Click on Alert Successful");

		} catch (Exception exc) {
			exc.printStackTrace();

			rg.logException("Exception in clicking ", exc);

		}
	}

	protected String getText(WebElement e, String elementName) throws Exception {
		WebDriver driver = getSysDriver(toolName);
		
		WebDriverWait wait = new WebDriverWait(driver, default_timeoutInSeconds, 500);
		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(e));
		
		String text = e.getText();
		rg.passTestCase("get text from " + elementName + " successful");
		return text;

	}

	protected String getText(WebElement e) throws Exception {
		WebDriver driver = getSysDriver(toolName);
		
		WebDriverWait wait = new WebDriverWait(driver, default_timeoutInSeconds, 500);
		wait.until(ExpectedConditions.visibilityOf(e));
				
		String text = e.getText();
		return text;
	}

	protected String driverSwitching(String articleTitlePath, String articleTitle) throws Exception {
		String storyTitle = "";
		try {
			Set<String> contextNames = (appiumDriver).getContextHandles();
			System.out.println("total contexts is 00000000000000000 " + contextNames.size());

			for (String contextName : contextNames) {
				System.out.println(contextNames); // prints out something like

				// Thread.sleep(10000);
				if (contextName.contains("WEBVIEW")) {
					(appiumDriver).context(contextName);
					System.out.println("current context is " + (appiumDriver).getContext());
					Set<String> windowhandles = (appiumDriver).getWindowHandles();
					System.out.println("window handles are ++++++++++++++++ " + windowhandles);
					for (String s : windowhandles) {
						System.out.println("current window handle is ------------" + s);
						(appiumDriver).switchTo().window(s);

						try {
							System.out.println("current window handle articleTitle is ------------" + articleTitlePath);
							if (elementIsDisplayed(articleTitlePath)) {
								storyTitle = appiumDriver.findElementByXPath(articleTitlePath).getText();
								System.out.println("storyTitle///" + storyTitle);
								if (storyTitle.equalsIgnoreCase(articleTitle)) {
									rg.passTestCase("Proper Article opened");
									System.out.println("Proper Article opened");
									break;
								}

							}
						} catch (Exception e) { // TODO
							e.printStackTrace();
							(appiumDriver).context("NATIVE_APP");
							// break;
						}
					}
				}
			}

		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("storyTitle ---" + storyTitle);

		return storyTitle;
	}

	protected void verifyIfPresent(String savedTitle, String path1, String path2) throws Exception {
		int res = 0;
		List<WebElement> totalList = appiumDriver.findElementsByXPath(
				"//android.widget.ListView[@resource-id='com.nbcnews.today.beta:id/secondaryCoverList']/android.widget.LinearLayout");
		int listSize = totalList.size();
		for (int i = 1; i <= listSize; i++) {
			String saveList = path1 + i + path2;
			WebElement we = appiumDriver.findElement(By.xpath(saveList));
			String titlePresent = getText(we);
			if (savedTitle.equalsIgnoreCase(titlePresent)) {
				rg.passTestCase("Article is present");
				res = 1;
				break;
			}
		}
		if (res == 0) {
			System.out.println("Article is not present");
			rg.failTestCase("Article is not present");
		}

	}

	protected void verifyIfPresentiOS(String savedTitle, String path1, String path2) throws Exception {
		List totalList = appiumDriver.findElementsByClassName("UIACollectionCell");
		int res = 0;
		int listSize = totalList.size();
		for (int i = 1; i <= listSize; i++) {
			String saveList = path1 + i + path2;
			WebElement we = appiumDriver.findElement(By.xpath(saveList));
			String titlePresent = getText(we);
			if (savedTitle.equalsIgnoreCase(titlePresent)) {
				System.out.println("Article is present");
				rg.passTestCase("Article is present");
				res = 1;
				break;
			}
		}
		if (res == 0) {
			System.out.println("Article is not present");
			rg.failTestCase("Article is not present");
		}
	}

	protected void verifySearchKey(String key, String path1, String path2) throws Exception {
		int res = 0;
		List totalList = appiumDriver.findElementsByClassName("UIACollectionCell");
		int listSize = totalList.size();
		for (int i = 1; i <= listSize; i++) {
			String saveList = path1 + i + path2;
			WebElement we = appiumDriver.findElement(By.xpath(saveList));
			String artTitle = getText(we);
			if (artTitle.contains(key)) {
				res = 1;
			} else {
				res = 0;
			}
		}
		if (res == 1) {
			rg.passTestCase(" Verify search key Success");
		} else if (res == 0) {
			rg.failTestCase("Problem with search key");
		}
		if (listSize == 0) {
			System.out.println("No Article for the search key");
		}
	}

	protected void webView() throws InterruptedException {
		//TODO: METHOD PERFORMS NO ACTION
		System.out.println("qwretrnghkjmdlf;kgz;gh");

		System.out.println("clvjadsgkl'jadfsgdfklskhjdfkljn");
	}

	protected void clickArticle(String latestArtTitle, String path1, String path2) throws Exception {

		for (int i = 1; i > 0; i++) {
			// android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.widget.ListView[1]/android.widget.LinearLayout[4]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]
			String xpathArt = path1 + i + path2;
			System.out.println("xpath-->" + xpathArt);
			System.out.println("title requested -->" + latestArtTitle);
			String title = getText(remoteDriver.findElement(By.xpath(xpathArt)));
			System.out.println("title present -->" + title);
			if (latestArtTitle.equalsIgnoreCase(title)) {
				click(xpathArt, "Click on Article");
				break;
			}
		}
	}

	protected void clickMultipleButtons(WebElement tab, WebElement pause, String elementName) throws Exception {

		try {
			Thread.sleep(20000);
			if (elementIsDisplayed(pause, "pausebutton")) {
				pause.click();
			} else {
				tab.click();
				pause.click();
			}
			Thread.sleep(10000);

			rg.passTestCase("click on element " + elementName + "" + " successful");

		} catch (Exception exc) {
			exc.printStackTrace();
			rg.logException("Exception on clicking webelement" + elementName, exc);
		}

	}

	protected void selectArticle(String articleName, String classText) throws Exception {
		List<WebElement> webElementList = remoteDriver.findElements(By.className(classText));

		for (WebElement we : webElementList) {
			if (we.getText().equalsIgnoreCase(articleName)) {
				try {
					appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					we.click();
					System.out.println("Click Article Success");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
	}

	public void switchToWindowTitle() throws Exception {

		try {
			Thread.sleep(10000);
			WebDriver driver = getSysDriver(toolName);
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
			/*
			switch (toolName) {
			case "Appium":
				Thread.sleep(10000);
				int size = appiumDriver.getWindowHandles().size();
				for (String winHandle : appiumDriver.getWindowHandles()) {
					appiumDriver.switchTo().window(winHandle);
					// if(Sherpath)
				}
				break;
			case "Selenium":
				Thread.sleep(10000);
				for (String winHandle : remoteDriver.getWindowHandles()) {
					remoteDriver.switchTo().window(winHandle);
				}
			}
			*/
		} catch (org.openqa.selenium.NoSuchWindowException exc) {
			exc.printStackTrace();
		}

	}

	protected String getParentWindow() throws Exception {
		String parentWindow = null;
		WebDriver driver = getSysDriver(toolName);
		parentWindow = driver.getWindowHandle();
		
		return parentWindow;
	}

	protected void switchToParentWindow(String parentWindow) throws Exception {
		WebDriver driver = getSysDriver(toolName);
		driver.close();
		driver.switchTo().window(parentWindow);
		
	}

	protected WebElement getElementById(String id) throws Exception {
		try{
			WebDriver driver = getSysDriver(toolName);
			
			WebDriverWait wait = new WebDriverWait(driver, default_timeoutInSeconds, 500);
			wait.until(
					ExpectedConditions.visibilityOf(
							driver.findElement(By.id(id))));
			WebElement we = appiumDriver.findElementById(id);
			return we;
			
		} catch (Exception exc) {
			rg.logException(String.format("ID '%s' not found", id), exc);
		}
		return null;
	}

	protected WebElement getElement(String xpath) throws Exception {
		WebDriver driver = getSysDriver(toolName);
		try{
			WebElement we = driver.findElement(By.xpath(xpath));
			WebDriverWait wait = new WebDriverWait(driver, default_timeoutInSeconds, 500);
			wait.until(ExpectedConditions.visibilityOf(we));
			
			rg.passTestCase("get text on webelement successful");
			return we;			
		}catch (Exception exc) {
			rg.logException(String.format("xpath '%s' not found", xpath), exc);
		}
		return null;

	}

	protected boolean verifyText(WebElement e, String value) {
		switch (toolName) {
		case "Appium":
			WebDriverWait wait = new WebDriverWait(appiumDriver, 60, 500);
			wait.until(ExpectedConditions.visibilityOf(e));
		case "Selenium":
			WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 60, 500);
			waitSelenium.until(ExpectedConditions.visibilityOf(e));
		}
		if (e.getText().equalsIgnoreCase(value))
			return true;
		else
			return false;

	}

	protected void enterText(WebElement element, String cred, String elementName) throws Exception {
		try {
			switch (toolName) {
			case "Appium":
				WebDriverWait wait = new WebDriverWait(appiumDriver, 60, 500);
				wait.until(ExpectedConditions.visibilityOf(element));
				break;
			case "Selenium":
				WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 60, 500);
				waitSelenium.until(ExpectedConditions.visibilityOf(element));
				break;
			}

			element.clear();
			element.sendKeys(cred);
			rg.passTestCase("enter text in " + elementName + " successful");
		} catch (Exception exc) {

			rg.logException("Enter text failed", exc);
		}

	}

	protected boolean elementIsDisplayed(WebElement e, String ElementName) throws Exception {
		return elementIsDisplayed(e, ElementName, 30, 500);
	}

	protected boolean elementIsDisplayed(WebElement e, String ElementName, long timeoutInSeconds, long pollingInMillis)
			throws Exception {
		try {
			switch (toolName) {
			case "Appium":
				WebDriverWait wait = new WebDriverWait(appiumDriver, timeoutInSeconds, pollingInMillis);
				wait.until(ExpectedConditions.visibilityOf(e));
				break;
			case "Selenium":
				WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, timeoutInSeconds, pollingInMillis);
				waitSelenium.until(ExpectedConditions.visibilityOf(e));
				break;

			}

		} catch (Exception exc) {

		}
		try {
			if (e.isDisplayed()) {
				rg.passTestCase(ElementName + " is displayed");

				return true;
			} else
				return false;
		} catch (Exception exc) {

			return false;

		}

	}

	protected boolean elementIsEnabled(WebElement e) throws Exception {
		try {
			switch (toolName) {
			case "Appium":
				WebDriverWait wait = new WebDriverWait(appiumDriver, 30, 500);
				wait.until(ExpectedConditions.visibilityOf(e));
			case "Selenium":
				WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 60, 500);
				waitSelenium.until(ExpectedConditions.visibilityOf(e));
			}
		} catch (Exception exc) {

			rg.logException("Get element visibilty failed", exc);
		}
		try {
			if (e.isEnabled()) {
				return true;
			} else
				return false;
		} catch (Exception exc) {

			rg.logException("Get element visibilty failed", exc);
			return false;

		}

	}

	protected boolean elementIsDisplayed(String xpath) throws Exception {

		try {
			switch (toolName) {
			case "Appium":
				WebDriverWait wait = new WebDriverWait(appiumDriver, 30, 500);
				wait.until(ExpectedConditions.visibilityOf(appiumDriver.findElementByXPath(xpath)));
				break;
			case "Selenium":
				WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 60, 500);
				waitSelenium.until(ExpectedConditions.visibilityOf(remoteDriver.findElementByXPath(xpath)));
				break;
			}

		} catch (Exception exc) {

			return false;

		}
		return true;

	}

	protected boolean elementIsDisplayedByName(String name) throws Exception {

		try {
			switch (toolName) {
			case "Appium":
				WebDriverWait wait = new WebDriverWait(appiumDriver, 30, 500);
				wait.until(ExpectedConditions.visibilityOf(appiumDriver.findElementByName(name)));
				break;
			case "Selenium":
				WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 60, 500);
				waitSelenium.until(ExpectedConditions.visibilityOf(remoteDriver.findElementByName(name)));
				break;
			}

		} catch (Exception exc) {
			exc.printStackTrace();
			return false;
		}
		return true;

	}

	protected void scroll(String key) {
		switch (toolName) {
		case "Appium":
			for (int i = 0;; i++) {
				boolean shouldBreak = false;

				@SuppressWarnings("unchecked")
				List<WebElement> listObject = appiumDriver.findElements(By.name("dropdownViewCell_" + i + ""));
				while ((listObject.size()) == 0)
					break;

				for (WebElement wb : listObject) {

					if ((wb.getText().equalsIgnoreCase(key))) {
						wb.click();
						shouldBreak = true;
						break;
					}

				}
				if (shouldBreak)
					break;

			}

		case "Selenium":
			for (int i = 0;; i++) {
				boolean shouldBreak = false;

				List<WebElement> listObject = remoteDriver.findElements(By.name("dropdownViewCell_" + i + ""));
				while ((listObject.size()) == 0)
					break;

				for (WebElement wb : listObject) {

					if ((wb.getText().equalsIgnoreCase(key))) {
						wb.click();
						shouldBreak = true;
						break;
					}

				}
				if (shouldBreak)
					break;

			}

		}

	}

	protected void clickCoordinates(final int x, final int y) {
		switch (toolName) {
		case "Appium":
			appiumDriver.executeScript("mobile: tap", new HashMap<String, Integer>() {
				{
					put("tapCount", (int) 1);
					put("touchCount", (int) 1);
					put("duration", (int) 0.5);
					put("x", x);
					put("y", y);
				}
			});
			break;
		case "Selenium":
			remoteDriver.executeScript("mobile: tap", new HashMap<String, Integer>() {
				{
					put("tapCount", (int) 1);
					put("touchCount", (int) 1);
					put("duration", (int) 0.5);
					put("x", x);
					put("y", y);
				}
			});
			break;
		}
	}

	protected void keyBoardActions(String text) {
		switch (toolName) {
		case "Appium":
			if (text.equalsIgnoreCase("return"))
				appiumDriver.findElementByName(text).click();
			else {
				for (int i = 0; i < text.length(); i++) {
					String alp = text.substring(i, i + 1);
					appiumDriver.findElementByName(alp).click();
				}
			}
		case "Selenium":
			if (text.equalsIgnoreCase("return"))
				remoteDriver.findElementByName(text).click();
			else {
				for (int i = 0; i < text.length(); i++) {
					String alp = text.substring(i, i + 1);
					remoteDriver.findElementByName(alp).click();
				}
			}
		}

	}

	protected void scrollToExact(String key) throws Exception {
		try {
			switch (toolName) {
			case "Appium":
				((ScrollsTo) appiumDriver).scrollToExact(key);
			case "Selenium":
				((ScrollsTo) remoteDriver).scrollToExact(key);
			}
			rg.passTestCase("scroll to element " + "" + key + "" + " successful");
		} catch (Exception exc) {
			rg.logException("Exception on scroll to element" + key, exc);

		}

	}

	protected void navToHomePage() throws Exception {

		while (elementIsDisplayedByName("OK")) {

			clickByElementName("OK", "pop up");

		}

		while (!elementIsDisplayedByName("Logout")) {

			clickByElementName("Back", "Back Button");

		}
		click("//UIAApplication[1]/UIAWindow[1]/UIASegmentedControl[1]/UIAButton[1]", "Arrivals");

	}

	protected void backButton() throws Exception {

		clickByElementName("Back", "Back Button");
	}

	/*
	 * protected static void launchAppiumiOS() { System.out.println(
	 * "open appium"); File wd = new File(".");
	 * 
	 * Process proc = null; try { proc = Runtime.getRuntime().exec("/bin/bash",
	 * null, wd); } catch (IOException e) { e.printStackTrace(); } if (proc !=
	 * null) { BufferedReader in = new BufferedReader(new InputStreamReader(
	 * proc.getInputStream())); PrintWriter out = new PrintWriter(new
	 * BufferedWriter( new OutputStreamWriter(proc.getOutputStream())), true);
	 * out.println("pwd"); // out.println("cd ReportGenerator");
	 * out.println("./iOScmd.sh"); out.println("exit");
	 * System.out.println("launched"); try { String line; while ((line =
	 * in.readLine()) != null) { System.out.println(line); System.out.println(
	 * "in while"); } // proc.waitFor(); in.close(); out.close();
	 * proc.destroy(); } catch (Exception e) { e.printStackTrace(); } } }
	 */
	public static String screenshot() throws IOException, InterruptedException {
		String imgPath = null;
		Thread.sleep(2000);
		n = n + 1;
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_MM_SS");
		Date date = new Date();
		String timeStamp = dateFormat.format(date);
		switch (toolName) {
		case "Appium":
			File scrFile = ((TakesScreenshot) appiumDriver).getScreenshotAs(OutputType.FILE);

			imgPath = ".//ReportGenerator//" + TestSuite.reportFolder + "//screenshots" + "/" + "/" + timeStamp
					+ ".png";
			FileUtils.copyFile(scrFile, new File(imgPath));
			break;

		case "Selenium":
			File scrFileSelenium = ((TakesScreenshot) remoteDriver).getScreenshotAs(OutputType.FILE);

			imgPath = ".//ReportGenerator//" + TestSuite.reportFolder + "//screenshots" + "/" + "/" + timeStamp
					+ ".png";
			FileUtils.copyFile(scrFileSelenium, new File(imgPath));
			break;

		}
		return imgPath;
	}

	// nfr scenarios
	protected void accessNotification() {
		AndroidDriver android = (AndroidDriver) this.appiumDriver;
		android.openNotifications();

	}

	protected void brightness(Activity act) {

		LayoutParams br = act.getWindow().getAttributes();
		br.screenBrightness = (250);
		act.getWindow().setAttributes(br);

	}

	protected void setDataConnection(boolean enable) {
		// TODO Auto-generated method stub
		if (this.appiumDriver instanceof AndroidDriver) {
			AndroidDriver android = (AndroidDriver) this.appiumDriver;
			NetworkConnectionSetting setting = android.getNetworkConnection();
			setting.dataEnabled();
			android.setNetworkConnection(setting);
			String mode = enable ? "ON" : "OFF";
			System.out.println("Current Status of data network:" + setting.dataEnabled());
		}
	}

	protected void setAirplaneConnection(boolean enable) {
		// TODO Auto-generated method stub
		if (this.appiumDriver instanceof AndroidDriver) {
			AndroidDriver android = (AndroidDriver) this.appiumDriver;
			NetworkConnectionSetting setting = android.getNetworkConnection();

			setting.setAirplaneMode(true);

			android.setNetworkConnection(setting);
			String mode = enable ? "ON" : "OFF";
		}
	}

	protected void setWifiConnection(boolean enable) {
		// TODO Auto-generated method stub
		System.out.println("before +++++");
		if (this.appiumDriver instanceof AndroidDriver) {
			System.out.println("inside +++++");
			AndroidDriver android = (AndroidDriver) this.appiumDriver;
			NetworkConnectionSetting setting = android.getNetworkConnection();
			setting.setWifi(enable);
			android.setNetworkConnection(setting);
			System.out.println("Current Status of wifi:" + setting.wifiEnabled());
			String mode = enable ? "ON" : "OFF";
		}
	}

	protected void findScreen(String image) throws FindFailed {

		screen.find(image);

	}

	protected void clickScreen(String image) throws FindFailed {

		screen.click(image);

	}

	protected void pauseVid() throws FindFailed, InterruptedException {
		// TODO Auto-generated method stub
		// WebElement element =
		// remoteDriver.findElement(By.xpath("//*[starts-with(@id,'ssn_display'))]"));
		/*
		 * ((JavascriptExecutor) remoteDriver) .executeScript(
		 * "var elems = document.querySelectorAll('div[id^=\"npn\"]'); " +
		 * "elems.pause()");
		 */
		Screen screen = new Screen();
		/*
		 * remoteDriver.findElement(
		 * By.xpath("//object[@type=\"application/x-shockwave-flash\"]"))
		 * .click();
		 */
		/*
		 * System.out.println("Coordinates: " + listFlash.getLocation().x + ", "
		 * + listFlash.getLocation().y); System.out.println("Size: " +
		 * listFlash.getSize().width + ", " + listFlash.getSize().height);
		 */

		// Thread.sleep(5000);
		// WebElement flash = remoteDriver.findElement(
		// By.xpath("//object[@type=\"application/x-shockwave-flash\"]"));

		// Actions act = new Actions(remoteDriver);
		// /act.moveToElement(flash, 110, 677).click().build().perform();
		/*
		 * act.moveByOffset(110,677).build().perform();
		 * act.click().build().perform();
		 */

		// screen.waitVanish(target);
		// screen.find("D:\\selenium demo\\FLite\\pause.PNG");
		screen.click("/Users/mspiosteam/Documents/FLite_v1/pause.PNG");
		// Thread.sleep(15000);

	}

	protected void keyboardActions(WebElement e, Keys key) {

		WebDriverWait wait = new WebDriverWait(remoteDriver, 60, 500);
		wait.until(ExpectedConditions.visibilityOf(e));
		e.sendKeys(key);

	}

	// code added by srujana

	protected void sendKeys(WebElement e, String key) throws Exception {
		this.click(e, key);
		e.sendKeys(key);
	}

	// code added by srujana

	protected void robotEnter() throws Exception {

		Robot robot = new Robot();
		robot.delay(200);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		// robot.delay(200);
	}

	protected void clearKeys(WebElement e) {
		e.clear();

	}

	protected String getCurrentDate() {

		String currentDate = new SimpleDateFormat("dd").format(new Date());
		int today = Integer.parseInt(currentDate);
		if (today < 10) {
			currentDate = new SimpleDateFormat("d").format(new Date());
			System.out.println("Current date is " + currentDate);
		}
		return currentDate;

	}

	protected String getCurrentDateandMonth() {
		String currentDateandMonth = new SimpleDateFormat("dd/mmm").format(new Date());
		return currentDateandMonth;
	}

	// code added by srujana

	protected String getOneDayLaterDate() throws ParseException {

		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, 1); // number of days to add
		String tmrwDate = new SimpleDateFormat("dd").format(c.getTime()); // tmrwDate
																			// is
																			// now
																			// the
																			// new
																			// date

		return tmrwDate;
	}

	// code added by srujana

	protected String getTwoDaysLaterDate() throws ParseException {

		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, 2); // number of days to add
		String newDate = new SimpleDateFormat("dd").format(c.getTime()); // newDate
																			// is
																			// now
																			// the
																			// new
																			// date

		return newDate;
	}

	// select checkbox
	protected void checkBox(WebElement checkBox, String elementName) throws Exception {
		try {
			// need to add webelements for mobile platform elements.
			switch (toolName) {
			case "Appium":
				WebDriverWait wait = new WebDriverWait(appiumDriver, 60, 500);
				wait.until(ExpectedConditions.visibilityOf(checkBox));
				break;
			case "Selenium":
				WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 60, 500);
				waitSelenium.until(ExpectedConditions.visibilityOf(checkBox));
				break;
			}

			checkBox.click();
			rg.passTestCase("enter text in " + elementName + " successful");
		} catch (Exception exc) {

			rg.logException("Enter text failed", exc);
		}

	}

	protected String getAttributesFromXpath(String xpath, String attribute) throws Exception {
		WebElement e = this.getElement(xpath);
		return getAttributes(e, attribute, 60, 500);
	}

	protected String getAttributesFromXpath(String xpath, String attribute, long timeoutInSeconds, long pollingInMillis)
			throws Exception {
		return getAttributes(remoteDriver.findElementByXPath(xpath), attribute, timeoutInSeconds, pollingInMillis);
	}

	protected String getAttributes(WebElement e, String attribute) throws Exception {
		return getAttributes(e, attribute, 60, 500);
	}

	protected String getAttributes(WebElement e, String attribute, long timeoutInSeconds, long pollingInMillis)
			throws Exception {
		try {
			switch (toolName) {
			case "Appium":
				WebDriverWait wait = new WebDriverWait(appiumDriver, timeoutInSeconds, pollingInMillis);
				wait.until(ExpectedConditions.visibilityOf(e));
			case "Selenium":
				WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, timeoutInSeconds, pollingInMillis);
				waitSelenium.until(ExpectedConditions.visibilityOf(e));
			}
		} catch (Exception exc) {

			rg.logException("Get element attribute", exc);
		}

		return e.getAttribute(attribute);
	}

	protected String getValueFromPattern(String pattern, String input, int matchInstance) {
		Pattern p = Pattern.compile(input);// "(\\d) OF (\\d)");
		Matcher m = p.matcher(pattern);
		if (m.find()) {
			String someStr = m.group(matchInstance);
			return someStr;
		}
		return null;
	}

	
	protected boolean isAlertPresent() {
		return isAlertPresent(default_timeoutInSeconds, default_pollingInMillis);
	}

	protected boolean isAlertPresent(long timeoutInSeconds, long pollingInMillis) {
		try {

			switch (toolName) {
			case "Appium":
				// appiumDriver.switchTo().alert();
				WebDriverWait wait = new WebDriverWait(appiumDriver, timeoutInSeconds, pollingInMillis);
				wait.until(ExpectedConditions.alertIsPresent());
			case "Selenium":
				// remoteDriver.switchTo().alert();
				WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, timeoutInSeconds, pollingInMillis);
				waitSelenium.until(ExpectedConditions.alertIsPresent());
			}
			return true;
		} // try
		catch (NoAlertPresentException Ex) {
			return false;
		} // catch
	}

	protected boolean isElementPresent(WebElement e) {
		return isElementNotPresent(e, default_timeoutInSeconds, default_pollingInMillis);
	}

	protected boolean isElementPresent(WebElement e, long timeoutInSeconds) {
		return isElementPresent(e, timeoutInSeconds, 250);
	}

	protected boolean isElementPresent(WebElement e, long timeoutInSeconds, long pollingInMillis) {
		Boolean test = false;
		WebDriver wait_Driver = getSysDriver(toolName);
		wait_Driver.manage().timeouts().implicitlyWait(timeoutInSeconds, TimeUnit.SECONDS);
		try {
			switch (toolName) {
			case "Appium":
				WebDriverWait wait = new WebDriverWait(appiumDriver, timeoutInSeconds, pollingInMillis);
				wait.until(ExpectedConditions.visibilityOf(e));
				break;
			case "Selenium":
				WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, timeoutInSeconds, pollingInMillis);
				waitSelenium.until(ExpectedConditions.visibilityOf(e));
				break;

			}

		} catch (Exception exc) {

		}
		try {
			if (e.isDisplayed()) {
				rg.passTestCase(e + " is displayed");

				return true;
			} else
				return false;
		} catch (Exception exc) {

			return false;

		}

	}
	
	

	protected boolean isElementNotPresent(WebElement e) {
		return isElementNotPresent(e, default_timeoutInSeconds, default_pollingInMillis);
	}

	protected boolean isElementPresentById(String id, long timeoutInSeconds) {
		return isElementPresentById(id, timeoutInSeconds, 250);
	}

	protected boolean isElementPresentById(String id, long timeoutInSeconds, long pollingInMillis) {
		WebElement e;
		WebDriver driver = getSysDriver(toolName);
		try {
			e = driver.findElement(By.id(id));
		} catch (Exception e1) { // If there is an exception we return false;
			return false;
		}
		return this.isElementPresent(e, timeoutInSeconds, pollingInMillis);
	}

	protected boolean isFluentPresent(WebElement e, long timeoutInSeconds, long pollingInMillis) {

		Boolean test = new FluentWait<WebElement>(e).withTimeout(timeoutInSeconds, TimeUnit.SECONDS)
				.pollingEvery(pollingInMillis, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class)
				.until(new Function<WebElement, Boolean>() {
					public Boolean apply(WebElement element) {
						return element.isDisplayed();
					}
				});

		return test;

	}

	protected boolean isElementNotPresent(WebElement e, long timeoutInSeconds, long pollingInMillis) {
		Boolean test = new Boolean(false);
		try {
			test = new FluentWait<WebElement>(e).withTimeout(timeoutInSeconds, TimeUnit.SECONDS)
					.pollingEvery(pollingInMillis, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class)
					.until(new Function<WebElement, Boolean>() {
						public Boolean apply(WebElement element) {
							return !element.isDisplayed();
						}
					});
		} catch (TimeoutException t) {
			return false;
		}

		return test;

	}

	protected boolean verifyPageText(String text) {
		try {
			boolean found = false;

			switch (toolName) {
			case "Appium":
				found = appiumDriver.getPageSource().contains(text);
			case "Selenium":
				found = remoteDriver.getPageSource().contains(text);
			}
			return found;

		} // try
		catch (NoAlertPresentException Ex) {
			return false;
		} // catch

	}

	protected int getNumberOfElementsByClass(String class_name) {
		int size = 0;

		try {
			switch (toolName) {
			case "Appium":
				size = appiumDriver.findElementsByClassName(class_name).size();
			case "Selenium":
				size = remoteDriver.findElementsByXPath(class_name).size();
			}
			return size;
		} // try
		catch (NoSuchElementException Ex) {
		}
		return size;
	}

	protected int getNumberOfElementsByXpath(String xpath) {
		int size = 0;

		try {
			WebDriver wait_Driver = getSysDriver(toolName);
			size = wait_Driver.findElements(By.xpath(xpath)).size();

			/*
			 * switch (toolName) { case "Appium": size =
			 * appiumDriver.findElementsByXPath(xpath).size(); case "Selenium":
			 * size = remoteDriver.findElementsByXPath(xpath).size(); }
			 */
			return size;

		} // try
		catch (NoSuchElementException Ex) {
		}
		return size;
	}

	protected void logErrorToReporter(String error_message, Exception exc) throws Exception {
		rg.logException(error_message, exc);
	}

	protected boolean elementIsEnabledById(String id, String ElementName) throws Exception {
		//
		WebElement answerOption;
		try {
			WebDriver driver = this.getSysDriver(toolName);
			answerOption = driver.findElement(By.id(id));
			WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, default_timeoutInSeconds, 250);
			waitSelenium.until(ExpectedConditions.visibilityOf(answerOption));
			
			return answerOption.isEnabled();

		} catch (Exception exc) {
			return false;
		}
	}

	protected String getFormattedDate(String format) {
		// TODO: REUSABLE Components has a duplicate method of the same type
		DateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(new Date());

	}

	protected String getCourseName() {

		String courseName = "C_" + getFormattedDate("yyyyMMdd_HHmmss");
		return courseName;

	}

	/**
	 * Wait Method designed for the Assessment Page to load
	 * 
	 * @param questionNumber
	 * @param questionCounter
	 * @param totalNumofQuestions
	 * @throws Exception
	 */
	protected void waitforAssessmentPageLoad(WebElement questionNumber, int questionCounter, int totalNumofQuestions)
			throws Exception {
		WebDriver driver = this.getSysDriver(toolName);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBePresentInElement(questionNumber,
				questionCounter + " of " + totalNumofQuestions));
	}

	// teacher_signup
	protected void switchToframe(WebElement frame) throws Exception {

		try {
			WebDriver wait_Driver = getSysDriver(toolName);

			switch (toolName) {
			case "Appium":
				Thread.sleep(10000);
				// int size = appiumDriver.getWindowHandles().size();
				for (String winHandle : wait_Driver.getWindowHandles()) {
					// wait_Driver.switchTo().
					wait_Driver.switchTo().window(winHandle);
				}
				break;
			case "Selenium":
				Thread.sleep(2000);
			default:
				wait_Driver.switchTo().frame(frame);
			}

		}

		catch (org.openqa.selenium.NoSuchWindowException exc) {
			exc.printStackTrace();
		}

	}

	protected void switchToiframe() throws Exception {

		try {
			WebDriver driver = getSysDriver(toolName);

			switch (toolName) {
			case "Appium":
				Thread.sleep(10000);
				// int size = appiumDriver.getWindowHandles().size();
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
				}
				break;
			case "Selenium":
				Thread.sleep(2000);
			default:
				driver.switchTo().frame(driver.findElement(By.className("cboxIframe")));

			}

			/*
			 * switch (toolName) { case "Appium": Thread.sleep(10000); int size
			 * = appiumDriver.getWindowHandles().size(); for (String winHandle :
			 * appiumDriver.getWindowHandles()) {
			 * appiumDriver.switchTo().window(winHandle); }
			 * 
			 * break; case "Selenium": Thread.sleep(2000);
			 * remoteDriver.switchTo().frame(remoteDriver.findElement(By.
			 * className("cboxIframe"))); break; case "htmlunit":
			 * htmlUnitDriver.switchTo().frame(htmlUnitDriver.findElement(By.
			 * className("cboxIframe"))); break; }
			 */
		}

		catch (org.openqa.selenium.NoSuchWindowException exc) {
			exc.printStackTrace();
		}

	}

	private WebDriver getSysDriver(String toolName) {
		WebDriver d = null;
		switch (toolName.toLowerCase()) {
		case "appium":
			d = appiumDriver;
			break;
		case "htmlunit":
			d = htmlUnitDriver;
			break;
		case "selenium":
		default: // All default go to remote driver for now
			d = remoteDriver;
		}
		return d;
	}

	private static void waitForPageLoad(WebDriver wait_Driver, long timeoutInSeconds, long pollingInMillis)
			throws Exception {
		// try {
		Wait<WebDriver> wait = new WebDriverWait(wait_Driver, timeoutInSeconds, pollingInMillis);
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				/*
				 * System.out.println("Current Window State       : " +
				 * String.valueOf(((JavascriptExecutor) driver).executeScript(
				 * "return document.readyState")));
				 */
				return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
						.equals("complete");
			}
		});

		/*
		 * } catch (Exception exc) { //rg.logException("Get element attribute",
		 * exc); }
		 */

	}

	public void waitForPageLoad() throws Exception {
		waitForPageLoad(60, 250);
	}

	// 60, 500
	/**
	 * Alternate method to wait for pages to load in WebDriver.
	 * 
	 * @throws Exception
	 */
	protected void waitForPageLoad(long timeoutInSeconds, long pollingInMillis) throws Exception {
		WebDriver wait_Driver = null;
		try {

			wait_Driver = getSysDriver(toolName);
			/*
			 * switch (toolName) { case "Appium":
			 * //remoteDriver.findElementById(id).isEnabled(); wait_Driver =
			 * appiumDriver; break; case "Selenium": wait_Driver = remoteDriver;
			 * break; }
			 * 
			 * //WebDriverWait waitSelenium = new WebDriverWait(wait_Driver,60,
			 * 500);
			 */
			waitForPageLoad(wait_Driver, timeoutInSeconds, pollingInMillis);

		} catch (Exception exc) {
			rg.logException("Get element attribute", exc);
		}

	}

	protected void waitUntilElementVisible(WebElement e) {
		WebDriver driver = getSysDriver(toolName);
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(e));
	}
	
	public boolean elementNotExist(String elementID, long interval) {
		Boolean exist = false;
		try { 
			WebDriver driver = getSysDriver(toolName);
			driver.manage().timeouts().implicitlyWait(interval, TimeUnit.SECONDS);
				System.out.println("before"+System.currentTimeMillis());
				exist = driver.findElements(By.id(elementID)).size() == 0;
				System.out.println(exist);
				System.out.println("after"+System.currentTimeMillis());
				driver.manage().timeouts().implicitlyWait(interval, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exist;
	}
	
	
	public boolean elementExist(String elementID, long interval) {
		Boolean exist = false;
		try { 
			WebDriver driver = getSysDriver(toolName);
			driver.manage().timeouts().implicitlyWait(interval, TimeUnit.SECONDS);
//				System.out.println("before"+System.currentTimeMillis());
				exist = driver.findElements(By.id(elementID)).size() != 0;
//				System.out.println(exist);
//				System.out.println("after"+System.currentTimeMillis());
				driver.manage().timeouts().implicitlyWait(interval, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exist;
	}

	

	
	
}