package org.pages;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass
{
	
//pagefactory
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}
//	@FindBy(name="q")
	
	@FindBys({@FindBy(name="q"), @FindBy(xpath="//input[@type='text']")})
	private WebElement searchbox;
	public WebElement getSearchbox() 
	{
		return searchbox;
	}
//   @FindBy(xpath="//div[text()='APPLE iPhone SE (Red, 128 GB)']")

    
   @FindAll({@FindBy(xpath="(//div[text()='vivo T1 5G (Starlight Black, 128 GB)'])[1]"), @FindBy(xpath="//div[text()='APPLE iPhone SE (Red, 128 GB)']")})
	private WebElement click;
	public WebElement getClick() 
	{
	return click;
	}
    
	
	
	
	
	
}
