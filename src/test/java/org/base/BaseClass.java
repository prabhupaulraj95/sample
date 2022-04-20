package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public static WebDriver driver;
	
	public static WebDriver browser()
	{
		WebDriverManager.chromedriver().setup();
	    driver= new ChromeDriver();
		return driver;
		
	}
	public static void launchUrl(String url) 
	{
		driver.get(url);
		driver.manage().window().maximize();
		}
	public static void implicitlywait(long time)
	{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		
	}
	public static String currenturl()
	{
	String currentUrl = driver.getCurrentUrl();
	return currentUrl;
	}
	public static String getTitle()
	{
		String title = driver.getTitle();
		return title;
	}
	public static void quit()
	{
		driver.quit();
	}
    public static void sendKeys(WebElement e,String textvalue)
    {
    	e.sendKeys(textvalue);
    	
    }
    
    public static String getAttribute(WebElement e)
    {
    	String attribute = e.getAttribute("value");
		return attribute;
    }
    public static String getText(WebElement e)
    {
    	String text = e.getText();
		return text;
    }
    public static void buttonclick(WebElement e)
    {
    	e.click();
    }
    //Actions
    public static void movetoElement(WebElement e)
    {
    	Actions a=new Actions(driver);
    	a.moveToElement(e).perform();
    }
    public static void dragAndDrop(WebElement source,WebElement target)
    {
    	Actions a=new Actions(driver);
    	a.dragAndDrop(source, target).perform();
    }
    //select
    public static void selectbyIndex(WebElement e,int index)
    {
    	Select s=new Select(e);
    	s.selectByIndex(index);
    }
    public static void deselectbyvalue(WebElement e,String value)
    {
    	Select s=new Select(e);
    	s.deselectByValue(value);
    }
    
    public static WebElement findElement(String locatorName,String LocatorValue)
    {
    	WebElement value=null;
    	
    	if(locatorName.equalsIgnoreCase("id"))
    	{
    		value = driver.findElement(By.id(LocatorValue));
    	}
    	else if(locatorName.equalsIgnoreCase("name"))
    	{
    		value = driver.findElement(By.name(LocatorValue));
    	}
    	else if(locatorName.equalsIgnoreCase("xpath"))
    	{
    	    value = driver.findElement(By.xpath(LocatorValue));
    	}
		return value;
		
    	
    }
   
    
//    1.Screenshot
    public static void ScreenShot(String id) throws IOException
    {
        TakesScreenshot tk= (TakesScreenshot) driver;
    	File src = tk.getScreenshotAs(OutputType.FILE);
    	File des=new File("C:\\Users\\Prabhu\\eclipse-workspace\\MavenProject\\Screenshot\\facebook.png");
    	FileUtils.copyFile(src, des);
    	 }
//   2.contextclick
    public static void contextClick(WebElement e)
    {
	 Actions a=new Actions(driver);
	 a.contextClick(e).perform();;
    }    
//  3.DoubleClick
    public static void doubleClick(WebElement e)
    {
	 Actions a=new Actions(driver);
	 a.doubleClick(e).perform();;
    }    
//  4.Action Sendkeys
    public static void actionSendkeys(WebElement e,String value)
    {
    	Actions a=new Actions(driver);
    	a.sendKeys(e,value).perform();;  
    }
//  5. simpleAlert
    public static void alertAccept()
    {
    	driver.switchTo().alert().accept();
    }
//  6.confirm Alert    
    public static void alertconfirm()
    {
    	driver.switchTo().alert().dismiss();
    }
//  7.prompt Alert
    public static void alertPrompt(String txt)
    {
    	Alert alert = driver.switchTo().alert();
    	alert.sendKeys(txt);
    	alert.accept();
    }    
// 8. SelectbyValue
    public static void selectbyValue(WebElement e,String value)
    {
    	Select s=new Select(e);
    	s.selectByValue(value);
    }
 // 9. SelectbyIndex
    public static void selectbyValue(WebElement e,int index)
    {
    	Select s=new Select(e);
    	s.selectByIndex(index);
    }
 // 10. SelectVisibleText
    public static void selectbyVisibleText(WebElement e,String txt)
    {
    	Select s=new Select(e);
    	s.selectByVisibleText(txt);
    }
//  11.Select getallOptions
    public static String getAlloptions(WebElement e,int index)
    {
    	Select s=new Select(e);
    	List<WebElement> options = s.getOptions();
		WebElement ops = options.get(index);
		String text = ops.getText();
		return text;
    }
//  12.Select Size
    public static int size(WebElement e)
    {
    	Select s=new Select(e);
        List<WebElement> options = s.getOptions();
        int size = options.size();
		return size;
    }
 //  13. DeselectbyIndex   
    public static void deselectbyindex(WebElement e,int index)
    {
    	Select s=new Select(e);
    	s.deselectByIndex(index);
    }
//  14.Deselectbyvalue   
    public static void deselectbyindex(WebElement e,String value)
    {
    	Select s=new Select(e);
    	s.deselectByValue(value);
    }
//  15.Deselectbyvisibletext   
    public static void deselectbyVisibleText(WebElement e,String value)
    {
    	Select s=new Select(e);
    	s.deselectByVisibleText(value);
    }
//  16.DeselectAll   
    public static void deselectall(WebElement e)
    {
    	Select s=new Select(e);
    	s.deselectAll();
    } 
//  17.First selected option
    public static String FirstSelected(WebElement e)
    {
    	Select s=new Select(e);
    	WebElement firstSelectedOption = s.getFirstSelectedOption();
    	String text = firstSelectedOption.getText();
		return text;
    }     
// 18. Js SetAttribute
    public static void jsSetAttribute(WebElement e)
    {
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("arguments[0].setAttribute('value','prabhu')",e);
    }
 // 19. Js getAttribute
    public static String jsgetAttribute(WebElement e)
    {
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	Object txt = js.executeScript("reuturn arguments[0].getAttribute('value')",e);
    	String value = txt.toString();
		return value;
    }
//  20.Scrolldown
    public static void scrollDown(WebElement e)
    {
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("arguments[0].scrollIntoview('true')",e);
    }
//  21.ScrollUp
    public static void scrollUp(WebElement e)
    {
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("arguments[0].scrollIntoview('false')",e);
    }
// 22.FrameHandlebyindex
    public static void framebyindex(int index)
    {
    	driver.switchTo().frame(index);
    }
 // 23.FrameHandlebyid
    public static void framebyindex(String id)
    {
    	driver.switchTo().frame(id);
    }
// 24.FrameHandlebyname
    public static void framebyname(String name)
    {
    	driver.switchTo().frame(name);
    }
 // 24.FrameHandlebywebElement
    public static void framebyWebElement(WebElement e)
    {
    	driver.switchTo().frame(e);
    }    
// 25.comeoutOfFrame
    public static void comeoutFrame()
    {
    	driver.switchTo().defaultContent();
    }
// 26.cometoparentFrame
    public static void parentFrame()
    {
    	driver.switchTo().parentFrame();
    }
// 27.getParentwindow  
    public static String parentwindow()
    {
    	String parent = driver.getWindowHandle();
		return parent;
    }
// 28.getParentAndChildwindow  
    public static Set<String> parentAndChildwindow()
    {
        Set<String> allwindows = driver.getWindowHandles();
        return allwindows;
   }
// 29.switchtoWebTablebyIndex
    public static void webtablebyindex(String tagName,int index)
    {
    	List<WebElement> table = driver.findElements(By.tagName(tagName));
        table.get(index);
    }
//  30. Navigation To
    public static void navigationTo(String url)
    {
    	driver.navigate().to(url);
    }
//  31. Navigation Back
    public static void Back(String url)
    {
    	driver.navigate().back();
    }
//  33. Navigation Forward
    public static void Forward(String url)
    {
    	driver.navigate().forward();
    }
//  34. Navigation Refresh 
    public static void Refresh()
    	{
    		driver.navigate().refresh();
    	}
// 35.Navigation isDisplayed
    public static boolean isDisplayed(WebElement e)
    {
    	boolean displayed = e.isDisplayed();
		return displayed;
    }
// 36.Navigation isEnabled
    public static boolean isEnabled(WebElement e)
    {
    	boolean enabled = e.isEnabled();
		return enabled;
    }
// 37.Navigation isEnabled
    public static boolean isSelected(WebElement e)
    {
    	boolean selected = e.isSelected();
		return selected;
    }
//  38.jsclick
    public static void jsClick(WebElement e)
    {
    	JavascriptExecutor js=(JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click()", e);
    }
//39.windowhandle
    public static void windowHandle(int index)
    {
    	Set<String> allwindows = driver.getWindowHandles();
    	List<String> li=new ArrayList<String>();
    	li.addAll(allwindows);
    	
    	driver.switchTo().window(li.get(index));
    }
    
// 40.get Excel data
    public static String getExcelData(String filename,String sheetName,int rowno,int cellno) throws IOException
    {
    	File loc=new File("C:\\Users\\Prabhu\\eclipse-workspace\\MavenProject\\src\\test\\resources\\"+filename+".xlsx");
	    FileInputStream fi=new FileInputStream(loc);
	    Workbook w=new XSSFWorkbook(fi);
	    Sheet s = w.getSheet(sheetName);
	    Row r = s.getRow(rowno);
	    Cell cell = r.getCell(cellno);
	   int cellType = cell.getCellType();
	   String value=null;
	//type 1----string type 0---numbers,dates
	   if(cellType==1)
	   {
		  value = cell.getStringCellValue();
	   }
	   else {
		   if(DateUtil.isCellDateFormatted(cell))
		   {
			    value = new SimpleDateFormat("dd-MMM-yyyy").format(cell.getDateCellValue());
			   
		   }
		   else
		   {
			   value = String.valueOf((long)cell.getNumericCellValue());
			   
		   }
	   }
	return value;
	}
    }
    



