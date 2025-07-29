package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
	
import Utilities.ExcelReadUtility;
import baseClass.BaseClass;
import pageClasses.ForgotPasswordpageClass;
import pageClasses.HomepageClass;
import pageClasses.LoginpageClass;

public class LoginpageTestClass extends BaseClass {
	@Test

	public void verifySuccesfulLogin() throws IOException {
		LoginpageClass lp = new LoginpageClass(driver);
		HomepageClass hp = lp.validLogin(ExcelReadUtility.getStringData(0, 0, "LoginPage"),ExcelReadUtility.getIntegerData(0, 1, "LoginPage"));
		hp.ClickOnEndTourButton();
		String actualResult = hp.getTextOfWelcomeHeading();
		String expectedResult = ExcelReadUtility.getStringData(4, 0, "LoginPage");
		Assert.assertTrue(actualResult.contains(expectedResult));

	}
	@Test
	public void verifyUnSuccesfulLogin() {
		LoginpageClass lp = new LoginpageClass(driver);
		lp.invalidLogin("www", "in87");
		String actualResult = lp.getTextofInvalidErrormsg();
		String expectedResult = "These credentials do not match our records.";
		Assert.assertTrue(actualResult.contains(expectedResult));

	}

	@Test
	public void verifyUsernameTextboxShowingHintorNot() {
		LoginpageClass lp = new LoginpageClass(driver);
		Boolean actualResult = lp.getPlaceholderattributeofUsername("placeholder").isEmpty();
		Assert.assertEquals(actualResult, true);

	}

	@Test
	public void verifyApplicationLaunch() {
		LoginpageClass lp = new LoginpageClass(driver);
		String actualResult = lp.getLoginpageHeading();
		String expectedResult = "Demo POS";
		Assert.assertTrue(actualResult.contains(expectedResult));

	}

	@Test
	public void verifyRemembermeCheckboxCheckOrNot() {
		LoginpageClass lp = new LoginpageClass(driver);
		boolean actualResult = lp.checkBoxEnableOrNot();
		System.out.println(actualResult);
		Assert.assertEquals(actualResult, false);
	}
	
	@Test
	public void verifyResetPassworddPageLoading()
	{
		LoginpageClass lp = new LoginpageClass(driver);
		ForgotPasswordpageClass resetPage =  lp.clickForgotPassword();
		boolean actualResult =  resetPage.isForgotPasswordPageLoaded();
		System.out.println(actualResult);
		Assert.assertEquals(actualResult, true);
		
	}
	}

//in 3 class create 5 Test case
// 
