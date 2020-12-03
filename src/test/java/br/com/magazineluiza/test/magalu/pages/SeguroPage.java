package br.com.magazineluiza.test.magalu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.slf4j.LoggerFactory;

public class SeguroPage extends BasePage {

    private final By continuarButton = By.cssSelector("a.price-warranty__btn--continue");

    public SeguroPage() {
        super();
    }

    public boolean seguroExibido() {
        try {
            waitForElement(continuarButton);
            return true;
        } catch (TimeoutException ex) {
            LoggerFactory.getLogger("SeguroPage").info("Seguro não foi exibido");
            return false;
        }
    }

    public void clicarEmContinuar() {
        click(continuarButton);
    }
}