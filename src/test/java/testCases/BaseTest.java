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

public class BaseTest {

	public WebDriver driver;
	public Properties p;

	@BeforeClass(groups = { "regression", "sanity", "master", "dataDriven" })
	@Parameters({ "browser", "os" })
	public void setUP(String br, String os) throws IOException {
		
		// Loading data of Config.properties file
		FileReader file = new FileReader("./src//test//resources//config.properties"); //Path of file..
		p = new Properties();
		p.load(file);   //Load data in file to properties..

		
		// If Execution environment as remote...
		if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {   //Check execution env value is local or remote...
			DesiredCapabilities capabilities = new DesiredCapabilities();  //Used to set broser(Chrome,Edge) and Platform(win 11, mac) to execute test cases.
			// OS
			if (os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			} else if (os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			}else if (os.equalsIgnoreCase("Linux")) {
				capabilities.setPlatform(Platform.LINUX);
			}else {
				System.out.println("No matching OS");
				return;
			}

			// browser
			switch (br.toLowerCase()) {
			case "chrome":
				capabilities.setBrowserName("chrome");
				break;

			case "edge":
				capabilities.setBrowserName("MicrosoftEdge");
				break;
			
			case "firefox":
				capabilities.setBrowserName("firefox");
				break;

			default:
				System.out.println("No matching browser");
				return;
			}
			
			//Launch the remote URL
			driver = new RemoteWebDriver(new URL("http://192.168.1.9:4444/wd/hub"),capabilities); //For Standalone Hub and Node...
//			driver = new RemoteWebDriver(new URL("http://localhost:4444/ui/wd/hub"),capabilities); //For docker Hub and multiple Node...
			
		} else if (p.getProperty("execution_env").equalsIgnoreCase("local")) {

			// If Execution environment as Local...
			switch (br) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			default:
				System.out.println("Invalid Browser...");
				return;
			}
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get(p.getProperty("appURL")); // reading URL from property file...
		driver.manage().window().maximize();

	}

	@AfterClass(groups = { "regression", "sanity", "master", "dataDriven" })
	public void tearDown() {
		driver.close();
	}

	/*
	 * // Alphanumeric string of length 10 String random =
	 * RandomStringUtils.randomAlphanumeric(10);
	 * System.out.println("Random String: " + random);
	 * 
	 * // Only letters String letters = RandomStringUtils.randomAlphabetic(8);
	 * 
	 * // Only numbers String numbers = RandomStringUtils.randomNumeric(6);
	 * 
	 * // Any chars (including symbols) String mixed = RandomStringUtils.random(10);
	 */

	public String randomString() {

		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;

	}

	public String randomNumber() {

//  // Only numbers
		String numbers = RandomStringUtils.randomNumeric(10);
		return numbers;
	}

	public String randomAlphaNumber() {

		// Alphanumeric string of length 10
		String randomAlphaNumeric = RandomStringUtils.randomAlphanumeric(10);
		return randomAlphaNumeric;
	}

}
