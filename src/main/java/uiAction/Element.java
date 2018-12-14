package uiAction;



import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.Browser;
import helper.Wait;
import utility.RandomData;

public class Element {

	private static Logger logger = Logger.getLogger(Element.class);

	public static void click( WebDriver driver, By locator) {
		
		if (Wait.checkElementExistance(driver, 30, 5, locator)) {
			Wait.waitForElementClickable(driver, 30, locator);
			WebElement elm = driver.findElement(locator);
			elm.click();
			logger.info(" click() executed on " + locator);
		} else {
			logger.info(" click () failed from execution on element  "+locator);
		}
	
	}

	public static void submit(WebDriver driver, By locator) {
		
		if (Wait.checkElementExistance(driver, 30, 5, locator)) {
			Wait.waitForElementClickable(driver, 30, locator);
			WebElement elm = driver.findElement(locator);
			elm.submit();
			logger.info("submit() Executed On" + locator);
		} else {
			logger.info("submit() failed from execution on "+locator);
		}
		
	}

	public static void clear(WebDriver driver, By locator) {
	
		if (Wait.checkElementExistance(driver, 30, 5, locator)) {
			WebElement elm = driver.findElement(locator);
			elm.clear();
			logger.info(" clear() Executed  on  " + locator);
		} else {
			logger.info(" clear() failed from execution on  "+ locator);
		}
		
	}

	public static void sendKeys(WebDriver driver, By locator, String data) {
		
		if (Wait.checkElementExistance(driver, 30, 5, locator)) {
			WebElement elm = driver.findElement(locator);
			elm.clear();
			elm.sendKeys(data);
			logger.info(" sendKeys() Executed on "+locator+ " with data " +data);
		} else {
			logger.info("sendKeys() failed from execution on "+locator+ " with data "+data);
		}
	
	}

	public static String getText(WebDriver driver, By locator) {
		
		String captureText = null;
		if (Wait.checkElementExistance(driver, 30, 5, locator)) {
			WebElement elm = driver.findElement(locator);
			captureText = elm.getText();

			logger.info("getText() executed on "+locator +" captured Text is "+captureText);
		} else {
			logger.info("getText() failed from execution on "+locator);
		}
		logger.info("getText() returned "+captureText);
		return captureText;

	}

	public static String getAttribute(WebDriver driver, By locator, String parameterName) {
	
		String captureText = null;
		if (Wait.checkElementExistance(driver, 30, 5, locator)) {
			WebElement elm = driver.findElement(locator);
			captureText = elm.getAttribute(parameterName);

			logger.info("getAttribute() executed  on "+locator +" with parameterName "+parameterName);
			
		} else {
			logger.info("getAttribute() failed from execution on "+locator +" with parameter name "+parameterName);
		}
		logger.info("getAttribute() returned "+captureText);
		return captureText;

	}

	public static boolean isEnabled(WebDriver driver, By locator) {
		
		boolean b = false;
		if (Wait.checkElementExistance(driver, 30, 5, locator)) {

			WebElement elm = driver.findElement(locator);
			elm.isEnabled();
			b = true;
		logger.info("isEnabled() Executed on "+locator);	

		}
	
		logger.info("isEnabled() returned "+b);
		return b;
	}

	public static boolean isDisplayed(WebDriver driver, By locator) {
	
		boolean b = false;
		if (Wait.checkElementExistance(driver, 30, 5, locator)) {
			WebElement elm = driver.findElement(locator);
			elm.isDisplayed();
			b = true;
			logger.info("isDisplayed() Executed on "+locator);   
		}
	
		logger.info("isDisplayed() returned "+b);
		return b;

	}

	public static boolean isSelected(WebDriver driver, By locator) {
	
		boolean b = false;
		if (Wait.checkElementExistance(driver, 30, 5, locator)) {

			WebElement elm = driver.findElement(locator);
			elm.isSelected();
			b = true;
			logger.info("isSelected() Executed on "+locator);  
		}
		
		logger.info("isSelected() returned "+b);
		return b;

	}

	public static int elementCount(WebDriver driver, By locator) {
		
		int count = 0;
        count = driver.findElements(locator).size();
	
		logger.info("elementCount() executed on "+locator);
		logger.info("elementCount() returned "+count);
		return count;
		
	}
	public static String getTitle(WebDriver driver){
		logger.info("getTitle() executed ");
	  String title = 	driver.getTitle();
		logger.info("getTitle() executed returned title is [ "+title + " ]");
	  return title ;
	}
public static String verifyAnyLink(WebDriver driver , By Locator  ){
		
		Element.click(driver, Locator);
		
	
		 
	    int i = Browser.getTotalOpenedWindow(driver);
	    
	    if(i>2){
	   	 Wait.staticWait(5000);
	    Browser.switchToWindowUsingIndex(driver, 2);	
	    Browser.closeBrowser(driver);
	    	
	    }
		 Wait.staticWait(5000);
		Browser.switchToWindowUsingIndex(driver, 1);
		String title = Element.getTitle(driver);
	    return title ;
	}
public static String verifyTextboxRelatedSearch(WebDriver driver , By searchBoxField ,String searchData ,By SearchButton ,By resultValidation){
	String result = null ;
	Element.sendKeys(driver, searchBoxField, searchData);
	Element.click(driver, SearchButton);
result =	Element.getText(driver, resultValidation);
	return result ;
	
	
}
}
