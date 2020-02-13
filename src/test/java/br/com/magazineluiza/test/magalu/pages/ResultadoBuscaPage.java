package br.com.magazineluiza.test.magalu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ResultadoBuscaPage extends BasePage {

    private By descricaoItens = By.cssSelector("ul li.nm-product-item h2.nm-product-name");
    private By produtoCard = By.cssSelector("li.nm-product-item");
	
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

    public DetalhesProdutoPage clicarNoPrimeiroItem() {
        click(produtoCard);
        return new DetalhesProdutoPage(driver);
    }
}