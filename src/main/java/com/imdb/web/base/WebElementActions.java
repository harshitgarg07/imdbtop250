package com.imdb.web.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.imdb.web.util.TestUtil;

import io.qameta.allure.Step;

/**
 * 
 * @author harshitgarg
 *
 */
public class WebElementActions {

	WebDriver driver = TestBase.driver;

	public void checkAndFillTextBox(WebElement element, String data) {
		if (data != null && !data.isEmpty()) {
			element.sendKeys(data);
		}
	}

	@Step("Populate movie list")
	public void checkAndFillTextBoxwithReturn(WebElement element, String data) {
		if (data != null && !data.isEmpty()) {
			element.sendKeys(data);
			TestUtil.waitFor(500);
			element.sendKeys(Keys.RETURN);
		}
	}

	public void checkAndClick(WebElement element, Boolean data) {
		if (data != null && data) {
			element.click();
		}
	}

	public void checkAndFillDropdown(WebElement element, String data) {
		if (data != null && !data.isEmpty()) {
			Select select = new Select(element);
			select.selectByVisibleText(data);
		}
	}

	public void checkAndFillMultipleDropdown(WebElement element, String data) {
		if (data != null && !data.isEmpty()) {
			element.click();
			String[] selection = data.split(",");
			for (String value : selection) {							
				driver.findElement(By.xpath(String.format("//*[@data-value = '%1s']/a", value))).click();
			}
		}
	}

	public void switchToFrameAndType(WebElement frame, WebElement element, String data) {
		if (data != null && !data.isEmpty()) {
			switchToFrame(frame);
			checkAndFillTextBox(element, data);
			switchToParentFrame();
		}
	}

	public void switchToFrame(WebElement frame) {
		driver.switchTo().frame(frame);
	}

	public void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}

	public void deSelectMultipleDropdown(String data) {
		if (data != null && !data.isEmpty()) {
			String[] selection = data.split(",");
			for (String value : selection) {
				driver.findElement(By.xpath(String.format("//*[@data-value = '%1s']/a", value))).click();
			}
		}
	}
}
