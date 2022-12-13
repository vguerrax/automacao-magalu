package br.com.magazineluiza.test.magalu.pages;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.slf4j.LoggerFactory;

@DefaultUrl("page:home.page")
public class HomePage extends BasePage {

    private static final By buscaField = By.cssSelector("input[data-testid='input-search']");
    private static final By buscarButton = By.cssSelector("svg[data-testid='search-submit']");
    private static final By fecharCookiesButton = By.cssSelector("button[data-testid='button-message-box']");

    public HomePage() {
        super();
    }

    public static Target CAMPO_BUSCA = Target
            .the("Campo de busca")
            .located(buscaField);

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