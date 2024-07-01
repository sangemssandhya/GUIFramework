package com.comcast.crm.HMStest;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.PatientAdmitToHsptlRegistration;
import com.comcast.crm.objectrepositoryutility.PatientInfo;
import com.comcast.crm.objectrepositoryutility.PatientInformation;
import com.comcast.crm.objectrepositoryutility.PatientRegistration;
@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class CreateRegisterAdmitAllocateRoomTest extends BaseClass {
	
@Test
public void CreateRegisterAdmitAllocateRoom() throws Throwable
{
	//Register Patient
	wdu.waitForPageToLoad(driver);
	UtilityClassObject.getTest().log(Status.INFO, "Navigate to Patient Info Page");
	/* Navigate to Patient Info Page */
	HomePage Hp=new HomePage(driver);
	Hp.getPatientInfo().click();
	Reporter.log("Navigate to Patient Info Page");
	
	
	UtilityClassObject.getTest().log(Status.INFO, "Navigate to Patient Registration Page");
	
	PatientInfo Pif=new PatientInfo(driver);
	/* Navigate to Patient Registration Page */
	Pif.getPatientReg().click();
	Reporter.log("Navigate to Patient Registration Page");
	
	UtilityClassObject.getTest().log(Status.INFO, "Read data from Excel");
	/* Read data from Excel */
	PatientRegistration pr=new PatientRegistration(driver);
	String FirstName=eLib.getDataFromExcel("Sheet1", 2, 1);
	Reporter.log("Read FirstName data from Excel");
	
	
	
	/* Enter the data into firstname TextField */
	pr.getFirstNmae().sendKeys(FirstName);
	Reporter.log("Enter the data into firstname TextField");
	String LastName=eLib.getDataFromExcel("Sheet1", 2, 2);
	Reporter.log("Read LastName data from Excel");
	
	
	
	/* Enter the data into Lastname TextField */
	pr.getLastNmae().sendKeys(LastName);
	Reporter.log("Enter the data into Lastname TextField");
	
	
	/* Select OPDpatient DropDown */
	wdu.select(pr.getOPDpatientDropDown(), 7);
	Reporter.log("Select OPDpatient DropDown ");
	String Address=eLib.getDataFromExcel("Sheet1", 2, 3);
	
	
	/* Enter the data into Address TextField */
	pr.getAddressTF().sendKeys(Address);
	Reporter.log("Enter the data into Address TextField ");
	
	
	
	/* Enter the data into Phonenum TextField */
	String ContactNum=eLib.getDataFromExcel("Sheet1", 2, 4);
	pr.getPhoneNumTF().sendKeys(ContactNum);
	Reporter.log("Enter the data into Phonenum TextField");
	
	/* Enter the data into Email TextField */
	String Email=eLib.getDataFromExcel("Sheet1", 2, 5);
	pr.getEmailTF().sendKeys(Email);
	Reporter.log("Enter the data into Email TextField");
	
	
	/* Select genderDropDown */
	wdu.select(pr.getGenderDropDown(), 1);
	Reporter.log("Select genderDropDown ");
	
	
	
	/* Enter the data into Email TextField */
	String DOB=eLib.getDataFromExcel("Sheet1", 2, 6);
	pr.getDOB().sendKeys(DOB);
	Reporter.log("Enter the data into Email TextField ");
	
	
	/* Select genderDropDown */
	wdu.select(pr.getBloodGroup(), 5);
	Reporter.log("Select genderDropDown ");
	
	/* Click on submit Button */
	pr.getSubmitBT().click();
	Reporter.log("Click on submit Button ");
	
	
	//Admit To Hospital
	UtilityClassObject.getTest().log(Status.INFO, "Navigate to Patient Information page");
	/* Navigate to Patient Information page */
	PatientInfo Pi=new PatientInfo(driver);
	Pi.getPatientInformation().click();
	Reporter.log("Navigate to Patient Information page");
	
	/* Validating the patient name with allocating patient fiirstname */
   String PatientName=driver.findElement(By.xpath("//td[text()='"+FirstName+" "+LastName+"']")).getText();
  SoftAssert soft=new SoftAssert();
   soft.assertTrue(PatientName.contains(FirstName));
  soft.assertAll();
  Reporter.log("Validating the patient name with allocating patient fiirstname  ");
  
  
	UtilityClassObject.getTest().log(Status.INFO, "Admitting Patient to Hsptl");
	/* click on Admitting Patient to Hsptl */
  PatientInformation pti=new PatientInformation(driver);
  pti.getAdmitToHsptlLink().click();
  Reporter.log(" click on Admitting Patient to Hsptl ");
   System.out.println("Hospital Link is Opened");
   
   
   
  //Allocate The Room
   
   
	/* Read the PartialURL From Excel */
  String PartialUrl=eLib.getDataFromExcel("Sheet1", 6, 1);
  Reporter.log(" Read the PartialURL From Excel ");
  
  
	/* Switch the Window */
	wdu.switchToTabOnURL(driver,PartialUrl);
	PatientAdmitToHsptlRegistration Phr=new PatientAdmitToHsptlRegistration(driver);
	String PatientDisease=eLib.getDataFromExcel("Sheet1", 6, 2);
	Reporter.log("Switch the Window ");
	
	
	/* Enter The Data Into PatientDisease TextField */
	Phr.getPatientDisease().sendKeys(PatientDisease);
	Reporter.log("Enter The Data Into PatientDisease TextField ");
	
	
	/* Select the RoomDropDown */
	wdu.select(Phr.getSelectRoomDropDown(), 3);
	Reporter.log("Select the RoomDropDown ");
	
	/* Click On SubMit Button */
	Phr.getSubMitBT().click();
	Reporter.log("Click On SubMit Button ");
	
	
	
	driver.quit();
	

	
	
}
}

