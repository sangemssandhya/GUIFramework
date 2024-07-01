package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientRegistration {
	
	@FindBy(xpath="//input[@name='fname']")
	private WebElement FirstNmae;
	
	@FindBy(xpath="//input[@name='lname']")
	private WebElement LastNmae;
	@FindBy(xpath="//select[@class='form-control selectpicker']")
	private WebElement OPDpatientDropDown;
	@FindBy(xpath="//input[@name='addr']")
	private WebElement AddressTF;
	@FindBy(xpath="//input[@name='tel']")
	private WebElement PhoneNumTF;
	@FindBy(xpath="//input[@name='email']")
	private WebElement EmailTF;
	@FindBy(xpath="//select[@name='gender']")
	private WebElement GenderDropDown;
	@FindBy(xpath="//input[@name='smbdd']")
	private WebElement DOB;
	@FindBy(xpath="//select[@name='bg']")
	private WebElement BloodGroup;
	@FindBy(xpath="//button[@class='btn']")
	private WebElement SubmitBT;
	
	public PatientRegistration(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getFirstNmae() {
		return FirstNmae;
	}

	public WebElement getLastNmae() {
		return LastNmae;
	}

	public WebElement getOPDpatientDropDown() {
		return OPDpatientDropDown;
	}

	public WebElement getAddressTF() {
		return AddressTF;
	}

	public WebElement getPhoneNumTF() {
		return PhoneNumTF;
	}

	public WebElement getEmailTF() {
		return EmailTF;
	}

	public WebElement getGenderDropDown() {
		return GenderDropDown;
	}

	public WebElement getDOB() {
		return DOB;
	}

	public WebElement getBloodGroup() {
		return BloodGroup;
	}

	public WebElement getSubmitBT() {
		return SubmitBT;
	}
	
	
	
	
	

}
