package com.imdb.web.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.gson.JsonElement;
import com.imdb.web.util.TestUtil;

/**
 * 
 * @author harshitgarg
 *
 */
public class TestBase extends WebElementActions {

	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait webDriverWait;
	public static String url;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("src/main/resources/com/imdb/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		webDriverWait = new WebDriverWait(driver, 60);
		driver.get(url);

	}
	
	 public WebDriver getDriver() {
        return driver;
    }

	public static void setURL() {
		url = prop.getProperty("urlMovieList");
	}


}
