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
public class Home extends BaseClass {
	public Home(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()=' Logout']")
	WebElement Logout;
	@FindBy(xpath = "//b[text()='Account Created!']")
	public WebElement AccountCreated ;
	@FindBy(xpath = "//a[contains(text(),'Delete Account')]")
	 WebElement DeleteAccountLink;
	 @FindBy(xpath = "//a[text()='Continue']")
	 WebElement Continue;
	 @FindBy(xpath = "//img[@alt='Website for automation practice']")
		public WebElement AutomationPractice;
	 

 public void clickOnLogoutButton() {
	 Action.click(driver, Logout);
 }
 public  void ClickOnDeleteAccountLink() {
	 Action.click(driver, DeleteAccountLink);
	
 }
 public SigninAndLogin clickOnCountinueButton() {
	 Action.click(driver, Continue);
	return new SigninAndLogin(driver);
	 
 }
 }