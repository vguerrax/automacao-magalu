package br.com.magazineluiza.test.magalu.steps;

import br.com.magazineluiza.test.magalu.pages.ResultadoBuscaPage;
import net.thucydides.core.annotations.Step;

import java.util.List;

public class ResultadoBuscaSteps {

    private ResultadoBuscaPage resultadoBuscaPage;

    @Step("Validar os itens listados")
    public List<String> itensListados() {
        return resultadoBuscaPage.itensListados();
    }

    @Step("Clicar no primeiro item da lista")
    public void clicarNoPrimeiroItem() {
        resultadoBuscaPage.clicarNoPrimeiroItem();
    }

    @Step("Validar mensagem de item não encontrado")
    public String mensagemNaoEncontrado() {
        return resultadoBuscaPage.mensagemNaoEncontrado();
    }
}