package org.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.pages.AddtoCart;
import org.pages.EmailPhoneLogin;
import org.pages.LoginPage;
import org.pages.OrderSummery;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch extends BaseClass {
	
	public static void main(String[] args) throws AWTException, InterruptedException, IOException 
	{
		    browser();
		    launchUrl("https://www.flipkart.com/");
		    implicitlywait(5000);		    
	//Login page	    
		   LoginPage l=new LoginPage();
		   sendKeys(l.getSearchbox(),getExcelData("example","Sheet1",2, 0));
          //sendKeys(l.getSearchbox(), "vivo mobiles");
           Robot r=new Robot();
           r.keyPress(KeyEvent.VK_ENTER);
           r.keyRelease(KeyEvent.VK_ENTER); 
           jsClick(l.getClick());
           //buttonclick(l.getClick());
           windowHandle(1);
  //AddtoCart page         
          AddtoCart b=new AddtoCart();
          sendKeys(b.getPinCode(),"638701");
          //jsClick(b.getBuy());
          buttonclick(b.getBuy());
          Thread.sleep(5000);
  //Emailphone loginpage
          EmailPhoneLogin e=new EmailPhoneLogin();
          sendKeys(e.getPhoneNum(), "9952822452");
          buttonclick(e.getContinuebutton());
          sendKeys(e.getPassword(),"prabhu123");
          buttonclick(e.getLogin());
  //OrderSummery Page
          OrderSummery k=new OrderSummery();
          buttonclick(k.getCntButton());
         
		    
		   
	}

}
