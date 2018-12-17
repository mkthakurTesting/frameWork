package staticDataManager;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import helper.Action;
import uiAction.Element;

public class ApplicationLevelMethod {

	private static Logger logger = Logger.getLogger(ApplicationLevelMethod.class);

	public static boolean isColumnMatching(WebDriver driver, String columnName) {
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

			recordData = rowCount * 4;

		} else {

			logger.info("*************Record is not Available ****************");

		}
		logger.info("getTotalRecordsData()....Returning totalRecordData is " + recordData);
		return recordData;
	}
   
}
