package org.pages;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtoCart extends BaseClass
{
	//pagefactory
		public AddtoCart()
		{
			PageFactory.initElements(driver,this);
		}
		
	@FindBy(xpath="//input[@id='pincodeInputId']")
	private WebElement pinCode;
	public WebElement getPinCode() {
		return pinCode;
	}
	@FindBy(xpath="//button[text()='BUY NOW']")
	
    private WebElement buy;
	public WebElement getBuy() 
	{
		return buy;
	}
	
		
}
		
		
		
		
		
		
		

		

