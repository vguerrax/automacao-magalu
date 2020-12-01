package br.com.magazineluiza.test.magalu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;

public class HomePage extends BasePage {

	private final By buscaField = By.id("inpHeaderSearch");
	private final By buscarButton = By.id("btnHeaderSearch");
	private final By fecharCookiesButton = By.cssSelector("p.text-button-cookie");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void acessarPaginaInicial() {
		open();
	}

	public boolean mensagemCookieExibida() {
		try {
			waitForElement(fecharCookiesButton);
			return true;
		} catch (TimeoutException ex) {
			LoggerFactory.getLogger("HomePage").info("Mensagem de cookie não foi exibida");
			return false;
		}
	}

	public void clicarEmFecharCoockies() {
		click(fecharCookiesButton);
	}

	public void informarTermoBusca(String termo) {
		sendKeys(buscaField, termo);
	}

	public void clicarEmBuscar() {
		click(buscarButton);
	}
}