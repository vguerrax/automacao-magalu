package br.com.magazineluiza.test.magalu.pages;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {

	private static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

	protected String baseUrl = "https://www.magazineluiza.com.br/";

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected JavascriptExecutor javaScriptExecutor = null;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		this.javaScriptExecutor = (JavascriptExecutor) driver;
	}

	public void acessarPaginaInicial() {
		driver.get(baseUrl);
	}

	private void waitUntilPageReady() {
		StopWatch timeOut = new StopWatch();
		timeOut.start();

		while (timeOut.getTime() <= 30000) {
			if (javaScriptExecutor.executeScript("return document.readyState").toString().equals("complete")) {
				timeOut.stop();
				break;
			}
		}
	}

	protected WebElement waitForElement(By locator) {
		waitUntilPageReady();
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement element = driver.findElement(locator);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}

	protected WebElement waitForElement(WebElement element) {
		waitUntilPageReady();
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}

	protected WebElement waitForElementByTime(By locator, int time) {
		WebDriverWait waitTime = new WebDriverWait(driver, time);
		waitTime.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement element = driver.findElement(locator);
		waitTime.until(ExpectedConditions.visibilityOf(element));
		return element;
	}

	protected WebElement waitForElementDisabled(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return driver.findElement(locator);
	}

	protected void click(By locator) {
		WebDriverException possibleWebDriverException = null;
		StopWatch timeOut = new StopWatch();
		timeOut.start();

		while (timeOut.getTime() <= 30000) {
			WebElement element = null;

			try {
				element = waitForElement(locator);
				element.click();
				timeOut.stop();
				return;
			} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
				// Do nothing
			} catch (WebDriverException e) {
				possibleWebDriverException = e;
				if (e.getMessage().contains("Other element would receive the click")) {
					continue;
				}

				throw e;
			}
		}

		if (possibleWebDriverException != null) {
			LOGGER.error(possibleWebDriverException.getMessage());
			throw possibleWebDriverException;
		}
	}
	
	protected void sendKeys(By locator, CharSequence text) {
		waitForElement(locator).sendKeys(text);
	}
	
	protected void clear(By locator) {
		WebElement webElement = waitForElement(locator);
		webElement.clear();
	}
	
	protected void clearAndSendKeys(By locator, String text) {
		WebElement webElement = waitForElement(locator);
		webElement.sendKeys(Keys.CONTROL + "a");
		webElement.sendKeys(Keys.DELETE);
		webElement.sendKeys(text);
	}

	protected void comboBoxSelectByVisibleText(By locator, String text) {
		Select comboBox = new Select(waitForElement(locator));
		comboBox.selectByVisibleText(text);
	}

	protected void mouseOver(By locator) {
		Actions action = new Actions(driver);
		action.moveToElement(waitForElement(locator)).build().perform();
	}

	protected String getText(By locator) {
		return waitForElement(locator).getText();
	}

	protected String getValue(By locator) {
		return waitForElement(locator).getAttribute("value");
	}

	protected boolean returnIfElementIsDisplayed(By locator) {
		return waitForElement(locator).isDisplayed();
	}

	protected boolean returnIfElementExists(By locator) {
		boolean result = false;

		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			result = true;
		} catch (Exception e) {
			result = false;
		}

		return result;
	}

	protected boolean returnIfElementIsEnabled(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return driver.findElement(locator).isEnabled();
	}

	protected boolean returnIfElementIsSelected(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return driver.findElement(locator).isSelected();
	}
}
