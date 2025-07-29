package testClasses;
import Utilities.General_Utilities.TableUtils;
import pageClasses.ExpensesPageClass;
import pageClasses.HomepageClass;
import pageClasses.LoginpageClass;
import pageClasses.UserManagementPageClass;
import baseClass.BaseClass;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ExpensePageTestClass extends BaseClass {
  @Test
  public void verifyExpenseCategoryLoading() 
  {
	  LoginpageClass lp = new LoginpageClass(driver);
	  HomepageClass hp = lp.validLogin("admin", "123456");
	  hp.ClickOnEndTourButton();
	  hp.clickOnExpense(); // chaining
	  hp.clickOnExpenseCategory();
	  ExpensesPageClass ep = new ExpensesPageClass(driver);
	  String expectedResult = ep.expenseCategoryHeading();
	  String actualResult = "All your expense categories";
	  Assert.assertEquals(actualResult, expectedResult);
	  

	  
  }
}
