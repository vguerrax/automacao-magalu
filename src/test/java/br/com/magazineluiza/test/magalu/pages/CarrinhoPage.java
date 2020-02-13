package br.com.magazineluiza.test.magalu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarrinhoPage extends BasePage {

    private By descricaoProdutoLabel = By.cssSelector("a.BasketItemProduct-info-title p");
    private By excluirProdutoCarrinhoLink = By.cssSelector("span.BasketItem-delete-label");
    private By mensagemSacolaVaziaLabel = By.cssSelector("div.EmptyBasket-title");

    public CarrinhoPage (WebDriver driver) {
        super(driver);
    }

    public String produtoNoCarrinho() {
        try {
            return getText(descricaoProdutoLabel);
        } catch (Exception ex) {
            return null;
        }
    }

    public void clicarEmExcluirProduto() {
        click(excluirProdutoCarrinhoLink);
    }

    public String mensagemSacolaVazia() {
        return getText(mensagemSacolaVaziaLabel);
    }
}