package org.pages;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummery extends BaseClass
{
	public OrderSummery()
	{
		PageFactory.initElements(driver,this);
	}
    @FindBy(xpath="//button[text()='CONTINUE']")
	private WebElement CntButton;

	public WebElement getCntButton() {
		return CntButton;
	}
	
}
