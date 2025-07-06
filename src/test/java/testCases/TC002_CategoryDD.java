package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.CategoryPage;
import utilities.DataProviders;

public class TC002_CategoryDD extends BaseTestNew {
	public CategoryPage cp;
	@Test(dataProvider =  "Category", dataProviderClass = DataProviders.class)
	public void test_AddCategory(String catNameDD,String catDescDD,String unitDD) throws InterruptedException {
		cp = new CategoryPage(driver);
		cp.CategoryNameVal(catNameDD);
		cp.CategoryDescVal(catDescDD);
		cp.selectValue(unitDD);
		cp.clickSubmit();
			
	}
}
