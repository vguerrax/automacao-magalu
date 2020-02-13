package br.com.magazineluiza.test.magalu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarrinhoPage extends BasePage {

    private By descricaoProdutoLabel = By.cssSelector("a.BasketItemProduct-info-title p");

    public CarrinhoPage (WebDriver driver) {
        super(driver);
    }

    public String produtoNoCarrinho() {
        return getText(descricaoProdutoLabel);
    }
}