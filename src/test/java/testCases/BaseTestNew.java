package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTestNew {

	public WebDriver driver;
	public Properties p;

	@BeforeClass()
	public void setUP() throws IOException {

		// Loading data of Config.properties file
		FileReader file = new FileReader("./src//test//resources//config.properties"); // Path of file..
		p = new Properties();
		p.load(file); // Load data in file to properties..

		// If Execution environment as Local...
//		switch (br) {
//		case "chrome":
//			driver = new ChromeDriver();
//			break;
//		case "edge":
//			driver = new EdgeDriver();
//			break;
//		case "firefox":
//			driver = new FirefoxDriver();
//			break;
//		default:
//			System.out.println("Invalid Browser...");
//			return;
//		}
		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get(p.getProperty("appURL")); // reading URL from property file...
		driver.manage().window().maximize();

	}

	@AfterClass()
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.close();
	}

}
