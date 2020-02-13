package br.com.magazineluiza.test.magalu.stepdefinitions;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;

public class BaseStepDefinitions {

	public WebDriver driver;
	
	public BaseStepDefinitions() {
		File driverFile = new File("src/test/resources/drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", driverFile.getAbsolutePath());
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown() {
		if(driver != null)
			driver.close();
	}
}
