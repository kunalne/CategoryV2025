package PageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CategoryPage extends BasePage {
	

	public String categoryName;
	public String categoryDesc;
	public String dropdownValll;

	public CategoryPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	@FindBy(xpath = "//input[@placeholder='Category Name']")
	WebElement CategoryName;

	@FindBy(xpath = "//input[@placeholder='Category Desc']")
	WebElement CategoryDesc;

	@FindBy(css = ".form-select")
	WebElement selectDropdown;
	@FindBy(css = ".btn.btn-success")
	WebElement submit;
	

	public void CategoryNameVal(String catName) throws InterruptedException {
		categoryName = catName;
		CategoryName.sendKeys(catName.toLowerCase());
		Thread.sleep(2000);
	}

	public void CategoryDescVal(String catDescc) throws InterruptedException {
		categoryDesc=catDescc;
		CategoryDesc.sendKeys(catDescc.toLowerCase());
		Thread.sleep(2000);
	}

	public void selectValue(String dropdownVal) throws InterruptedException {
		
		dropdownValll = dropdownVal;

		Select dropdown = new Select(selectDropdown);
		List<WebElement> allOptions = dropdown.getOptions();
		for (WebElement option : allOptions) {
//			System.out.println(option.getText());
			if (option.getText().equalsIgnoreCase(dropdownVal.toLowerCase())) {
				dropdown.selectByVisibleText(dropdownVal);
			}
		}
		Thread.sleep(2000);
	}

	public void clickSubmit() throws InterruptedException {
		submit.click();
		Thread.sleep(2000);
	}

	public void deleteData() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Wait until the table is visible (important for dynamic tables)
		
		WebElement table = wait.until(
		ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".table.table-striped.table-bordered")));
		List<WebElement> rows = table.findElements(By.xpath("//div[@class='col-md-12']//tbody//tr"));
//		System.out.println(rows.size());
		
		for (int r = 1; r <= rows.size(); r++) {
			WebElement catName = driver.findElement(By.xpath("//div[@class='col-md-12']//tbody//tr["+r+"]//td[2]"));
//			CategoryName.add(catName.getText().trim());	
			if (catName.getText().equalsIgnoreCase(categoryName)) {
				WebElement elem = driver.findElement(By.xpath("//td[normalize-space()='"+categoryName+"']//following-sibling::*//button[contains(text(), 'Delete')]"));
				elem.click();
				
			}}
		String Actualpara = "Do you want to delete?";
		String Expectedpara = driver.findElement(By.xpath("//div[@class = 'modal-body']//p")).getText();
		Assert.assertEquals(Actualpara, Expectedpara);
		
		driver.findElement(By.xpath("//div[@class = 'modal-footer']//button[2]")).click();
		
}
}