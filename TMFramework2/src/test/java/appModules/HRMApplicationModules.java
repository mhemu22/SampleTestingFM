package appModules;

import org.openqa.selenium.WebDriver;

import applicationPages.HRMBasePage;
import applicationPages.Pg101_Login;
import applicationPages.Pg102_Home;
import applicationPages.Pg103_ContactDetails;
import applicationPages.Pg104_EmergencyContacts;

public class HRMApplicationModules extends HRMBasePage
{
	WebDriver driver;
	Pg101_Login loginpage;
	Pg102_Home homepage;
	Pg103_ContactDetails contactdetailspage;
	Pg104_EmergencyContacts emergencycontacts;

	public HRMApplicationModules(WebDriver driver)
	{
		this.driver = driver;
		loginpage = new Pg101_Login(driver);
		homepage = new Pg102_Home(driver);
		contactdetailspage = new Pg103_ContactDetails(driver);
		emergencycontacts = new Pg104_EmergencyContacts(driver);
	}
	
	public void login(String Username,String Password)
	{
		loginpage.setUserName(Username);
		loginpage.setpassword(Password);
		loginpage.ClickonLogin();
	}
	
	public void NavigateToContactDetails()
	{
		homepage.clickOnMyInfo();
		homepage.clickOnContactDetails();
	}
	public void NavigateToEmergencyContacts()
	{
		homepage.clickOnMyInfo();
		homepage.clickOnEmergencyContacts();
	}
	public void Logout()
	{
		homepage.Logout();
		quitdriver(driver);
	}
}
