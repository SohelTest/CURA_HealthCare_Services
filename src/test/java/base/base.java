package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {

	public static Properties prop = new Properties();
	public static WebDriver driver;

	public base() {

		try {
			FileInputStream file = new FileInputStream(
					"C:\\Users\\ADMIN\\eclipse-workspace\\CURA_Healtcare_Services\\src\\test\\java\\properties\\config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException a) {
			a.printStackTrace();
		}
	}

	public static void setupbrowser() {

		String browser = prop.getProperty("browsername");

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver-win64\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}

	public static String[] getMonthYear(String monthyear) {
		return monthyear.split(" ");
	}

	public static void screenshots(String filename) {
		try {
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File(
					"C:\\Users\\ADMIN\\eclipse-workspace\\CURA_Healtcare_Services\\src\\test\\java\\screenshots\\screenshots"
							 + filename +  ".jpg"));
		} catch (IOException e) {

			e.printStackTrace();

		}
	}

}
