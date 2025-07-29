package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.General_Utilities.TableUtils;
import baseClass.BaseClass;
import pageClasses.CustomerPageClass;
import pageClasses.HomepageClass;
import pageClasses.LoginpageClass;

public class CustomerPageTestClass  extends BaseClass  {
  @Test
  public void verifyCustomerPageNavigation() {
	  
	  LoginpageClass lp = new LoginpageClass(driver);
	  HomepageClass hp = lp.validLogin("admin", "123456");
	  hp.ClickOnEndTourButton();
	  hp.clickOnContacts();
	  hp.clickOnCustomer();
	  CustomerPageClass cp=new CustomerPageClass(driver);
	  String actualResult=cp.getHeading();
	  String expectedResult = "All your Customers";
	  Assert.assertEquals(actualResult,expectedResult );
	  
  }
  
  @Test
  public void verifySearchCustomer()
  {
	  LoginpageClass lp = new LoginpageClass(driver);
	  HomepageClass hp = lp.validLogin("admin", "123456");
	  hp.ClickOnEndTourButton();
	  hp.clickOnContacts();
	  hp.clickOnCustomer();
	  CustomerPageClass cp=new CustomerPageClass(driver);
	  String searchTerm = "Jackson";
	  cp.searchCustomer(searchTerm);
	  boolean isPresent = TableUtils.isTextPresentInTable(cp.getTableRows(), searchTerm);
	  Assert.assertTrue(isPresent);
	  
  }
  }

