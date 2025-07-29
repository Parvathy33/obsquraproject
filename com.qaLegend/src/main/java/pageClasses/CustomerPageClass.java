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


public class CustomerPageClass {
	WebDriver driver;
	General_Utilities gl = new General_Utilities();
	WaitUtilities wait = new WaitUtilities();

	public CustomerPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//h3[contains(@class, 'box-title') and contains(text(), 'All your Customers')]")
	WebElement customerPage;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement customerSearch;
	
	@FindBy(xpath = "//table[@id='contact_table']/tbody/tr")
	List<WebElement> tableRows;
	

	public String getHeading()
	{
		wait.waitForElementTobeVisible(driver, customerPage, 5);
		return customerPage.getText();
	

	}
	public void searchCustomer(String customerName)
	
	{
		wait.waitForElementTobeVisible(driver, customerSearch, 5);
		customerSearch.sendKeys(customerName);
	}
	 public List<WebElement> getTableRows() {
	        return tableRows;
	    }
	 
	}

	

