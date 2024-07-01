package com.comcast.crm.HMStest;



import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.CreatePatientInvoice;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.PatientInfo;
import com.comcast.crm.objectrepositoryutility.PatientInformation;
import com.comcast.crm.objectrepositoryutility.PatientRegistration;
@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)

public class CreatePatientOPDInvoiceTest extends BaseClass {
	
	@Test
	 public void CreatePatientOPDInvoiceTest() throws Throwable
	 {
		
		
		wdu.waitForPageToLoad(driver);
		HomePage Hp=new HomePage(driver);
		/* Navigate to Patient Info Page */
		Hp.getPatientInfo().click();
		Reporter.log("Navigate to Patient Info Page");
		
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Patient Info Page");
		/* Navigate to Patient Information Page */
		PatientInfo Pi=new PatientInfo(driver);
		Pi.getPatientInformation().click();
		Reporter.log("Navigated to Patient Information Page");
		
		
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		/* read data from excel */
		PatientRegistration pr=new PatientRegistration(driver);
		
		String FirstName=eLib.getDataFromExcel("Sheet1", 1, 1);
		String LastName=eLib.getDataFromExcel("Sheet1", 1, 2);
		Reporter.log("read data from excel");
		
		
		/* validating the patient name with patient invoices first name and last name */
      String PatientName=driver.findElement(By.xpath("//td[text()='"+FirstName+" "+LastName+"']")).getText();
      SoftAssert soft=new SoftAssert();
      Reporter.log("validating the patient name with patient invoice page firstname");
      soft.assertTrue(PatientName.contains(FirstName));
      soft.assertAll();
    
     	UtilityClassObject.getTest().log(Status.INFO, "Navigate to Patient invoice page");
		/* Navigate to Patient invoice page */
      PatientInformation pti=new PatientInformation(driver);
		pti.getMakeOPDinvoice().click();
		Reporter.log("Navigate to Patient invoice page");
		
		
		/* Switching the window */
	
		 String PartialUrl=eLib.getDataFromExcel("Sheet1", 4, 1);
		
		wdu.switchToTabOnURL(driver,PartialUrl);
		Reporter.log("Switching the window");
     
		
		CreatePatientInvoice Cpi=new CreatePatientInvoice(driver);
		/* read data from excel */
		String Medicinecharge=eLib.getDataFromExcel("Sheet1", 4, 2);
		Reporter.log("read data medicinecharge  from excel");
		
		
		/* Enter the data into medicinecharge TextField */
      Cpi.getMedicineCharge().sendKeys(Medicinecharge);
      Reporter.log("Enter the data into medicinecharge TextField ");
      
      
      /* read data from excel */
      Reporter.log("read data  DoctorCharge from excel");
		String DoctorCharge=eLib.getDataFromExcel("Sheet1", 4, 3);
		
		
		/* Enter the data into doctorcharge TextField */
      Cpi.getDoctorCharge().sendKeys(DoctorCharge);
      Reporter.log("Enter the data into medicinecharge TextField ");
      
      
		/* click on submit button */
      Cpi.getSubmitBT().click();
      Reporter.log("click on submit button ");
      
		
		
		
	 }

}

