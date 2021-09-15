package Utility_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.regex.Pattern;

public class ApplicationWaits {

	public WebDriverWait wait;

	public ApplicationWaits(WebDriver driver,long timeout) {
		wait = new WebDriverWait(driver, timeout);
	}

	public List<WebElement> waitForVisibilityOfNestedElementsLocatedBy(WebElement element, By childLocator) {
		return wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(element, childLocator));
	}

	public List<WebElement> waitForVisitbilityOfNestedElementsLocatedBy(WebElement parent, By childLocator) {
		return wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(parent, childLocator));
	}

	public WebElement waitForvisibilityOfElementLocated(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public List<WebElement> waitForpresenceOfElementLocated(By locator) {
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public List<WebElement> waitForpresenceOfElementLocated(WebElement... elements) {
		return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	public WebElement waitForvisibilityOf(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public Boolean waitForurlToBe(String url) {
		return wait.until(ExpectedConditions.urlToBe(url));
	}

	public Boolean isUrlMatches(String regex) {
		return wait.until(ExpectedConditions.urlMatches(regex));
	}

	public Boolean isUrlContains(String fraction) {
		return wait.until(ExpectedConditions.urlContains(fraction));
	}

	public Boolean istitle(String title) {
		return wait.until(ExpectedConditions.titleIs(title));
	}

	public Boolean isTitleContains(String title) {
		return wait.until(ExpectedConditions.titleContains(title));
	}

	public Boolean presenceOfElementLocated(WebElement element, String text) {
		return wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
	}

	public Boolean istextPresentInlocator(By locator, String text) {
		return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}

	public Boolean istextPresentInElementValue(WebElement element,String text) {
		return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	
	public Boolean istextMatches(By locator,Pattern pattern) {
		return wait.until(ExpectedConditions.textMatches(locator, pattern));
	}
	
	public Boolean textToBe(By locator,String value) {
		return wait.until(ExpectedConditions.textToBe(locator, value));
	}
	
	public List<WebElement> waitForpresenceOfNestedElementsLocatedBy(By parent,By childLocator) {
		return wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(parent, childLocator));
	}
	
	public List<WebElement> istextPresentInElementValue(By locator) {
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	public Boolean waitFornumberOfWindowsToBe(int expectedNumberOfWindows) {
		return wait.until(ExpectedConditions.numberOfWindowsToBe(expectedNumberOfWindows));
	}
	
	public List<WebElement> waitFornumberOfElementsToBeMoreThan(By locator,int number) {
		return wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, number));
	}
	
	public List<WebElement> waitFornumberOfElementsToBeLessThan(By locator,int number) {
		return wait.until(ExpectedConditions.numberOfElementsToBeLessThan(locator, number));
	}
	
	public List<WebElement> waitFornumberOfElementsToBe(By locator,int number) {
		return wait.until(ExpectedConditions.numberOfElementsToBe(locator, number));
	}
	
	public Object waitForjsReturnsValue(String javaScript) {
		return wait.until(ExpectedConditions.jsReturnsValue(javaScript));
	}

	public Boolean waitForjavaScriptThrowsNoExceptions(String javaScript) {
		return wait.until(ExpectedConditions.javaScriptThrowsNoExceptions(javaScript));
	}
	
	public Boolean waitForinvisibilityOfElementWithText(By locator,String text) {
		return wait.until(ExpectedConditions.invisibilityOfElementWithText(locator, text));
	}
	
	public Boolean waitForinvisibilityOfElementLocated(By locator) {
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	public Boolean waitForinvisibilityOfAllElements(WebElement...elements) {
		return wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}
	
	public Boolean waitForinvisibilityOf(WebElement element) {
		return wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public WebDriver waitForframeToBeAvailableAndSwitchToIt(String frameLocator) {
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}
	
	public Boolean waitForelementToBeSelected(By locator) {
		return wait.until(ExpectedConditions.elementToBeSelected(locator));
	}
	
	public WebElement waitForelementToBeClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public Boolean waitForelementSelectionStateToBe(WebElement element,boolean selected) {
		return wait.until(ExpectedConditions.elementSelectionStateToBe(element, selected));
	}
	
	public Boolean waitForelementSelectionStateToBe(By locator,boolean selected) {
		return wait.until(ExpectedConditions.elementSelectionStateToBe(locator, selected));
	}
	
	public Boolean waitForattributeToBeNotEmpty(WebElement element,String attribute) {
		return wait.until(ExpectedConditions.attributeToBeNotEmpty(element, attribute));
	}
	
	public Boolean waitForattributeToBe(By locator,String attribute,String value) {
		return wait.until(ExpectedConditions.attributeToBe(locator, attribute, value));
	}
	
	public Boolean waitForattributeContains(By locator,String attribute,String value) {
		return wait.until(ExpectedConditions.attributeContains(locator, attribute, value));
	}

	public WebElement presenceOfElementLocated(By locator) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	public WebElement visibleOfElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement elementToBeClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public WebElement frameToBeAvailabeAndSwitchToIt(By locator) {
		return (WebElement) wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}

	public WebElement alertIsPresent(By locator) {
		return (WebElement) wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void dynamicWait(long timeoutSeconds) {
		try {
			Thread.sleep(timeoutSeconds*1000);
		}
		catch(Exception e) {
			
		}
	}

}
