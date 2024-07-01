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
import com.comcast.crm.objectrepositoryutility.UpdatePatient;

public class EditAndDeletePatientInformationTest extends BaseClass {
	@Test
	public void EditAndDeletePatientInformation() throws Throwable
	{

	
	wdu.waitForPageToLoad(driver);
	UtilityClassObject.getTest().log(Status.INFO, "Navigate to Patient Info Page");
	/* Navigate to Patient Info Page */
	HomePage Hp=new HomePage(driver);
	Hp.getPatientInfo().click();
	Reporter.log("Navigate to Patient Info Page");
	
	
	/* Navigate to Patient Edit Ans Delete Pagge */
	UtilityClassObject.getTest().log(Status.INFO, "Navigate to Patient Edit Ans Delete Pagge");
	PatientInfo PaInf=new PatientInfo(driver);
	PaInf.getPatientEditDelete().click();
	Reporter.log("Navigate to Patient Edit Ans Delete Pagge");
	
	/* login to superadmin details */
	UtilityClassObject.getTest().log(Status.INFO, "login to superadmin details");
	PatientInformationEditAndDelete Pied=new PatientInformationEditAndDelete(driver);
	Pied.getUsernameEdt().clear();
	Reporter.log("login to superadmin details");
	
	
	/*
	 * //enter the data into uSername and passwod Textfield
	 */
	UtilityClassObject.getTest().log(Status.INFO, "enter the data into uSername and passwod Textfield");
	String USERNAME = System.getProperty("username" , fLib.getDataFromPropertiesFile("username"));
	String PASSWORD = System.getProperty("password" , fLib.getDataFromPropertiesFile("password"));
	//Pied.getUsernameEdt().clear();
	Pied.getUsernameEdt().sendKeys(USERNAME);
	Pied.getPasswordEdt().sendKeys( PASSWORD);
	Thread.sleep(3000);
	Reporter.log("enter the data into uSername and passwod Textfield");
	
	
	/* click on submit button */
	Pied.getSubmitBT().click();
	Thread.sleep(3000);
	Reporter.log("click on submit button");
	
	
	/*
	 * search patient
	 */	
	UtilityClassObject.getTest().log(Status.INFO, "search the patient ");
	PatientRegistration pr=new PatientRegistration(driver);
	String FirstName=eLib.getDataFromExcel("Sheet1", 1, 1);

	Pied.getSearchTF().click();
	Reporter.log("search patient");
	
	/* Enter the firstname into search textfield */
	Pied.getSearchTF().sendKeys(FirstName);
	
	Reporter.log("Enter the firstname into search textfield ");
	
	
	/* click on submit button */
	Pied.getSubmitBT().click();
	Reporter.log("click on submit button ");
	
	
	/* Modify the patient Details */
	UtilityClassObject.getTest().log(Status.INFO, "Modify the patient details");
	String PatientFirstname=driver.findElement(By.xpath("//input[@value='"+FirstName+"']")).getText();
	SoftAssert soft=new SoftAssert();
    soft.assertTrue(FirstName.contains(PatientFirstname));
    soft.assertAll();
    Reporter.log("Modify the patient details");
    
	/* click on updatebutton */
	PatientModify Pm=new PatientModify(driver);
	Pm.getUpadateBT().click();
	 Reporter.log("click on updatebutton");
	 
	 
	/* Update the Data into Firstname Textfield */
	UpdatePatient Up=new UpdatePatient(driver);
	Up.getUpdateFirstNameTF().clear();
	Up.getUpdateFirstNameTF().sendKeys("Manohar");
	Up.getUpdateLastName().clear();
	Reporter.log("Update the Data into Firstname Textfield");
	
	/* Update the Data into Last Textfield */
	Up.getUpdateLastName().sendKeys("sai");
	Reporter.log("Update the Data into Last Textfield");
	
	/* select activefield dropdown */
	wdu.select(Up.getActiveFieldDropDown(), 1);
	Reporter.log("select activefield dropdown ");
	
	/* click on updatebutton */
	Up.getUpdateBT().click();
	Reporter.log("click on updatebutton  ");

	System.out.println("Updated ");
	driver.quit();
	
	
	
	
	
	
	
	
	
	
	}

}
