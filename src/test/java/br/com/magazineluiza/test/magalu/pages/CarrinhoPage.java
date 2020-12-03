package br.com.magazineluiza.test.magalu.pages;

import org.openqa.selenium.By;

public class CarrinhoPage extends BasePage {

    private final By descricaoProdutoLabel = By.cssSelector("a.BasketItemProduct-info-title p");
    private final By excluirProdutoCarrinhoLink = By.cssSelector("span.BasketItem-delete-label");
    private final By mensagemSacolaVaziaLabel = By.cssSelector("div.EmptyBasket-title");

    public CarrinhoPage () {
        super();
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