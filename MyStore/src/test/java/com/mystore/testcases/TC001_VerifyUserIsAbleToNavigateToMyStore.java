package com.mystore.testcases;

import java.io.IOException;
import java.util.Map;

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
import com.mystore.pageobject.SigninAndLogin;
import com.mystore.pageobject.Welcome;

@Listeners(ExtentTestNGITestListener.class)
public class TC001_VerifyUserIsAbleToNavigateToMyStore extends BaseClass {
	Object LoginText;

	@Test
	public void loginToApplication() throws IOException {
		Variables variable = new Variables();
		variable.sheetName = "MyStore";
		variable.uniqueId = "TC001";

		variable.filePath = prop.getProperty("filePath");
		Welcome welcome = new Welcome(driver);
		boolean result = welcome.MyStorelogoIsDisplayed();
		Assert.assertTrue(result);

		welcome.ClickOnSignupAndLoginLink();
		SigninAndLogin signinAndlogin = new SigninAndLogin(driver);
		boolean isDisplayed = signinAndlogin.LogintoyouraccountTextIsDisplayed();
		Assert.assertTrue(isDisplayed);
		Map<String, String> commonData = Test_Data1.loadData(variable.filePath, variable.sheetName, variable.uniqueId);
		System.out.println("Loaded commonData: " + commonData);
		String LoginText = Test_Data1.getValueByKey(commonData, "LoginText");
		Action.waitTillVisible(driver, signinAndlogin.LogintoyouraccountText);
		Action.isTextOfElementMatchesExpectedValue(signinAndlogin.LogintoyouraccountText, LoginText, false);
		String userName = prop.getProperty("userName");
		Action.click(driver, signinAndlogin.enterEmailAddresstoLogin);
		signinAndlogin.enterEmailAddressToLogin(userName);
		Action.click(driver, signinAndlogin.Password);
		signinAndlogin.enterPassword(prop.getProperty("password"));
		signinAndlogin.ClickOnloginButton();

		String title = driver.getTitle();
		Assert.assertEquals(title, "Automation Exercise");

	}
}
