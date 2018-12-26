package staticDataManager;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import helper.Action;
import uiAction.Element;
import utility.ScriptExecutor;

public class ApplicationLevelMethod {

	private static Logger logger = Logger.getLogger(ApplicationLevelMethod.class);

	public static boolean isColumnHeadingMatching(WebDriver driver, String columnName) {
		boolean b = false;
		By columnLoc = By.xpath("//th");
		int columnCount = Element.elementCount(driver, columnLoc);

		for (int i = 2; i <= columnCount; i++) {

			String dynamicColumnString = "(//th)[" + i + "]/a";
			By dynamicColumnLoc = By.xpath(dynamicColumnString);
			String columnActualText = Element.getText(driver, dynamicColumnLoc);
			if (columnActualText.equalsIgnoreCase(columnName)) {

				b = true;
				break;
			}

		}
		return b;

	}
	public static int getIndexValueWhereColumnMatching(WebDriver driver, String columnName) {
		int b = 0;
		By columnLoc = By.xpath("//th");
		int columnCount = Element.elementCount(driver, columnLoc);

		for (int i = 2; i <= columnCount; i++) {

			String dynamicColumnString = "(//th)[" + i + "]/a";
			By dynamicColumnLoc = By.xpath(dynamicColumnString);
			String columnActualText = Element.getText(driver, dynamicColumnLoc);
			if (columnActualText.equalsIgnoreCase(columnName)) {
             
				b = i; 
			
				break;
			}

		}
		return b;

	}

	public static int getTotalRecordsData(WebDriver driver) {
		int recordData = 0;

		By rowLoc = By.xpath("//tr");
		int rowCount = Element.elementCount(driver, rowLoc) - 1;
		if (rowCount >= 1) {

			recordData = rowCount * 5;

		} else {

			logger.info("*************Record is not Available ****************");

		}
		logger.info("getTotalRecordsData()....Returning totalRecordData is " + recordData);
		return recordData;
	}
	 public static int getTotalRowCount(WebDriver driver){
		 int rowCount = 0;
		 By rowLoc = By.xpath("//tr");
		rowCount = Element.elementCount(driver, rowLoc);
		 return rowCount  ;
		 
	 }
	 public static int getTotalHeading(WebDriver driver){
		 int headingCount = 0;
		 
		 By headingLoc = By.xpath("//th");
		 
		 headingCount = Element.elementCount(driver, headingLoc);
		 
		 return headingCount ;
		 
	 }
	
	
	public static String getColumnData(WebDriver driver ,String columnName ,int desireRow){
		
		   String columnData = null ;
		   
		   int IndexMatched =	getIndexValueWhereColumnMatching(driver, columnName);
		   int headingCount = getTotalHeading(driver);
		   int totalRow = getTotalRowCount(driver);
		   int finalRow = desireRow + 1 ;
		
       if(isColumnHeadingMatching(driver, columnName)&& totalRow >= desireRow){
			         
		  
		    for(int i=IndexMatched ;i<= headingCount ;i++){
		    	 
		    	 String data = "(//tr)["+finalRow+"]/td["+IndexMatched+"]/a";
		    	 By dataLoc = By.xpath(data);
		    	 ScriptExecutor.scrollInToView(dataLoc);
		    	 columnData = Element.getText(driver, dataLoc);
		    	 break ;
		    	   
		    }
		   
			
		}else {
			
		logger.info("getColumnData()...Failed From Execution Given column name ----"+columnName+" Not matched");
		}
		logger.info("getColumnData()...Returning---"+columnData);
		
		return columnData;
		
	}
	public static boolean getAllColumeWiseData(WebDriver driver ,String columnName ,String selectedDropDownValue){

		 boolean isDropDownValueMatched = true ;
		   
		   int IndexMatched =	getIndexValueWhereColumnMatching(driver, columnName);
		   int headingCount = getTotalHeading(driver);
		   int totalRow = getTotalRowCount(driver);
		 
		
    if(isColumnHeadingMatching(driver, columnName)&&totalRow >1){
			         
		  
		    for(int i=2 ;i<= totalRow ;i++){
		    	 
		    	 String data = "(//tr)["+i+"]/td["+IndexMatched+"]";
		    	 By dataLoc = By.xpath(data);
		    	 ScriptExecutor.scrollInToView(dataLoc);
		    	String columnData = Element.getText(driver, dataLoc);
		    	 if(columnData.contains(selectedDropDownValue)){
		    		 
		    		 isDropDownValueMatched = true ;
		    }else{
		    	 isDropDownValueMatched = false ;
	    		   break ;
		    }
		   
		    }
		}else {
			
		logger.info("getColumnData()...Failed From Execution Given column name ----"+columnName+" Not matched");
		}
		logger.info("getColumnData()...Returning---"+isDropDownValueMatched);
		
		return isDropDownValueMatched;
		
	}	
		
	}
	  
    

