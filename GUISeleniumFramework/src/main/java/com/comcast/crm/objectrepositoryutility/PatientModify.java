package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientModify {
	
	@FindBy(xpath="//strong[text()='Patient Information Modify']")
	private WebElement PatientModifyBT;
	@FindBy(xpath="//input[@name='searvalu']")
	private WebElement SearchTF;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement SubmitBT;
	
	@FindBy(xpath="//a[text()='Update']")
	private WebElement UpadateBT;
	
	@FindBy(xpath="//a[text()='Delete']")
	private WebElement DeleteBT;
	
	public PatientModify(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getPatientModifyBT() {
		return PatientModifyBT;
	}

	public WebElement getSearchTF() {
		return SearchTF;
	}

	public WebElement getSubmitBT() {
		return SubmitBT;
	}

	public WebElement getUpadateBT() {
		return UpadateBT;
	}

	public WebElement getDeleteBT() {
		return DeleteBT;
	}
	
	
	
	
	//@FindBy(xpath="//select[@id='fieldsac']")
	//private WebElement ActiveFieldDropDown;
	
	//@FindBy(xpath="//button[text()='Update']")
	//private WebElement UpdateBT;
	
	
	

}
