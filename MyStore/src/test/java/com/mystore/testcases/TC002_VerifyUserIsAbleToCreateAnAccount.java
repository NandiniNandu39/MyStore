/**
 * 
 */
package com.mystore.testcases;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mystore.actionsdriver.Action;
import com.mystore.actionsdriver.Variables;
import com.mystore.base.BaseClass;
import com.mystore.base.ExtentTestNGITestListener;
import com.mystore.dataprovider.Test_Data1;
import com.mystore.pageobject.EnterAccountInformation;
import com.mystore.pageobject.Home;
import com.mystore.pageobject.SigninAndLogin;
import com.mystore.pageobject.Welcome;
import com.mystore.utility.GenericRepository;

/**
 * 
 */
@Listeners(ExtentTestNGITestListener.class)
public class TC002_VerifyUserIsAbleToCreateAnAccount extends BaseClass {

	@Test
	public void createAnAccount() throws IOException, InterruptedException {
		Welcome welcome = new Welcome(driver);
		Variables variables = new Variables();
		variables.filePath = prop.getProperty("filePath");
		boolean result = welcome.MyStorelogoIsDisplayed();
		Assert.assertTrue(result);
		welcome.ClickOnSignupAndLoginLink();
		SigninAndLogin signinAndlogin = new SigninAndLogin(driver);
		variables.isDisplayed = signinAndlogin.LogintoyouraccountTextIsDisplayed();
		Assert.assertTrue(variables.isDisplayed);
		Map<String, String> commonData = Test_Data1.loadData(variables.filePath, "MyStore", "TC002");
		System.out.println("Loaded commonData: " + commonData);
		Test_Data1.getValueByKey(commonData, "LoginText");
		Action.waitTillVisible(driver, signinAndlogin.LogintoyouraccountText);
		Action.isTextOfElementMatchesExpectedValue(signinAndlogin.LogintoyouraccountText, variables.LoginText, false);
		signinAndlogin.enterEmailAddress(GenericRepository.generateRandomEmail(Variables.length));
		signinAndlogin.enterUserName(GenericRepository.generateRandomString(Variables.length));
		signinAndlogin.clickOnSignIn();
		EnterAccountInformation information = new EnterAccountInformation(driver);
		variables.enterAccountDetains = Test_Data1.getValueByKey(commonData, "Enter_Account_Details");
		Variables.isEqual = Action.isTextOfElementMatchesExpectedValue(information.enterAccountInformationText,
				variables.enterAccountDetains, false);
		Assert.assertTrue(Variables.isEqual);
		variables.gender = Test_Data1.getValueByKey(commonData, "Gender");
		WebElement gender = information.gender(variables.gender);
		Action.click(driver, gender);
		variables.password = Test_Data1.getValueByKey(commonData, "LoginText");
		information.PassWordTextField(variables.password.toString());
		Object birthYear = Test_Data1.getValueByKey(commonData, "Birth_Year");
		information.selectBirthYear(birthYear.toString());
		Object birthMonth = Test_Data1.getValueByKey(commonData, "Birth_Month");
		information.selectBirthMonth(birthMonth.toString());
		Object birthDay = Test_Data1.getValueByKey(commonData, "Birth_Date");
		information.selectBirthDay(birthDay.toString());
		Variables.randomName = GenericRepository.generateRandomString(Variables.length);
		information.enterFirstName(Variables.randomName);
		information.enterlastName(Variables.randomName);
		Test_Data1.writeData(variables.filePath, "MyStore", "TC002", "First_Name", Variables.randomName, false);
		Test_Data1.writeData(variables.filePath, "MyStore", "TC002", "Last_Name", Variables.randomName, false);
		Action.scrollByVisibilityOfElement(driver, information.Address);
		variables.Address = Test_Data1.getValueByKey(commonData, "Birth_Month");
		information.enterAddress(variables.Address);
		String state = Test_Data1.getValueByKey(commonData, "State");
		information.enterStateName(state);
		String city = Test_Data1.getValueByKey(commonData, "City");
		information.enterCityName(city);
		String zipCode = Test_Data1.getValueByKey(commonData, "ZipCode");
		information.enterZipCode(zipCode);
		Variables.mobileNumber = Test_Data1.getValueByKey(commonData, "Mobile_Number");
		information.enterMobileNumber(Variables.mobileNumber);
		information.clickOnCreateAccountButton();
		Home home = new Home(driver);
		variables.SuccessMessage = Test_Data1.getValueByKey(commonData, "Success_Message");
		Action.isTextOfElementMatchesExpectedValue(home.AccountCreated, variables.SuccessMessage, false);
		home.clickOnCountinueButton();
		variables.isDisplayed = Action.isElementDisplayed(driver, welcome.IFrameClose);
		if (variables.isDisplayed) {
			Action.switchToFrameByFrameElement(welcome.IFrameClose);
			welcome.clickOnCloseIcon();
		}
		Action.switchToDefaultFrame();
		String logo = Test_Data1.getValueByKey(commonData, "Logo");
		Action.waitTillVisible(driver, home.AutomationPractice);
		Action.isValueOfElementMatchesExpectedValue(home.AutomationPractice, "alt", logo, false);

	}

}
