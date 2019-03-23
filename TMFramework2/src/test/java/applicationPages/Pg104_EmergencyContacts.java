package applicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class Pg104_EmergencyContacts extends HRMBasePage
{
	HRMBasePage basepage = new HRMBasePage();
	
	WebDriver driver;
	boolean stepstatus;
	
	public Pg104_EmergencyContacts(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='btnAddContact']")
	WebElement addbutton;
	public void clickonAddButton()
	{
		stepstatus = basepage.clickElement(addbutton);
		reportEvent(stepstatus, "Able to click on add button", "Unable to click on add button", driver);
	}
	
	
	@FindBy(how=How.XPATH,using="//input[@name='emgcontacts[name]']")
	WebElement name;
	public void enterName(String strname)
	{
		stepstatus = basepage.setText(name, strname);
		reportEvent(stepstatus, "Able to entername", "Unable to enter name", driver);
	}
	
	
	public WebElement selectrecord(String name)
	{
		return driver.findElement(By.xpath(String.format("//a[text()='%s']/../preceding-sibling::td[1]/input[@type='checkbox']", name)));
	}
	public void clickOnCheckBoxBasedOnName(String name)
	{
		stepstatus = basepage.clickElement(selectrecord(name));
		reportEvent(stepstatus, "Able to click on checkbox", "Unable to click on checkbox", driver);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
