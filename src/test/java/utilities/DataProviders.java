package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	// Dataprovider 1
	
	@DataProvider(name = "Category")
	public String[][] categoryData() throws IOException {
		

		String [][] data = {
				  {"SugerCane","Sugar for Tea","kg"},
				  {"Cloth","Cloth for wearing","mm"},
				  {"Toy","Toy for Child","feet"}
				  
		  };
		  return data;

	}
}
