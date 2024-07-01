package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientInfo {
	
	@FindBy(xpath="//img[@src='images/menu/pdinfo.jpg']")                        // Rule-2 Object Creation
	private WebElement PatientInfo;
	
	@FindBy(xpath="//strong[text()='Patient Registration']")
	private WebElement PatientReg;
	
	@FindBy(xpath="//strong[text()='Patient Search']")
	private WebElement PatientSearch;
	
	@FindBy(xpath="//strong[text()='Patient Information']")
	private WebElement PatientInformation;
	
	@FindBy(xpath="//strong[text()='Patient Information Edit and Delete']")
	private WebElement PatientEditDelete;
	
	public PatientInfo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getPatientInfo() {
		return PatientInfo;
	}

	public WebElement getPatientReg() {
		return PatientReg;
	}

	public WebElement getPatientSearch() {
		return PatientSearch;
	}

	public WebElement getPatientInformation() {
		return PatientInformation;
	}

	public WebElement getPatientEditDelete() {
		return PatientEditDelete;
	}
	
	
	
	
	
	
	

}
