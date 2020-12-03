package br.com.magazineluiza.test.magalu.pages;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.slf4j.LoggerFactory;

@DefaultUrl("page:home.page")
public class HomePage extends BasePage {

    private final By buscaField = By.id("inpHeaderSearch");
    private final By buscarButton = By.id("btnHeaderSearch");
    private final By fecharCookiesButton = By.cssSelector("p.text-button-cookie");

    public HomePage() {
        super();
    }

    public static Target CAMPO_BUSCA = Target
            .the("Campo de busca")
            .located(By.id("inpHeaderSearch"));

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