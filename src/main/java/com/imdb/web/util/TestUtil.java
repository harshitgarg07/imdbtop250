package com.imdb.web.util;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;

import com.imdb.web.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;



	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}


	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}


	public static void waitFor(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void waitUntilPageLoads() {

		FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofMillis(5))
				.ignoring(NoSuchElementException.class);

		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver)
						.executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};

		fWait.until(expectation);
	}


	public static String getYear(String yr) {
		return yr.substring(1, yr.length() - 1);
	}

	public static Double getRating(String rating) {
		String[] s = rating.split(" ");
		return Double.parseDouble(s[0]);
	}
	
	public static int getRank(String rank) {
		return Integer.parseInt(rank.substring(0,rank.indexOf(".")));
	}

	public static String getTitle(String[] details) {
		StringBuilder str = new StringBuilder();
		for(int i=1; i<details.length-2;i++)
			str.append(details[i]).append(" ");
		return str.substring(0, str.length()-1).toString();
	}
}
