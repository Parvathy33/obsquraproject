package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.General_Utilities;

public class LoginpageClass {

	WebDriver driver;
	General_Utilities gl = new General_Utilities();

	public LoginpageClass(WebDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initializing WebElements
	}

	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(xpath = "//button[contains(text(),'Login')]")
	WebElement loginButton;

	@FindBy(xpath = "//strong[text()='These credentials do not match our records.']")
	WebElement invalidErrorMsg;
	
	@FindBy(xpath="//h1[text()='Demo POS']")
	WebElement loginHeading;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement checkBox;
	
	@FindBy(xpath="//a[@class='btn btn-link']")
	WebElement forgotPassword;

	public HomepageClass validLogin(String uname, String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginButton.click();
		return new HomepageClass(driver); // chaining of pages. Login page to dash board page navigation

	}

	public LoginpageClass invalidLogin(String uname, String pwd) // LoginpageClass or void can be used as return type
	{
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginButton.click();
		return this; // this is used to represent the current class or

		// return LoginpageClass.this;

	}

	public String getTextofInvalidErrormsg() {
		return invalidErrorMsg.getText();

	}
	
	public String getPlaceholderattributeofUsername(String attribute)
	{
		return gl.getAttributeof_Element(username, attribute);
	}
	
	public String getLoginpageHeading()
	{
		return loginHeading.getText();
	}
	
	public boolean checkBoxEnableOrNot()
	{
		return gl.is_Element_selected(checkBox);
	}
	
	 public ForgotPasswordpageClass clickForgotPassword() 
	 
	{
		 forgotPassword.click();
		 return new ForgotPasswordpageClass(driver); // chaining of pages. Login page to reset page navigation
	}
}
	


