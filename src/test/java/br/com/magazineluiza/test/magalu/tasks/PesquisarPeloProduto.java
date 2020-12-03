package br.com.magazineluiza.test.magalu.tasks;

import br.com.magazineluiza.test.magalu.pages.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.RETURN;

public class PesquisarPeloProduto implements Task {
    private String termo;

    @Override
    @Step("{0} pesquisa pelo termo '#termo'")
    public <T extends Actor> void performAs(T ator) {
        ator.attemptsTo(
                Enter.theValue(termo)
                        .into(HomePage.CAMPO_BUSCA)
                        .thenHit(RETURN)
        );
    }

    public PesquisarPeloProduto(String termo) {
        this.termo = termo;
    }

    public static PesquisarPeloProduto comOTermo(String termo) {
        return instrumented(PesquisarPeloProduto.class, termo);
    }
}
