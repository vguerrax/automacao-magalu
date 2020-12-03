package br.com.magazineluiza.test.magalu.tasks;

import br.com.magazineluiza.test.magalu.pages.BasePage;
import br.com.magazineluiza.test.magalu.pages.HomePage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;

public class Acessar implements Task {
    BasePage page;

    @Override
    @Step("{0} acessa a página inicial")
    public <T extends Actor> void performAs(T ator) {
        ator.attemptsTo(
                Open.browserOn().the(page)
        );
    }

    public Acessar(BasePage page) {
        this.page = page;
    }

    public static Acessar pagina(BasePage pagina) {
        return Instrumented.instanceOf(Acessar.class).withProperties(pagina);
    }
}
