package br.com.magazineluiza.test.magalu.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.LoggerFactory;

public class SeguroPage extends BasePage {

    private By continuarButton = By.cssSelector("a.price-warranty__btn--continue");

    public SeguroPage (WebDriver driver) {
        super(driver);
    }

    public CarrinhoPage clicarEmContinuar() {
        try {
            waitForElement(continuarButton);
            click(continuarButton);
        } catch (TimeoutException ex) {
            LoggerFactory.getLogger("SeguroPage").info("Seguro não foi exibido");
        }
        return new CarrinhoPage(driver);
    }
}