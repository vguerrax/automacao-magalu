package br.com.magazineluiza.test.magalu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	private By buscaField = By.cssSelector("#inpHeaderSearch[name='q']");

	private By buscarButton = By.id("btnHeaderSearch");
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void informarTermoBusca(String termo) {
		sendKeys(buscaField, termo);
	}

	public ResultadoBuscaPage clicarEmBuscar() {
		click(buscarButton);
		return new ResultadoBuscaPage(driver);
	}
}
