package pageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.General_Utilities;
import Utilities.WaitUtilities;
import constants.ConstantsClass;

public class ExpensesPageClass {
	WebDriver driver;
	General_Utilities gl = new General_Utilities();
	WaitUtilities wait = new WaitUtilities();

	public ExpensesPageClass(WebDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	@FindBy(xpath = "//div[@class='file-caption-name']")
	WebElement expenseFileBrowse;

	@FindBy(xpath = "//span[@id='select2-location_id-container']")
	WebElement businessLocation;
	
	@FindBy(css="span#select2-location_id-container")
	WebElement businessLocationSelection;

	@FindBy(id = "select2-expense_category_id-container")
	WebElement expenseCategory;
	
	@FindBy(xpath="//h3[@class='box-title']")
	WebElement categoryHeading;
	
	@FindBy(xpath = "//input[@name='ref_no']")
	WebElement referenceNumber;

	@FindBy(id = "expense_transaction_date")
	WebElement expenseDate;

	@FindBy(xpath = "//input[@class='form-control input_number' and @name='final_total' and @placeholder='Total amount']")
	WebElement totalAmount;

	@FindBy(xpath = "//ul[@class='select2-results__options']//li")
	WebElement expenseFor;

	@FindBy(xpath = "//textarea[@name='additional_notes']")
	WebElement textArea;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement save;



	public void businessLocationExpenseDropdownClick() {
		wait.waitForElementTobeVisible(driver, businessLocation, 5);
		businessLocation.click();
		gl.keyDown_Utility(driver,Keys.UP);
		gl.keyEnter_Utility(driver, Keys.ENTER);

	}

	public void expenseCategoryDropdown(int index) {
		wait.waitForElementTobeVisible(driver, expenseCategory, 5);

		gl.select_Option_From_Dropdown_Using_Index(expenseCategory, index);
	}

	public void referenceNumberTextBox(String ref) {
		referenceNumber.clear();
		referenceNumber.sendKeys(ref);
	}

	public void expenseDateDropDown(String date) {
		expenseDate.clear();
		expenseDate.sendKeys(date);
	}

	public void totalAmountTextBox(String amount) {
		totalAmount.clear();
		totalAmount.sendKeys(amount);
	}

	public void expenseForDropdown(int index) {
		wait.waitForElementTobeVisible(driver, expenseFor, 5);

		gl.select_Option_From_Dropdown_Using_Index(expenseFor, index);
	}

	public void expenseFileUpload() {
		expenseFileBrowse.sendKeys(ConstantsClass.addExpenseFile);

	}

	public void expenseNote(String text) 
	{
		wait.waitForElementTobeVisible(driver, textArea, 5);
		textArea.sendKeys(text);
	}
	
	public void clickOnSaveButton()
	{
	wait.waitForElementTobeVisible(driver, save, 5);
	save.click();
	}
	
	public String expenseCategoryHeading()
	{
		wait.waitForElementTobeVisible(driver, categoryHeading, 5);
	return categoryHeading.getText();
	}
}
