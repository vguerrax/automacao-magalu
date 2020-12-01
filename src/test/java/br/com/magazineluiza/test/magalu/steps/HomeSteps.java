package br.com.magazineluiza.test.magalu.steps;

import br.com.magazineluiza.test.magalu.pages.HomePage;
import net.thucydides.core.annotations.Step;

public class HomeSteps {

    private HomePage homePage;

    @Step("Acessar a página inicial")
    public void acessarPaginaInicial() {
        homePage.acessarPaginaInicial();
    }

    public boolean mensagemCookieExibida() {
        return homePage.mensagemCookieExibida();
    }

    @Step("Clicar em 'Entendi e Fechar'")
    public void clicarEmFecharCoockies() {
        homePage.clicarEmFecharCoockies();
    }

    @Step("Informar o termo de busca '{0}'")
    public void informarTermoBusca(String termo) {
        homePage.informarTermoBusca(termo);
    }

    @Step("Clicar no botão 'Buscar'")
    public void clicarEmBuscar() {
        homePage.clicarEmBuscar();
    }
}