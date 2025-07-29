package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomepageClass;
import pageClasses.LoginpageClass;
import baseClass.BaseClass;

public class HomePageTestClass extends BaseClass {
  @Test
  public void verifyTheTooltipOfCalculatorIcon() 
  {
	  LoginpageClass lp = new LoginpageClass(driver);
	  HomepageClass hp = lp.validLogin("admin", "123456");
	  hp.ClickOnEndTourButton();
	  String actualResult = hp.getToolTipOfCalculatorIcon("data-original-title");
	  String expectedResult = "Calculator";
	  System.out.println(actualResult);
	  Assert.assertEquals(actualResult, expectedResult);
  }
}
