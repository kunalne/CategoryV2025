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

public class TC001_Category extends BaseTestNew {
	public CategoryPage cp;
//	@Test(dataProvider =  "LoginData", dataProviderClass = DataProviders.class, groups = "dataDriven")
	@Test()
	public void test_AddCategory() throws InterruptedException {
		cp = new CategoryPage(driver);
		cp.CategoryNameVal("Kunal Test");
		cp.CategoryDescVal("Kunalpaint");
		cp.selectValue("mm");
		cp.clickSubmit();
			
	}
	
	@Test(dependsOnMethods = {"test_AddCategory"})
	public void test_DeleteCategory() throws InterruptedException {
		cp.deleteData();
			
	}
}
