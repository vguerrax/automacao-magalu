package br.com.magazineluiza.test.magalu.stepdefinitions;

import br.com.magazineluiza.test.magalu.pages.HomePage;
import br.com.magazineluiza.test.magalu.questions.MensagemDeItemNaoEncontrado;
import br.com.magazineluiza.test.magalu.questions.ResultadosDaPesquisa;
import br.com.magazineluiza.test.magalu.tasks.Acessar;
import br.com.magazineluiza.test.magalu.tasks.PesquisarPeloProduto;
import io.cucumber.java.ParameterType;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import net.serenitybdd.screenplay.Actor;

import static br.com.magazineluiza.test.magalu.matchers.StringMatchers.containsAnyOfStrings;
import static net.serenitybdd.core.Serenity.sessionVariableCalled;
import static net.serenitybdd.core.Serenity.setSessionVariable;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.*;

public class ScreenplayStepDefinitions {

    @ParameterType("([^'\"][A-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ]+[^'\"])")
    public Actor actor(String ator) {
        return Actor.named(ator);
    }

    @Dado("que {string} acessou a página inicial")
    public void atorAcessouAPaginaInicial(String ator) {
        theActorCalled(ator).wasAbleTo(Acessar.pagina(new HomePage()));
    }

    @Quando("ele pesquisa pelo termo {string}")
    public void elePesquisaPeloTermoSamsungGalaxyS(String termo) {
        theActorInTheSpotlight().attemptsTo(PesquisarPeloProduto.comOTermo(termo));
        setSessionVariable("TERMO").to(termo);
    }

    @Então("ele deve ver a lista de todos os produtos relacionados ao termo")
    public void eleDeveVerAListaDeTodosOsProdutosRelacionadosAoTermo() {
        String termoPesquisa = sessionVariableCalled("TERMO");
        theActorInTheSpotlight()
                .should(
                        seeThat(
                                ResultadosDaPesquisa.exibidos(),
                                everyItem(
                                        anyOf(
                                                containsAnyOfStrings(termoPesquisa.split("\\s+"))
                                        )
                                )
                        )
                );
    }

    @Então("ele deve ver a mensagem")
    public void eleDeveVerAMensagem(String mensagem) {
        theActorInTheSpotlight()
                .should(
                        seeThat(
                                MensagemDeItemNaoEncontrado.exibida(),
                                equalTo(mensagem)
                        )
                );
    }
}
