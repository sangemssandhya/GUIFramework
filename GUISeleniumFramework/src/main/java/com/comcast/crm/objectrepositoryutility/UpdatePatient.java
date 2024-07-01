package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdatePatient {
	
	@FindBy(xpath="//input[@name='pfname']")
	private WebElement  UpdateFirstNameTF;
	
	@FindBy(xpath="//input[@name='psname']")
	private WebElement UpdateLastName;
	
	@FindBy(xpath="//input[@name='pdob']")
	private WebElement UpdateDOB;
	
	@FindBy(xpath="//input[@name='em']")
	private WebElement UpdateEmail;
	
	@FindBy(xpath="//select[@name='gen']")
	private WebElement UpdateGenderDropDown;
	
	@FindBy(xpath="//select[@name='bg']")
	private WebElement UpadateBloodGroup;
	
	@FindBy(xpath="//input[@name='age']")
	private WebElement UpdateAge;
	
	@FindBy(xpath="//input[@name='padd']")
	private WebElement UpdateAddress;
	
	@FindBy(xpath="//input[@name='ptel']")
	private WebElement UpdateContactNumber;
	
	@FindBy(xpath="//select[@id='fieldsac']")
	private WebElement ActiveFieldDropDown;
	
	@FindBy(xpath="//button[text()='Update']")
    private WebElement UpdateBT;
		
	
	public UpdatePatient(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getUpdateFirstNameTF() {
		return UpdateFirstNameTF;
	}


	public WebElement getUpdateLastName() {
		return UpdateLastName;
	}


	public WebElement getUpdateDOB() {
		return UpdateDOB;
	}


	public WebElement getUpdateEmail() {
		return UpdateEmail;
	}


	public WebElement getUpdateGenderDropDown() {
		return UpdateGenderDropDown;
	}


	public WebElement getUpadateBloodGroup() {
		return UpadateBloodGroup;
	}


	public WebElement getUpdateAge() {
		return UpdateAge;
	}


	public WebElement getUpdateAddress() {
		return UpdateAddress;
	}


	public WebElement getUpdateContactNumber() {
		return UpdateContactNumber;
	}


	public WebElement getActiveFieldDropDown() {
		return ActiveFieldDropDown;
	}


	public WebElement getUpdateBT() {
		return UpdateBT;
	}
	
	

}
