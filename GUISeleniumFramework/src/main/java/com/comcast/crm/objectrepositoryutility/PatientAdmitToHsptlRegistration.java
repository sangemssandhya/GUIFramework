package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientAdmitToHsptlRegistration {
	
	@FindBy(xpath="//input[@name='pet_disea']")                        // Rule-2 Object Creation
	private WebElement PatientDisease;
	
	@FindBy(xpath="//select[@name='adm_rn']")                        // Rule-2 Object Creation
	private WebElement SelectRoomDropDown;
	
	@FindBy(xpath="//button[@name='submit']")                        // Rule-2 Object Creation
	private WebElement SubMitBT;
	
	public PatientAdmitToHsptlRegistration(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getPatientDisease() {
		return PatientDisease;
	}

	public WebElement getSelectRoomDropDown() {
		return SelectRoomDropDown;
	}

	public WebElement getSubMitBT() {
		return SubMitBT;
	}
	
	
	
	

}
