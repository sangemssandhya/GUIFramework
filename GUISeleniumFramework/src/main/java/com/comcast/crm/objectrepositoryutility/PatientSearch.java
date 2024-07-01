package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientSearch {
	
	@FindBy(xpath="//input[@name='searvalu']")
	private WebElement PatientSearchTF;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement SubmitBT;
	
	public PatientSearch (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getPatientSearchTF() {
		return PatientSearchTF;
	}

	public WebElement getSubmitBT() {
		return SubmitBT;
	}
	
	

}
