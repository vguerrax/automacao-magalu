package br.com.magazineluiza.test.magalu.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Ability;
import net.thucydides.core.annotations.WhenPageOpens;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.temporal.TemporalUnit;

public class BasePage extends PageObject implements Ability {

	private static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

	protected Duration waitTime = Duration.ofSeconds(5);

	public static BasePage abrirONavegador() {
		return new BasePage();
	}

	@WhenPageOpens
	public void maximiseScreen() {
		getDriver().manage().window().maximize();
	}

	public JavascriptExecutor javaScriptExecutor() {
		return (JavascriptExecutor) getDriver();
	}

	public WebDriverWait webDriverWait() {
		return new WebDriverWait(getDriver(), waitTime);
	}

	private void waitUntilPageReady() {
		StopWatch timeOut = new StopWatch();
		timeOut.start();

		while (timeOut.getTime() <= waitTime.toMillis()) {
			if (javaScriptExecutor().executeScript("return document.readyState").toString().equals("complete")) {
				timeOut.stop();
				break;
			}
		}
	}

	public void scrollToElement(WebElement element) {
		javaScriptExecutor().executeScript("arguments[0].scrollIntoView(true);", element);
	}

	protected WebElement waitForElement(By locator) {
		waitUntilPageReady();
		webDriverWait().until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement element = getDriver().findElement(locator);
		webDriverWait().until(ExpectedConditions.visibilityOf(element));
		return element;
	}

	protected WebElement waitForElement(WebElement element) {
		waitUntilPageReady();
		webDriverWait().until(ExpectedConditions.visibilityOf(element));
		return element;
	}

	protected WebElement waitForElementByTime(By locator, long time) {
		WebDriverWait waitTime = new WebDriverWait(getDriver(), Duration.ofMillis(time));
		waitTime.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement element = getDriver().findElement(locator);
		waitTime.until(ExpectedConditions.visibilityOf(element));
		return element;
	}

	protected WebElement waitForElementDisabled(By locator) {
		webDriverWait().until(ExpectedConditions.presenceOfElementLocated(locator));
		return getDriver().findElement(locator);
	}

	protected void click(By locator) {
		WebDriverException possibleWebDriverException = null;
		StopWatch timeOut = new StopWatch();
		timeOut.start();

		while (timeOut.getTime() <= waitTime.toMillis()) {
			WebElement element = null;

			try {
				element = waitForElement(locator);
				element.click();
				timeOut.stop();
				return;
			} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
				LOGGER.info(e.getMessage());
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
		Actions action = new Actions(getDriver());
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
		boolean result;

		try {
			webDriverWait().until(ExpectedConditions.presenceOfElementLocated(locator));
			result = true;
		} catch (Exception e) {
			result = false;
		}

		return result;
	}

	protected boolean returnIfElementIsEnabled(By locator) {
		webDriverWait().until(ExpectedConditions.presenceOfElementLocated(locator));
		return getDriver().findElement(locator).isEnabled();
	}

	protected boolean returnIfElementIsSelected(By locator) {
		webDriverWait().until(ExpectedConditions.presenceOfElementLocated(locator));
		return getDriver().findElement(locator).isSelected();
	}
}