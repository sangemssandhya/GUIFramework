package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientInformationEditAndDelete {
	
	@FindBy(xpath="//input[@name='sadmun']")                        // Rule-2 Object Creation
	private WebElement usernameEdt;
	
	@FindBy(xpath="//input[@name='sadmpw']")
	private WebElement passwordEdt;
	
	@FindBy(xpath="//button[@name='login']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//strong[text()='Patient Information Modify']")
	private WebElement PatientModifyBT;
	@FindBy(xpath="//input[@name='searvalu']")
	private WebElement SearchTF;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement SubmitBT;
	
	public PatientInformationEditAndDelete(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getPatientModifyBT() {
		return PatientModifyBT;
	}

	public WebElement getSearchTF() {
		return SearchTF;
	}

	public WebElement getSubmitBT() {
		return SubmitBT;
	}
	
	
	
	
	

}
