package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
	@FindBy(xpath="//img[contains(@src,'images/menu/pdinfo.jpg')]")                        // Rule-2 Object Creation
	private WebElement PatientInfo;
	
	@FindBy(xpath="//img[contains(@src,'images/menu/piidinfo.jpg')")                        // Rule-2 Object Creation
	private WebElement PatientInvoices;
	
	@FindBy(xpath="//img[contains(@src,'images/menu/radinfo.jpg')]")                        // Rule-2 Object Creation
	private WebElement RoomsAvailability;
	@FindBy(xpath="//img[contains(@src,'images/menu/padinfob.jpg')]")                        // Rule-2 Object Creation
	private WebElement AdmittedPatientInfo;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getPatientInfo() {
		return PatientInfo;
	}

	public WebElement getPatientInvoices() {
		return PatientInvoices;
	}

	public WebElement getRoomsAvailability() {
		return RoomsAvailability;
	}

	public WebElement getAdmittedPatientInfo() {
		return AdmittedPatientInfo;
	}
	
	
	
	
	

}
