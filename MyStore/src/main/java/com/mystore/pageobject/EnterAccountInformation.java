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
import com.mystore.utility.GenericRepository;

/**
 * 
 */
public class EnterAccountInformation extends BaseClass{
	GenericRepository generic=new GenericRepository();
	public EnterAccountInformation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//b[text()='Enter Account Information']")
	public
	 WebElement enterAccountInformationText;
	 @FindBy(xpath = "//input[@name='password']")
	 WebElement PassWord;
	 @FindBy(xpath = "//select[@id='days']")
	 WebElement BirthDay;
	 @FindBy(xpath = "//select[@id='months']")
	 WebElement BirthMonth;
	 @FindBy(xpath = "//select[@id='years']")
	 WebElement BirthYear;
	 @FindBy(xpath = "//input[@id='first_name']")
	 WebElement FullName;
	 @FindBy(xpath = "//input[@id='last_name']")
	 WebElement LastName;
	 @FindBy(xpath = "//input[@id='address1']")
	public WebElement Address;
	 @FindBy(xpath = "//input[@id='state']")
	 WebElement State;
	 @FindBy(xpath = "//input[@id='city']")
	 WebElement City;
	 @FindBy(xpath = "//input[@id='zipcode']")
	public  WebElement Zipcode;
	 @FindBy(xpath = "//input[@id='mobile_number']")
	 WebElement Mobilenumber;
	 @FindBy(xpath = "//button[text()='Create Account']")
	 WebElement Createaccount;
	 @FindBy(xpath = "//b[text()='Account Created!']")
	 WebElement AccountCreated;
	 @FindBy(xpath = "//a[text()='Continue']")
	 WebElement Continue;
	 
	 

public WebElement gender(Object value) {
	return generic.elementName("//input[contains(@value, '%s')]", value);  
}

public void PassWordTextField(String pswd) {
	Action.type(driver, PassWord,pswd );
	
}
public boolean selectBirthDay(String day) {
	return Action.selectByValue(BirthDay, day);
}
public boolean selectBirthMonth(String month) {
	return Action.selectByValue(BirthMonth, month);
}
public boolean selectBirthYear(String year) {
	return Action.selectByValue(BirthYear, year);
}
public String enterFirstName(String firstName) {
	Action.type(driver, FullName,firstName );
	return firstName;
	
}
public void enterlastName(String lastname) {
	Action.type(driver, LastName, lastname);
	
}
public void enterCountryName(String address) {
	Action.type(driver, Address, address);
	
}
public void enterStateName(String stateName) {
	Action.type(driver,State , stateName);
	
}
public void enterCityName(String cityName) {
	Action.type(driver,City , cityName);
	
}
public void enterZipCode(String zipCode) {
	Action.type(driver,Zipcode ,zipCode );
	
}
public void enterMobileNumber(String MobileNumber) {
	Action.type(driver,Mobilenumber ,MobileNumber );
	
}
public void clickOnCreateAccountButton() {
	Action.click(driver,Createaccount);
}
public  boolean accountCreatedtextisDisplayed() {
	return Action.isElementDisplayed(driver,AccountCreated );
	
}
public  boolean enterAddress(String value) {
	return Action.type(driver, Address, value);
	
}
public Home clickOnContinueButton() {
	Action.click(driver,Continue);
	return new Home(driver);
}
}
