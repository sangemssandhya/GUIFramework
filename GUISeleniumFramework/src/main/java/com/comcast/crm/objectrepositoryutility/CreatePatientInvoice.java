package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePatientInvoice {
	
	@FindBy(xpath="//h3[text()='Patient Invoices']")
	private WebElement Headertext;
	
	@FindBy(xpath="//input[@name='pid']")
	private WebElement PatienTRegNo;
	
	@FindBy(xpath="//input[@name='dname']")
	private WebElement PatientFullName;
	
	@FindBy(xpath="//input[@name='age']")
	private WebElement PatientAge;
	
	@FindBy(xpath="//input[@placeholder='Medicine Charge']")
	private WebElement MedicineCharge;
	
	@FindBy(xpath="//input[@placeholder='Doctor Charge']")
	private WebElement DoctorCharge;
	
	@FindBy(xpath="//button[text()='SUBMIT']")
	private WebElement SubmitBT;
	
	
	public CreatePatientInvoice(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getHeadertext() {
		return Headertext;
	}


	public WebElement getPatienTRegNo() {
		return PatienTRegNo;
	}


	public WebElement getPatientFullName() {
		return PatientFullName;
	}


	public WebElement getPatientAge() {
		return PatientAge;
	}


	public WebElement getMedicineCharge() {
		return MedicineCharge;
	}


	public WebElement getDoctorCharge() {
		return DoctorCharge;
	}


	public WebElement getSubmitBT() {
		return SubmitBT;
	}
	
	
	
	
	
	
	

}
