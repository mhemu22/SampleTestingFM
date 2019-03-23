package applicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import frameworkLibrary.BasePage;

public class HRMBasePage extends BasePage
{
	public WebDriver launchHRMLoginpage()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.testingmasters.com/hrm");
		return driver;
	}
}
