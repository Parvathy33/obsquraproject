package Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class General_Utilities {
	public String getAttributeof_Element(WebElement element, String attribute) {

		return element.getAttribute(attribute);

	}

	public boolean is_Element_Displayed(WebElement element) {
		return element.isDisplayed();
	}

	public boolean is_Element_selected(WebElement element) {
		return element.isSelected();
	}

	public boolean is_Dropdown_Multiselect(WebElement element) {

		Select select = new Select(element);
		return select.isMultiple();// command is used to check whether drop down is multiple

	}

	public void select_Option_From_Dropdown_Using_Index(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public List<String> getAllOptions_From_Dropdown(WebElement element) {
		Select select = new Select(element);
		return select.getOptions().stream().map(WebElement::getText).collect(Collectors.toList());
	} // to get the name of all values from the drop down

	public List<String> getAllSelectedOptions_From_Dropdown(WebElement element) {
		Select select = new Select(element);
		return select.getAllSelectedOptions().stream().map(WebElement::getText).collect(Collectors.toList());
	}

	public List<String> getTextsFromElements(List<WebElement> elements) {
		List<String> texts = new ArrayList<String>();
		for (WebElement element : elements) {
			texts.add(element.getText().trim());
		}
		return texts;

	}

	public void file_Upload(WebElement element, String filePath) {
		element.sendKeys(filePath);
	}

	public void keyDown_Utility(WebDriver driver, Keys key) {
		Actions actions = new Actions(driver);
		actions.keyDown(key).perform();
	}

	public void keyUp_Utility(WebDriver driver, Keys key) {
		Actions actions = new Actions(driver);
		actions.keyUp(key).perform();
	}
	public void keyEnter_Utility(WebDriver driver, Keys key) {
		Actions actions = new Actions(driver);
		actions.sendKeys(key).perform();
	}

	public void dragAndDrop_Utility(WebDriver driver, WebElement sourceElement, WebElement destinationElement) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(sourceElement, destinationElement).perform();
	}

	public void alert_Accept(WebDriver driver) {
		driver.switchTo().alert().accept(); // accepting alert
	}

	public void alert_Dismiss(WebDriver driver) {

		driver.switchTo().alert().dismiss();// dismissing an alert
	}

	public void promptAlert_Input_Text(WebDriver driver, String text) {

		driver.switchTo().alert().sendKeys(text);
	}

	public void switchToFrameByNameOrID(WebDriver driver, String NameOrID) {
		driver.switchTo().frame(NameOrID);
	}

	public void switchToFrameByWebElement(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchBackFromTheiFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void addSleep_Utility(long timeOut) throws InterruptedException {
		Thread.sleep(timeOut);
	}

	public boolean is_Element_enabled(WebElement element) {
		return element.isEnabled();
	}

	public void select_By_Value(WebElement Element, String value) {
		Select select = new Select(Element);
		select.selectByValue(value);
	}

	public void select_By_VisibleText(WebElement Element, String visibleText) {
		Select select = new Select(Element);
		select.selectByVisibleText(visibleText);

	}

	public void deselect_All(WebElement Element) {
		Select select = new Select(Element);
		if (select.isMultiple()) {
			select.deselectAll();
			System.out.println("All options deselected.");
		} else {
			System.out.println("Dropdown does not support multiple selections.");
		}
	}

	public void deselect_By_index(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	public String getTextOf_Alertmsg(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public static class TableUtils {

		public static boolean isTextPresentInTable(List<WebElement> rows, String searchText) 
		{
			if (rows == null || rows.isEmpty()) 
			{
				System.out.println("No table rows found.");
				return false;
			}

			for (WebElement row : rows) 
			{
				if (row.getText().toLowerCase().contains(searchText.toLowerCase())) 
				{
					return true;
				}
			}

			return false;
		}
	}
}

//is_Element_enabled
//select_By_Value
//select_By_VisibleText
//deselect_All
//deselect_By_index
//getTextOf_Alertmsg
