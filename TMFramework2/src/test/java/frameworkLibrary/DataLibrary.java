package frameworkLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataLibrary
{
	public  String getdata(String FieldName)
	{
		if (FrameworkVariables.getInstance().getCurrentTestData().containsKey(FieldName)) 
		{
			return FrameworkVariables.getInstance().getCurrentTestData().get(FieldName);
		} else 
		{
			System.out.println("Data Not Found For '" + FieldName + "' Field");
			return null;
		}
	}
	
	public  void setdata(String FieldName,String FieldValue)
	{
		if (FrameworkVariables.getInstance().getCurrentTestData().containsKey(FieldName)) 
		{
			FrameworkVariables.getInstance().getCurrentTestData().put(FieldName, FieldValue);
		} 
		else 
		{
			System.out.println(FieldName + "' Field is not found in Excel");
		}
	}
/*
 *****************************************************************************************************
 ****************************End:Methods For the use of test cases development************************
 *****************************************************************************************************
 */
	
	
	
//##############################################################################################################################
//##############################################################################################################################
//##############################################################################################################################
//##############################################################################################################################
//##############################################################################################################################
//##############################################################################################################################
//##############################################################################################################################
//##############################################################################################################################
//##############################################################################################################################
//##############################################################################################################################
//##############################################################################################################################
//##############################################################################################################################
	
/*
 *****************************************************************************************************
 **************************Start:Methods For the use of framework development************************
 *****************************************************************************************************
 */
	public  void loadDataFromExceltoHashMap() 
	{
		String TestCaseName = FrameworkVariables.getInstance().getCurrentTestCaseName();
		String ModuleName= FrameworkVariables.getInstance().getCurrentModuleName();
		
		try 
		{
			String FilePath = FrameworkVariables.getInstance().getDataFilesPath() + "\\" + ModuleName + ".xlsx";
			File f1 = new File(FilePath);
			FileInputStream fis = new FileInputStream(f1);
			XSSFWorkbook wb1 = new XSSFWorkbook(fis);

			XSSFSheet ws1 = wb1.getSheet("TestData");

			int rowcount = ws1.getLastRowNum();
			for (int r = 0; r <= rowcount; r++) {
				if (ws1.getRow(r).getCell(0) != null) {
					String Excel_TestCaseName = ws1.getRow(r).getCell(0).getStringCellValue();
					if (Excel_TestCaseName.equalsIgnoreCase(TestCaseName)) {
						int datarow = r;
						int valuerow = r + 1;
						int cellcount = ws1.getRow(datarow).getLastCellNum();
						for (int c = 1; c < cellcount; c++) {
							String ExcelFieldName = "";
							String ExcelFieldValue = "";
							if (ws1.getRow(datarow).getCell(c) != null)
								ExcelFieldName = ws1.getRow(datarow).getCell(c).getStringCellValue();
							if (ws1.getRow(valuerow).getCell(c) != null)
								ExcelFieldValue = ws1.getRow(valuerow).getCell(c).getStringCellValue();
							if (ExcelFieldName.length() > 1)
								FrameworkVariables.getInstance().getCurrentTestData().put(ExcelFieldName, ExcelFieldValue);
						}
						break;
					}
				}
			}
			fis.close();
			wb1.close();
		} catch (Exception e)
		{
			System.out.println("Exception occured while reading data of '" + TestCaseName + "'  TestCase and '"
					+ ModuleName + "' Module");
		}
	}
	
	public  void loadDataFromHashMaptoExcel() 
	{
		String TestCaseName = FrameworkVariables.getInstance().getCurrentTestCaseName();
		String ModuleName= FrameworkVariables.getInstance().getCurrentModuleName();
		try 
		{
			String FilePath = FrameworkVariables.getInstance().getDataFilesPath() + "\\" + ModuleName + ".xlsx";
			File f1 = new File(FilePath);
			FileInputStream fis = new FileInputStream(f1);
			XSSFWorkbook wb1 = new XSSFWorkbook(fis);

			XSSFSheet ws1 = wb1.getSheet("TestData");

			int rowcount = ws1.getLastRowNum();
			for (int r = 0; r <= rowcount; r++) 
			{
				if (ws1.getRow(r).getCell(0) != null)
				{
					String Excel_TestCaseName = ws1.getRow(r).getCell(0).getStringCellValue();
					if (Excel_TestCaseName.equalsIgnoreCase(TestCaseName)) 
					{
						int datarow = r ;
						int valuerow = r + 1;
						int cellcount = ws1.getRow(datarow).getLastCellNum();
						for (int c = 1; c < cellcount; c++) 
						{
							String ExcelFieldName = "";
							if (ws1.getRow(datarow).getCell(c) != null)
							{
								ExcelFieldName = ws1.getRow(datarow).getCell(c).getStringCellValue();
								if(FrameworkVariables.getInstance().getCurrentTestData().containsKey(ExcelFieldName))
								{
									if (ws1.getRow(valuerow).getCell(c) == null)
									{
										ws1.getRow(valuerow).createCell(c);
									}
									ws1.getRow(valuerow).getCell(c).setCellValue(FrameworkVariables.getInstance().getCurrentTestData().get(ExcelFieldName));
								}
							}
						}
						break;
					}
				}
			}
			fis.close();
			FileOutputStream fos = new FileOutputStream(f1);
			wb1.write(fos);
			fos.close();
			wb1.close();
		} catch (Exception e) 
		{
			System.out.println("Exception occured while writing data of '" + TestCaseName + "'  TestCase and '"
					+ ModuleName + "' Module");
		}
	}
/*
 *****************************************************************************************************
 *****************************End:Methods For the use of framework development************************
 *****************************************************************************************************
 */
}
