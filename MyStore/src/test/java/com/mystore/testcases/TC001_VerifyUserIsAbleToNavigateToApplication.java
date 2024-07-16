package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mystore.actionsdriver.Action;
import com.mystore.base.BaseClass;
import com.mystore.base.ExtentTestNGITestListener;
import com.mystore.dataprovider.Test_Data;
import com.mystore.pageobject.SigninAndLogin;
import com.mystore.pageobject.Welcome;
@Listeners(ExtentTestNGITestListener.class)
public class TC001_VerifyUserIsAbleToNavigateToApplication extends BaseClass {
    Object LoginText;

   
   

    @Test
    public void loginToApplication() {
        Welcome welcome = new Welcome(driver);
        boolean result = welcome.MyStorelogoIsDisplayed();
        Assert.assertTrue(result);

        welcome.ClickOnSignupAndLoginLink();
        SigninAndLogin signinAndlogin = new SigninAndLogin(driver);
        boolean isDisplayed = signinAndlogin.LogintoyouraccountTextIsDisplayed();
        Assert.assertTrue(isDisplayed);

        try {
            LoginText = Test_Data.singleRowMapData("C:\\Users\\User\\Downloads\\MyStore_TestData.xlsx", "MyStore", "TC002", "Enter_Account_Details");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Action.isTextOfElementMatchesExpectedValue(signinAndlogin.LogintoyouraccountText, LoginText,false);
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
