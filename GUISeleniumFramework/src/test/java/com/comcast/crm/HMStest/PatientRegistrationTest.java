package com.comcast.crm.HMStest;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.PatientInfo;
import com.comcast.crm.objectrepositoryutility.PatientRegistration;

public class PatientRegistrationTest extends BaseClass {
	@Test
	public void PatientRegistration() throws Throwable
	{
		
		
		wdu.waitForPageToLoad(driver);
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Patient Info Page");
		/* Navigate to Patient Info Page */
		
		HomePage Hp=new HomePage(driver);
		Hp.getPatientInfo().click();
		Reporter.log("Navigate to Patient Info Page");
		
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Patient Registration page");
		/* Navigate to Patient Registration page */
		PatientInfo Pif=new PatientInfo(driver);
		Pif.getPatientReg().click();
		Reporter.log("Navigate to Patient Registration page");
		
		
		/* Read the data from Excel */
		UtilityClassObject.getTest().log(Status.INFO, "Read the data from Excel");
		PatientRegistration pr=new PatientRegistration(driver);
		Reporter.log("Read the data from Excel");
		
		/* Enter The Data Into FirstNmae TextField */
		String FirstName=eLib.getDataFromExcel("Sheet1", 1, 1);
		pr.getFirstNmae().sendKeys(FirstName);
		Reporter.log(" Enter The Data Into FirstNmae TextField");
		
		
		/* Enter The Data Into LastName TextField */
		String LastName=eLib.getDataFromExcel("Sheet1", 1, 2);
		pr.getLastNmae().sendKeys(LastName);
		Reporter.log(" Enter The Data Into LastName TextField");

		/* Select OdpPatientDropDown */
		wdu.select(pr.getOPDpatientDropDown(), 6);
		Reporter.log("Select OdpPatientDropDown");
		
		/* Enter The Data Into Address TextField */
		String Address=eLib.getDataFromExcel("Sheet1", 1, 3);
		pr.getAddressTF().sendKeys(Address);
		Reporter.log(" Enter The Data Into Address TextField");
		
		/* Enter The Data Into ContactNum TextField */
		String ContactNum=eLib.getDataFromExcel("Sheet1", 1, 4);
		pr.getPhoneNumTF().sendKeys(ContactNum);
		Reporter.log("Enter The Data Into ContactNum TextField");
		
		/* Enter The Data Into Email TextField */
		String Email=eLib.getDataFromExcel("Sheet1", 1, 5);
		pr.getEmailTF().sendKeys(Email);
		Reporter.log(" Enter The Data Into Email TextField");
		
		/* Select GenderDropDown */
		wdu.select(pr.getGenderDropDown(), 1);
		Reporter.log("Select GenderDropDown ");
		
		
		/* Enter The Data Into DOB TextField */
		String DOB=eLib.getDataFromExcel("Sheet1", 1, 6);
		pr.getDOB().sendKeys(DOB);
		Reporter.log("Enter The Data Into DOB TextField ");
		
		/* Select BloodGroupDropDown */
		wdu.select(pr.getBloodGroup(), 4);
		Reporter.log(" Select BloodGroupDropDown ");
		
		
		/* Click On Submit Button */
		pr.getSubmitBT().click();
		Reporter.log(" Click On Submit Button ");
		
		
		driver.quit();
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	

}
