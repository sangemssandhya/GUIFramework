package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientInformation {
	//a[text()='Admit to Hospital']
	
	@FindBy(xpath="//a[text()='Admit to Hospital']")                        // Rule-2 Object Creation
	private WebElement AdmitToHsptlLink;
	
	@FindBy(xpath="//a[text()='Make OPD Invoice']")                        // Rule-2 Object Creation
	private WebElement MakeOPDinvoice;
	
	public PatientInformation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAdmitToHsptlLink() {
		return AdmitToHsptlLink;
	}

	public WebElement getMakeOPDinvoice() {
		return MakeOPDinvoice;
	}
	
	
	

}
