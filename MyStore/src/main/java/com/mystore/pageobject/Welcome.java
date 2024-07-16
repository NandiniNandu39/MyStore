package com.mystore.pageobject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actionsdriver.Action;
import com.mystore.base.BaseClass;

public class Welcome extends BaseClass {
 public Welcome(WebDriver driver) {
	 PageFactory.initElements(driver, this);
	 
 }
 
 @FindBy(xpath = "//img[@alt=\"Website for automation practice\"]")
 WebElement MyStorelogo;
 @FindBy(xpath = "//a[contains(text(),'Signup / Login')]")
 WebElement SignupAndLoginLink;
 @FindBy(xpath = "//div[@aria-label='Close ad']")
 public WebElement Close;
 @FindBy(xpath = "//iframe[@id='aswift_1']")
 public WebElement IFrameClose;
 
 public boolean MyStorelogoIsDisplayed() {
	 return Action.isElementDisplayed(driver, MyStorelogo); 
 }
 public String getMyStoreTitle() {
	 String myStoreTitle=driver.getTitle();
	 return myStoreTitle;
 }
 public SigninAndLogin ClickOnSignupAndLoginLink() {
	 Action.click(driver, SignupAndLoginLink);
	 return new SigninAndLogin(driver);
 }
 public void clickOnCloseIcon() {
	 Action.click(driver, Close);
 }
 
 
}
