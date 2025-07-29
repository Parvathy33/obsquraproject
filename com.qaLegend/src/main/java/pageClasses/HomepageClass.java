package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.General_Utilities;
import Utilities.WaitUtilities;

public class HomepageClass {
	WebDriver driver;
	General_Utilities gl = new General_Utilities();
	WaitUtilities wait = new WaitUtilities();

	public HomepageClass(WebDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='End tour']")
	WebElement endTourButton;
	
	@FindBy(xpath = "//span[text()='User Management']")
	WebElement userManagement;

	@FindBy(xpath = "//span[contains(text(), 'Users')]")
	WebElement users;

	
	@FindBy(xpath = "//section[@class='content-header']/h1")
	WebElement welcomeHeading;
	
	@FindBy (id="btnCalculator")
	WebElement calculatorIcon;
	
	@FindBy(xpath = "//i[@class='fa fa-minus-circle']")
	WebElement expensesOption;
	
	@FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/expenses/create']")
	WebElement expenseAdd;
	
	@FindBy(id="tour_step4_menu")
	WebElement contacts;
	
	@FindBy(xpath="//a[contains(@href, 'contacts?type=customer') and contains(text(), 'Customers')]")
	WebElement customer;
	
	@FindBy(xpath="//a[contains(@href, 'expense-categories') and contains(text(), 'Expense Categories')]")
	WebElement expenseCategoryMenu;
	
	public void ClickOnEndTourButton()
	{
		try 
		{
			wait.waitForElementTobeVisible (driver, endTourButton,5);
			if(endTourButton.isDisplayed())
			{
				endTourButton.click();
				System.out.println("Clicked on EndTour button");
			}
			
			else 
			{
				System.out.println("EndTour button is not visible");
			}
			
		}
		catch (Exception e) 
		{
			System.out.println("Exception occured" + e.getMessage());
		}
	}
		public String getTextOfWelcomeHeading()
		{
			wait.waitForElementTobeVisible(driver, welcomeHeading, 5);
			return welcomeHeading.getText();
			
		}
		
		public String getToolTipOfCalculatorIcon(String attribute)
		{
			return gl.getAttributeof_Element(calculatorIcon, attribute);
		}
		
		public HomepageClass clickOnUserManagement()
		{
			wait.waitForElementTobeVisible(driver, userManagement, 5);
			userManagement.click();
			return this; // loading in the same page
		}
		
		
		 public UserManagementPageClass clickOnUser() 
		 
			{
			 wait.waitForElementTobeVisible(driver, users, 5);
			 users.click();
				 return new UserManagementPageClass(driver); // chaining of pages. Home page to add user page navigation
			}
		 
		 public HomepageClass clickOnExpense() 
		 
			{
			 wait.waitForElementTobeVisible(driver, expensesOption, 5);
			 expensesOption.click();
			 return this; // loading on same page
			}
		 
			public ExpensesPageClass clickOnExpenseAdd() {
				wait.waitForElementTobeVisible(driver, expenseAdd, 5);
				expenseAdd.click();
				return new ExpensesPageClass(driver);
			}
			public HomepageClass clickOnContacts()
			{
				wait.waitForElementTobeVisible(driver, contacts, 5);
				contacts.click();
				return this;
			}
		
			public CustomerPageClass clickOnCustomer()
			{
				wait.waitForElementTobeVisible(driver, customer, 5);
				customer.click();
				return new CustomerPageClass(driver);
			}
			public ExpensesPageClass clickOnExpenseCategory()
			{
				wait.waitForElementTobeVisible(driver, expenseCategoryMenu, 5);
				expenseCategoryMenu.click();
				return new ExpensesPageClass(driver);
			}
			}
		
		
		
	
		
	

