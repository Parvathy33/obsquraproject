package testClasses;

import static org.testng.Assert.assertTrue;

import java.util.List;

import javax.lang.model.element.Element;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.General_Utilities.TableUtils;
import pageClasses.HomepageClass;
import pageClasses.LoginpageClass;
import pageClasses.UserManagementPageClass;
import baseClass.BaseClass;

public class UserManagementTestClass extends BaseClass {
	@Test
	public void verifyAddUser()

	{
		LoginpageClass lp = new LoginpageClass(driver);
		HomepageClass hp = lp.validLogin("admin", "123456");
		hp.ClickOnEndTourButton();
		hp = hp.clickOnUserManagement(); // loading the same page
		UserManagementPageClass usr = hp.clickOnUser(); // chaining
		usr = usr.clikOnAddUserPlusButton();
		usr.preFixOfUser("Mrs");
		usr.firstNameOfUser("Deepa");
		usr.lastNameOfUser("NJJacob");
		usr.emailOfUser("Deepa@test.com");
		usr.roleOfUser(1);
		usr.userNameOfUser("Deepatester");
		usr.passwordOfUser("123456");
		usr.confirmPasswordOfUser("123456");
		usr.salesCommission("30");
		usr = usr.clickOnSaveButton(); // same page
		String searchTerm = "Deepa@test.com";
		usr.searchUser(searchTerm);
		boolean isPresent = TableUtils.isTextPresentInTable(usr.getTableRows(), searchTerm);
		System.out.println(isPresent);
		Assert.assertTrue(isPresent, "Search result for was NOT found.");

	}

	@Test
	public void deleteUser() {
		LoginpageClass lp = new LoginpageClass(driver);
		HomepageClass hp = lp.validLogin("admin", "123456");
		hp.ClickOnEndTourButton();
		hp = hp.clickOnUserManagement(); // loading the same page
		UserManagementPageClass usr = hp.clickOnUser(); // chaining
		String usernameToDelete = "newusersayhijohn@test.com";
		usr.searchUser(usernameToDelete);
		usr.clickDeleteButton(usernameToDelete);
		usr.deleteAlertPopUpAccept();
		usr.searchUser(usernameToDelete);
		boolean afterDelete = TableUtils.isTextPresentInTable(usr.getTableRows(), usernameToDelete);
		Assert.assertFalse(afterDelete);
		

	}
}
