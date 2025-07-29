package pageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.General_Utilities;
import Utilities.WaitUtilities;

public class UserManagementPageClass {
	WebDriver driver;
	General_Utilities gl = new General_Utilities();
	WaitUtilities wait = new WaitUtilities();

	public UserManagementPageClass(WebDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/users/create']")
	WebElement addUserButton;

	@FindBy(id = "surname")
	WebElement preFix;

	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "last_name")
	WebElement lastName;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "role")
	WebElement role;

	@FindBy(id = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(name = "confirm_password")
	WebElement confirmPassword;

	@FindBy(id = "cmmsn_percent")
	WebElement salesCommissioPercentage;

	@FindBy(id = "submit_user_button")
	WebElement saveButton;

	@FindBy(xpath = "//h3[@class='box-title' and contains(text(), 'All users')]")
	WebElement allUsers;

	@FindBy(xpath = "//div[@id='users_table_filter']//input[@type='search']")
	WebElement searchBox;

	@FindBy(xpath = "//table[@id='users_table']/tbody/tr")
	List<WebElement> tableRows;
	
	@FindBy(xpath = "//button[contains(@class, 'swal-button--confirm') and text()='OK']")
	WebElement deleteAlertOk;

	public UserManagementPageClass clikOnAddUserPlusButton() {
		addUserButton.click();
		return this;
	}

	public void preFixOfUser(String prefix) {
		preFix.clear();
		preFix.sendKeys(prefix);
	}

	public void firstNameOfUser(String fname) {
		firstName.clear();
		firstName.sendKeys(fname);

	}

	public void lastNameOfUser(String lname) {
		lastName.clear();
		lastName.sendKeys(lname);

	}

	public void emailOfUser(String emailid) {
		email.clear();
		email.sendKeys(emailid);

	}

	public void roleOfUser(int index) {

		gl.select_Option_From_Dropdown_Using_Index(role, index);

	}

	public void userNameOfUser(String uname) {
		username.clear();
		username.sendKeys(uname);

	}

	public void passwordOfUser(String pass) {
		password.clear();
		password.sendKeys(pass);

	}

	public void confirmPasswordOfUser(String confirmPass) {
		confirmPassword.clear();
		confirmPassword.sendKeys(confirmPass);

	}

	public void salesCommission(String valueofsalesCP)

	{
		salesCommissioPercentage.clear();
		salesCommissioPercentage.sendKeys(valueofsalesCP);

	}

	public UserManagementPageClass clickOnSaveButton() {

		saveButton.click();
		return this;
	}

	public String getHeadingOfUserPage() {
		return allUsers.getText();
	}
	
	public void searchUser(String searchText) {
		
	
		wait.waitForElementTobeVisible(driver, searchBox, 5);
		searchBox.click();
		searchBox.clear();
		searchBox.sendKeys(searchText);
		
	}

	 public List<WebElement> getTableRows() {
	        return tableRows;
	    }
	 public By deleteButtonForUsername(String username) {
	        return By.xpath("//td[text()='" + username + "']/following-sibling::td//button[contains(@class, 'delete_user_button')]");
	    }
	 public void clickDeleteButton(String username) {
	        driver.findElement(deleteButtonForUsername(username)).click();
	       
	    }
	 public void deleteAlertPopUpAccept()
	 {
		 wait.waitForElementTobeVisible(driver, deleteAlertOk, 10);
		 deleteAlertOk.click();
	 }
	
}

