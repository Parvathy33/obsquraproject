package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.General_Utilities;
import Utilities.WaitUtilities;

public class ForgotPasswordpageClass {
	WebDriver driver;
	General_Utilities gl = new General_Utilities();
	WaitUtilities wait = new WaitUtilities();

	public ForgotPasswordpageClass(WebDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='panel-heading']")
	WebElement resetPageHeading;

	public boolean isForgotPasswordPageLoaded()
	
	{
		return resetPageHeading.isDisplayed();
		
}
}


