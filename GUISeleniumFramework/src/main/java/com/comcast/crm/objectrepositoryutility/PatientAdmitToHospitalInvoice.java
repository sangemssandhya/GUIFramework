package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientAdmitToHospitalInvoice {
	
	@FindBy(xpath="//input[@placeholder='Patient Name']")
	private WebElement PatientRegNoEdt; 
	@FindBy(xpath="//input[@placeholder='Doctor Name']")
	private WebElement PatientFullNameEdt;
	@FindBy(xpath="//input[@placeholder='Age']")
	private WebElement AgeEdt; 
	@FindBy(xpath="//input[@placeholder='Medicine Charge']")
	private WebElement MedicineChargeEdt;
	@FindBy(xpath="//input[@placeholder='Doctor Charge']")
	private WebElement DoctorChargeEdt;
	@FindBy(xpath="//input[@placeholder='Count of days']")
	private WebElement CountofdaysEdt;
	@FindBy(xpath="//button[text()='SUBMIT']")
	private WebElement patentSUBMITBtn;
	
	public PatientAdmitToHospitalInvoice(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getPatientRegNoEdt() {
		return PatientRegNoEdt;
	}

	public WebElement getPatientFullNameEdt() {
		return PatientFullNameEdt;
	}

	public WebElement getAgeEdt() {
		return AgeEdt;
	}

	public WebElement getMedicineChargeEdt() {
		return MedicineChargeEdt;
	}

	public WebElement getDoctorChargeEdt() {
		return DoctorChargeEdt;
	}

	public WebElement getCountofdaysEdt() {
		return CountofdaysEdt;
	}

	public WebElement getPatentSUBMITBtn() {
		return patentSUBMITBtn;
	}
	
	


}
