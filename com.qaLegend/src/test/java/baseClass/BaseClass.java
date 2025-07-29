package baseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import constants.ConstantsClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
	public WebDriver driver;
	public static Properties property;

	public static void readProperty() throws IOException {
		property = new Properties();
		FileInputStream file = new FileInputStream(ConstantsClass.filePath);
		property.load(file);
	}

	@BeforeMethod
	public void setUp() throws IOException {
		readProperty();
		driver = new ChromeDriver();
		driver.get(property.getProperty("Base_URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConstantsClass.implicitWaitTimeDuration));
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
}
