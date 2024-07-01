
package com.comcast.crm.HMStest;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.PatientInfo;
import com.comcast.crm.objectrepositoryutility.PatientInformationEditAndDelete;
import com.comcast.crm.objectrepositoryutility.PatientModify;
import com.comcast.crm.objectrepositoryutility.PatientRegistration;

public class RegisterSearchDeletePatientTest extends BaseClass {
	@Test
	public void RegisterSearchDeletePatientTest() throws Throwable
	{
		/*
		 * //Registration of Patient
		 */		
		
		wdu.waitForPageToLoad(driver);
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Patient Info Page");
		
		
		/*
		 * Navigate to Patient Info Page
		 */		
		
		HomePage Hp=new HomePage(driver);
		
		Hp.getPatientInfo().click();
		Reporter.log("Navigate to Patient Info Page");
		
		
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Patient Registration page");
		
		/*
		 * Navigate to Patient Registration page
		 */
		
		PatientInfo Pif=new PatientInfo(driver);
		Pif.getPatientReg().click();
		Reporter.log("Navigate to Patient Registration page");
		
		
		
		/*
		 * Read Data From Excel
		 */		
		UtilityClassObject.getTest().log(Status.INFO, "Read Data From Excel");
		PatientRegistration pr=new PatientRegistration(driver);
		String FirstName=eLib.getDataFromExcel("Sheet1", 1, 1);
		Reporter.log("Read Data From Excel");
		
		/*
		 * Enter the data into FirstNmae Textfield
		 */
		
		pr.getFirstNmae().sendKeys(FirstName);
		Reporter.log("Enter the data into FirstNmae Textfield");
		
		/*
		 * Enter the data into LastNmae Textfield
		 */		
		String LastName=eLib.getDataFromExcel("Sheet1", 1, 2);
		pr.getLastNmae().sendKeys(LastName);
		Reporter.log("Enter the data into LastNmae Textfield");
		
		
		/*
		 * Select ODPpatientDropDown
		 */		
		wdu.select(pr.getOPDpatientDropDown(), 7);
		Reporter.log("Select ODPpatientDropDown");
		
		
		/*
		 * Enter the data into Address Textfield
		 */		
		String Address=eLib.getDataFromExcel("Sheet1", 1, 3);
		pr.getAddressTF().sendKeys(Address);
		Reporter.log("Enter the data into Address Textfield");
		
		/*
		 * Enter the data into ContactNum Textfield
		 */		
		String ContactNum=eLib.getDataFromExcel("Sheet1", 1, 4);
		pr.getPhoneNumTF().sendKeys(ContactNum);
		Reporter.log("Enter the data into ContactNum Textfield");
		
		/*
		 * Enter the data into Email Textfield
		 */		
		
		String Email=eLib.getDataFromExcel("Sheet1", 1, 5);
		pr.getEmailTF().sendKeys(Email);
		Reporter.log(" Enter the data into Email Textfield");
		
		
		/*
		 * Select GendertDropDown
		 */		
		
		wdu.select(pr.getGenderDropDown(), 1);
		Reporter.log(" Select GendertDropDown");
		
		
		/*
		 * Enter the data into DOB Textfield
		 */		
		
		String DOB=eLib.getDataFromExcel("Sheet1", 1, 6);
		pr.getDOB().sendKeys(DOB);
		Reporter.log(" Enter the data into DOB Textfield");
		
		/*
		 * Select BloodGroupDropDown
		 */
		wdu.select(pr.getBloodGroup(), 5);
		Reporter.log("Select BloodGroupDropDown");
		pr.getSubmitBT().click();
		
		//Serach For Patient
		//Pif.getPatientSearch().click();
		//PatientSearch Ps=new PatientSearch(driver);
		//Ps.getPatientSearchTF().sendKeys(FirstName);
		//Ps.getSubmitBT().click();
		
		//sEARCH and dELETE pATIENT
		
		/* Navigate to Patient Edit And Delete Page */
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Patient Edit And Delete Page");
		PatientInfo PaInf=new PatientInfo(driver);
		PaInf.getPatientEditDelete().click();
		Reporter.log("Select BloodGroupDropDown");
		
		/* Pass The UserName And PassWord Into Patient Edit And Delete Page */
		UtilityClassObject.getTest().log(Status.INFO, "Pass The UserName And PassWord Into Patient Edit And Delete Page ");
		PatientInformationEditAndDelete Pied=new PatientInformationEditAndDelete(driver);
		
		Pied.getUsernameEdt().clear();
		String USERNAME = System.getProperty("username" , fLib.getDataFromPropertiesFile("username"));
		String PASSWORD = System.getProperty("password" , fLib.getDataFromPropertiesFile("password"));
		Reporter.log("Pass The UserName And PassWord Into Patient Edit And Delete Page");
		
		//Pied.getUsernameEdt().clear();
		
		/*
		 * //Enter the data into UserNameTextfield
		 */
		Pied.getUsernameEdt().sendKeys(USERNAME);
		Reporter.log("Enter the data into UserNameTextfield");
		
		/*
		 * //Enter the data into Password Textfield
		 */
		Pied.getPasswordEdt().sendKeys( PASSWORD);
		Reporter.log("Enter the data into Password Textfield");
		//Thread.sleep(3000);
		Pied.getSubmitBT().click();
		
		//Thread.sleep(3000);
		/* Naviagte to search Page */
		UtilityClassObject.getTest().log(Status.INFO, "Naviagte to search Page");
		Pied.getSearchTF().click();
		Reporter.log("Naviagte to search Page ");
		
		
		/* Edit Data In THe FirstNmae TextField */
		
		Pied.getSearchTF().sendKeys(FirstName);
		Reporter.log("Edit Data In THe FirstNmae TextField ");
		
		/* click the submit button */
		//Thread.sleep(3000);
		Pied.getSubmitBT().click();
		//Thread.sleep(3000);
		UtilityClassObject.getTest().log(Status.INFO, "Deleting the patient ");
		
		
		/*
		 * //Delete Patient
		 */		
		
		String PatientFirstname=driver.findElement(By.xpath("//input[@value='"+FirstName+"']")).getText();
		SoftAssert soft=new SoftAssert();
	    soft.assertTrue(FirstName.contains(PatientFirstname));
	    soft.assertAll();
		
		PatientModify Pm=new PatientModify(driver);
		/* click on delete button */
		Pm.getDeleteBT().click();
		Reporter.log("click on delete button ");
		
		
		
		
	}

}
