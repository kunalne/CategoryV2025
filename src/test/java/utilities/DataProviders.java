package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	// Dataprovider 1
	
	@DataProvider(name = "LoginData")
	public String[][] getDataFromExcel() throws IOException {
		
/*
		String path = "./testData//OpenCart_Login.xlsx";

		ExcelUtilities xlutil = new ExcelUtilities(path); // Creating an object for ExcelUtilities.

		int totalRows = xlutil.getRowCount("Sheet1");
		int totalColumn = xlutil.getCellCount("Sheet1", 0);

		String[][] Logindata = new String[totalRows][totalColumn];
		for (int r = 1; r <= totalRows; r++) {

			for (int c = 0; c < totalColumn; c++) {
				Logindata[r - 1][c] = xlutil.getCellData(path, r, c);
			}
		}
		return Logindata;
		*/
		String [][] data = {
				  {"rahul@gmail.com","dfdsf@2025"},
				  {"sdsdxa23@gmail.com","dds@20dd25"},
				  {"negikunal@gmail.com","Welcome@2025"},
				  {"adsd34l@gmail.com","Welcome@2025"}
				  
		  };
		  return data;

	}
	// Dataprovider 2

	// Dataprovider 3

	// Dataprovider 4

}
