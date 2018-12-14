package staticDataManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import uiAction.Element;

public class ApplicationLevelMethod {

	public static int getTotalSetOfData(WebDriver driver, By locator) {

		int count = Element.elementCount(driver, locator);

		int actualDataCount = count - 1;

		return actualDataCount;

	}

	@Test
	public static void getColumnHeading(WebDriver driver, String columnName) {

		By columnLoc = By.xpath("//tr[1]/th");
		int columnCount = Element.elementCount(driver, columnLoc);

		for (int i = 2; i <= columnCount; i++) {

			String columnLocator = "//tr[1]/th[" + i + "]/a";

			By columnHeardingLoc = By.xpath(columnLocator);

			String getcolumnName = Element.getText(driver, columnHeardingLoc);

			By rowLocator = By.xpath("//tr");
			
			int counttotalRow = Element.elementCount(driver, rowLocator);
			
			

			if (getcolumnName.equalsIgnoreCase(columnName)) {
                
				 int   totalData = (counttotalRow -1) * 5 ;
				  
				  
				 
				  
			}

		}

	}

	public static void getGridSpaceficData(String columnName, By locator) {

	}

}
