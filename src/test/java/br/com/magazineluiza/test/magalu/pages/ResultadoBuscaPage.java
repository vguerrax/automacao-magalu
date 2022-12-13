package br.com.magazineluiza.test.magalu.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ResultadoBuscaPage extends BasePage {

    private static final By descricaoItens = By.cssSelector("h2[data-testid='product-title']");
    private static final By produtoCard = By.cssSelector("div[data-testid='product-list'] ul[data-testid='list']");
    private static final By mensagemNaoEncontrado = By.cssSelector("h1[data-testid='text-list-title']");

    public static Target ITENS_LISTADOS = Target
            .the("Itens listados")
            .located(descricaoItens);

    public static Target MENSAGEM_ITEM_NAO_ENCONTRADO = Target
            .the("Mensagem de item não encontrado")
            .located(mensagemNaoEncontrado);

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