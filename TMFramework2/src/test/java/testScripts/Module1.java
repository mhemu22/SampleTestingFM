package testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import appModules.HRMApplicationModules;
import applicationPages.Pg103_ContactDetails;
import frameworkLibrary.BaseClass;

public class Module1 extends BaseClass
{
	WebDriver driver;
	Pg103_ContactDetails contactdetailspage;
	HRMApplicationModules hrmmodules;
	
	@BeforeMethod
	public void before()
	{
		driver = launchHRMLoginpage();
		
		hrmmodules = new HRMApplicationModules(driver);
		hrmmodules.login("ankit3", "abcd1234");
		hrmmodules.NavigateToContactDetails();
	}
	
	@Test
	public void TC101()
	{
		contactdetailspage = new Pg103_ContactDetails(driver);
		contactdetailspage.clickOnEdit();
		contactdetailspage.setAddressStreet1(getdata("Address1"));
		contactdetailspage.setAddressStreet2("Madhapur");
		contactdetailspage.setCity("Hyderabad");
		contactdetailspage.setZipCode("500081");
		contactdetailspage.setCounty("India");
		contactdetailspage.setHomeTelephone("9632598745");
		contactdetailspage.setWorkTelephone("9635125896");
		contactdetailspage.setWorkEmail("abcd@gmail.com");
		contactdetailspage.setOtherEmail("pqrs@gmail.com");
		contactdetailspage.clickOnSave();
	}
	
	@AfterMethod
	public void after()
	{
		hrmmodules.Logout();
	}
}
