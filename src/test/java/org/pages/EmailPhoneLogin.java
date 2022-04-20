package org.pages;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailPhoneLogin extends BaseClass
{
	public EmailPhoneLogin()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement phoneNum;
	public WebElement getPhoneNum() 
	{
		return phoneNum;
	}
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement continuebutton;
	public WebElement getContinuebutton() 
	{
		return continuebutton;
		   
	}
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	public WebElement getPassword() 
	{
		return password;
	}
	@FindBy(xpath="//button[@type='submit']")
	private WebElement Login;
	public WebElement getLogin() {
		return Login;
	}
	}
	
	


