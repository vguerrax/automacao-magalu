package br.com.magazineluiza.test.magalu.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ResultadoBuscaPage extends BasePage {

    private final By descricaoItens = By.cssSelector("ul li.product h3.productTitle");
    private final By produtoCard = By.cssSelector("li.product");
    private final By mensagemNaoEncontrado = By.cssSelector("div.header-not-found");

    public static Target ITENS_LISTADOS = Target
            .the("Itens listados")
            .located(By.cssSelector("ul li.product h3.productTitle"));

    public static Target MENSAGEM_ITEM_NAO_ENCONTRADO = Target
            .the("Mensagem de item não encontrado")
            .located(By.cssSelector("div.header-not-found"));

    public ResultadoBuscaPage() {
        super();
    }

    public List<String> itensListados() {
        List<String> itens = new ArrayList<>();
        List<WebElement> resultados = getDriver().findElements(descricaoItens);
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