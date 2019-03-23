package frameworkLibrary;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BasePage extends ReportLibrary
{
	public boolean setText(WebElement ele, String StrValue) 
	{	
		boolean stepstatus;
		try
		{
			ele.clear();
			ele.sendKeys(StrValue);
			stepstatus = true;
		} 
		catch (Exception e) 
		{
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}
	
	public  boolean clickElement(WebElement ele) 
	{
		boolean stepstatus;
		try
		{
			ele.click();
			stepstatus = true;
		} 
		catch (Exception e)
		{
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}
	
	public  boolean clickifElementTextEquals(List<WebElement> allitems,String TextValue) 
	{
		boolean stepstatus;
		try
		{
			for(WebElement ele:allitems)
			{
				if(ele.getText().equals(TextValue))
				{
					ele.click();
				}
			}
			stepstatus = true;
		} 
		catch (Exception e)
		{
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}
	
	public  boolean clickifElementAttributeValueEquals(List<WebElement> allitems,String AttributeName,String AttributeValue) 
	{
		boolean stepstatus;
		try
		{
			for(WebElement ele:allitems)
			{
				if(ele.getAttribute(AttributeName).equals(AttributeValue))
				{
					ele.click();
				}
			}
			stepstatus = true;
		} 
		catch (Exception e)
		{
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}
	
	public  boolean setOptionInSelectBox(WebElement ele, String eleOption) 
	{
		boolean stepstatus = false;
		try 
		{
			new Select(ele).selectByVisibleText(eleOption);
			stepstatus = true;
		} catch (Exception e) 
		{
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public  boolean setCheckBox(WebElement ele, String ONorOFF) 
	{
		boolean stepstatus = false;
		try 
		{
			
			switch (ONorOFF.toLowerCase()) 
			{
				case "on":
					if(!ele.isSelected())
					{
						ele.click();
					}
					stepstatus = true;
					break;
				case "off":
					if(ele.isSelected())
					{
						ele.click();
					}
					stepstatus = true;
					break;
				default:
					stepstatus = false;
					break;
			}
			
		} 
		catch (Exception e) 
		{
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}
	
	
	public  String getLinkText(WebElement ele) 
	{
		String value = "";
		try 
		{
			
			if(exists(ele))
			{
				value=ele.getText();
			}
		} catch (Exception e) 
		{
			value = "";
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return value;
	}
	
	public  String getAttributeValue(WebElement ele,String AttributeName) 
	{
		String value = "";
		try 
		{
			
			if(exists(ele))
			{
				value=ele.getAttribute(AttributeName);
			}
		} catch (Exception e) 
		{
			value = "";
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return value;
	}
	
	public   void waitForPageToLoad(WebDriver driver) 
	{
		String pageLoadStatus;
		do 
		{
	    	JavascriptExecutor js = (JavascriptExecutor)driver;
	        pageLoadStatus = (String)js.executeScript("return document.readyState");
	    } while (!pageLoadStatus.equals("complete") );
	}
	
	public  boolean exists(WebElement ele) 
	{
		boolean stepstatus;
		try 
		{
			stepstatus = ele.isDisplayed();
		} catch (Exception e) 
		{
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}
	

	public  boolean isEnabled(WebElement ele) 
	{
		boolean stepstatus;
		try 
		{
			stepstatus = ele.isEnabled();
		} catch (Exception e) 
		{
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}
	
	public  boolean isSelected(WebElement ele) 
	{
		boolean stepstatus;
		try 
		{
			stepstatus = ele.isSelected();
		} catch (Exception e) 
		{
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}
	public  boolean mouseHover(WebElement ele,WebDriver driver) {
		boolean stepstatus;
		try 
		{
			Actions a1 = new Actions(driver);
			a1.moveToElement(ele);
			a1.build().perform();
			stepstatus = true;
		} catch (Exception e) 
		{
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public  boolean rightClick(WebElement ele,WebDriver driver) {
		boolean stepstatus;
		try {
			Actions a1 = new Actions(driver);
			a1.contextClick(ele);
			a1.build().perform();
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public  boolean doubleClick(WebElement ele,WebDriver driver) {
		boolean stepstatus;
		try {
			Actions a1 = new Actions(driver);
			a1.doubleClick(ele);
			a1.build().perform();
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public  boolean dragAndDrop(WebElement drag, WebElement drop,WebDriver driver) {
		boolean stepstatus;
		try {
			Actions a1 = new Actions(driver);
			a1.dragAndDrop(drag, drop);
			a1.build().perform();
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public  boolean JsclickElement(WebElement ele,WebDriver driver) {
		boolean stepstatus;
		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", ele);
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public  boolean JssetText(WebElement ele, String StrValue,WebDriver driver) {
		boolean stepstatus;
		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value='" + StrValue + ";", ele);
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public  boolean JsScrollToWebElement(WebElement ele,WebDriver driver) {
		boolean stepstatus;
		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", ele);
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public  boolean acceptAlert(WebElement ele,WebDriver driver) {
		boolean stepstatus;
		try {
			Alert a1 = driver.switchTo().alert();
			a1.accept();
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}
	
	
	public  boolean dismissAlert(WebElement ele,WebDriver driver) {
		boolean stepstatus;
		try {
			Alert a1 = driver.switchTo().alert();
			a1.dismiss();
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public  boolean alertExist(WebElement ele,WebDriver driver) {
		boolean stepstatus;
		try {
			driver.switchTo().alert();
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public  String alertGetText(WebElement ele,WebDriver driver) {
		String StrValue = "";
		try {
			Alert a1 = driver.switchTo().alert();
			StrValue = a1.getText();
		} catch (Exception e) {
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return StrValue;
	}

	public  boolean isWindowExistsByURL(String URL,WebDriver driver) {
		boolean stepstatus = false;
		try {
			Set<String> allhandles = driver.getWindowHandles();
			for (String handle : allhandles) {
				driver.switchTo().window(handle);
				String CurrentURL = driver.getCurrentUrl();
				if (CurrentURL.contains(URL)) {
					stepstatus = true;
					break;
				}
			}
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public  boolean isWindowExistsByTitle(String Title,WebDriver driver) {
		boolean stepstatus = false;
		try {
			Set<String> allhandles = driver.getWindowHandles();
			for (String handle : allhandles) {
				driver.switchTo().window(handle);
				String CurrentURL = driver.getTitle();
				if (CurrentURL.contains(Title)) {
					stepstatus = true;
					break;
				}
			}
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}
	
	public  boolean SwitchtoWindowByURL(String URL,WebDriver driver) 
	{
		boolean stepstatus = false;
		try {
			Set<String> allhandles = driver.getWindowHandles();
			for (String handle : allhandles) {
				driver.switchTo().window(handle);
				String CurrentURL = driver.getCurrentUrl();
				if (CurrentURL.contains(URL)) 
				{
					stepstatus = true;
					break;
				}
			}
		} catch (Exception e) {
			stepstatus= false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public  boolean SwitchtoWindowByTitle(String Title,WebDriver driver) 
	{
		boolean stepstatus = false;
		try 
		{
			Set<String> allhandles = driver.getWindowHandles();
			for (String handle : allhandles) 
			{
				driver.switchTo().window(handle);
				String CurrentURL = driver.getTitle();
				if (CurrentURL.contains(Title)) 
				{
					stepstatus= true;
					break;
				}
			}
		} catch (Exception e) 
		{
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public  boolean closeWindowByURL(String URL,WebDriver driver) 
	{
		boolean stepstatus = false;
		try 
		{
			Set<String> allhandles = driver.getWindowHandles();
			for (String handle : allhandles) 
			{
				driver.switchTo().window(handle);
				String CurrentURL = driver.getCurrentUrl();
				if (CurrentURL.contains(URL)) 
				{
					driver.close();
					stepstatus = true;
					break;
				}
			}
		} 
		catch (Exception e) 
		{
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}
	
	public  boolean closeWindowByTitle(String Title,WebDriver driver) 
	{
		boolean stepstatus = false;
		try 
		{
			Set<String> allhandles = driver.getWindowHandles();
			for (String handle : allhandles) 
			{
				driver.switchTo().window(handle);
				String CurrentURL = driver.getTitle();
				if (CurrentURL.contains(Title)) 
				{
					driver.close();
					stepstatus = true;
					break;
				}
			}
		} 
		catch (Exception e) 
		{
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}
	
	public  boolean SwitchtoFrameByElementReference(WebElement FrameRef,WebDriver driver )
	{
		boolean stepstatus = false;
		try 
		{
			driver.switchTo().frame(FrameRef);
			stepstatus = true;
		} 
		catch (Exception e) 
		{
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public  boolean SwitchtoFrameByName(String FrameName,WebDriver driver) 
	{
		boolean stepstatus = false;
		try 
		{
			driver.switchTo().frame(FrameName);
			stepstatus = true;
		} 
		catch (Exception e) 
		{
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}
	
	public  boolean SwitchtoFrameByIndex(int FrameIndex,WebDriver driver) 
	{
		boolean stepstatus = false;
		try 
		{
			driver.switchTo().frame(FrameIndex);
			stepstatus = true;
		} 
		catch (Exception e) 
		{
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}
	
	public  boolean SwitchtoMainDocument(WebDriver driver) 
	{
		boolean stepstatus = false;
		try 
		{
			driver.switchTo().defaultContent();
			stepstatus = true;
		} catch (Exception e) 
		{
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public  boolean RobotKeysFileUpload(String Filepath)
	{
		boolean stepstatus;
		try 
		{
			wait(2);
			StringSelection selection = new StringSelection(Filepath);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(selection, selection);

			Robot robo = new Robot();
			robo.keyPress(KeyEvent.VK_CONTROL);
			robo.keyPress(KeyEvent.VK_V);
			robo.keyRelease(KeyEvent.VK_V);
			robo.keyRelease(KeyEvent.VK_CONTROL);

			wait(2);
			robo.keyPress(KeyEvent.VK_ENTER);
			robo.keyRelease(KeyEvent.VK_ENTER);
			robo.keyPress(KeyEvent.VK_ENTER);
			robo.keyRelease(KeyEvent.VK_ENTER);
			wait(2);
			stepstatus = true;
		} catch (Exception e) 
		{
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public  boolean clickifElementAttributeValueContains(List<WebElement> allitems,String AttributeName,String AttributeValue) 
	{
		boolean stepstatus;
		try
		{
			for(WebElement ele:allitems)
			{
				if(ele.getAttribute(AttributeName).contains(AttributeValue))
				{
					ele.click();
				}
			}
			stepstatus = true;
		} 
		catch (Exception e)
		{
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}
	
	
	public  boolean wait(int timeInSec) 
	{
		boolean stepStatus;
		try 
		{
			Thread.sleep(timeInSec * 1000);
			stepStatus = true;
		} 
		catch (Exception e)
		{
			stepStatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepStatus;
	}

	public  boolean dynamicWait(By by, int waittimeinsec,WebDriver driver) 
	{
		boolean status = false;
		int counter = 0;
		while (counter <= waittimeinsec) 
		{
			try 
			{
				driver.findElement(by);
				status = true;
				break;
			} catch (Exception e) 
			{
				wait(1);
			}
			counter = counter + 1;
		}
		if (counter > waittimeinsec) 
		{
			status = false;
		}
		return status;
	}

	public  boolean quitdriver(WebDriver driver)
	{
		boolean stepstatus = false;
		try
		{
			driver.quit();
			stepstatus= true;
		}
		catch(Exception e)
		{
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}
}
