package testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import appModules.HRMApplicationModules;
import applicationPages.Pg104_EmergencyContacts;
import frameworkLibrary.BaseClass;

public class Module2 extends BaseClass
{
	@Test
	public void TC201()
	{
		WebDriver driver = launchHRMLoginpage();
		
		
		HRMApplicationModules appmodules = new HRMApplicationModules(driver);
		appmodules.login("ankit3", "abcd1234");
		appmodules.NavigateToEmergencyContacts();
		
		Pg104_EmergencyContacts emergencycontacts = new Pg104_EmergencyContacts(driver);
		emergencycontacts.clickonAddButton();
		emergencycontacts.enterName(getdata("Name"));
		
		
	}
	@Test
	public void TC202()
	{
		System.out.println("Executing TC202");
	}
	@Test
	public void TC203()
	{
		System.out.println("Executing TC203");
	}
	@Test
	public void TC204()
	{
		System.out.println("Executing TC204");
	}
}
