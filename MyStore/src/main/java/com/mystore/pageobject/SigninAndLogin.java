/**
 * 
 */
package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actionsdriver.Action;
import com.mystore.base.BaseClass;

/**
 * 
 */
public class SigninAndLogin extends BaseClass	 {
	public SigninAndLogin (WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//h2[text()='Login to your account']")
	public WebElement LogintoyouraccountText;	
	@FindBy(xpath = "//input[@name='name']")
	public WebElement enterUserName;
	@FindBy(xpath = "//h2[text()='New User Signup!']/../form//input[@placeholder='Email Address']")
	public WebElement enterEmailAddress;
	@FindBy(xpath = "//button[text()='Signup']")
	public WebElement signinButton;
	@FindBy(xpath = "//h2[text()='Login to your account']/..//input[@placeholder='Email Address']")
	public WebElement enterEmailAddresstoLogin;
	@FindBy(xpath = "//input[@name='password']")
	public WebElement Password;
	@FindBy(xpath = "//button[text()='Login']")
	public WebElement Login;
	@FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
	public WebElement LoginErrorMessage;
	public boolean LogintoyouraccountTextIsDisplayed() {
		return Action.isElementDisplayed(driver, LogintoyouraccountText);
	}
	public void enterUserName(String userName) {
		Action.type(driver, enterUserName, userName);
	}
	public void enterEmailAddress(String email) {
		Action.type(driver, enterEmailAddress,email );
	}
	public EnterAccountInformation clickOnSignIn() {
		Action.click(driver, signinButton);
		return new EnterAccountInformation(driver);
	}
	public void enterEmailAddressToLogin(String email) {
		Action.type(driver, enterEmailAddresstoLogin,email );
	}
	public void enterPassword(String pswd) {
		Action.type(driver, Password,pswd );
	}
	public Home ClickOnloginButton() {
		Action.click(driver, Login);
		return new Home(driver);
	}
	public boolean LoginErrorMessage() {
		return Action.isElementDisplayed(driver,LoginErrorMessage );
	}
 
}
