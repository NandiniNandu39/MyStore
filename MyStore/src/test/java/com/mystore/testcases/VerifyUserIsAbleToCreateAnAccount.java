/**
 * 
 */
package com.mystore.testcases;

import java.io.IOException;

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
import com.mystore.dataprovider.Test_Data;
import com.mystore.pageobject.EnterAccountInformation;
import com.mystore.pageobject.SigninAndLogin;
import com.mystore.pageobject.Welcome;
import com.mystore.utility.GenericRepository;

/**
 * 
 */
@Listeners(ExtentTestNGITestListener.class)
public class VerifyUserIsAbleToCreateAnAccount extends BaseClass{
    
	@Test
	public void createAnAccount() throws IOException, InterruptedException {
		Welcome welcome = new Welcome(driver);
		Variables variables=new Variables();
        boolean result = welcome.MyStorelogoIsDisplayed();
        Assert.assertTrue(result);
        welcome.ClickOnSignupAndLoginLink();
        SigninAndLogin signinAndlogin = new SigninAndLogin(driver);
        variables.isDisplayed   = signinAndlogin.LogintoyouraccountTextIsDisplayed();
        Assert.assertTrue( variables.isDisplayed );
        try {
        	variables.LoginText = Test_Data.singleRowMapData("C:\\Users\\User\\Downloads\\MyStore_TestData.xlsx", "MyStore", "TC001", "LoginText");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Action.isTextOfElementMatchesExpectedValue(signinAndlogin.LogintoyouraccountText,variables.LoginText,false);
        signinAndlogin.enterEmailAddress(GenericRepository.generateRandomEmail(Variables.length));
        signinAndlogin.enterUserName(GenericRepository.generateRandomString(Variables.length));
        signinAndlogin.clickOnSignIn();
        EnterAccountInformation information=new EnterAccountInformation(driver);
        
	try {
		variables.enterAccountDetains = Test_Data.singleRowMapData("C:\\Users\\User\\Downloads\\MyStore_TestData.xlsx", "MyStore", "TC002", "Enter_Account_Details");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(variables.enterAccountDetains);
	Variables.isEqual= Action.isTextOfElementMatchesExpectedValue(information.enterAccountInformationText, variables.enterAccountDetains,false);
       Assert.assertTrue(Variables.isEqual);
      
       variables.gender=Test_Data.singleRowMapData("C:\\Users\\User\\Downloads\\MyStore_TestData.xlsx", "MyStore", "TC002", "Gender");
	
       System.out.println(variables.gender);
       
       WebElement gender=information.gender(variables.gender);
       Action.click(driver, gender);
       Object password="";
       try {
    	   password =Test_Data.singleRowMapData("C:\\Users\\User\\Downloads\\MyStore_TestData.xlsx", "MyStore", "TC002", "Password");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

       information.PassWordTextField(password.toString());
       Object birthYear=Test_Data.singleRowMapData("C:\\Users\\User\\Downloads\\MyStore_TestData.xlsx", "MyStore", "TC002", "Birth_Year");
	   information.selectBirthYear(birthYear.toString());
	   Object birthMonth=Test_Data.singleRowMapData("C:\\Users\\User\\Downloads\\MyStore_TestData.xlsx", "MyStore", "TC002", "Birth_Month");
	   information.selectBirthMonth(birthMonth.toString());
	   Object birthDay=Test_Data.singleRowMapData("C:\\Users\\User\\Downloads\\MyStore_TestData.xlsx", "MyStore", "TC002", "Birth_Date");
	   information.selectBirthDay(birthDay.toString());
	   Variables.randomName= GenericRepository.generateRandomString(Variables.length);
	   information.enterFirstName(Variables.randomName);
	   information.enterlastName(Variables.randomName);
	   information.enterlastName(Variables.randomName);

	   
	}
	

}
