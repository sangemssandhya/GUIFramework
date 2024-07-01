package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientInvoicePage {
	
	@FindBy(xpath="//strong[text()='All OPD Patients Invoiceses']")
	private WebElement ODPpatientInvoices;
	
	@FindBy(xpath="//strong[text()='Admited Patients Invoiceses']")
	private WebElement AdmitpatientInvoices;
	
	public PatientInvoicePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getODPpatientInvoices() {
		return ODPpatientInvoices;
	}

	public WebElement getAdmitpatientInvoices() {
		return AdmitpatientInvoices;
	}
	

}
