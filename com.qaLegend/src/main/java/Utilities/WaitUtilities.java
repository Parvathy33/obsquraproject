package Utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities {

	// **************************Explicit
	// Wait***************************************************//
	public void waitForElementToBeClickableByXpathLocator_Utility(WebDriver driver, String locatorValue, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue))); // locator value or web element can
																						// be passed
	}

	public void waitForElementToBeClickableByIDLocator_Utility(WebDriver driver, String locatorValue, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue))); // locator value or web element can be
																					// passed
	}

	public void waitForElementToBeClickableByWebElement_Utility(WebDriver driver, WebElement element, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(element)); // locator value or web element can be passed
	}

	public void waitForElementTobeVisible(WebDriver driver, WebElement element, int timeOut)

	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// **************************Fluent
	// Wait***************************************************//

	public void fluentWaitForElementtoBeClickableByXpathLocator_Utility(WebDriver driver, String locatorValue,
			int totalTimeOut, int pollingTimeOut) {

		FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(totalTimeOut))
				.pollingEvery(Duration.ofSeconds(pollingTimeOut)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
	}

	public List<WebElement> visibilityOfAllElementsLocated(WebDriver driver, By locator, int timeoutSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public static WebElement presenceOfElementLocated(WebDriver driver, By locator, int timeoutSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public Alert alert_WaitForAlertPresence(WebDriver driver, int timeoutSeconds)
	{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
		 return wait.until(ExpectedConditions.alertIsPresent());
		
	}

}

//visibilityOfAllElementsLocated
//presenceOfElemntLocated
//alertIsPresent
