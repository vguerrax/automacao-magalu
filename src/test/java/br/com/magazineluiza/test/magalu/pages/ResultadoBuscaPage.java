package br.com.magazineluiza.test.magalu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ResultadoBuscaPage extends BasePage {

    private final By descricaoItens = By.cssSelector("ul li.product h3.productTitle");
    private final By produtoCard = By.cssSelector("li.product");
    private final By mensagemNaoEncontrado = By.cssSelector("div.header-not-found");

    public ResultadoBuscaPage(WebDriver driver) {
        super(driver);
    }

    public List<String> itensListados() {
        List<String> itens = new ArrayList<>();
        List<WebElement> resultados = driver.findElements(descricaoItens);
        for(WebElement item : resultados) {
            waitForElement(item);
            itens.add(item.getText());
        }

        return itens;
    }

    public void clicarNoPrimeiroItem() {
        click(produtoCard);
    }

    public String mensagemNaoEncontrado() {
        return getText(mensagemNaoEncontrado);
    }
}