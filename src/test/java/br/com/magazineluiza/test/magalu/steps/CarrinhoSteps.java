package br.com.magazineluiza.test.magalu.steps;

import br.com.magazineluiza.test.magalu.pages.BasePage;
import br.com.magazineluiza.test.magalu.pages.CarrinhoPage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarrinhoSteps {

    private CarrinhoPage carrinhoPage;

    @Step("Validar produto no carrinho")
    public String produtoNoCarrinho() {
        return carrinhoPage.produtoNoCarrinho();
    }

    @Step("Clicar no botão 'Excluir Produto'")
    public void clicarEmExcluirProduto() {
        carrinhoPage.clicarEmExcluirProduto();
    }

    @Step("Validar mensagem de carrinho vazio")
    public String mensagemSacolaVazia() {
        return carrinhoPage.mensagemSacolaVazia();
    }
}