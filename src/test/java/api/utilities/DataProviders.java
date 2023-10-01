package api.utilities;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="AllData")
	public String [][] AllDataProvider() throws IOException
	{
		String ExcelPath=System.getProperty("user.dir")+"//testData//TestData.xlsx";
		ReadExcel xl=new ReadExcel();
		
		int rowcount=xl.getRowCount(ExcelPath, "Sheet1");
		int cellCount=xl.getCellCount(ExcelPath, "Sheet1", 1);
		
		String userData[][]=new String[rowcount][cellCount];
		for(int i=1;i<=rowcount;i++)
		{
			for(int c=0;c<cellCount;c++)
			{
				userData[i-1][c]=xl.getCellData(ExcelPath, "Sheet1", i, c);
			}
		}
		return userData;
	}
	
	@DataProvider(name="UserNamesData")
	public String [] UserNamesDataProvider() throws IOException
	{
		String ExcelPath=System.getProperty("user.dir")+"//testData//TestData.xlsx";
		ReadExcel xl=new ReadExcel();
		
		int rowcount=xl.getRowCount(ExcelPath, "Sheet1");
//		int cellCount=xl.getCellCount(ExcelPath, "Sheet1", 1);
		
		String userNamesData[]=new String[rowcount];
		for(int i=1;i<rowcount;i++)
		{
			userNamesData[i-1]=xl.getCellData(ExcelPath, "Sheet1", i, 1);
		}
		return userNamesData;
	}
}
