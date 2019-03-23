package frameworkLibrary;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import applicationPages.HRMBasePage;

public class BaseClass extends HRMBasePage
{
	@BeforeSuite
	public void beforesuite()
	{
		CreateNewExtentReportInResultsFolderWithDateAndTimeStamp();
	}
	
	@BeforeMethod
	public void beforemethod(Method currentmethod)
	{
		FrameworkVariables.getInstance().setCurrentTestCaseName(currentmethod.getName());
		FrameworkVariables.getInstance().setCurrentModuleName(currentmethod.getDeclaringClass().getSimpleName());
		FrameworkVariables.getInstance().setDataFilesPath(FrameworkVariables.getInstance().getCurrentFolderPath() + "\\DataFiles");
		FrameworkVariables.getInstance().setCurrentTestData();
		
		loadDataFromExceltoHashMap();
		
		startExtentTestForCurrentTestCase();
	}
	
	@AfterMethod
	public void aftermethod(ITestResult result)
	{
		endExtentTestForCurrentTestCase();
		loadDataFromHashMaptoExcel();
	}
	
	@AfterSuite
	public void aftersuite()
	{
		closeExtentReport();
		launchResult();
	}
}
