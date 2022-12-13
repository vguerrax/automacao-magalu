package br.com.magazineluiza.test.magalu.questions;

import br.com.magazineluiza.test.magalu.pages.ResultadoBuscaPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Step;

import java.util.List;
import java.util.stream.Collectors;

public class MensagemDeItemNaoEncontrado implements Question<String> {
    @Override
    @Step("{0} vê os resultados da pesquisa")
    public String answeredBy(Actor actor) {
        return Text.of(ResultadoBuscaPage.MENSAGEM_ITEM_NAO_ENCONTRADO)
                .answeredBy(actor);
    }

    public static Question<String> exibida() {
        return new MensagemDeItemNaoEncontrado();
    }
}
